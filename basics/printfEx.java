public class printfEx {

    public static void main(String args[]) {

        // %[flags][width][.precision][specifier-character]

        {
            String word = "dragondagi";// %s
            char fletter = 'd';// %c
            int age = 21;// %d
            double gpa = 3.48;// %f
            boolean isHappy = true;// %b

            System.out.printf("\nhello %s.\n", word);

            System.out.printf("first letter is '%c'\n", fletter);
            // .precision
            // %f = 3.480000 ,, %.2f = 3.48 ,, %.1f = 3.5
            System.out.printf("your age is %d years old, with a gpa of %.2f\n", age,
                    gpa);

            System.out.printf("are you happy: %b\n", isHappy);
        }

        // flags
        // + = output a plus
        // , = comma grouping separator
        // ( = negative numbers are enclosed in()
        // space = display minus if negative , space if positive

        // {
        // int x = 10000000;
        // double y = -32.2;

        // System.out.printf("%,d\n", x);
        // System.out.printf("%(.2f\n", y);
        // System.out.printf("% ,d\n% .1f\n", x, y);
        // }

        // width
        // 0 = padding with 0
        // number = right padding
        // negetive number= left padding

        // {
        // int id1 = 1;
        // int id2 = 23;
        // int id3 = 456;
        // int id4 = 7890;

        // System.out.printf("%04d\n", id1);
        // System.out.printf("%4d\n", id2);
        // System.out.printf("%-4d\n", id3);// padded by space 456_
        // System.out.printf("%-4d\n", id4);
        // }
    }
}
