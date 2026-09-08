//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import Model.Reservation;
import Model.Room;
import Model.RoomType;
import Model.User;

import java.util.Scanner;

public class Main {

    public static int lireInt(Scanner scanner){
        try{
        int choice = scanner.nextInt() ;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void main(){
        Boolean continuer = true ;
        Scanner scanner = new Scanner(System.in) ;
        while(continuer){
                System.out.println("==========================");
                System.out.println("1 - Register");
                System.out.println("2 - Login");
                System.out.println("3 - Exit");
                System.out.println("Your choice : ");
                int choice = lireInt(scanner);
                //switch ()
        }
    }
}
        //public int PrincipleMenu(Scanner scanner , String name){
        //    System.out.println("==========================");
        //    System.out.println("== Login as "+name+" ==");
        //    System.out.println("==========================");
        //    System.out.println("1 - Search Availble Rooms");
        //    System.out.println("2 - View all rooms");
        //    System.out.println("3 - Create reservation");
        //    System.out.println("4 - My reservations");
        //    System.out.println("5 - Update reservation");
        //    System.out.println("6 - Cancel reservation");
        //    System.out.println("7 - Update profile");
        //    System.out.println("8 - Change password");
        //    System.out.println("9 - Logout");
        //    System.out.println("10 - Exit");
        //    System.out.println("Your choice : ");
        //    return scanner.nextInt() ;
        //}
        //}
//    System.out.println();
//}
