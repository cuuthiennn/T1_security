package javasecurity.t1_security.dbo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
}
