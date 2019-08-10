package pl.imjustcoding.ContactBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ContactQuery {
    
    public ContactQuery(){}
    
    public boolean insertContact(Contact cont){
        boolean contactIsCreated=true;
        try {
            Connection con=MyConnection.getConnection();
            PreparedStatement ps;
            
            ps=con.prepareStatement("INSERT INTO `mycontact`(`fname`, `lname`, `groupc`, `phone`, `email`, `address`, `pic`, `userid`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1,cont.getfName());
            ps.setString(2,cont.getlName());
            ps.setString(3,cont.getGroupc());
            ps.setString(4,cont.getPhone());
            ps.setString(5,cont.getEmail());
            ps.setString(6,cont.getAddress());
            ps.setBytes(7,cont.getPic());
            ps.setInt(8,cont.getUid());
            
            if(ps.executeUpdate()!=0){
                JOptionPane.showMessageDialog(null,"New Contact Added");
                contactIsCreated=true;
            }else{
                JOptionPane.showMessageDialog(null,"Something wrong happened");
                contactIsCreated=false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contactIsCreated;
    }
    
    public void updateContact(Contact cont, boolean withImage){
        if(withImage==true){
            try {
                Connection con=MyConnection.getConnection();
                PreparedStatement ps;

                ps=con.prepareStatement("UPDATE `mycontact` SET `fname`=?,`lname`=?,`groupc`=?,`phone`=?,`email`=?,`address`=?,`pic`=? WHERE `id`=?");
                ps.setString(1,cont.getfName());
                ps.setString(2,cont.getlName());
                ps.setString(3,cont.getGroupc());
                ps.setString(4,cont.getPhone());
                ps.setString(5,cont.getEmail());
                ps.setString(6,cont.getAddress());
                ps.setBytes(7,cont.getPic());
                ps.setInt(8,cont.getCid());

                if(ps.executeUpdate()!=0){
                    JOptionPane.showMessageDialog(null,"Contact Updated");
                }else{
                    JOptionPane.showMessageDialog(null,"Something wrong happened");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                Connection con=MyConnection.getConnection();
                PreparedStatement ps;

                ps=con.prepareStatement("UPDATE `mycontact` SET `fname`=?,`lname`=?,`groupc`=?,`phone`=?,`email`=?,`address`=? WHERE `id`=?");
                ps.setString(1,cont.getfName());
                ps.setString(2,cont.getlName());
                ps.setString(3,cont.getGroupc());
                ps.setString(4,cont.getPhone());
                ps.setString(5,cont.getEmail());
                ps.setString(6,cont.getAddress());
                ps.setInt(7,cont.getCid());

                if(ps.executeUpdate()!=0){
                    JOptionPane.showMessageDialog(null,"Contact Updated");
                }else{
                    JOptionPane.showMessageDialog(null,"Something wrong happened");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void deleteContact(int id){
        try {
                Connection con=MyConnection.getConnection();
                PreparedStatement ps;

                ps=con.prepareStatement("DELETE FROM `mycontact` WHERE `id`=?");
                ps.setInt(1,id);
                if(ps.executeUpdate()!=0){
                    JOptionPane.showMessageDialog(null,"Contact Deleted");
                }else{
                    JOptionPane.showMessageDialog(null,"Something wrong happened");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // create a list of contact
    public ArrayList<Contact> contactList(int userId){
        
        ArrayList<Contact> cList = new ArrayList<Contact>();
        Connection con=null;
        Statement st;
        ResultSet rs;
        
        Contact ct;
        try {
            con=MyConnection.getConnection();
            
            st=con.createStatement();
            rs=st.executeQuery("SELECT `id`, `fname`, `lname`, `groupc`, `phone`, `email`, `address`, `pic` FROM `mycontact` WHERE userid =" +userId);
            
            while(rs.next()){
                ct=new Contact(rs.getInt("id"),
                               rs.getString("fname"),
                               rs.getString("lname"),
                               rs.getString("groupc"),
                               rs.getString("phone"),
                               rs.getString("email"),
                               rs.getString("address"),
                               rs.getBytes("pic"),
                               userId);
                
                cList.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return cList;
        
        
    }
}
