package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("SELECT SUM(c.population) as popTotale " +
            "FROM City c " +
            "WHERE c.country.id = :IDPays")
    public int populationPourPays (int IDPays);

    @Query("SELECT c.name as name, populationPourPays(c.id) as popTotale " +
            "FROM Country c")
    public CountryByNameAndPopulation CountryTrieParNomEtPopu ();
}
