package edu.escuelaing.arep.usuarios.recovery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.escuelaing.arep.usuarios.model.usuario;

public class usuarioRepository {
	
	private static final String urlDb = "jdbc:postgresql://ec2-52-70-15-120.compute-1.amazonaws.com:5432/df8fnet8g4qges?user=vkmhojgspnrtck&password=56a27fd884fbc84e91acbf895eec119d174ccb7155d612ea9ef27b3af78e9f68";
    private Connection c;
    private usuario u;
    
    
    public void getConnection() {
        try {
            c = DriverManager.getConnection(urlDb);
        } catch (SQLException e) {
        }
    }   
    
    public usuario getLogin(String nickname,String password ) {
        PreparedStatement pstmt = null;
        System.out.println("Consultando a: " + nickname);
        try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "select * from usuario where nickname = ? and password= ?";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, nickname);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            if (rs.next()){
                u = new usuario(rs.getString("nickname"),rs.getString("nombre"),rs.getString("password"));
            }
            pstmt.close();
            rs.close();
            return u;
        } catch (Exception ex) {
            Logger.getLogger(usuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public usuario getUser(String nickname) {
    	PreparedStatement pstmt = null;
    	try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "select * from usuario where nickname = ?";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, nickname);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            if (rs.next()){
                u = new usuario(rs.getString("nickname"),rs.getString("nombre"),rs.getString("password"));
            }
            pstmt.close();
            rs.close();
            return u;
        } catch (Exception ex) {
            Logger.getLogger(usuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void saveUser(String nickname,String nombre,String password) {
    	PreparedStatement pstmt = null;
    	try {
            Class.forName("org.postgresql.Driver");
            getConnection();
            c.setAutoCommit(false);
            String sql = "insert into usuario values(?,?,?)";
            pstmt = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, nickname);
            pstmt.setString(2, nombre);
            pstmt.setString(3, password);
            ResultSet rs = pstmt.executeQuery();
            c.close();
            if (rs.next()){
                u = new usuario(rs.getString("nickname"),rs.getString("nombre"),rs.getString("password"));
            }
            pstmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(usuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
    }
  
}
