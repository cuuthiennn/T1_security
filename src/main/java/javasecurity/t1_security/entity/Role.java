package javasecurity.t1_security.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Role {
    private Long roleId;
    private String roleName;
    private String isuse;
    private String image;
    private String description;
}
