package Initializer;

import Model.Room;
import Model.RoomType;
import Repository.impl.InMemoryRoomRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoomInitializer {
    static InMemoryRoomRepository inMemoryRoomRepository ;
    static {
        inMemoryRoomRepository.save(20,
                new Room(20, RoomType.SINGLE, 1, new BigDecimal(32)));
        inMemoryRoomRepository.save(30,
                new Room(20, RoomType.DOUBLE, 2, new BigDecimal(42)));
        inMemoryRoomRepository.save(40,
                new Room(20, RoomType.HIGH, 3, new BigDecimal(13)));
    }
}
