
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar (String user,String dni){
        Cliente cl=new Cliente();
        String sql="select * from empleado where user=? and dni=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()){
                //em.setId(rs.getInt("IdEmpleado"));
                cl.setUser(rs.getString("user"));
                cl.setDni(rs.getString("dni"));
                cl.setNom(rs.getString("Nombres"));
            }
        }catch (Exception e){
        }
        return cl;
    }
    
    //operación CRUD
    
    public List listar(){
        String sql="select * from cliente";
        List<Cliente>lista=new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl=new Cliente();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
                
            }
        }catch(Exception e){
        }
        return lista;
    }
    public int agregar(Empleado em){
        String sql="insert into empleado(Dni, Nombres, Telefonos, Estados, User)values(?,?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        }catch(Exception e){}
        return r;
    }
    
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql="select * from empleado where IdEmpleado="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        }catch(Exception e){}
        return emp;
    }
    
    public int actualizar(Empleado em){
        String sql="update empleado set Dni=?, Nombres=?, Telefonos=?, Estados=?, User=? where IdEmpleado=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        }catch(Exception e){}
        return r;
    }
    public void delete(int id){
        String sql="delete from empleado where IdEmpleado="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){}
    }
}
