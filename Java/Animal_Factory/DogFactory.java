package day25.Animal_Factory;

import day25.factory.Animal;
import day25.factory.Dog;

public class DogFactory implements Factory{
    @Override
    public Animal createAnimal(){
        return new Dog();
    }
    public void eat(){
        System.out.println("狗吃肉");
    }
}
