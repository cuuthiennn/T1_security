package javasecurity.t1_security.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Long roleId;
    private String roleName;
    private String isuse;
    private String image;
    private String description;
}
