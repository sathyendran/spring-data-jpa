package org.sathya.user;

public interface UserService {
    User save(User user);

    User getUserById(Long id) throws UserException;

    User findByEmail(String email);
}
