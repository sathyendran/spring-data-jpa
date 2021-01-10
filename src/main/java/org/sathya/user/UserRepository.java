package org.sathya.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailAddress(String email);

    @Query(value = "select * from user u where u.first_name=?1 or u.last_name=?1",nativeQuery = true)
    List<User> findByName(String name);
}
