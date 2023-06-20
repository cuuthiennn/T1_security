package javasecurity.t1_security.service;

import javasecurity.t1_security.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRole() throws NullPointerException;
}
