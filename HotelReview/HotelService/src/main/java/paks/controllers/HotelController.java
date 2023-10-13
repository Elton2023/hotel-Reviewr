package paks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import paks.Entities.hotel;
import paks.servicez.hotelservice;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private hotelservice hs;

    @PostMapping("/Add")
    public ResponseEntity<hotel> createHotel(@RequestBody hotel hotel){
        hotel newhotel =this.hs.addhotel(hotel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newhotel);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<hotel>> showAllHotels(){
        List<hotel> Allhotel =this.hs.getAllhotels();
        return  ResponseEntity.status(HttpStatus.FOUND).body(Allhotel);
    }

    @GetMapping("/Get/{id}")
    public ResponseEntity<hotel> showHotels(@PathVariable("id") String id){
        hotel TheHotel =this.hs.gethotel(id);
        return  ResponseEntity.status(HttpStatus.OK).body(TheHotel);
    }

}
