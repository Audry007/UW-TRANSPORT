/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Urbain
 */
public class databaseMapper {
    private databaseconfig dbc=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private Statement stmt=null;
    private ResultSet rs=null;

    
    public databaseMapper() {
        dbc=new databaseconfig();
        con = dbc.getCon();
    }
    
   //------------------------------------------------------------------------------------------------------------
    //---------------SQL Operation for a user--------------------------------------------------------------------
    //--------------------------------------1.chaufeur-------------------------------------------------------------
    //======================================1.1 add chaufeur=========================================================
    public int addchaufeur(chaufeur c){
        String sql="INSERT INTO chaufeur (nom_chaufeur,prenonm_chaufeur,email_chaufeur,telephone_chaufeur,permi_conduire) values (?,?,?,?,?)";
            try{ 
               pstmt=con.prepareStatement(sql);
               pstmt.setString(1, c.getNom_chaufeur());
               pstmt.setString(2, c.getPrenonm_chaufeur());
               pstmt.setString(3, c.getEmail_chaufeur());
               pstmt.setString(4,c.getTelephone_chaufeur());
               pstmt.setString(5, c.getPermi_conduire());
               
               int add=pstmt.executeUpdate();
               return add;
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
        return 0;
    }
    
    //====================================1.2 update chaufeur===========================================================
    public int updatechaufeur(chaufeur c){
        String up="UPDATE TABLE chaufeur SET nom_chaufeur=?,prenonm_chaufeur=?,email_chaufeur=?,telephone_chaufeur=?,permi_conduire=? where id_chaufeur=?";
         try{
             pstmt=con.prepareStatement(up);
             pstmt.setString(1, c.getNom_chaufeur());
             pstmt.setString(2, c.getPrenonm_chaufeur());
             pstmt.setString(3, c.getEmail_chaufeur());
             pstmt.setString(4,c.getTelephone_chaufeur());
             pstmt.setString(5, c.getPermi_conduire());
             pstmt.setInt(6, c.getId_chaufeur());
             
             int update=pstmt.executeUpdate();
             return update;
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
        return 0;
    }
    
    //=====================================1.3 delete chaufeur =========================================================
    public int deletechaufeur(chaufeur c){
        String delete="DELETE FROM chaufeur where id_chaufeur=?";
        try{
            pstmt=con.prepareStatement(delete);
            pstmt.setInt(1, c.getId_chaufeur());
            
            int del=pstmt.executeUpdate();
            return del;
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    //===============================1.4 show chaufeur ==============================================================
    public List<chaufeur> getchaufeur(){
        List<chaufeur> chaufeurs=new ArrayList<>();
        String select="SELECT * FROM chaufeur";
        try{
           stmt=con.createStatement();
           rs=stmt.executeQuery(select);
           while(rs.next()){
               int id=rs.getInt("id");
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String email=rs.getString("email");
               String telephone=rs.getString("telephone");
               String permis=rs.getString("permis");
               
               chaufeur charger_chaufeur =new chaufeur(id,nom,prenom,email,telephone,permis);
               chaufeurs.add(charger_chaufeur);
           }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        
        return chaufeurs;
    }
    
    //=========================1.5 select count chaufeur ==============================================================
    public int count_chaufeur(){
        String count="SELECT count(*) as count from chaufeur";
        try{
          stmt=con.createStatement();
          rs=stmt.executeQuery(count);
          if(rs.next()){
              return rs.getInt(1);
          }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return 0;
    }
    
    //==============================1.6 search chaufeur ==============================================================
    public List<chaufeur>  searchchaufeur(String text){
        List<chaufeur> search=new ArrayList<>();
        String seek="SELECT * FROM chaufeur where nom_chaufeur LIKE ? OR prenom_chaufeur LIke ?";
        try{
            pstmt=con.prepareStatement(seek);
            pstmt.setString(1, "%"+text+"%");
            pstmt.setString(2, "%"+text+"%");
            
            rs=pstmt.executeQuery();
            
            while(rs.next()){
               int id=rs.getInt("id");
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String email=rs.getString("email");
               String telephone=rs.getString("telephone");
               String permis=rs.getString("permis");
               
               chaufeur search_chaufeur =new chaufeur(id,nom,prenom,email,telephone,permis);
               search.add(search_chaufeur);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return search;
    }
    
    //--------------------------------------------------------------------------------------------------------------
    //***************************************************************************************************************
    //---------------------------------------2.client------------------------------------------------------------------
    //=======================================2.1 add client ===========================================================
    public int addclinet(client c){
        String sql="INSERT INTO client (nom_client,prenom_client,telephone_client,email_client) VALUES (?,?,?,?)";
        try{
           pstmt=con.prepareStatement(sql);
           pstmt.setString(1, c.getNom_client());
           pstmt.setString(2, c.getPrenom_client());
           pstmt.setString(3, c.getTelephone_client());
           pstmt.setString(4,c.getEmail());
           
           int add=pstmt.executeUpdate();
           return add;
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    //===================================2.2 update clinet ==============================================================
    public int updateclinet(client c){
        String up="UPDATE TABLE client SET nom_client=?,prenom_client=?,telephone_client=?,email_client=? where id=?";
        try{
           pstmt=con.prepareStatement(up);
           pstmt.setString(1, c.getNom_client());
           pstmt.setString(2, c.getPrenom_client());
           pstmt.setString(3, c.getTelephone_client());
           pstmt.setString(4,c.getEmail());
           pstmt.setInt(5, c.getId_client());
           
           int update=pstmt.executeUpdate();
           return update;
           
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    //==============================================2.3 DELETE CLIENT ==================================================
    public int deleteclient(client c){
        String del="DELETE FROM client WHERE id_client=?";
        try{
            pstmt=con.prepareStatement(del);
            pstmt.setInt(1, c.getId_client());
            
            int delete=pstmt.executeUpdate();
            return delete;
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }
     
    //==========================================2.4 SELECT ALL CLIENT ==============================================
    public List<client> select_all_client(){
        List<client> found=new ArrayList<>();
        String select="SELECT * FROM client";
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(select);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String telephone=rs.getString("telephone");
                String email=rs.getString("email");
                
                client display=new client(id,nom,prenom,telephone,email);
                found.add(display);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return found;
    }
    
    //===========================2.5 select_id_nom_mail CLIENT=================================================
    public List<client> select_id_nom_mail(){
        List<client> foundnom=new ArrayList<>();
        String get="SELECT id_client,nom_client,email_client FROM client";
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(get);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String nom=rs.getString("nom");
                String email=rs.getString("email");
                
                client getter=new client(id,nom,email);
                foundnom.add(getter);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return foundnom;
    }
    
    //==============================2.6 countALL_client ============================================
    public int countclient(){
        String count="SELECT count(*) as count FROM client";
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(count);
            
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return 0;
    }
    
    //==============================2.7 search from client ============================================
    public List<client> searchclient(String txt){
        List<client> search=new ArrayList<>();
        String req="SELECT * FROM client WHERE nom_client LIKE ?,email_client LIKE ?";
        try{
            pstmt=con.prepareStatement(req);
            pstmt.setString(1, "%"+txt+"%");
            pstmt.setString(2, "%"+txt+"%");
            
            rs=pstmt.executeQuery();
            while(rs.next()){
               int id=rs.getInt("id");
                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String telephone=rs.getString("telephone");
                String email=rs.getString("email");
                
                client display=new client(id,nom,prenom,telephone,email);
                search.add(display); 
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return search;
    }
    
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------3.exercer_utilisateur_role---------------------------------------
  //========================================== 3.1 add_exercer_utilisateur_role =========================================
    public int addexercer(exercer e){
        String sql="INSERT INTO exercer (date_debut,matricule,id_role) VALUES (?,?,?)";
        try{
          pstmt=con.prepareStatement(sql);
          pstmt.setString(1, e.getDate_debut());
          pstmt.setString(2, e.getMatricule());
          pstmt.setInt(3, e.getId_role());
          
          int r=pstmt.executeUpdate();
          return r;
        }catch(SQLException error){
            System.err.println(error.getMessage());
        }
        
        return 0;
    }
    
    //===================================3.2 update exercer_utilisateur_role ===========================================
    public int updateexercer(exercer e){
        String up="UPDATE TABLE exercer SET date_debut=?, matricule=? ,id_role=? WHERE id_exercer=?";
        try{
          pstmt=con.prepareStatement(up);
          pstmt.setString(1, e.getDate_debut());
          pstmt.setString(2, e.getMatricule());
          pstmt.setInt(3, e.getId_role());
          pstmt.setInt(4, e.getId_exercer());
          
          int r=pstmt.executeUpdate();
          return r;  
        }catch(SQLException error){
            System.err.println(error.getMessage());
        }
        return 0;
    }
 //==================================3.3 delete exercer_role_users ==================================================
        public int deleteexercer(exercer e){
        String del="DELETE FROM exercer WHERE id_exercer=?";
        try{
            pstmt=con.prepareStatement(del);
            pstmt.setInt(1, e.getId_exercer());
            
            int delete=pstmt.executeUpdate();
            return delete;
        }catch(SQLException error){
            System.err.println(error.getMessage());
        }
        return 0;
    }
    
 //============================== 3.4 delect_all_exercer_role_users ========================================================
        public List<exercer> select_exercer(){
            List<exercer> found=new ArrayList<>();
            String sql="SELECT exercer.id_exercer,exercer.date_debut,exercer.id_role,utilisateur.matricule,role.nom_role,utilisateur.email_user FROM utilisateur INNER JOIN (role inner join exercer) ON utilisateur.matricule=exercer.matricule AND role.id_role=exercer.id_role";
            try{
                stmt=con.createStatement();
                rs=stmt.executeQuery(sql);
                
                while(rs.next()){
                   int id=rs.getInt("id");
                   String date_debut=rs.getString("date_debut");
                   int id_role=rs.getInt("id_role");
                   String matricule=rs.getString("matricule");
                   String nom_role=rs.getString("nom_role");
                   String email=rs.getString("email");
                   
                   exercer chek=new exercer(id,date_debut,id_role,matricule,nom_role,email);
                   found.add(chek);
                }
            }catch(SQLException e){
                System.err.println(e);
            }
            return found;
        }
        
  //=============================== 3.5 Search_exercer_user_role =================================================
        public List<exercer> searchexercer(String txt){
            List<exercer> found=new ArrayList<>();
            String sql="SELECT exercer.id_exercer,exercer.date_debut,exercer.id_role,utilisateur.matricule,role.nom_role,utilisateur.email_user FROM utilisateur INNER JOIN (role inner join exercer) ON utilisateur.matricule=exercer.matricule AND role.id_role=exercer.id_role WHERE utilisateur.email_user LIKE ?, role.nom_role LIKE ? ";
            try{
              pstmt=con.prepareStatement(sql);
              pstmt.setString(1, "%"+txt+"%");
              pstmt.setString(1, "%"+txt+"%");
              
              rs=pstmt.executeQuery();
              while(rs.next()){
                   int id=rs.getInt("id");
                   String date_debut=rs.getString("date_debut");
                   int id_role=rs.getInt("id_role");
                   String matricule=rs.getString("matricule");
                   String nom_role=rs.getString("nom_role");
                   String email=rs.getString("email");
                   
                   exercer chek=new exercer(id,date_debut,id_role,matricule,nom_role,email);
                   found.add(chek);      
              }
            }catch(SQLException e){
                System.err.println(e.getMessage());
            } 
            
            return found;
        }
        
    //====================================== 3.6 select_count_exercer_user_role ====================================
        public int selectcount_exercer(){
            String r="SELECT count(*) as count FROM exercer";
            try{
                stmt=con.createStatement();
                rs=stmt.executeQuery(r);
                
                if(rs.next()){
                     return rs.getInt(1);
                }
            }catch(SQLException error){
                System.err.println(error.getMessage());
            }
            
            return 0;
        }
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------4.reservation---------------------------------------
    //==================================================4.1 addreservation ===============================================
             public int addreservation(reservation e){
                String sql="INSERT INTO reservation (date_reservation,nom_place,id_voyage,id_client,matricule) VALUES (?,?,?,?,?)";
                try{
                  pstmt=con.prepareStatement(sql);
                  pstmt.setString(1, e.getDate_reservation());
                  pstmt.setString(2, e.getNom_place());
                  pstmt.setInt(3, e.getId_voyage());
                  pstmt.setInt(4, e.getId_client());
                  pstmt.setString(5, e.getMatricule());

                  int r=pstmt.executeUpdate();
                  return r;
                }catch(SQLException error){
                    System.err.println(error.getMessage());
                }

                return 0;
    }
 
 //================================== 4.2 updatereservation ===========================================================
             public int updatereservation(reservation e){
                String up="UPDATE TABLE reservation SET date_reservation=? ,nom_place=? ,id_voyage=?,id_client=?,matricule=? WHERE id_reservation=?";
                try{
                  pstmt=con.prepareStatement(up);
                  pstmt.setString(1, e.getDate_reservation());
                  pstmt.setString(2, e.getNom_place());
                  pstmt.setInt(3, e.getId_voyage());
                  pstmt.setInt(4, e.getId_client());
                  pstmt.setString(5, e.getMatricule());
                  pstmt.setInt(6,e.getId_reservation());

                  int r=pstmt.executeUpdate();
                  return r;
                }catch(SQLException error){
                    System.err.println(error.getMessage());
                }

                return 0;
    }             
    
  //================================== 4.3 deletereservation ===========================================================
        public int deletereservation(reservation e){
           String del="DELETE FROM reservation WHERE id_reservation=?";
           try{
               pstmt=con.prepareStatement(del);
               pstmt.setInt(1, e.getId_reservation());

               int delete=pstmt.executeUpdate();
               return delete;
           }catch(SQLException error){
               System.err.println(error.getMessage());
           }
           return 0;
       }
        
 //================================= 4.4 select_all_reservation =======================================================
    public List<reservation> selectreservation(){
        List<reservation> foundnom=new ArrayList<>();
        String get="SELECT * FROM reservation";
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(get);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String data_reservation=rs.getString("data_reservation");
                String nom_place=rs.getString("nom_place");
                int id_voyage=rs.getInt("id_voyage");
                int id_client=rs.getInt("id_client");
                String matricule=rs.getString("matricule");
                
                reservation ge=new reservation(id,data_reservation,nom_place,id_voyage,id_client,matricule);
                foundnom.add(ge);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return foundnom;
    } 
    
    //================================= 4.5 search reservation ==========================================================
    public List<reservation> searchreservation(String txt){
        List<reservation> foundnom=new ArrayList<>();
        String get="SELECT * FROM reservation date_reservation LIKE ? ";
        try{
            pstmt=con.prepareStatement(get);
            pstmt.setString(1, "%"+txt+"%");
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                int id=rs.getInt("id");
                String data_reservation=rs.getString("data_reservation");
                String nom_place=rs.getString("nom_place");
                int id_voyage=rs.getInt("id_voyage");
                int id_client=rs.getInt("id_client");
                String matricule=rs.getString("matricule");
                
                reservation ge=new reservation(id,data_reservation,nom_place,id_voyage,id_client,matricule);
                foundnom.add(ge);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return foundnom;
    } 
    
    //========================================= 4.6 count reservation ==================================================
        public int selectcount_reservation(){
            String r="SELECT count(*) as count FROM reservation";
            try{
                stmt=con.createStatement();
                rs=stmt.executeQuery(r);
                
                if(rs.next()){
                     return rs.getInt(1);
                }
            }catch(SQLException error){
                System.err.println(error.getMessage());
            }
            
            return 0;
        }
        
    //====================================== 4.7  select reservation to ticket=============================================
    public List<reservation> select_ticket_reservation(String txt){
        List<reservation> foundnom=new ArrayList<>();
        String get="SELECT reservation.id_reservation,reservation.date_reservation,reservation.nom_place,utilisateur.matricule,client.email_client FROM utilisateur INNER JOIN (client INNER JOIN reservation) ON utilisateur.matricule=reservation.matricule AND client.id_client=reservation.id_client WHERE client.email_client LIKE ? ";
        try{
            pstmt=con.prepareStatement(get);
            pstmt.setString(1, "%"+txt+"%");
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                int id=rs.getInt("id");
                String data_reservation=rs.getString("data_reservation");
                String nom_place=rs.getString("nom_place");
                String matricule=rs.getString("matricule");
                String email_client=rs.getString("iemail_client");
                
                reservation ge=new reservation(id,data_reservation,nom_place,matricule,email_client);
                foundnom.add(ge);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return foundnom;
    } 
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------5.role_utilisateur------------------------------------------------
    //================================================== 5.1 add role_user ==============================================
    public int add_role(role r){
        String add="INSERT INTO role (nom_role) VALUES (?)";
        try{
        pstmt=con.prepareStatement(add);
        pstmt.setString(1, r.getNom_role());
        int added=pstmt.executeUpdate();
        return added;
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }
   //============================================== 5.2 update role_user =================================================
        public int update_role(role r){
            String up="UPDATE role SET nom_role=? WHERE id_role=?";
            try{
             pstmt=con.prepareStatement(up);
             pstmt.setString(1, r.getNom_role());
             pstmt.setInt(2, r.getId_role());

             int upd=pstmt.executeUpdate();
             return upd;
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            return 0;
        }
  //======================================= 5.3 delete role_user =======================================================
        public int delete_role(role r){
            String del="DELETE FROM role where id_role=?";
            try{
                pstmt=con.prepareStatement(del);
                pstmt.setInt(1, r.getId_role());
                
                int p=pstmt.executeUpdate();
                return p;
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            return 0;
        }
        
   //==================================== 5.4 select all_role ======================================================
        public List<role> select_role(){
            List<role> found=new ArrayList<>();
            String select="SELECT * FROM role";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int id=rs.getInt("id");
                   String nom=rs.getString("nom");
                   
                   role pp=new role(id,nom);
                   found.add(pp);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found;
        }
        
    //===================================== 5.5 Search role_user =======================================================
        public List<role> search_role(String txt){
            List<role> found=new ArrayList<>();
            String ff="SELECT * FROM role WHERE nom_role LIKE ?";
            try{
               pstmt=con.prepareStatement(ff);
               pstmt.setString(1, "%"+txt+"%");
               
               rs=pstmt.executeQuery();
                while(rs.next()){
                    int id=rs.getInt("id");
                   String nom=rs.getString("nom");
                   
                   role pp=new role(id,nom);
                   found.add(pp);
                }
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            
            return found;
        }
    
     //=============================================== 5.6 count_select_all_role_we have ===============================
         public int countrole(){
             String in="Select count(*) FROM role ";
             try{
                 stmt=con.createStatement();
                 rs=stmt.executeQuery(in);
                 if(rs.next()){
                     return rs.getInt(1);
                 }
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
             return 0;
         }        
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------6.ticket---------------------------------------------------------
 
 
    
    
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------7.trajectoire---------------------------------------
 
 
    
    
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------8.type_veliocule---------------------------------------
 
 
    
    
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------9.utulisateur---------------------------------------
 
 
    
    
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------10.vehicule---------------------------------------
 
 
    
    
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------11.voyage---------------------------------------
 
 
    
    
    //-------------------------------------------------------------------------------------------------------------------
    
    //####################################################################################################################
    //-----------------------------SQL Operation for Administrator---------------------------------------------------
    
    
    
    
    //------------------------------------------------------------------------------------------------------------------
    
}
