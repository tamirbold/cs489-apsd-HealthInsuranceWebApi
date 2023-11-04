package edu.miu.cs.cs489.healthinsurancesys;

import edu.miu.cs.cs489.healthinsurancesys.model.Role;
import edu.miu.cs.cs489.healthinsurancesys.model.User;
import edu.miu.cs.cs489.healthinsurancesys.repository.RoleRepository;
import edu.miu.cs.cs489.healthinsurancesys.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HealthinsurancesysApplication {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public HealthinsurancesysApplication(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(HealthinsurancesysApplication.class, args);
    }

    @PostConstruct
    public void initAdminUser() {
        var adminUser = userRepository.findByUsername("admin");
        if(adminUser.isEmpty()) {
            List<Role> listAdminRoles = new ArrayList<>();
            var adminRole = roleRepository.findByName("ROLE_ADMIN");
            if(adminRole.isEmpty()) {
                var newAdminRole =  new Role(null, "ROLE_ADMIN");
                listAdminRoles.add(newAdminRole);
            } else {
                listAdminRoles.add(adminRole.get());
            }
            User newAdminUser = new User(null, "Admin", "Admin", "Admin", "admin",
                    passwordEncoder.encode("test1234"), "admin@fairfieldlibrary.com",
                    true,true, true, true);
            newAdminUser.setRoles(listAdminRoles);
            userRepository.save(newAdminUser);
        }
    }

    @Bean
    CommandLineRunner commandLineRunner () {
        return args -> {
            System.out.println("good luck");
        };
    }
}
