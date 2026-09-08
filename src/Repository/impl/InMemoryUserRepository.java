package Repository.impl;

import Model.User;
import Repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryUserRepository implements UserRepository {

    private Map<UUID, User> users = new HashMap<>() ;


    public void save(User user){
        users.put(user.getId(),user) ;
    }

    public Boolean findEmail(String email){
        users.entrySet().stream() ;
        return true ;
    }


    public Optional<User> findById(UUID id) {
        return Optional.of(users.get(id)) ;
    }


    public Optional<User> findByEmail(String email) {
        return users.entrySet().stream().map(user->user.getValue()).filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }


    public boolean existsByEmail(String email) {
        return false;
    }


    public List<User> findAll() {
        return List.of();
    }


    public User editProfile(User user,String newFullName,String newPhone,String newPassword,String newEmail){
        User Storeduser = users.get(user.getId());
        Storeduser.setFullName(newFullName);
        Storeduser.setPhone(newPhone);
        Storeduser.setPassword(newPassword);
        Storeduser.setEmail(newEmail);
        return Storeduser ;
    }

    public User changePassword(User user,String newPassword){
        User Storeduser = users.get(user.getId());
        Storeduser.setPassword(newPassword);
        return Storeduser ;
    }
}
