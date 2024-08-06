// package com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.DAO;
// import java.sql.Connection; 

// import java.sql.PreparedStatement;
// import java.sql.ResultSet;

// import com.projeto.cadastro.Projeto.Sistema.de.cadastro.model.Usuario;

// public class UsuarioDAO {

//     public Connection conn;

//     public void registrarUsuario(Usuario usuario){
//         String query = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
//         PreparedStatement st = null;
//         try {
//             st = conn.prepareStatement(query);
            
//             st.setString(1, usuario.getNome());
//             st.setString(2, usuario.getEmail());
//             st.setString(3, usuario.getSenha());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public boolean LogarUsuario(Usuario usuario){


//         String query = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
//         PreparedStatement st = null;
//         try {
//             st = conn.prepareStatement(query);

//             st.setString(1, usuario.getEmail());
//             st.setString(2, usuario.getSenha());
            
//             ResultSet rs = st.executeQuery();

//             return rs.next();

//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         return false;

//     }
    
// }
