public class Officer {
    public Officer() {
        this("Second");
        System.out.println("1 ");
        System.out.println("I am First");
    }

    public Officer(String name) {
        System.out.println("2 ");
        System.out.println("Officer name is " + name);
    }

    public Officer(int salary) {

        this();
        System.out.println("3 ");
        System.out.println("Officer salary is " + salary);
    }

    public static void main(String args[]) {
        Officer o1 = new Officer(9000);
    }
}