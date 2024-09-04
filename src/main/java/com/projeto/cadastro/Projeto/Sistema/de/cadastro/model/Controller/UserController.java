package com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Usuario;
import com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Service.UserService;

import jakarta.transaction.Transactional;
// A classe Controller lida com as requisições HTTP e respostas HTTP. E a Service lida com a 
// lógica de negócios. Controller usa Service para acessar o banco de dados.
@RestController
public class UserController {

    // @Autowired
    // AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    // cadastrar usuario post mapping
    @CrossOrigin(origins = "http://127.0.0.1:5501") // vai vincular o servidor do front-end ao servidor do back-end
    @PostMapping("/user")
    public UserDetails cadastrarUsuario(@RequestBody Usuario usuario) {
        return userService.cadastro(usuario);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping("/user/listar")
    public List<Usuario> listarUsuario() {
        return userService.listarUsuario();
    }

    // @CrossOrigin(origins = "http://127.0.0.1:5501")
    // @Transactional
    // @DeleteMapping("/user/{id}")
    // public void deleteUsuario(@PathVariable Long id) {
    //     userService.deleteUsuario(id);
    // }

    // deletar usuario por nome
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @Transactional
    @DeleteMapping("/user/nome/{nome}")
    public void deleteUsuarioPorNome(@PathVariable String nome) {
        System.out.println("deletei");
        userService.deleteUsuarioPorNome(nome);
    }

    
}
