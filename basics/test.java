
public class test {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("I said \"Hello\" to you.");
        // substriting and length of string
        String text;
        text = "Espresso";
        System.out.println(text.substring(2, 7));
        System.out.println(text.length());
        // comparing
        String greeting = "Hello";
        System.out.println(greeting.equals("Hello"));
        System.out.println(greeting.equals("hello"));
        // toLower and toUpper
        String Greeting = "Hi Mary!";// 19,23,25,31,32,34,35,42,47,
        System.out.println(Greeting.toLowerCase());
        System.out.println(Greeting.toUpperCase());
        // index
        String txt = "I Love Java and Java loves me.";
        System.out.println(txt.indexOf("J"));
        System.out.println(txt.indexOf("love"));
        System.out.println(txt.indexOf("ove"));
        // even i dont know
        int a = 10;
        int b = 20;
        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));
        System.out.println();
    }

}