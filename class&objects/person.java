class Person {
   private String fname;
   private String mname;
   private String lname;
   private String addr;

   public Person(String firstname, String middlename, String lastname, String address) {// constructor
      fname = firstname;
      mname = middlename;
      lname = lastname;
      addr = address;
   }

   public String getFname() { // accessor for fname
      return fname;
   }

   public String getMname() { // accessor for Mname
      return mname;
   }

   public String getLname() { // acccessor for Lname
      return lname;
   }

   public String getAddress() { // accessor for Address
      return addr;
   }

   public void setAddress(String address) { // mutator for address
      addr = address;
   }

   public void setLname(String lastname) { // mutator for Last name
      lname = lastname;
   }

   public static void main(String args[]) {
      Person per = new Person("Alice", "Bob", "James", "London");
      System.out.println(per.getFname() + " " + per.getMname() + " " + per.getLname() + " " + per.getAddress());
      per.setAddress("Paris"); // to change London to Paris
      per.setLname("Baker"); // to change last name from James to Baker
      System.out.println(per.getFname() + " " + per.getMname() + " " + per.getLname() + " " + per.getAddress());
   }
}