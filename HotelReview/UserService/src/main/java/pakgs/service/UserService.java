package pakgs.service;

import pakgs.Entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    void DeleteUser(String userId);

    User UpdateUser(String userId,User userBody);

}
