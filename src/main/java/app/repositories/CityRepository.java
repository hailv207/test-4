package app.repositories;

import app.models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {
    Iterable<City> findAllByNameLike(String searchKey);
    Iterable<City> findAllByNameContains(String searchKey);
}
