//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import Model.User;
import Service.AuthService;
import Service.ReservationService;
import Service.RoomService;
import Util.InputUtils;
import Exception.InvalidCredentialsException ;

public class Main {

    private static AuthService authService = new AuthService() ;
    private static RoomService roomService = new RoomService() ;
    private static ReservationService reservationService = new ReservationService() ;
    private static InputUtils inputUtils = new InputUtils() ;
    //private static RoomInitializer roomInitializer = new RoomInitializer() ;

    public static void mainMenu(){
        Boolean continuer = true ;
        while(continuer){
            System.out.println("==========================");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");
            System.out.println("Your choice : ");
            int choice = inputUtils.lireInt() ;
            switch (choice){
                case 1 : registerForm();
                    break;
                case 2 : loginForm();
                    break;
                case 3 :
                    System.out.println("Au revoir !!");
                    continuer = false ;
                    break;
                default:
                    System.out.println("choix invalide ! ");
                    continuer = false ;
            }
        }
    }

    // ================ Hotel Menu =================
    public static void hotelManagementMenu(User user){
        Boolean continuer = true ;
        while(continuer) {
            System.out.println("==========================");
            System.out.println("== Welcome back " + user.getFullName() + " ! ");
            System.out.println("==========================");
            System.out.println("1 - Search Availble Rooms");
            System.out.println("2 - View all rooms");
            System.out.println("3 - Create reservation");
            System.out.println("4 - My reservations");
            System.out.println("5 - Update reservation");
            System.out.println("6 - Cancel reservation");
            System.out.println("7 - Update profile");
            System.out.println("8 - Change password");
            System.out.println("9 - Logout");
            System.out.println("10 - Exit");
            System.out.println("Your choice : ");
            int choice = inputUtils.lireInt();
            switch (choice) {
                case 1: roomService.getAvailbleRooms();break;
                case 2: roomService.getAll();break;
                case 3: createReservation();break;
                case 4: reservationService.getMyReservations();break;
                case 7 : updateProfileForm(user);break;
                case 8 : updatePasswordForm(user);break;
                case 9 :
                    System.out.println("Au revoir !!");
                     authService.deconnexion(user) ;
                    continuer = false;
                    break;
                default:
                    System.out.println("choix invalide ! ");
                    continuer = false;
            }
        }
    }

    // ============== For User ===============
    public static void registerForm(){
        System.out.println("===============================");
        String fullName = inputUtils.lireString("fullName");
        String email = inputUtils.lireString("email");
        String password = inputUtils.lireString("password");
        String phone = inputUtils.lireString("phone");
        try {
        User user = authService.inscreption(email,fullName,phone,password) ;
        hotelManagementMenu(user);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loginForm(){
        System.out.println("===============================");
        String email = inputUtils.lireString("email");
        String password = inputUtils.lireString("password");
        try {
        User user = authService.connexion(email,password).get() ;
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
            return ;
        }
        hotelManagementMenu(AuthService.getCurrentUser());
    }

    public static void updatePasswordForm(User user){
        System.out.println("==== Change password Form ====");
        String newPassword = inputUtils.lireString("neauvau mot de pass ") ;
        authService.changePassword(user,newPassword) ;
        System.out.println("Your password is updated seccussfuly");
    }

    public static void updateProfileForm(User user){
        System.out.println("=== Update Profile Form ===");
        String newFullName = inputUtils.lireString("neauvau full name ");
        String newEmail = inputUtils.lireString("neauvau email ");
        String newPassword = inputUtils.lireString("neauvau mot de pass ");
        String newPhone = inputUtils.lireString("neauvau phone number ");
        authService.editProfile(user,newFullName,newPhone,newPassword,newEmail) ;
        System.out.println("User updated seccessfuly");
    }

    // ============== For reservations =============
    public static void createReservation(){
        System.out.println("====== Cree ton reservation ici ======\n");
        System.out.println("Le nombre de chambre ?");
        Integer roomNumber = inputUtils.lireInt();
        String checkin = inputUtils.lireString("date d'entree en ce format : 2026-09-09") ;
        String checkout = inputUtils.lireString("date de sortie en ce format : 2026-09-09") ;
        System.out.println("Combien de guest ?");
        int numberOfGuests = inputUtils.lireInt();
        System.out.println("Combien de nuits ?");
        Long numberOfNights = inputUtils.lireLong() ;
        reservationService.createReservation(roomNumber,checkin,checkout,numberOfGuests,numberOfNights);
    }

    // =============== Principal main ================
    public void main(){
        mainMenu();
    }
}
