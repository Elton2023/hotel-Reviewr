package pakgs.service.serviceImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pakgs.Entities.User;
import pakgs.Entities.hotel;
import pakgs.Entities.rating;
import pakgs.Repository.UserRepository;
import pakgs.exceptionsHandling.ResourceNotFoundException;
import pakgs.externalServices.HotelService;
import pakgs.service.UserService;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl  implements UserService {


    @Autowired
    private UserRepository udb;

    @Autowired
    private RestTemplate RestTemplate;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private HotelService  HotelService;

    @Override
    public User saveUser(User user) {
       String uid= UUID.randomUUID().toString();//since we didnt create auto-generate for id we use this;this creates id
user.setId(uid);
        System.out.println("saved user to "+user.getName()+" database");
        return udb.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("Getting all users");
        return udb.findAll();
    }

    @Override
    public User getUser(String userId) {

        System.out.println("Searching  user");
 User user = udb.findById(userId).orElseThrow(()->new ResourceNotFoundException("User your Serching for isnt regsitered"));
     //fetching rating ratings from ratings projects
        /*below we have used an array of rating insted of ArrayList and converted it to simple list befour using map on it
        because we cant use map on ArrayList..becasu map is a other type of list*/
     rating[] UsersRatingz=   RestTemplate.getForObject("http://RATING-SERVICE/rating/GetByUserId/"+user.getId(),rating[].class);
   //  logger.info("{} ",UsersRatings);
     //Collecting data from hotel api
        List<rating>UsersRatings= Arrays.stream(UsersRatingz).collect(Collectors.toList());
      List<rating> ratings= UsersRatings.stream().map(rating -> {
          System.out.println(" the hotel id in the map izzzzzzz"+rating.getHotel());
         // Hotel Hotel=  RestTemplate.getForObject("http://HOTEL-SERVICE/hotels/showhotel/"+rating.getHotelId(), Hotel.class);//---below is a convinet way of doing this
          hotel Hotel =HotelService.theHotel(rating.getHotelId());
          rating.setHotel(Hotel);
          return rating;
        }).collect(Collectors.toList());


        user.setRating(ratings);

        return user ;
    }

    @Override
    public void DeleteUser(String userId) {
        this.udb.deleteById(userId);
        System.out.println("successfully deleted user with id "+userId);
     }

    @Override
    public User UpdateUser(String userId, User userBody)
    {

      User oldUSer=this.udb.findById(userId).orElseThrow(()->new ResourceNotFoundException("User your Serching for isnt regsitered"));
        userBody.setId(userId);
        userBody.setRating(oldUSer.getRating());
        User Updated =this.udb.save(userBody);
        System.out.println("updated user "+userBody.getName());
return Updated;
    }
}
