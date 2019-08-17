package day25.factory;

public class test {
    public static void main(String[] args){
        Dog d=(Dog) AnimalFactory.createAnimal("dog");
        d.eat();
        Cat c=(Cat) AnimalFactory.createAnimal("cat");
        c.eat();
    }
}