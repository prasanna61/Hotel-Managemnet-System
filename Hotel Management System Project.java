import java.util.Scanner;
public class HotelManagementSystem {
    private static String[][] rooms = new String[10][2];
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        for(int i=0;i< rooms.length;i++) {
            rooms[i][0]=String.valueOf(i+1);
            rooms[i][1]="Empty";
        }
        while(true) {
            System.out.println("\nWelcome to the Hotel Management System \n");
            System.out.println("1.Check-In\n");
            System.out.println("2.Check-Out\n");
            System.out.println("3.View Occupancy\n");
            System.out.println("4.Exit\n");
            System.out.println("Enter your choice : ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    check_in();
                    break;
                case 2:
                    check_out();
                    break;
                case 3:
                    view_occupancy();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
    private static void check_in() {
        System.out.print("\nEnter room number: ");
        int roomNumber = sc.nextInt() - 1;

        if (roomNumber >= 0 && roomNumber < rooms.length) {
            if (rooms[roomNumber][1].equals("Empty")) {
                System.out.print("\nEnter guest name: ");
                String guestName = sc.next();
                rooms[roomNumber][1] = guestName;
                System.out.println("\nCheck-in successful.");
            } else {
                System.out.println("\nSorry, this room is already occupied.");
            }
        } else {
            System.out.println("\nInvalid room number. Please try again.");
        }
    }
    private static void check_out() {
        System.out.print("\nEnter room number: ");
        int roomNumber = sc.nextInt() - 1;
        if (roomNumber >= 0 && roomNumber < rooms.length) {
            if (!rooms[roomNumber][1].equals("Empty")) {
                System.out.print("\nGuest " + rooms[roomNumber][1] + " has checked out of room " + rooms[roomNumber][0] + ".");
                rooms[roomNumber][1] = "Empty";
            } else {
                System.out.println("\nSorry, this room is already vacant.");
            }
        } else {
            System.out.println("\nInvalid room number. Please try again.");
        }
    }
    private static void view_occupancy() {
        System.out.println("\nRoom\tGuest");
        for (int i = 0; i < rooms.length; i++) {
            System.out.println(rooms[i][0] + "\t" + rooms[i][1]);
        }
    }
}
