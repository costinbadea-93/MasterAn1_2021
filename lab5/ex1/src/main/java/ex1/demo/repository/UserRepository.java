package ex1.demo.repository;

import ex1.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository  {
    private static List<User> userList = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(UserRepository.class);
    public UserRepository() {
//        User u1 = new User(1,"Username1","FirstName1", "LastName1", "email","address","contact");
        User u1 = User.builder()
                .id(1)
                .userName("UserName1")
                .firstName("FirstName1")
                .lastName("LastName1")
                .email("email")
                .address("address")
                .contact("contact")
                .build();

        User u2 = User.builder()
                .id(2)
                .userName("UserName2")
                .firstName("FirstName2")
                .lastName("LastName2")
                .email("email")
                .address("address")
                .contact("contact")
                .build();

        userList.add(u1);
        userList.add(u2);
    }

    public List<User> findAll() {
        logger.info("returning to user {}", userList);
        return userList;
    }

    public User save(User user) {
        logger.info("saving user {}", user);
        userList.add(user);
        return user;
    }

    public void deleteById(int userId){
        logger.info("deleting user with id {}", userId);
        userList = userList.stream()
                .filter(u -> u.getId() != userId)
                .collect(Collectors.toList());
    }

    public Optional<User> findById(int userId) {
        logger.info("retrieving user by id {}", userId);
        return userList.stream()
                .filter(u -> u.getId() == userId)
                .findFirst();
    }
}
