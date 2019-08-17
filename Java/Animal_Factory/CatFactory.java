package day25.Animal_Factory;

import day25.factory.Animal;
import day25.factory.Cat;

public class CatFactory implements Factory{
    @Override
    public Animal createAnimal(){
        return new Cat();
    }
    public void eat(){
        System.out.println("猫吃鱼");
    }

}
