package Service;

import Model.Room;
import Repository.RoomRepository;
import Repository.impl.InMemoryRoomRepository;

import java.util.Optional;

public class RoomService {

    private RoomRepository roomRepository ;
    private static InMemoryRoomRepository inMemoryRoomRepository = new InMemoryRoomRepository() ;

    public void getAll(){
        System.out.println("========= All Rooms =========") ;
        inMemoryRoomRepository.getAll().forEach(room->{
            System.out.println("===============================");
            System.out.println("Room number : "+room.getRoomNumber());
            System.out.println("Status : "+room.getRoomStatus());
            System.out.println("Capacite : "+room.getCapacite());
            System.out.println("Price Per night : "+room.getPricePerNight());
            System.out.println("Type : "+room.getType());
            System.out.println("Is availble : "+room.isAvailble());
        });
    }

    public void getAvailbleRooms(){
        System.out.println("========= Availble Rooms =========") ;
        inMemoryRoomRepository.getAvailbleRooms().forEach(room -> {
            System.out.println("=================================");
            System.out.println("Room number : " + room.getRoomNumber());
            System.out.println("Status : " + room.getRoomStatus());
            System.out.println("Capacite : " + room.getCapacite());
            System.out.println("Price Per night : " + room.getPricePerNight());
            System.out.println("Type : " + room.getType());
        });
    }

    public Optional<Room> findRoomByNumber(Integer roomNumber){
        return inMemoryRoomRepository.findByRoomNumber(roomNumber) ;
    }



}
