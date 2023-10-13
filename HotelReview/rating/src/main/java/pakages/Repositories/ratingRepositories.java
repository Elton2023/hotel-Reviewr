package pakages.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pakages.Entities.Rating;

import java.util.List;

public interface ratingRepositories extends MongoRepository<Rating,String> {
    List<Rating> findByUserId(String hotelId);
    List<Rating> findByHotelId(String hotelId);

}
