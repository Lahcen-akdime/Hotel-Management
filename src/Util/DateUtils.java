package Util;

import java.time.LocalDate;
import Exception.InvalidReservationDateException ;

public class DateUtils {

    public static LocalDate PerseStringToLocalDate(String inputDate){
        LocalDate localDate = LocalDate.parse(inputDate);
        return localDate ;
    }
    public static void ValidateDate(String date){
        if (date.length() != 10){
            throw new InvalidReservationDateException("La date doit etre 10 character") ;
        }
        else if (LocalDate.parse(date).isBefore(LocalDate.now())){
            throw new InvalidReservationDateException("La date est invalide") ;
        }
    }

    public static void ValidateChekinCheckoutDates(LocalDate chiken,LocalDate checkout){
        if (chiken.isBefore(LocalDate.now())){
            throw new InvalidReservationDateException("La date de checkin est deja passé ! ");
        }
        if(checkout.isBefore(chiken)){
            throw new InvalidReservationDateException("La date checkout doit etre apres le checkin ! ");
        }
        else if (chiken.equals(checkout)) {
            throw new InvalidReservationDateException("La date checkout doit etre pas le meme que checkin ! ");
        }
    }
}
