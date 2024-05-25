package inheritance.polymorphism;

public class adddd {
    public static void main(String[] args) {
        String stringArray = "hello class this is final exam.";
        try {
            for (int i = 0; i <= stringArray.length(); i++) {
                System.out.println(stringArray.charAt(i));
            }
            // Attempt to access the 45th character which does not exist
            System.out.println(stringArray.charAt(45));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Attempted to access an elemen." + e.getMessage());
        }

    }
}
