package paks.servicez;

import paks.Entities.hotel;

import java.util.List;

public interface hotelservice {
    hotel addhotel(hotel hotel);

    List<hotel> getAllhotels();

    hotel gethotel(String id);




}
