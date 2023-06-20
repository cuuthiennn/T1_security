package javasecurity.t1_security.controller;

import javasecurity.t1_security.entity.User;
import javasecurity.t1_security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    UserService userService;

    @PostMapping("/getAllUser")
    ResponseEntity<?> doGetAllUser(){
        List<User> listUser = new ArrayList<>();
        HashMap<String, Object> result = new HashMap<>();
        try {
            listUser = userService.getAllUser();
            result.put("success", true);
            result.put("massage", "Success when call Api getAllUser");
            result.put("data", listUser);
        } catch (NullPointerException e) {
            log.error("Faid when call Api getAllUser", e);
            result.put("success", false);
            result.put("massage", "Faild when call Api getAllUser");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
}
