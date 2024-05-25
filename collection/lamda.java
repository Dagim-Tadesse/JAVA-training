package collection;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class lamda {

    public static void main(String[] args) {
        // Step 1: Creating a lambda expression
        Greeting greetingLambda = (name) -> System.out.println("Hello, " + name);

        // Step 2: Using the lambda expression
        greetingLambda.sayHello("Dragon");
    }
}
