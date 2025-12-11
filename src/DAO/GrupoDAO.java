package DAO;

import DTO.GrupoDTO;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO {
 public static void CrearGrupo(GrupoDTO grp){
 String sql = "INSERT INTO Grupo(nome) VALUES (?)";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, grp.getNomeGrupo());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    grp.setIdGrupo(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

   public static List<GrupoDTO> findAll(){
    List<GrupoDTO> grupos = new ArrayList<>();
        String sql = "SELECT idGRupo, nome FROM Grupo";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                GrupoDTO grp = new GrupoDTO();
                grp.setIdGrupo(rs.getInt("idGrupo"));
                grp.setNomeGrupo(rs.getString("name"));
                grupos.add(grp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grupos;
   }

   public void ModificarGrupo(GrupoDTO grp){
        String sql = "UPDATE Grupo SET nome = ? WHERE idGrupo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt (1, grp.getIdGrupo());
            ps.setString(2, grp.getNomeGrupo());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

   public static void EliminarGrupo(int id){
             String sqlIntegrantes = "DELETE FROM Integrante WHERE idGrupo = ?";
    String sqlGroup = "DELETE FROM Grupo WHERE idGrupo = ?";
 try (Connection conn = ConnectionFactory.getConnection()) {

        conn.setAutoCommit(false); 

        try (PreparedStatement ps1 = conn.prepareStatement(sqlIntegrantes);
             PreparedStatement ps2 = conn.prepareStatement(sqlGroup)) {
                //Borrar relaciones en film_category
            ps1.setInt(1, id);
            ps1.executeUpdate();
                //Borrar el actor
            ps2.setInt(1, id);
            ps2.executeUpdate();
                //Confirmar todo
            conn.commit(); 
        } catch (SQLException ex) {
            conn.rollback();  //Deshacer si algo falla
            throw ex;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
   }

   public List<GrupoDTO> VerContactosGrupo(String nombre){
    List<GrupoDTO> grupos =new ArrayList<>();
    String sql = "SELECT category_id, name, last_update FROM Contacto WHERE name LIKE ? JOIN ";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        String filtro = "%" + nombre + "%";
        ps.setString(1, filtro);
        ps.setString(2, filtro);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                GrupoDTO grp = new GrupoDTO();
                grp.setIdGrupo(rs.getInt("category_id"));
                grp.setNomeGrupo(rs.getString("name"));
                grupos.add(grp);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return grupos;
   }
}
