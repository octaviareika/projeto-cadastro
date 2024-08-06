package com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.projeto.cadastro.Projeto.Sistema.de.cadastro.Repository.UsuarioRepository;

@Service
public class UserService {
    // Service geralmente utiliza o Repository para acessar o banco de dados.
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails loadUserByUsername(String nome) {
        return usuarioRepository.findByNome(nome);
    }
    
}
