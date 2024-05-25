class Counter {
    int count = 0;// what if it is static int count=0;

    public void printCounter() {
        count++;
        System.out.println(count);
    }

    public static void main(String args[]) {
        Counter c1 = new Counter();
        c1.printCounter();
        c1.printCounter();
        Counter c2 = new Counter();
        c2.printCounter();
        Counter c3 = new Counter();
        c3.printCounter();
    }
}
