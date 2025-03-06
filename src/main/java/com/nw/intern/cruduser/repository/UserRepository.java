package com.nw.intern.cruduser.repository;

import com.nw.intern.cruduser.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private long userIdCounter = 1;

    @PostConstruct
    public void initData() {
        users.add(new User(userIdCounter++, "John Doe", "john@example.com",1));
        users.add(new User(userIdCounter++, "Jane Doe", "jane@example.com",1));
        users.add(new User(userIdCounter++, "Alice Smith", "alice@example.com",1));
        users.add(new User(userIdCounter++, "Bob Johnson", "bob@example.com",1));
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(userIdCounter++);
        } else {
            deleteById(user.getId()); // Xóa user cũ nếu update
        }
        users.add(user);
        return user;
    }

    public boolean deleteById(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}