package app.services;

import app.models.City;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CityService {
    Iterable<City> findAll();

    Iterable<City> findAllByNameLike(String searchKey);

    Iterable<City> findAllByNameContain(String searchKey);

    Optional<City> findById(Long id);

    void save(City city);

    void deleteById(Long id);

    boolean isExist(City city);
}
