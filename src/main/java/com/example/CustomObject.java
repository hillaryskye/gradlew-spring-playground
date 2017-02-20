package com.example;

/**
 * Created by hillaryskye on 2/19/17.
 */
public class CustomObject {

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

    @Override
    public String toString() {
        return "CustomObject{" + "animal='" + animal + '\'' + ", sound='" + sound + '\'' + '}';
    }
}
