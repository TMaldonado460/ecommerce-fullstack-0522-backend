package com.example.demo.security.entity;

import com.example.demo.entity.Adress;
import com.example.demo.entity.Bill;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Review;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;


@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserInfo implements UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String username;
    private String password;
    private String email;
    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente; <- no es buena practica
     */
    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority= new SimpleGrantedAuthority(roles.name());
        System.out.println("auth: " + grantedAuthority);
        return Collections.singletonList(grantedAuthority);
    }
    @OneToMany(mappedBy = "userInfo",cascade = CascadeType.REMOVE)
    private Set<Adress> adressList;

    @OneToOne(mappedBy = "userInfo")
    private Cart cart;

    //Agrego las relaciones de "One to Many" desde la clase UserInfo a las clases Review y Bill
    @OneToMany(mappedBy = "userInfo")
    private Set<Review> reviewList;

    @OneToMany(mappedBy = "userInfo")
    private Set<Bill> billList;

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
