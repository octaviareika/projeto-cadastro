package com.projeto.cadastro.Projeto.Sistema.de.cadastro.ConexaoNoBanco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.sql.ResultSet;

public class DB {
    
    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null){
            Properties props = loadProperties();
               // properties = classe que carrega as propriedades do arquivo
               String url = props.getProperty("spring.datasource.url");
               try {
                connection = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){ // fechar conexão com banco  de dados 
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("db.properties")){ // carrega o arquivo de propriedades do banco de dados
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo de propriedades", e);
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
