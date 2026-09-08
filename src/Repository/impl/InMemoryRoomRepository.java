package Repository.impl;

import Model.Room;
import Model.User;
import Repository.RoomRepository;

import java.util.*;

public class InMemoryRoomRepository implements RoomRepository {

    private Map<Integer, Room> rooms = new HashMap<>();

    @Override
    public void save(Integer roomNumber , Room room) {

    }

    @Override
    public Optional<Room> findByRoomNumber(String roomNumber) {
        return Optional.empty();
    }

    @Override
    public List<Room> findAll() {
        return List.of();
    }
}
