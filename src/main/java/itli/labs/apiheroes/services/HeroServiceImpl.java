package itli.labs.apiheroes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import itli.labs.apiheroes.model.Hero;
import itli.labs.apiheroes.repository.IHeroRepository;

@Service
public class HeroServiceImpl implements IHeroService {
	
	private final IHeroRepository heroRepository;
	public HeroServiceImpl(IHeroRepository heroRepository) {
		this.heroRepository = heroRepository;
	}
	
	@Override
	public List<Hero> finAll() {
		// TODO Auto-generated method stub
		return heroRepository.findAll();
	}

	@Override
	public Hero findById(Integer id) {
		// TODO Auto-generated method stub
		return heroRepository.findById(id);
	}

	@Override
	public Hero save(Hero Hero) {
		
		return heroRepository.save(Hero);		
	}

	
	@Override
	public void delete(Hero Hero) {
		Hero h = findById(Hero.getId());
		heroRepository.delete(h);
		
	}
	
	

}
