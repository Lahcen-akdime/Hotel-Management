package Model;

import java.math.BigDecimal;

public class Room {
    private Integer roomNumber ;
    private RoomType type ;
    private int capacite ;
    private BigDecimal pricePerNight ;
    private RoomStatus roomStatus = RoomStatus.AVAILABLE ;

    public Room(Integer roomNumber, RoomType type, int capacite, BigDecimal pricePerNight) {
        if(pricePerNight.compareTo(BigDecimal.ZERO) == 0){
            throw new IllegalArgumentException("The price per night "+pricePerNight+" is negatif !");
        }
        if(capacite < 0){
            throw new IllegalArgumentException("The capacite "+capacite+" not acceptable !");
        }
        this.roomNumber = roomNumber;
        this.type = type;
        this.capacite = capacite;
        this.pricePerNight = pricePerNight;
        this.roomStatus = roomStatus;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public int getCapacite() {
        return capacite;
    }


    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }


    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public RoomType getType() {
        return type;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Boolean isAvailble(){
        if (roomStatus == RoomStatus.AVAILABLE){
            return true ;
        }
        else {
            return false ;
        }
    }

    @Override
    public String toString() {
        StringBuilder reservationInfo = new StringBuilder("[room] roomNumber : "+roomNumber+" , roomType : "+type+" , reservation Status : "+pricePerNight.toString()) ;
        return reservationInfo.toString() ;
    }

}
