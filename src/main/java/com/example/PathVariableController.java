package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hillaryskye on 2/19/17.
 */

@RestController
@RequestMapping("/animals/{animal}")

public class PathVariableController {
    @GetMapping("/{sound}")
    public String getIndividualParams(@PathVariable String animal, @PathVariable String sound) { // http://localhost:8080/animals/Cat/meow
        return String.format("animal:%s sound:%s", animal, sound); // animal:Cat sound:meow
    }

    @GetMapping("/map/{sound}")
    public String getAnimalSound(@PathVariable Map pathVariables) { // http://localhost:8080/animals/Cat/map/meow
        return pathVariables.toString(); // {animal="Cat", sound=meow}
    }

    @GetMapping("/object/{sound}")
    public String getAnimalSound(Animals animals) { // http://localhost:8080/animals/Cat/object/meow
        return String.format("animal:%s sound:%s", animals.getAnimal(), animals.getSound()); // animal:Cat sound:meow
    }

    public static class Animals {
        public String getAnimal() {
            return animal;
        }

        public void setAnimal(String animal) {
            this.animal = animal;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        private String animal;
        private String sound;
    }
}
