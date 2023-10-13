package pakgs.controllers;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pakgs.Entities.User;
import pakgs.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")//ResponseEntity
public class userController {

    @Autowired
    private UserService us;

    @PostMapping("/Add")
    public ResponseEntity<User> createUser(@RequestBody User  user){

     User newUser=   us.saveUser(user);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(newUser);
    }
    int retryCount=1;

    @GetMapping("/Get/{id}")
  // @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
     @Retry(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
    public    ResponseEntity<User> getUser(@PathVariable("id") String id){
        System.out.println("retry count number"+retryCount);
      retryCount++;
        User usr =this.us.getUser(id);
    return    ResponseEntity.status(HttpStatus.FOUND).body(usr);
    }

    public    ResponseEntity<User> ratingHotelFallBack(String userId ,Exception ex){
        //the return type for fallback must be same as for which its declared for

        System.out.println("Circuit-Breaker invoked while fetching user ");
        User ReplacementUser =User.builder().email("blehhh@bleh.com").name("Ben").about("nothing").id("777").build();
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ReplacementUser);
    }

    @GetMapping("/GetAll")
    public    ResponseEntity<List<User>>getUser(){
       List<User>   usrs =this.us.getAllUsers();
        return    ResponseEntity.status(HttpStatus.FOUND).body(usrs);
    }

    @PutMapping("/UpdateUser/{id}")
    public    ResponseEntity<User> UpdateUser(@RequestBody User  user,@PathVariable("id") String id){
        User updated =this.us.UpdateUser(id,user);
        return    ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    //-------------------------------------------------------------------
}
