package itli.labs.apiheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import itli.labs.apiheroes.model.Hero;


public interface IHeroRepository extends JpaRepository<Hero, Long> {
    Hero findById(int id);
    //List<Hero> findAll();
}
