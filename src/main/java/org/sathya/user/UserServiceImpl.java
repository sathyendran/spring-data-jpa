package org.sathya.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        log.info("Saving the user {} ", user);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) throws UserException {
        log.info("Fetching the user Based on id : {} ", id);
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(() -> new UserException("User information not available for the id"));
        return user;
    }

    /**
     * Fetch the email by user
     * Uses the named query
     *
     * @param email
     * @return
     */
    @Override
    public User findByEmail(String email) {
        log.info("Find the user based on Email-{}", email);
        return userRepository.findByEmailAddress(email);
    }
}
