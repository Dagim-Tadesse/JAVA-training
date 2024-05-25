public class TestLocal {
    public void pupAge() {
        int age = 0;
        age = age + 7;
        System.out.println("Puppy age is : " + age);
    }

    public void pupAge1() {
        int age1 = 1999999993;// should be initialized ,, NO:- int age1;
        age1 = age1 + 7;
        System.out.println("Puppy age is : " + age1);
    }

    public static void main(String args[]) {
        TestLocal test = new TestLocal();
        test.pupAge();
        // ...............
        test.pupAge1();
    }
}