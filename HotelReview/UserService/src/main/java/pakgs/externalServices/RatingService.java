package pakgs.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pakgs.Entities.rating;
@Service
@FeignClient(name="RATING-SERVICE")//this is the name of the service as per it is declared in yml file
public interface RatingService {

    @GetMapping("/rating/findRating/{rid}")
    rating findRating(@PathVariable("rid") String rid);

@PostMapping("/rating/Add")
   rating CreateRating( rating ratings);

    @PutMapping("/rating/Update/{ratingId}")
  rating updateRating(@PathVariable("ratingId")String ratingId, rating ratings);

    @DeleteMapping("/rating/Delete/{ratingId}")
   void deleteRating(@PathVariable("ratingId") String ratingId);

}
