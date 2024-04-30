package com.ejemplo.demooauth.controller;

import com.ejemplo.demooauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/details")
    public String getUserDetails(OAuth2AuthenticationToken token) {
        Map<String, Object> attributes = token.getPrincipal().getAttributes();
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        userService.saveUserDetails(email, name, ""); // Pasar cadena vacía en lugar de null

        return "Detalles del usuario guardados: " + name;
    }


    @GetMapping("/user/update/{codigo_tecsup}")
    public String updateUserDetails(@PathVariable String codigo_tecsup, OAuth2AuthenticationToken token) {
        Map<String, Object> attributes = token.getPrincipal().getAttributes();
        String email = (String) attributes.get("email");  // Extraer el email del token

        userService.saveUserDetails(email, null, codigo_tecsup); // No se actualiza el nombre
        return "Código Tecsup actualizado con éxito para el usuario con email: " + email;
    }
}