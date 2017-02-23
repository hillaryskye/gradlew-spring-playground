package com.example;

/**
 * Created by hillaryskye on 2/20/17.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// ...

@RestController
@RequestMapping("/json")
public class JSONRequestController {

    @PostMapping("/string-example")
    public String postJSONString(@RequestBody Car car) {
        Gson builder = new GsonBuilder().create();
        String jsonString = builder.toJson(car);
        return jsonString;
    }

    @PostMapping("/object-example")
    public String postJSONObjString(@RequestBody String person) {
//        Gson builder = new GsonBuilder().create();
//        String jsonString = builder.toJson(person);
        return person;
    }

    public static class Person {
        private String name;
        private Car[] cars;

        public String getName() {
            return name;
        }

        public Person() {
        }

        public Person(String name, Car[] cars) {

            this.name = name;
            this.cars = cars;
        }

        public void setName(String name) {

            this.name = name;
        }

        public Car[] getCars() {
            return cars;
        }

        public void setCars(Car[] cars) {
            this.cars = cars;
        }
    }

    public static class Car{
        private String make;
        private String model;

        public Car() {

        }

        public Car(String make, String model) {
            this.make = make;
            this.model = model;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }
}