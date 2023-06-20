package javasecurity.t1_security.service.serviceimpl;

import javasecurity.t1_security.entity.Role;
import javasecurity.t1_security.mapper.RoleMapper;
import javasecurity.t1_security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() throws NullPointerException {
        return roleMapper.getAllRole();
    }
}
