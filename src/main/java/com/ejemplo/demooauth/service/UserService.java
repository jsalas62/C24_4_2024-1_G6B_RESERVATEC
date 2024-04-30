package com.ejemplo.demooauth.service;

import com.ejemplo.demooauth.model.Usuario;
import com.ejemplo.demooauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUserDetails(String email, String name, String codigoTecsup) {
        Usuario usuario = userRepository.findByEmail(email);
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setEmail(email);
        }
        if (name != null && !name.isEmpty()) {
            usuario.setName(name);
        }
        // Set the codigoTecsup to empty string if it's null
        usuario.setCodigoTecsup(codigoTecsup != null ? codigoTecsup : "");

        userRepository.save(usuario);
    }
}
