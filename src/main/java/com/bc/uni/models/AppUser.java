package com.bc.uni.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(
        name = "app_user"
)
@AttributeOverrides({
        @AttributeOverride(
                name = "isAccountExpired",
                column = @Column(name ="account_expired" )
        ),
        @AttributeOverride(
                name = "isAccountLocked",
                column = @Column(name ="account_locked" )
        ),
        @AttributeOverride(
                name = "isCredentialsExpired",
                column = @Column(name ="credentials_expired" )
        ),
        @AttributeOverride(
                name = "isEnabled",
                column = @Column(name ="account_enabled" )
        ),
        @AttributeOverride(
                name = "username",
                column = @Column(
                        nullable = false,
                        unique = true
                )
        )
})
public class AppUser implements UserDetails {
    @Id @Column(
            nullable = false,
            unique = true,
            updatable = false
    ) @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_user_sequence"
    )
    @SequenceGenerator(
            name = "app_user_sequence",
            sequenceName = "app_user_sequence",
            allocationSize = 1
    )
    private Long id;
    @ManyToMany
    private Collection<Role> roles = new ArrayList<>();
    private String password;

    private String username;
    private boolean isAccountExpired = false;
    private boolean isAccountLocked = false;
    private boolean isCredentialsExpired = false;
    private boolean isEnabled = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
