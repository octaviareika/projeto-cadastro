package com.projeto.cadastro.Projeto.Sistema.de.cadastro.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public UserDetails findByNome(String nome);
}
