package com.bernardo.lizzie.serviceimpl;

import com.bernardo.lizzie.entity.User;
import com.bernardo.lizzie.repository.UserRepository;
import com.bernardo.lizzie.service.UserService;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String rawPassword) {
        Optional<User> opt = userRepository.findByEmail(email);
        if (opt.isPresent()) {
            User u = opt.get();
            if (passwordEncoder.matches(rawPassword, u.getPassword())) {
                u.setPassword((null));
                return u;
            }
        }
        return null;
    }
}
