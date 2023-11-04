package edu.miu.cs.cs489.healthinsurancesys.service.impl;

import edu.miu.cs.cs489.healthinsurancesys.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InsuranceUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public InsuranceUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found for " + username));
    }
}
