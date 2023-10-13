package paks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paks.Entities.hotel;

@Repository
public interface hotelDB extends JpaRepository<hotel,String> {
}
