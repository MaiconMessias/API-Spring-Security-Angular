package praticando.securityspring.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import praticando.securityspring.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsConfig  implements UserDetails {

    private User user;
    private List<String> roles;

    public UserDetailsConfig(User user, List<String> roles){
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> listaDeRoles = null;
        if (roles != null) {
            listaDeRoles = new ArrayList();
            for (String role : roles)
                listaDeRoles.add(new SimpleGrantedAuthority(role));
        }
        return listaDeRoles;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
