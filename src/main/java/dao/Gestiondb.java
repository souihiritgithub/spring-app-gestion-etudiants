package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Model.Etudiant;

public class Gestiondb  implements IGestion {
	
	
        Connection cnx;
        public Gestiondb() {
                try {Class.forName("com.mysql.jdbc.Driver");
                cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/basetp1jee","root","");
       
                } catch (Exception e) {
                        e.printStackTrace();
                }}

	
	public List<Etudiant> getAllEtudiants() {
		
            
                ArrayList <Etudiant> le=new ArrayList ();
                String req="select * from Etudiant ";
                 PreparedStatement ps;

                  try {
                         ps=cnx.prepareStatement(req);
                         ResultSet res=ps.executeQuery();
                         while(res.next()) {
                                 Etudiant e=new Etudiant (res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
                                 le.add(e);
                         }
                 }catch (SQLException e1) {
                         e1.printStackTrace();
                 }

                return le;
            }
        
    


	

	public void addEtudiant(Etudiant etu)   {
		  String req="insert into Etudiant values (?,?,?,?)";
          PreparedStatement ps;
		try {
			ps = cnx.prepareStatement(req);
	
                          ps.setInt(1,etu.getNum());
                          ps.setString(2,etu.getPrenom());
                          ps.setString(3,etu.getNom());
                          ps.setString(4,etu.getNumr());
                          ps.executeUpdate();
                          

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
		
	

	public void deleteEtudiant(int num) {
		String req="delete from etudiant where num=?";

        PreparedStatement ps;
		try {
			ps = cnx.prepareStatement(req);
		
               
         ps.executeUpdate();
		}        

	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public boolean verif(String user, String mp) { 
		boolean b = false;
		
			String req="select * from user Compte where user=? and mp=?";
					PreparedStatement ps;
					try {
						ps = cnx.prepareStatement(req);
					ps.setString(1,user);
					ps.setString(2,mp);
					ResultSet rs= ps.executeQuery();
			while (rs.next()){
				if ((rs.getString(1).equals(user)) &&( rs.getString(2).equals(mp) ))
				  b=true;
			
			else b= false; }
			
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			return b; 
		}
			
					
		
      
	}


