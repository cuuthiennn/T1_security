package javasecurity.t1_security.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long maKh;
    private String tenKh;
    private String diaChi;
    private String mail;
    private String phone;
    private String image;
    private Date birthday;
    private String isUse;
    private int roleId;
    private String roleName;
    private String password;
}
