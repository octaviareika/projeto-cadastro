package com.projeto.cadastro.Projeto.Sistema.de.cadastro.model;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.validation.constraints.NotBlank;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String senha;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
    
        
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

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
    // private static final long serialVersionUID = 1L;


    // private int id;
    // private String nome;
    // private String email;
    // private String senha;

    // public Usuario() {
    // }

    // public Usuario(int id, String nome, String email, String senha) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.email = email;
    //     this.senha = senha;
    // }

    // // getter e setter

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    // public String getNome() {
    //     return nome;
    // }

    // public void setNome(String nome) {
    //     this.nome = nome;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public String getSenha() {
    //     return senha;
    // }


    // public void setSenha(String senha) {
    //     this.senha = senha;
    // }

    // @Override
    // public String toString() {
    //     return "Usuario{" +
    //             "id=" + id +
    //             ", nome='" + nome + '\'' +
    //             ", email='" + email + '\'' +
    //             ", senha='" + senha + '\'' +
    //             '}';
    // }

    
}
