package app.services;

import app.models.Country;

public interface CountryService {
    Iterable<Country> findAll();
}
