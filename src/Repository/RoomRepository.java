package Repository;

import Model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {

    void save(Integer roomNumber , Room room);
    Optional<Room> findByRoomNumber(String roomNumber) ;
    List<Room> findAll();
}
