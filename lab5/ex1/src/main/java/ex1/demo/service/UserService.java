package ex1.demo.service;

import ex1.demo.model.User;
import ex1.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
       return  userRepository.findAll();
    }

    public User save(User user) {
       return userRepository.save(user);
    }

    public void deleteById(int userId){
        userRepository.deleteById(userId);
    }

    public User findById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User was not found!!!"));
    }
}
