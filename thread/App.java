package thread;

class MyClass implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println("hello students");
        // Thread.yield();
    }

}

class MyClass2 implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println("hello teacher");
        Thread.yield();
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Runnable obj1 = new MyClass();
        Runnable obj2 = new MyClass2();
        Thread tr1 = new Thread(obj1);

        Thread tr2 = new Thread(obj2);
        tr1.start();

        tr2.start();
    }
}
