package org.sathya.user;

import java.util.List;

public interface UserService {
    User save(User user);

    User getUserById(Long id) throws UserException;

    User findByEmail(String email);

    List<User> getByUser(String name);
}
