package com.ejemplo.demooauth.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_usuario") // Este mapeo refleja el cambio en la base de datos
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "nombres", nullable = false) // Mapeo al campo nombres en la base de datos
    private String name;

    @Column(name = "codigo_tecsup") // Mapeo al campo codigo_tecsup en la base de datos
    private String codigoTecsup;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodigoTecsup() {
        return codigoTecsup;
    }

    public void setCodigoTecsup(String codigoTecsup) {
        this.codigoTecsup = codigoTecsup;
    }
}
