package org.example.lab11.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab11.Api.ApiException;
import org.example.lab11.Model.User;
import org.example.lab11.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser() {

        return userRepository.findAll();
    }


    public void addUser(User user) {
        user.setRegistrationDate(LocalDate.now());
        userRepository.save(user);
    }


    public void updateUser(Integer id, User user) {
        User c = userRepository.findUserById(id);

        if (c == null) {
            throw new ApiException("wrong id");
        }

        c.setEmail(user.getEmail());
        c.setPassword(user.getPassword());
        c.setUsername(user.getUsername());
        c.setRegistrationDate(user.getRegistrationDate());
        userRepository.save(c);

    }


    public void deleteUser(Integer id) {
        User c = userRepository.findUserById(id);
        if (c == null) {
            throw new ApiException("wrong id");
        }
        userRepository.delete(c);
    }


    public User getUserByEmail(String email) {
        User c = userRepository.findByEmail(email);
        if (c == null) {
            throw new ApiException("wrong id");
        }
        return c;
    }


    public List<User> getUsersByRegistrationDate(LocalDate registrationDate) {
        return userRepository.findByRegistrationDate(registrationDate);
    }

}




