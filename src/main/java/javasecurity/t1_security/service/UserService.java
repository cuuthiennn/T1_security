package javasecurity.t1_security.service;

import javasecurity.t1_security.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser() throws NullPointerException;
}
