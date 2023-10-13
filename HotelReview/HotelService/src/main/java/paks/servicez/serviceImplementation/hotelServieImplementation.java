package paks.servicez.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paks.Entities.hotel;
import paks.exceptionz.ResourceNotFoundException;
import paks.repository.hotelDB;
import paks.servicez.hotelservice;

 import java.util.List;
import java.util.UUID;

@Service
public class hotelServieImplementation implements hotelservice {
    @Autowired
    private hotelDB hdb;

    @Override
    public hotel addhotel(hotel hotel) {
      String HotelID =  UUID.randomUUID().toString();
        hotel.setId(HotelID);
        System.out.println("created hotle name"+ hotel.getName());
        return this.hdb.save(hotel);
    }

    @Override
    public List<hotel> getAllhotels() {
        List<hotel> found = hdb.findAll();
        System.out.println("Displayed all hotels");
        for(hotel display:found){
            System.out.println("our customer(Hotel) "+display.getName());
        }
        return found;
    }

    @Override
    public hotel gethotel(String id) {
        hotel found =this.hdb.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel With this id not found"));
        System.out.println("found "+found.getName());
  return found;
    }
}
