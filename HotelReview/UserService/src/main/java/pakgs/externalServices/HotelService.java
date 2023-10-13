package pakgs.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pakgs.Entities.hotel;

@Service
@FeignClient(name= "HOTEL-SERVICE")//this is the name of the service as per it is declared in yml file
public interface HotelService {


     @GetMapping("/hotel/Get/{id}")//this is the api from hotel microservice
    hotel theHotel(@PathVariable("id") String id);



}
