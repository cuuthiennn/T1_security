package javasecurity.t1_security.controller;

import javasecurity.t1_security.config.JwtUtils;
import javasecurity.t1_security.dbo.AuthenticationRequest;
import javasecurity.t1_security.dbo.CustomUserDetails;
import javasecurity.t1_security.dbo.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class Authentication {

    @Autowired
    private AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    @GetMapping("/authLogin")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        HashMap<String, Object> result = new HashMap<>();
        try {
            final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            result.put("success", true);
            result.put("massage", "Success when call api authLogin");
            result.put("data", jwtUtils.generateToken(userDetails));
        } catch (UsernameNotFoundException e){
            log.error("Failed when call api authLogin", e);
            result.put("success", true);
            result.put("massage", "Failed when call api authLogin");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
}
