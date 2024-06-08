package itli.labs.apiheroes.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import itli.labs.apiheroes.model.Hero;
import itli.labs.apiheroes.services.IHeroService;




@RestController
public class ControllerHero {
	
	private final IHeroService HeroService;	
		
    public ControllerHero(IHeroService HeroService) {
		super();
		this.HeroService = HeroService;
	}

	@GetMapping("/api/v1/heroes")
    public @ResponseBody List<Hero> getItems() {
    	return this.HeroService.finAll();
    	
    };
    
    @GetMapping("/api/v1/heroes/{code}")
    public Hero getHeroByCode(@PathVariable("code") Integer code) {
           
      return this.HeroService.findById(code);
    };
    

    //PUT actulizar un Heroa
    @PutMapping("/api/v1/heroes")
    public ResponseEntity<String> updateHero(@RequestBody Hero updatedHero){
    	
        // si no encuentra el codigo del Heroa que se quiere actualizar muestra el mensaje
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún Heroa con el código");
    }
    
    //DELETE borrar algun Heroa teniendo en cuenta el code
    @DeleteMapping("/api/v1/heroes/{code}")
    public ResponseEntity<String> deleteHeroByCode(@PathVariable("code") int code) {
      
        // Si no se encuentra ningún Heroa con el código proporcionado, devuelve una respuesta con estado NOT FOUND (404)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún Heroa con el código proporcionado");
    }

    
    //POST Agregar un nuevo "Heroa"  
    @PostMapping("/api/v1/heroes")
           
     public ResponseEntity<Hero> addHero(@RequestBody Hero newHero) {
     	    	
    	Hero proragam = this.HeroService.save(newHero);   
        return ResponseEntity.status(HttpStatus.CREATED).body(proragam);
          
    }
    

         
   	    
    /*
     *	GET http://localhost:8080/api/v1/heroes    //Devuleve todos los registros
     *	GET http://localhost:8080/api/v1/heroes/{code}  // Devuelve un registro consultado por code: 
     * 	Ejemplo:  http://localhost:8080/api/v1/heroes/C001  debe retornar el Heroa con code=C001
     * 
     * 	POST http://localhost:8080/api/v1/heroes    en el body llega JSON del Heroa y lo crea enla base de datos.
     * 
     * 
     * 	PUT http://localhost:8080/api/v1/heroes/{code}
     * 	DELETE http://localhost:8080/api/v1/heroes/{code}
     * 
     */
   
  
    }