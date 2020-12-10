package mallek.com.appmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnimalRestController {

    @Autowired
    private AnimalRepo animalRepo;

    public AnimalRestController(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }
    //get
    @GetMapping("/getList")
    public List<Animal>getAnimal(){
        return animalRepo.findAll();
    }
    //post
    @PostMapping("/addAnimal")
    public Animal addAnimal(@RequestBody Animal animal){
        return animalRepo.save(animal);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public void deleteAnimal(@PathVariable Long id){
        animalRepo.deleteById(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Animal> putProduct(@PathVariable Long id, @RequestBody Animal animal){
        return animalRepo.findById(id)
                .map(productFROMDB-> {
                    productFROMDB.setName(animal.getName());
                    animalRepo.save(productFROMDB);
                    return ResponseEntity.ok().body(animalRepo.save(productFROMDB));
                }).orElseGet(()->ResponseEntity.notFound().build());
    }


}
