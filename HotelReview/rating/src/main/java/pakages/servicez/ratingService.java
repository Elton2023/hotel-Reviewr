package pakages.servicez;


import pakages.Entities.Rating;

import java.util.List;

public interface ratingService {

    Rating findRating( String ratingId);
    Rating createRating (Rating Rating);

    List<Rating> getAll ();

    List<Rating> getAllRatingByUserId(String UserID);


    List<Rating> getAllRatingByHotelId(String HotelID);

    Rating updateRatings (String RatingID,Rating Rating);

    void deleteRatings (String RatingID);


}
