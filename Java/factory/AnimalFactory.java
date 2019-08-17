package day25.factory;

public class AnimalFactory {
    /*public static Dog createDog(){
        return new Dog();
    }
    public static Cat createCat(){
        return new Cat();
    }
    //发现方法复用性太差
    */
    public static Animal createAnimal(String name){
        if("dog".equals(name)){
            return new Dog();
        }else if("cat".equals(name)){
            return new Cat();
        }else{
            return null;//弊端：如果出现其他的类，那么该类返回值为null，那么由null来调用eat()方法，就会出现空指针异常，这是该条件的弊端。
        }
    }
}
