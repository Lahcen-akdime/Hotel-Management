package Repository.impl;

import Model.Reservation;
import Model.User;
import Repository.ReservationRepository;

import java.util.*;

public class InMemoryReservationRepository implements ReservationRepository {

    private Map<UUID, Integer> reservations = new HashMap<>() ; ;

    @Override
    public void save(Reservation reservation) {

    }

    @Override
    public Optional<Reservation> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> findByCode(String code) {
        return Optional.empty();
    }

    @Override
    public List<Reservation> findByUserId(UUID userId) {
        return List.of();
    }

    @Override
    public List<Reservation> findByRoomNumber(String roomNumber) {
        return List.of();
    }

    @Override
    public List<Reservation> findAll() {
        return List.of();
    }
}
