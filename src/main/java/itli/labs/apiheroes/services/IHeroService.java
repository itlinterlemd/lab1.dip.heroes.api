package itli.labs.apiheroes.services;
import java.util.List;

import itli.labs.apiheroes.model.Hero;



public interface IHeroService {
	
	public List<Hero> finAll();
	public Hero findById(Integer id);
	public Hero save(Hero Hero);	
	public void delete(Hero Hero);		

}
