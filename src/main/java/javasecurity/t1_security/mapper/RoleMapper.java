package javasecurity.t1_security.mapper;

import javasecurity.t1_security.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    public List<Role> getAllRole() throws NullPointerException;
}
