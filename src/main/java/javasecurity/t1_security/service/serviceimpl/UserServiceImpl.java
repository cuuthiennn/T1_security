package javasecurity.t1_security.service.serviceimpl;

import javasecurity.t1_security.entity.User;
import javasecurity.t1_security.mapper.UserMapper;
import javasecurity.t1_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUser() throws NullPointerException {
        return userMapper.getAllUser();
    }
}
