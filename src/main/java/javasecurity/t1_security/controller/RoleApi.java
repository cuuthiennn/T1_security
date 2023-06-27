package javasecurity.t1_security.controller;

import javasecurity.t1_security.entity.Role;
import javasecurity.t1_security.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleApi {
    @Autowired
    RoleService roleService;

    @GetMapping("/getAllRole")
    public ResponseEntity<?> doGetAllUser(){
        List<Role> listRole = new ArrayList<>();
        HashMap<String, Object> result = new HashMap<>();
        try{
            listRole = roleService.getAllRole();
            result.put("success", true);
            result.put("massage", "Success when call Api getAllUser!");
            result.put("date", listRole);
        }catch (NullPointerException e){
            log.error("Error when call Api getAllRole", e);
            result.put("success", false);
            result.put("massage", "Faild when call Api getAllUser!");
            result.put("date", null);
        }
        return ResponseEntity.ok(result);
    }
}
