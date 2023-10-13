package pakgs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pakgs.Entities.User;
import pakgs.Entities.hotel;
import pakgs.Entities.rating;
import pakgs.externalServices.HotelService;
import pakgs.externalServices.RatingService;
import pakgs.service.UserService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService rs;

	@Autowired
	private HotelService hs;

	@Autowired
	private UserService us;
/*
	@Test
	void createRating(){
		//rating rating = pakgs.Entities.rating.builder().rating(10).userId("one").hotelId("twenty").feedback("this is created in user").build();
		//rating rated=rs.CreateRating(rating);
		rating rating = pakgs.Entities.rating.builder().rating(10).userId("oneAndOly").hotelId("twenty23").feedback("this is created in user test").build();
		rating rated=rs.updateRating("63ee2251fa41b71908b60a7b",rating);
		System.out.println("new rating created");
	}
*/


	@Test
	void showHotel(){
	 hotel	hotel = hs.theHotel("d33a3531-bd52-4864-a862-5551d232ab3d");
 		System.out.println("hotels arweeeeeeeeeee"+ hotel.getName());
	}

	@Test
	void showRating(){
rating rts=this.rs.findRating("63ee2251fa41b71908b60a7b");
		System.out.println("feedback found is"+rts.getFeedback());
	}

	@Test
	void showUser(){
		User user  =this.us.getUser("0fd6db4d-1c43-4869-a248-bee0931ca96a");
		System.out.println(user.getName());
	}

}
