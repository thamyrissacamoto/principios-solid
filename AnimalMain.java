class Animal {
    void eat() {
        System.out.println("The animal is eating");
    }
}

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("The dog is eating");
    }
}

public class AnimalMain {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.eat();  
        dog.eat();  
    }
}