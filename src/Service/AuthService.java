package Service;

import Model.User;
import Repository.impl.InMemoryUserRepository;
import Exception.InvalidCredentialsException ;

import java.util.Optional;
import java.util.UUID;

public class AuthService {

    private InMemoryUserRepository inMemoryUserRepository ;
    //private String fullName ;
    //private String email ;
    //private String phone ;
    //private String password ;

    public User inscreption(String email , String fullName,String phone,String password){
        User user = new User(fullName,email,phone,password) ;
        inMemoryUserRepository.save(user);
        return user ;
    }

    public Optional<User> connexion(String email , String password)throws InvalidCredentialsException{
        if(!inMemoryUserRepository.existsByEmail(email)){
            throw new InvalidCredentialsException(" The email is not exist ");
        }
        else{
            Optional<User> user = inMemoryUserRepository.findByEmail(email) ;
            return user ;
        }
    }

    public Boolean déconnexion(User user){
        return null ;
    }

    public User editProfile(User user,String newFullName,String newPhone,String newPassword,String newEmail){
        return inMemoryUserRepository.editProfile(user,newFullName,newEmail,newPhone,newPassword) ;
    }

    public User changePassword(User user,String newPassword){
        return inMemoryUserRepository.changePassword(user,newPassword) ;
    }

}
