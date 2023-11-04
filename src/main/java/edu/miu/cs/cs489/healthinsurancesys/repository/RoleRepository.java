package edu.miu.cs.cs489.healthinsurancesys.repository;

import edu.miu.cs.cs489.healthinsurancesys.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public abstract Optional<Role> findByName(String name);
}
