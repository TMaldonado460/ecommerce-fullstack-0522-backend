package com.example.demo.security.controller;


import com.example.demo.dto.UserInfoDTO;
import com.example.demo.security.UserDetailsServiceImpl;
import com.example.demo.security.components.JwtUtil;
import com.example.demo.security.entity.UserInfo;
import com.example.demo.service.CartService;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CartService cartService;


    @PostMapping("/signin")
    //el map tiene un mapa con usuario y contraseña
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.get("username"),
                            loginRequest.get("password")
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.get("username"));
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getAuthorities()));
    }


    @GetMapping
    public ResponseEntity<?> login() {
        return null;
    }

    private class AuthenticationResponse {
        private final String jwt;
        private final Collection<? extends GrantedAuthority> authorities;
        public AuthenticationResponse(String jwt, Collection<? extends GrantedAuthority> authorities) {
            this.jwt = jwt;
            this.authorities = authorities;
        }
        public String getJwt() {
            return jwt;
        }
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }
    }
    //Registrar

    @GetMapping("/register")
    public ResponseEntity<?> registrer(Model model) {
        return (ResponseEntity<?>) model.addAttribute("user", new UserInfoDTO());
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @ModelAttribute UserInfo userInfo, BindingResult result,Model model) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }else {
            model.addAttribute("user", userInfoService.registrer(userInfo));
        }
        return ResponseEntity.ok("registro exitoso");
    }

    //Login
    @GetMapping("/login")
    public ResponseEntity<?> login(Model model) {
        return (ResponseEntity<?>) model.addAttribute("user", new UserInfoDTO());
    }

    //acceder a atributos propios del usuario(review, carrito, etc)

    //problemas posibles:recuperar usario e id


    @PostMapping("/login")
    public String login(@RequestAttribute("username") String userName, @RequestAttribute("password")  String password) {
        //does the authentication
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userName,
                        password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "";
    }




}


