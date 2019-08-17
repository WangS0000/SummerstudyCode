package day25.Animal_Factory;

import day25.factory.Dog;

public class Test {
    public static void main(String[] args){
        DogFactory df=new DogFactory();
        Dog d=(Dog) df.createAnimal();
        d.eat();
    }
}
