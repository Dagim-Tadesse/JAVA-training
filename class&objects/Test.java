abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void makeSound();

    // Concrete method
    public void sleep() {
        System.out.println("Zzz...");
    }
}

class Dog extends Animal {
    // Implementing the abstract method
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Test {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound(); // Outputs: Woof!
        myDog.sleep(); // Outputs: Zzz...
    }
}
