package app.services;

import app.models.City;
import app.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }


    @Override
    public Iterable<City> findAllByNameLike(String searchKey) {
        return cityRepository.findAllByNameLike(searchKey);
    }

    @Override
    public Iterable<City> findAllByNameContain(String searchKey) {
        return cityRepository.findAllByNameContains(searchKey);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public boolean isExist(City city) {
        return cityRepository.existsById(city.getId());
    }
}
