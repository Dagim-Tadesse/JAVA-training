
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Room {
    String roomNumber;
    String roomType;
    int roomPrice;
    int paymentStatus;
    String isBooked;

    Room(String roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = "Available";
        this.paymentStatus = 0;
        if (roomType.equals("singlebed")) {
            this.roomPrice = 1500;
        } else if (roomType.equals("doublebed")) {
            this.roomPrice = 3000;
        } else {
            this.roomPrice = 5000;
        }
    }

    void bookRoom() {
        if (isBooked.equals("Available")) {
            isBooked = "Booked";
            paymentStatus = 1;
            System.out.println("Room " + roomNumber + " has been booked.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    void checkAvailability() {
        if (isBooked.equals("Booked")) {
            System.out.println("Room " + roomNumber + " - " + roomType + " is booked.");
        } else if (isBooked.equals("Occupied")) {
            System.out.println("Room " + roomNumber + " - " + roomType + " is occupied.");
        } else {
            System.out.println("Room " + roomNumber + " - " + roomType + " is available.");
        }
    }
}

class Guest {
    String name;
    String contactInfo;

    Guest(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }
}

class Booking {
    Room room;
    Guest guest;

    Booking(Room room, Guest guest) {
        this.room = room;
        this.guest = guest;
    }
}

public class HotelManagement {
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Guest> guests = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static ArrayList<String> reports = new ArrayList<>();
    static String RoomPath = "room.txt";
    static String BookPath = "book.txt";
    static String GuestPath = "guest.txt";
    static String ReportPath = "report.txt";

    // to set the date
    // Get the current date and time
    static LocalDateTime currentDateTime = LocalDateTime.now(); // Define a formatter to display the date and time in a
    // readable format for only the date
    static DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Format the current date

    static String formattedDate = currentDateTime.format(dateformatter); // Print the current date

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // to load the arrays from the existing files

        ////////////////////////////// room

        try (FileInputStream fis = new FileInputStream(RoomPath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line, line1;
            while ((line = reader.readLine()) != null) {
                line1 = reader.readLine();
                rooms.add(new Room(line, line1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //////////////////////////// guest

        try (FileInputStream fis = new FileInputStream(GuestPath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line, line1;
            while ((line = reader.readLine()) != null) {
                line1 = reader.readLine();
                guests.add(new Guest(line, line1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /////////////////////////// booking

        try (FileInputStream fis = new FileInputStream(BookPath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String roomLine;
            while ((roomLine = reader.readLine()) != null) {
                String guestLine = reader.readLine();
                String payLine = reader.readLine();
                Guest guest = null;
                for (Guest g : guests) {
                    if (g.name.equals(guestLine)) {
                        guest = g;
                        break;
                    }
                }
                Room room = null;
                for (Room r : rooms) {
                    if (r.roomNumber.equals(roomLine)) {
                        room = r;
                        break;
                    }
                }

                bookings.add(new Booking(room, guest));
                // this is room.bookRoom() with out the statement;
                for (Booking booking : bookings) {
                    if (booking.room.roomNumber.equals(roomLine)) {
                        booking.room.isBooked = "Booked";
                        booking.room.paymentStatus = 1;
                    }
                }
                for (Booking booking : bookings) {
                    if (booking.room.roomNumber.equals(roomLine)) {
                        if (payLine.equals("paid")) {
                            booking.room.paymentStatus = 0;
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //////////////////////////////////// report

        try (FileInputStream fis = new FileInputStream(ReportPath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = reader.readLine()) != null) {

                reports.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //////////////////////////////////// LOADED!!!////////////////////////////////////////////////////////////
        while (true) {
            displayMainMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 7) {
                displayExitMenu();
                int exitChoice = scanner.nextInt();
                handleExitMenuChoice(exitChoice);
                if (exitChoice == 1 || exitChoice == 2)
                    break; // Exit loop to terminate program
            } else {
                handleMainMenuChoice(choice, scanner);
            }
        }

        scanner.close();
    }

    public static void displayMainMenu() {
        // clearScreen();
        System.out.println("----------------------------------");
        System.out.println("        HOTEL MANAGEMENT          ");
        System.out.println("----------------------------------");
        System.out.println("1. Room Management");
        System.out.println("2. Guest Management");
        System.out.println("3. Booking Management");
        System.out.println("4. Check-In/Check-Out");
        System.out.println("5. Billing and Payments");
        System.out.println("6. Reports and Analytics");
        System.out.println("7. Exit");
        System.out.println("----------------------------------");
    }

    public static void handleMainMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                displayRoomMenu(scanner);
                break;
            case 2:
                displayGuestMenu(scanner);
                break;
            case 3:
                displayBookingMenu(scanner);
                break;
            case 4:
                displayCheckInOutMenu(scanner);
                break;
            case 5:
                displayBillingMenu(scanner);
                break;
            case 6:
                displayReportsMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void displayRoomMenu(Scanner scanner) {
        System.out.println("\nROOM MANAGEMENT");
        System.out.println("----------------");
        System.out.println("1. Add Room");
        System.out.println("2. List All Rooms");
        System.out.println("3. Search Room by ID");
        System.out.println("4. Update Room Details");
        System.out.println("5. Delete Room");
        System.out.println("6. Back to Main Menu");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();// when scanning it consumes only the intiger but not the '\n'(which exists in
                                       // every input scanner)
        scanner.nextLine();// to consume the leftover '\n'
        handleRoomMenuChoice(choice, scanner);
    }

    public static void handleRoomMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                addRoom(scanner);
                break;
            case 2:
                listAllRooms();
                break;
            case 3:
                searchRoomByID(scanner);
                break;
            case 4:
                updateRoomDetails(scanner);
                break;
            case 5:
                deleteRoom(scanner);
                break;
            case 6:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void addRoom(Scanner scanner) {
        System.out.print("Enter room number to add: ");
        String roomNumber = scanner.nextLine();

        System.out.println("Enter the room type(singlebed,doublebed,suite):");
        String roomtype = scanner.nextLine();

        roomtype = roomtype.toLowerCase();// to change uppercase to lowercase

        if (roomtype.equals("singlebed") || roomtype.equals("doublebed") || roomtype.equals("suite")) {
            rooms.add(new Room(roomNumber, roomtype));
            System.out.println("Room " + roomNumber + " added.");
        } else {
            System.out.println("ERROR wrong room type, try again");
        }
    }

    public static void listAllRooms() {
        System.out.println("All Rooms:");
        for (Room room : rooms) {
            System.out.println("Room " + room.roomNumber + " - " + room.roomType + " - "
                    + room.isBooked);
        }
    }

    public static void searchRoomByID(Scanner scanner) {
        System.out.print("Enter room number to search: ");
        String roomNumber = scanner.nextLine();
        for (Room room : rooms) {
            if (room.roomNumber.equals(roomNumber)) {
                room.checkAvailability();
                return;
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
    }

    public static void updateRoomDetails(Scanner scanner) {
        System.out.print("Enter room number to update: ");
        String roomNumber = scanner.nextLine();
        for (Room room : rooms) {
            if (room.roomNumber.equals(roomNumber)) {
                System.out.print("Enter new room number: ");
                room.roomNumber = scanner.nextLine();
                System.out.println("Enter the new room type(singleroom,doubleroom,suite):");
                room.roomType = scanner.nextLine();
                System.out.println("Room details updated.");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
    }

    public static void deleteRoom(Scanner scanner) {
        System.out.print("Enter room number to delete: ");
        String roomNumber = scanner.nextLine();
        rooms.removeIf(room -> room.roomNumber.equals(roomNumber));
        bookings.removeIf(booking -> booking.room.roomNumber.equals(roomNumber));
        System.out.println("Room " + roomNumber + " deleted.");
    }

    public static void displayGuestMenu(Scanner scanner) {
        System.out.println("\nGUEST MANAGEMENT");
        System.out.println("----------------");
        System.out.println("1. Add Guest");
        System.out.println("2. List All Guests");
        System.out.println("3. Search Guest by Name");
        System.out.println("4. Update Guest Details");
        System.out.println("5. Delete Guest");
        System.out.println("6. Back to Main Menu");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        handleGuestMenuChoice(choice, scanner);
    }

    public static void handleGuestMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                addGuest(scanner);
                break;
            case 2:
                listAllGuests();
                break;
            case 3:
                searchGuestByName(scanner);
                break;
            case 4:
                updateGuestDetails(scanner);
                break;
            case 5:
                deleteGuest(scanner);
                break;
            case 6:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void addGuest(Scanner scanner) {
        System.out.print("Enter guest name to add: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact-Info(phone-Number): ");
        String contactInfo = scanner.nextLine();
        guests.add(new Guest(name, contactInfo));
        System.out.println("Guest " + name + " added.");
    }

    public static void listAllGuests() {
        System.out.println("All Guests:");
        for (Guest guest : guests) {
            System.out.println("Guest Name: " + guest.name + " , Contact-Info: " + guest.contactInfo);
        }
    }

    public static void searchGuestByName(Scanner scanner) {
        System.out.print("Enter guest name to search: ");
        String name = scanner.nextLine();
        for (Guest guest : guests) {
            if (guest.name.equals(name)) {
                System.out.println("Guest " + name + " - " + guest.contactInfo + " found.");
                return;
            }
        }
        System.out.println("Guest " + name + " not found.");
    }

    public static void updateGuestDetails(Scanner scanner) {
        System.out.print("Enter guest name to update: ");
        String name = scanner.nextLine();
        for (Guest guest : guests) {
            if (guest.name.equals(name)) {
                System.out.print("Enter new guest name: ");
                guest.name = scanner.nextLine();
                System.out.println("Enter new contact-Info: ");
                guest.contactInfo = scanner.nextLine();
                System.out.println("Guest details updated.");
                return;
            }
        }
        System.out.println("Guest " + name + " not found.");
    }

    public static void deleteGuest(Scanner scanner) {
        System.out.print("Enter guest name to delete: ");
        String name = scanner.nextLine();
        guests.removeIf(guest -> guest.name.equals(name));
        bookings.removeIf(booking -> booking.guest.name.equals(name));
        System.out.println("Guest " + name + " deleted.");
    }

    public static void displayBookingMenu(Scanner scanner) {
        System.out.println("\nBOOKING MANAGEMENT");
        System.out.println("------------------");
        System.out.println("1. Add Booking");
        System.out.println("2. List All Bookings");
        System.out.println("3. Search Booking by Room Number");
        System.out.println("4. Update Booking Details");
        System.out.println("5. Delete Booking");
        System.out.println("6. Back to Main Menu");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        handleBookingMenuChoice(choice, scanner);
    }

    public static void handleBookingMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                addBooking(scanner);
                break;
            case 2:
                listAllBookings();
                break;
            case 3:
                searchBookingByRoomNumber(scanner);
                break;
            case 4:
                updateBookingDetails(scanner);
                break;
            case 5:
                deleteBooking(scanner);
                break;
            case 6:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void addBooking(Scanner scanner) {
        System.out.print("Enter room number to book: ");
        String roomNumber = scanner.nextLine();
        System.out.print("Enter guest name: ");
        String guestName = scanner.next();

        Room room = null;
        for (Room r : rooms) {
            if (r.roomNumber.equals(roomNumber)) {
                room = r;
                break;
            }
        }

        if (room == null) {
            System.out.println("Room " + roomNumber + " not found.");
            return;
        }

        Guest guest = null;
        for (Guest g : guests) {
            if (g.name.equals(guestName)) {
                guest = g;
                break;
            }
        }

        if (guest == null) {
            System.out.println("Guest " + guestName + " not found.");
            return;
        }

        bookings.add(new Booking(room, guest));
        room.bookRoom();
    }

    public static void listAllBookings() {
        System.out.println("All Bookings:");
        for (Booking booking : bookings) {
            System.out.println("Room " + booking.room.roomNumber + " booked by " + booking.guest.name);
            if (booking.room.paymentStatus == 0)
                System.out.println("paid.");
            else
                System.out.println("not paid.");
        }
    }

    public static void searchBookingByRoomNumber(Scanner scanner) {
        System.out.print("Enter room number to search booking: ");
        String roomNumber = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.room.roomNumber.equals(roomNumber)) {
                System.out.println("Room " + roomNumber + " booked by " + booking.guest.name);
                if (booking.room.paymentStatus == 0)
                    System.out.println("paid.");
                else
                    System.out.println("not paid.");
                return;
            }
        }
        System.out.println("Booking for room " + roomNumber + " not found.");
    }

    public static void updateBookingDetails(Scanner scanner) {
        System.out.print("Enter room number to update booking: ");
        String roomNumber = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.room.roomNumber.equals(roomNumber)) {
                System.out.print("Enter new guest name: ");
                String newGuestName = scanner.next();

                Guest newGuest = null;
                for (Guest g : guests) {
                    if (g.name.equals(newGuestName)) {
                        newGuest = g;
                        break;
                    }
                }

                if (newGuest == null) {
                    System.out.println("Guest " + newGuestName + " not found.");
                    return;
                }

                booking.guest = newGuest;
                System.out.println("Booking details updated.");
                return;
            }
        }
        System.out.println("Booking for room " + roomNumber + " not found.");
    }

    public static void deleteBooking(Scanner scanner) {
        System.out.print("Enter room number to delete booking: ");
        String roomNumber = scanner.nextLine();
        bookings.removeIf(booking -> booking.room.roomNumber.equals(roomNumber));
        System.out.println("Booking for room " + roomNumber + " deleted.");
    }

    public static void displayCheckInOutMenu(Scanner scanner) {
        System.out.println("\nCHECK-IN/CHECK-OUT");
        System.out.println("------------------");
        System.out.println("1. Check-In");
        System.out.println("2. Check-Out");
        System.out.println("3. Back to Main Menu");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        handleCheckInOutMenuChoice(choice, scanner);
    }

    public static void handleCheckInOutMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                checkIn(scanner);
                break;
            case 2:
                checkOut(scanner);
                break;
            case 3:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void checkIn(Scanner scanner) {
        System.out.print("Enter room number to check-in: ");
        String roomNumber = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.room.roomNumber.equals(roomNumber)) {
                booking.room.isBooked = "Occupied";
                System.out.println("Check-in successful for room " + roomNumber + ".");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not booked or doesn't exist.");
    }

    public static void checkOut(Scanner scanner) {
        System.out.print("Enter room number to check-out: ");
        String roomNumber = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.room.roomNumber.equals(roomNumber) && booking.room.paymentStatus == 0) {
                // room.isBooked = false;
                bookings.remove(booking);
                System.out.println("Check-out successful for room " + roomNumber + ".");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not booked or hasn't been paid or doesn't exist.");
    }

    public static void displayExitMenu() {
        System.out.println("\nEXIT MENU");
        System.out.println("------------------");
        System.out.println("1. Save and Exit");
        System.out.println("2. Exit without Saving");
        System.out.println("3. Cancel");
    }

    public static void handleExitMenuChoice(int choice) {
        switch (choice) {
            case 1:
                saveData();
                System.out.println("Data saved successfully. Exiting...");
                System.exit(0);
                break;
            case 2:
                System.out.println("Exiting without saving...");
                System.exit(0);
                break;
            case 3:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void displayBillingMenu(Scanner scanner) {
        System.out.println("\nBILLING AND PAYMENTS");
        System.out.println("------------------");
        System.out.println("1. Generate Invoice");
        System.out.println("2. Process Payment");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        handleBillingMenuChoice(choice, scanner);
    }

    public static void handleBillingMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                generateInvoice(scanner);
                break;
            case 2:
                processPayment(scanner);
                break;
            case 3:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void generateInvoice(Scanner scanner) {
        System.out.print("Enter room number to generate invoice: ");
        String roomNumber = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.room.roomNumber.equals(roomNumber) && booking.room.paymentStatus == 1) {
                System.out.println("Room " + booking.room.roomNumber + " booked by " + booking.guest.name + " - "
                        + booking.room.roomType + " : " + booking.room.roomPrice);
                System.out.println("Invoice generated for room " + roomNumber + ".");
                return;
            }
        }
        System.out.println("The room doesn't exist or has been paid.");
    }

    public static void processPayment(Scanner scanner) {
        System.out.print("Enter room number for payment: ");
        String roomNumber = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.room.roomNumber.equals(roomNumber) && booking.room.paymentStatus == 1) {

                System.out.print("Enter the exact payment amount: ");
                int amount = scanner.nextInt();
                if (booking.room.roomPrice == amount) {
                    booking.room.paymentStatus = 0;
                    // --------------------------------------
                    int datefind = 0, salecount = 0;
                    for (String str1 : reports) {
                        salecount = 0;
                        // str1.length() > 3; because the error of substring (out of bound index)
                        if (str1.length() > 3 && !(str1.substring(0, 5).equals("Guest"))) {
                            salecount = 1;
                        }
                        if (str1.equals(formattedDate)) {
                            datefind++;
                        }
                    }

                    if (datefind == 0) {
                        if (salecount == 1) {
                            reports.add("NO-SALE");
                        }
                        reports.add(formattedDate);
                    }
                    // -------------------------------------
                    String str = "Guest: " + booking.guest.name + " - " + booking.guest.contactInfo + " Room: "
                            + booking.room.roomNumber
                            + " - " + booking.room.roomType + " - " + booking.room.roomPrice + "br.";
                    reports.add(booking.room.roomNumber);
                    reports.add(str);

                    System.out.println("Payment of " + booking.room.roomNumber + " has been processed.");

                } else {
                    System.out.println("Payment Failed!!!");
                }
                return;
            }

        }
        System.out.println("The room doesn't exist or has been paid.");
    }

    public static void displayReportsMenu(Scanner scanner) {
        System.out.println("\nREPORTS AND ANALYTICS");
        System.out.println("------------------");
        System.out.println("1. View Payment History");
        System.out.println("2. Daily Sales Report");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        handleReportsMenuChoice(choice, scanner);
    }

    public static void handleReportsMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                viewPaymentHistory(scanner);
                break;
            case 2:
                generateDailySalesReport(scanner);
                break;

            case 3:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void viewPaymentHistory(Scanner scanner) {
        System.out.println("Payment History:"); // Logic to display payment history
        try (FileInputStream fis = new FileInputStream(ReportPath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void generateDailySalesReport(Scanner scanner) {

        int x = -1, count = 0, totalSales = 0;
        System.out.println("Enter a date (yyyy-MM-dd): ");
        String datestr = scanner.nextLine();

        for (int i = 0; i < reports.size() - 1; i++) {
            String line = reports.get(i);
            if (line.length() > 4 && line.equals(datestr) && !(reports.get(i + 1).equals("NO-SALE"))) {
                x = i + 1;
                for (int j = i + 1; j < reports.size(); j += 2) {
                    line = reports.get(j);
                    if (line.length() > 4)
                        break;
                    count += 2;
                }
            }

        }
        if (x == -1) {
            System.out.println("The date doesnt exist or there was no sale.");
            return;
        }
        for (int i = x; i < count + x; i += 2) {
            String line = reports.get(i);
            for (Room room : rooms) {
                if (room.roomNumber.equals(line)) {
                    totalSales += room.roomPrice;
                }
            }
        }
        double averageSales = (double) totalSales / (count / 2);
        System.out.println("Daily Sales Report:");
        System.out.println("Total Sales: " + totalSales);
        System.out.println("Average Sales: " + averageSales);
    }

    public static void saveData() {
        try (FileOutputStream fos = new FileOutputStream(RoomPath);
                PrintWriter writer = new PrintWriter(fos)) {
            for (Room room : rooms) {
                String str = room.roomNumber;
                String str1 = room.roomType;
                writer.println(str);
                writer.println(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(GuestPath);
                PrintWriter writer = new PrintWriter(fos)) {
            for (Guest guest : guests) {
                String str = guest.name;
                String str1 = guest.contactInfo;
                writer.println(str);
                writer.println(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(BookPath);
                PrintWriter writer = new PrintWriter(fos)) {
            for (Booking booking : bookings) {
                String strRoom = booking.room.roomNumber;
                String strGuest = booking.guest.name;
                String strpay;
                if (booking.room.paymentStatus == 0) {
                    strpay = "paid";
                } else {
                    strpay = "-";
                }
                writer.println(strRoom);
                writer.println(strGuest);
                writer.println(strpay);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(ReportPath);
                PrintWriter writer = new PrintWriter(fos)) {
            // int datefind = 0, salecount = 0;
            // for (String str1 : reports) {
            // salecount = 0;
            // // str1.length() > 3; because the error of substring (out of bound index)
            // if (str1.length() > 3 && !(str1.substring(0, 5).equals("Guest"))) {
            // salecount = 1;
            // }
            // if (str1.equals(formattedDate)) {
            // datefind++;
            // }
            // }

            for (String str : reports) {
                writer.println(str);
            }
            // if (datefind == 0) {
            // if (salecount == 1) {
            // writer.println("NO-SALE");
            // }
            // writer.println(formattedDate);
            // }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Data saved successfully.");

    }

}