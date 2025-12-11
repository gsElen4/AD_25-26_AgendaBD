package DAO;
import DTO.ContactoDTO;
import DTO.GrupoDTO;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    private static List<ContactoDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  public void CrearContact(ContactoDTO contact){
 String sql = "INSERT INTO Contacto(nome, telefono, email) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, contact.getNomeContact());
            ps.setInt(2, contact.getTelefono());
            ps.setString(3,contact.getEmail());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    contact.setIdContact(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

   public static void ListarContact(){
        List<ContactoDTO> contacts = ContactoDAO.findAll();
        for(ContactoDTO contact : contacts){
            System.out.println(contact);
        }
   }

   public ContactoDTO BuscarContact(int idContacto){
    String sql = "SELECT  idContacto , nome, telefono , email FROM Contacto WHERE idCOntacto = ? OR nome = ? OR telefono = ? OR email = ? ";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idContacto);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ContactoDTO contact = new ContactoDTO();
                    contact.setIdContact(rs.getInt("idConacto"));
                    contact.setNomeContact(rs.getString("nome"));
                    contact.setTelefono(rs.getInt("telefono"));
                    contact.setEmail(rs.getString("email"));
                    return contact;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   

   public void ModificarContact(ContactoDTO contact){
  String sql = "UPDATE Contacto SET nome = ?, telefono = ?, email = ? WHERE idContacto = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, contact.getIdContact());
            ps.setString(2, contact.getNomeContact());
            ps.setInt(3, contact.getTelefono());
            ps.setString(2, contact.getEmail());
            

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

   public void EliminarContact(int idContacto){
    String sqlContacto = "DELETE FROM Contacto WHERE idContacto = ?";
    String sqlIntegrantes = "DELETE FROM Integrantes WHEREidContacto = ?";

    try (Connection conn = ConnectionFactory.getConnection()) {

        conn.setAutoCommit(false); 

        try (PreparedStatement ps1 = conn.prepareStatement(sqlContacto);
             PreparedStatement ps2 = conn.prepareStatement(sqlIntegrantes)) {
                //Borrar relaciones en integrante
            ps1.setInt(1, idContacto);
            ps1.executeUpdate();
                //Borrar el contacto
            ps2.setInt(1, idContacto);
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

   public void VerGruposContact(String nombre){
    List<ContactoDTO> contacto =new ArrayList<>();
    String sql = "SELECT category_id, name, last_update FROM Grupo WHERE name LIKE ? JOIN";

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


   public void AnhadirContact(){

   }


