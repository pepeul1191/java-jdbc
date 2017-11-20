
package pe.softweb.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.softweb.configs.Database;

public class Animal {
    private int id;
    private String nombre;
    private String nombreCientifico;
    private double peso;
    private int anios;

    public Animal(String nombre, String nombreCientifico, double peso, int anios) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.peso = peso;
        this.anios = anios;
    }

    public Animal(int id, String nombre, String nombreCientifico, double peso, int anios) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.peso = peso;
        this.anios = anios;
    }
    
    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nombre=" + nombre + ", nombreCientifico=" + nombreCientifico + ", peso=" + peso + ", anios=" + anios + '}';
    }
    
    public List<Animal> listar(){
        List<Animal> lista = new ArrayList<>();
            
        String sql ="SELECT * FROM animales";
        Connection con= Database.getConnection();
        PreparedStatement psmt=null; 
        ResultSet rs=null;  
        try {
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            while (rs.next()) {
                Animal a =new Animal();
                a.setId(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setNombreCientifico(rs.getString(3));
                a.setPeso(rs.getInt(4));
                a.setAnios(rs.getInt(5));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            try {
                psmt.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return lista;
    }
    
    public void crear(){
        String sql ="INSERT INTO animales (nombre, nombre_cientifico, peso_kg, anios, id_habitad, id_locomocion, id_alimentacion) "
                + "VALUES (?,?,?,?,1,1,1) ";
        Connection con= Database.getConnection();
        PreparedStatement psmt=null; 
        try {
            psmt=con.prepareStatement(sql);
            psmt.setString(1, this.nombre);
            psmt.setString(2, this.nombreCientifico);
            psmt.setDouble(3, this.peso);
            psmt.setInt(4, this.anios);
            psmt.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            try {
                psmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
    }
    
    public void editar(){
        String sql ="UPDATE animales SET nombre = ?, nombre_cientifico = ?, peso_kg = ?, anios = ? WHERE id = ?";
        Connection con= Database.getConnection();
        PreparedStatement psmt=null; 
        try {
            psmt=con.prepareStatement(sql);
            psmt.setString(1, this.nombre);
            psmt.setString(2, this.nombreCientifico);
            psmt.setDouble(3, this.peso);
            psmt.setInt(4, this.anios);
            psmt.setInt(5, this.id);
            psmt.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            try {
                psmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
    }
    
     public void eliminar(){
        String sql ="DELETE FROM animales WHERE id = ?";
        Connection con= Database.getConnection();
        PreparedStatement psmt=null; 
        try {
            psmt=con.prepareStatement(sql);
            psmt.setInt(1, this.id);
            psmt.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            try {
                psmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
    }
}
