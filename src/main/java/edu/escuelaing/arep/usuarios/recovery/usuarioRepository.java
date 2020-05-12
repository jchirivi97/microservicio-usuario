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
	
	private static final String urlDb = "jdbc:postgresql://ec2-3-231-16-122.compute-1.amazonaws.com:5432/d82dgnug27a8v1?user=vebjylzbvbhkrd&password=7c23c795d8069466561a02303eb7027408f04235b2525c347f204f3249664fef";
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
