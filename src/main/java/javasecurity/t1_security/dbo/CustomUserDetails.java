package javasecurity.t1_security.dbo;

import javasecurity.t1_security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

public class CustomUserDetails extends User implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Long maKh, String tenKh, String diaChi, String mail
            , String phone, String image, Date birthday, String isUse, int roleId
            , String roleName, String password, Collection<GrantedAuthority> authorities) {
        super(maKh, tenKh, diaChi, mail
                , phone, image, birthday, isUse, roleId, roleName, password);
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public static CustomUserDetails convert(User user){
        Collection<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRoleName()));
        return new CustomUserDetails(
                user.getMaKh(),
                user.getTenKh(),
                user.getDiaChi(),
                user.getMail(),
                user.getPhone(),
                user.getImage(),
                user.getBirthday(),
                user.getIsUse(),
                user.getRoleId(),
                user.getRoleName(),
                user.getPassword(),
                authorities
        );
    }
}
