
public class string {
    public static void main(String[] args) {
        System.out.println("This is a string literal.\n123 Main Street");
        // .......................
        String text, text1 = "", text2 = "Hello", text3 = "Java", text4 = "world";
        text = "Espresso";
        System.out.println(text.substring(6, 8));
        System.out.println(text.substring(4));
        System.out.println("text1:" + text1.length());
        System.out.println("text2:" + text2.length());
        System.out.println("text3:" + text3.length());

        String txt = "I Love Java and Java loves me.";
        System.out.println(txt.indexOf("J"));
        System.out.println(txt.indexOf("love"));
        System.out.println(txt.indexOf("ove"));

        String txt1 = "John";
        String txt2 = "Java";
        System.out.println(txt1 + txt2);
        System.out.println(txt1 + " " + txt2);
        System.out.println("how are you, " + txt1 + "?");

        System.out.println(text2.substring(1, 3));
        System.out.println(text4.length());
        System.out.println(txt.indexOf("I"));
        System.out.println(text2 + " " + text4);

    }
}
