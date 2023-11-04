package edu.miu.cs.cs489.healthinsurancesys.repository;

import edu.miu.cs.cs489.healthinsurancesys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public abstract Optional<User> findByUsername(String username);
}
