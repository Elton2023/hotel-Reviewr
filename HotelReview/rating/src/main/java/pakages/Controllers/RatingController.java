package pakages.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pakages.Entities.Rating;
import pakages.servicez.ratingService;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private ratingService rs;

    @PostMapping("/Add")
    public ResponseEntity<Rating> addrating(@RequestBody Rating Rating){
        Rating rts=  this.rs.createRating(Rating);
        return  ResponseEntity.status(HttpStatus.CREATED).body(rts);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<Rating>> showAll(){
        List<Rating> all=  this.rs.getAll();
        return  ResponseEntity.status(HttpStatus.FOUND).body(all);
    }

    @GetMapping("/findRating/{ratingId}")
    public ResponseEntity<Rating> findRating(@PathVariable("ratingId") String ratingId){
        Rating DRating=  this.rs.findRating(ratingId);
        return  ResponseEntity.status(HttpStatus.OK).body(DRating);
    }

    @GetMapping("/GetByUserId/{UserID}")
    public ResponseEntity<List<Rating>> showAllByUSer(@PathVariable("UserID") String UserID){
        List<Rating> all=  this.rs.getAllRatingByUserId(UserID);
        return  ResponseEntity.status(HttpStatus.FOUND).body(all);
    }

    @GetMapping("/GetByHotelId/{HotelID}")
    public ResponseEntity<List<Rating>> showAllByHotelID(@PathVariable("HotelID") String HotelID){
        List<Rating> all=  this.rs.getAllRatingByHotelId(HotelID);
        return  ResponseEntity.status(HttpStatus.FOUND).body(all);
    }

    @PutMapping("/Update/{ratingId}")
    public ResponseEntity<Rating>updateRating(@PathVariable("ratingId")String ratingId,@RequestBody Rating Ratings){
        Rating UpdatedRatings= this.rs.updateRatings(ratingId,Ratings);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(UpdatedRatings);
    }

    @DeleteMapping("/Delete/{ratingId}")
    public ResponseEntity<?>DeleteRating(@PathVariable("ratingId")String ratingId){
        this.rs.deleteRatings(ratingId);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    //--------------------------------------------------------------------------------------------------
}
