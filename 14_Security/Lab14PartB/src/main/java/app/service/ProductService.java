package app.service;

import app.domain.Role;
import app.domain.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createAccount(String name, String password, String role){
        userRepository.save(new User(name, password, new Role(role)));
    }
}
