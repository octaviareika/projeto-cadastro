package com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;

import com.projeto.cadastro.Projeto.Sistema.de.cadastro.Repository.UsuarioRepository;
import com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Usuario;

@Service
public class UserService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails loadUserByUsername(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    public UserDetails cadastro(Usuario usuario) {
        if (!StringUtils.hasText(usuario.getPassword())) {
            throw new IllegalArgumentException("O campo 'senha' não pode ser nulo ou vazio.");
        }

        return usuarioRepository.save(usuario);

    }

    // listar usuario 
    public List<Usuario> listarUsuario(){

        if (usuarioRepository.findAll().isEmpty()) {
            throw new IllegalArgumentException("Nenhum usuário cadastrado.");
        }
        return usuarioRepository.findAll();
    }
    
}
