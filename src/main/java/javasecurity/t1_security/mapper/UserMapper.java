package javasecurity.t1_security.mapper;

import javasecurity.t1_security.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> getAllUser() throws NullPointerException;
}
