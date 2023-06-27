package javasecurity.t1_security.controller;

import javasecurity.t1_security.config.JwtUtils;
import javasecurity.t1_security.dbo.AuthenticationRequest;
import javasecurity.t1_security.dbo.CustomUserDetails;
import javasecurity.t1_security.dbo.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class Authentication {

    private final AuthenticationManager authenticationManager = new AuthenticationManager() {
        @Override
        public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws AuthenticationException {
            return null;
        }
    };
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    @GetMapping("/authLogin")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        if (userDetails != null){
            return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
        }
        return ResponseEntity.status(400).body("Error");
    }
}
