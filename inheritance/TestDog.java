package inheritance;

class Animal {
    public void move1() {
        System.out.println("Animals can move");
    }
}

class Dog extends Animal {
    public void move() {
        System.out.println("Dogs can walk and run");
    }
}

public class TestDog {
    public static void main(String args[]) {
        Animal a = new Animal();
        Dog b = new Dog();
        a.move1(); // runs the method in Animal clas
        b.move1(); // Runs the method in Dog clas
    }
}
