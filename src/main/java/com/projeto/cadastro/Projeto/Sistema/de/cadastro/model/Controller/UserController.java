package com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Usuario;
import com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Service.UserService;
// A classe Controller lida com as requisições HTTP e respostas HTTP. E a Service lida com a 
// lógica de negócios. Controller usa Service para acessar o banco de dados.
@RestController
@RequestMapping("/user")
public class UserController {

    // @Autowired
    // AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    // cadastrar usuario post mapping
    @PostMapping("/cadastrar")
    public UserDetails cadastrarUsuario(@RequestBody Usuario usuario) {
        return userService.loadUserByUsername(usuario.getNome());
    }

    
}
