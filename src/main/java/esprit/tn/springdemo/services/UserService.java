package esprit.tn.springdemo.services;

import esprit.tn.springdemo.repositories.UserRepo;

public class UserService {
    UserRepo userRepo;

    public Object login(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }
}
