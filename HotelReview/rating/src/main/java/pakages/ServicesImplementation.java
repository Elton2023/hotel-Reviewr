package pakages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pakages.Entities.Rating;
import pakages.Repositories.ratingRepositories;
import pakages.exceptionHandeling.ResourceNotFoundException;
import pakages.servicez.ratingService;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class ServicesImplementation implements ratingService {
    @Autowired
    private ratingRepositories rr;

    @Override
    public Rating findRating(String ratingId) {
        Rating TheRating= this.rr.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("User your Serching for isnt regsitered"));
  return TheRating;  }

    @Override
    public Rating createRating(Rating Rating) {
        Rating r=   this.rr.save(Rating);
        return r;
    }

    @Override
    public List<Rating> getAll() {
        List<Rating> all =this.rr.findAll();
        return all;
    }

    @Override
    public List<Rating> getAllRatingByUserId(String UserID) {

        return this.rr.findByUserId(UserID);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String HotelID) {

        return this.rr.findByHotelId(HotelID);
    }

    @Override
    public Rating updateRatings(String RatingID, Rating Rating) {
        Rating TheRating= this.rr.findById(RatingID).orElseThrow(()->new ResourceNotFoundException("User your Serching for isnt regsitered"));
           Rating.setRatingId(TheRating.getRatingId());
     Rating UpdatedRatings=   this.rr.save(Rating);
        System.out.println("Successfully updated rating");
        return UpdatedRatings;
    }

    @Override
    public void deleteRatings(String RatingID) {
this.rr.deleteById(RatingID);
        System.out.println("successfully deleted the rating");
    }
}
