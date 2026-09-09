package Service;

import Model.Reservation;
import Model.Room;
import Repository.impl.InMemoryReservationRepository;
import Util.CalculationUtils;
import Util.DateUtils;
import Util.MoneyUtils;
import Util.ValidationUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import Exception.InvalidReservationDateException ;
import Exception.InvalidReservationException ;

public class ReservationService {

    private static RoomService roomService = new RoomService() ;
    private InMemoryReservationRepository inMemoryReservationRepository = new InMemoryReservationRepository() ;

    public void createReservation(Integer roomNumber, String checkin, String checkout, int numberOfGuests, Long numberOfNights){

        try {
            // date validation
        DateUtils.ValidateDate(checkin);
        DateUtils.ValidateDate(checkout);
        LocalDate chekinDate = DateUtils.PerseStringToLocalDate(checkin.replaceAll("\\s","")) ;
        LocalDate chekoutDate = DateUtils.PerseStringToLocalDate(checkout.replaceAll("\\s","")) ;
        DateUtils.ValidateChekinCheckoutDates(chekinDate,chekoutDate);
        // get room
        Optional<Room> room = roomService.findRoomByNumber(roomNumber) ;
        // verify capacite
        ValidationUtils.TheCapaciteOfRoomIsPossible(numberOfGuests,room.get());
        // calculate total price
        BigDecimal totalPrice = MoneyUtils.totalPrice(room.get().getPricePerNight(),numberOfNights) ;
        // create + save the reservation
        Reservation reservation = new Reservation(roomNumber,chekinDate,chekoutDate,numberOfGuests,numberOfNights,totalPrice);
        inMemoryReservationRepository.save(reservation);
            System.out.println(inMemoryReservationRepository.toString());
        } catch (InvalidReservationDateException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidReservationException e) {
            System.out.println(e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date ( la date doit respecter cette format : 2026-09-03 )");
        }
    }

    public void getMyReservations(){
            System.out.println("======= Your reservations =======");
         inMemoryReservationRepository.findByUserId(AuthService.getCurrentUser().getId()).stream()
                .forEach(reservation -> {
            System.out.println("=================================");
            System.out.println("checkin : "+reservation.getCheckin());
            System.out.println("checkout : "+reservation.getCheckout());
            System.out.println("number of guests : "+reservation.getNumberOfGuests());
            System.out.println("reservation code : "+reservation.getReservationCode());
            System.out.println("price total : "+reservation.getTotalPrice());
            System.out.println("reservation status : "+reservation.getReservationStatus());
        });
    }
}
