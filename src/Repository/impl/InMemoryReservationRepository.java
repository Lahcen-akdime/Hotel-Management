package Repository.impl;

import Model.Reservation;
import Model.User;
import Repository.ReservationRepository;

import java.util.*;

public class InMemoryReservationRepository implements ReservationRepository {

    private Map<UUID, Reservation> reservations = new HashMap<>() ; ;

    @Override
    public void save(Reservation reservation) {
        reservations.put(UUID.randomUUID(),reservation) ;
    }

    @Override
    public Optional<Reservation> findById(UUID id) {
        return Optional.of(reservations.get(id)) ;
    }

    @Override
    public Optional<Reservation> findByCode(String code) {
        return Optional.empty();
    }

    @Override
    public List<Reservation> findByUserId(UUID userId) {
        return reservations.entrySet().stream()
                                    .map(r->r.getValue())
                                    .filter(r->r.getUserId().equals(userId))
                                    .toList();
    }

    @Override
    public List<Reservation> findAll() {
        return reservations.entrySet().stream().map(r->r.getValue()).toList();
    }

}