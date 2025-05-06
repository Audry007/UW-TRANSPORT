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
               int id_chaufeur =rs.getInt("id_chaufeur ");
               String nom_chaufeur=rs.getString("nom_chaufeur");
               String prenom_chaufeur=rs.getString("prenom_chaufeur");
               String email_chaufeur=rs.getString("email_chaufeur");
               String telephone_chaufeur=rs.getString("telephone_chaufeur");
               String permis_chaufeur=rs.getString("permis_chaufeur");
               
               chaufeur charger_chaufeur =new chaufeur(id_chaufeur,nom_chaufeur,prenom_chaufeur,email_chaufeur,telephone_chaufeur,permis_chaufeur);
               chaufeurs.add(charger_chaufeur);
           }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        
        return chaufeurs;
    }
    
    //===============================1.5 show select chaufeur to voyage ==============================================================
    public List<chaufeur> get_few_chaufeur(){
        List<chaufeur> chaufeurs=new ArrayList<>();
        String select="SELECT id_chaufeur,nom_chaufeur,prenom_chaufeur,telephone_chaufeur,permi_conduire FROM chaufeur";
        try{
           stmt=con.createStatement();
           rs=stmt.executeQuery(select);
           
           while(rs.next()){
               int id_chaufeur=rs.getInt("id_chaufeur");
               String nom_chaufeur=rs.getString("nom_chaufeur");
               String prenom_chaufeur=rs.getString("prenom_chaufeur");
               String telephone_chaufeur=rs.getString("telephone_chaufeur");
               String permi_conduire=rs.getString("permi_conduire");
               
               chaufeur charger_chaufeur =new chaufeur(id_chaufeur,nom_chaufeur,prenom_chaufeur,telephone_chaufeur,permi_conduire);
               chaufeurs.add(charger_chaufeur);
           }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        
        return chaufeurs;
    }
    
   //===============================1.6 show select chaufeur to chaufeur ============================================ 
    public List<chaufeur>  search_few_chaufeur(String text){
        List<chaufeur> search=new ArrayList<>();
        String seek="SELECT id_chaufeur,nom_chaufeur,prenom_chaufeur,telephone_chaufeur,permi_conduire FROM chaufeur where nom_chaufeur LIKE ? OR prenom_chaufeur LIke ?";
        try{
            pstmt=con.prepareStatement(seek);
            pstmt.setString(1, "%"+text+"%");
            pstmt.setString(2, "%"+text+"%");
            
            rs=pstmt.executeQuery();
            
           while(rs.next()){
               int id_chaufeur=rs.getInt("id_chaufeur");
               String nom_chaufeur=rs.getString("nom_chaufeur");
               String prenom_chaufeur=rs.getString("prenom_chaufeur");
               String telephone_chaufeur=rs.getString("telephone_chaufeur");
               String permi_conduire=rs.getString("permi_conduire");
               
               chaufeur charger_chaufeur =new chaufeur(id_chaufeur,nom_chaufeur,prenom_chaufeur,telephone_chaufeur,permi_conduire);
               search.add(charger_chaufeur);
           }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return search;
    }
    
    //=========================1.7 select count chaufeur ==============================================================
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
    
    //==============================1.8 search chaufeur ==============================================================
    public List<chaufeur>  searchchaufeur(String text){
        List<chaufeur> search=new ArrayList<>();
        String seek="SELECT * FROM chaufeur where nom_chaufeur LIKE ? OR prenom_chaufeur LIke ?";
        try{
            pstmt=con.prepareStatement(seek);
            pstmt.setString(1, "%"+text+"%");
            pstmt.setString(2, "%"+text+"%");
            
            rs=pstmt.executeQuery();
            
            while(rs.next()){
               int id_chaufeur=rs.getInt("id_chaufeur");
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String email=rs.getString("email");
               String telephone=rs.getString("telephone");
               String permis=rs.getString("permis");
               
               chaufeur search_chaufeur =new chaufeur(id_chaufeur,nom,prenom,email,telephone,permis);
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
        String select="SELECT * FROM client ORDER BY id_client ASC";
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(select);
            
            while(rs.next()){
                int id_client=rs.getInt("id_client");
                String nom_client=rs.getString("nom_client");
                String prenom_client=rs.getString("prenom_client");
                String telephone_client=rs.getString("telephone_client");
                String email_client=rs.getString("email_client");
                
                client display=new client(id_client,nom_client,prenom_client,telephone_client,email_client);
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
        String req="SELECT * FROM client WHERE nom_client LIKE ? or prenom_client LIKE ?";
        try{
            pstmt=con.prepareStatement(req);
            pstmt.setString(1, "%"+txt+"%");
            pstmt.setString(2,"%"+txt+"%");
            
            rs=pstmt.executeQuery();
            while(rs.next()){
               int id_client=rs.getInt("id_client");
                String nom_client=rs.getString("nom_client");
                String prenom_client=rs.getString("prenom_client");
                String telephone_client=rs.getString("telephone_client");
                String email_client=rs.getString("email_client");
                
                client display=new client(id_client,nom_client,prenom_client,telephone_client,email_client);
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
                String up="UPDATE  reservation SET date_reservation=? ,nom_place=?,matricule=?,id_client=?,id_voyage=? WHERE id_reservation=?";
                try{
                  pstmt=con.prepareStatement(up);
                  pstmt.setString(1, e.getDate_reservation());
                  pstmt.setString(2, e.getNom_place());
                   pstmt.setString(3, e.getMatricule());
                   pstmt.setInt(4, e.getId_client());
                  pstmt.setInt(5, e.getId_voyage());
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
                int id_reservation =rs.getInt("id_reservation");
                String date_reservation=rs.getString("date_reservation");
                String nom_place=rs.getString("nom_place");
                int id_voyage =rs.getInt("id_voyage");
                int id_client =rs.getInt("id_client");
                String matricule =rs.getString("matricule");
                
                reservation ge=new reservation(id_reservation,date_reservation,nom_place,matricule,id_client,id_voyage);
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
        String get="SELECT * FROM reservation where date_reservation LIKE ? ";
        try{
            pstmt=con.prepareStatement(get);
            pstmt.setString(1, "%"+txt+"%");
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                int id_reservation =rs.getInt("id_reservation");
                String date_reservation=rs.getString("date_reservation");
                String nom_place=rs.getString("nom_place");
                int id_voyage =rs.getInt("id_voyage");
                int id_client =rs.getInt("id_client");
                String matricule =rs.getString("matricule");
                
                reservation ge=new reservation(id_reservation,date_reservation,nom_place,matricule,id_client,id_voyage);
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
    public List<reservation> select_ticket_reservation(){
        List<reservation> foundnom=new ArrayList<>();
        String get="SELECT reservation.id_reservation,reservation.date_reservation,reservation.nom_place,utilisateur.matricule,client.email_client FROM utilisateur INNER JOIN (client INNER JOIN reservation) ON utilisateur.matricule=reservation.matricule AND client.id_client=reservation.id_client";
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(get);
            
            while(rs.next()){
                int id_reservation=rs.getInt("id_reservation");
                String date_reservation=rs.getString("date_reservation");
                String nom_place=rs.getString("nom_place");
                String matricule=rs.getString("matricule");
                String email_client=rs.getString("email_client");
                
                reservation ge=new reservation(id_reservation,date_reservation,nom_place,matricule,email_client);
                foundnom.add(ge);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return foundnom;
    } 
        
        
    //====================================== 4.7  select reservation to ticket=============================================
    public List<reservation> search_ticket_reservation(String txt){
        List<reservation> foundnom=new ArrayList<>();
        String get="SELECT reservation.id_reservation,reservation.date_reservation,reservation.nom_place,utilisateur.matricule,client.email_client FROM utilisateur INNER JOIN (client INNER JOIN reservation) ON utilisateur.matricule=reservation.matricule AND client.id_client=reservation.id_client WHERE client.email_client LIKE ? ";
        try{
            pstmt=con.prepareStatement(get);
            pstmt.setString(1, "%"+txt+"%");
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                int id_reservation=rs.getInt("id_reservation");
                String date_reservation=rs.getString("date_reservation");
                String nom_place=rs.getString("nom_place");
                String matricule=rs.getString("matricule");
                String email_client=rs.getString("email_client");
                
                reservation ge=new reservation(id_reservation,date_reservation,nom_place,matricule,email_client);
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
         public int count_role(){
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
    //============================================== 6.1 Add_ticket ======================================================
         public int add_ticket(ticket r){
             String add="INSERT INTO ticket (numero_ticket,date_emission,id_reservation) VALUES (?,?,?)";
             try{
                 pstmt=con.prepareStatement(add);
                 pstmt.setString(1, r.getNumero_ticket());
                 pstmt.setString(2, r.getDate_emission());
                 pstmt.setInt(3,r.getId_reservation());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
             return 0;
         }
 
    //============================== 6.2 update_ticket   ==================================================================
         public int update_ticket(ticket r){
             String up="UPDATE ticket SET numero_ticket=?, date_emission=? , id_reservation=? WHERE id_ticket=?";
             try{
                 pstmt=con.prepareStatement(up);
                 pstmt.setString(1, r.getNumero_ticket());
                 pstmt.setString(2, r.getDate_emission());
                 pstmt.setInt(3,r.getId_reservation());
                 pstmt.setInt(4, r.getId_ticket());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
             return 0;
         }
         
    //======================================== 6.3 delete_ticket ========================================================
        public int delete_ticket(ticket r){
            String del="DELETE FROM role where id_role=?";
            try{
                pstmt=con.prepareStatement(del);
                pstmt.setInt(1, r.getId_ticket());
                
                int pop=pstmt.executeUpdate();
                return pop;
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            return 0;
        }
    
    //============================================== 6.4 select_ticket ==================================================
        public List<ticket> select_ticket(){
            List<ticket> found_ticket=new ArrayList<>();
            String select="SELECT * FROM ticket";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int id_ticket=rs.getInt("id_ticket");
                   String numero_ticket=rs.getString("numero_ticket");
                   String date_emission=rs.getString("date_emission");
                   int id_reservation=rs.getInt("id_reservation");
                   
                   
                   ticket pp=new ticket(id_ticket,numero_ticket,date_emission,id_reservation);
                   found_ticket.add(pp);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_ticket;
        }
        
     //=================================================== 6.5 search_ticket ===========================================
        public List<ticket> search_ticket(String txt){
            List<ticket> found_ticket=new ArrayList<>();
            String select="SELECT * FROM ticket WHERE numero_ticket LIKE ?";
            try{
                 pstmt=con.prepareStatement(select);
                 pstmt.setString(1, "%" +txt+ "%");
                 
                 rs=pstmt.executeQuery();
               while(rs.next()){
                   int id_ticket=rs.getInt("id_ticket");
                   String numero_ticket=rs.getString("numero_ticket");
                   String date_emission=rs.getString("date_emission");
                   int id_reservation=rs.getInt("id_reservation");
                   
                   
                   ticket pp=new ticket(id_ticket,numero_ticket,date_emission,id_reservation);
                   found_ticket.add(pp);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_ticket;
        }
        
   //=================================================== 6.6 select_Count_ticket ======================================
         public int count_ticket(){
             String in="Select count(*) FROM ticket ";
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
    //================================================ 6.7 display et affichage ticket =================================
        public List<ticket> generate_ticket(String txt){
            List<ticket> found=new ArrayList<>();
            String select="SELECT ticket.numero_ticket,client.nom_client,client.prenom_client,client.email_client,reservation.id_reservation FROM ticket inner join reservation ON reservation.id_reservation=ticket.id_reservation INNER JOIN client ON client.id_client=reservation.id_client";
            try{
                 stmt=con.createStatement();
                 rs=stmt.executeQuery(select);
                 
               while(rs.next()){
                   String numero_ticket=rs.getString("numero_ticket");
                   String nom_client=rs.getString("nom_client");
                   String prenom_client=rs.getString("prenom_client");
                   String email_client=rs.getString("email_client"); 
                   int id_reservation=rs.getInt("id_reservation");
                   
                   
                   ticket pp=new ticket(numero_ticket,nom_client,prenom_client,email_client,id_reservation);
                   found.add(pp);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found;
        }
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------7.trajectoire---------------------------------------
     //============================================== 7.1 add trajectoire ===============================================
        public int addtrajectoire(trajectoire t){
               String add="INSERT INTO trajectoire (ville_depart,ville_arrive,heure_depart,prix_trajet,duree_estime) VALUES (?,?,?,?,?)";
             try{
                 pstmt=con.prepareStatement(add);
                 pstmt.setString(1, t.getVille_depart());
                 pstmt.setString(2, t.getVille_arrive());
                 pstmt.setString(3,t.getHeure_depart());
                 pstmt.setInt(4,t.getPrix_trajet());
                 pstmt.setString(5,t.getDuree_estime());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
            return 0;
        }
 
   //====================================== 7.2 update trajectiore =================================================
         public int update_trajectoire(trajectoire t){
             String up="UPDATE trajectoire SET ville_depart=?, ville_arrive=? , heure_depart=? , prix_trajet=? , duree_estime=? WHERE id_trajet =?";
             try{
                 pstmt=con.prepareStatement(up);
                 pstmt.setString(1, t.getVille_depart());
                 pstmt.setString(2, t.getVille_arrive());
                 pstmt.setString(3,t.getHeure_depart());
                 pstmt.setInt(4,t.getPrix_trajet());
                 pstmt.setString(5,t.getDuree_estime());
                 pstmt.setInt(6, t.getId_trajet());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
             return 0;
         }
         
    //======================================== 7.3 delete trajectoire ================================================
        public int delete_trajectoire(trajectoire t){
            String del="DELETE FROM trajectoire where id_trajet =?";
            try{
                pstmt=con.prepareStatement(del);
                pstmt.setInt(1, t.getId_trajet());
                
                int pop=pstmt.executeUpdate();
                return pop;
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            return 0;
        }  
        
    //========================================== 7.4 select_all_Trajectoire ============================================
        public List<trajectoire> select_trajectoire(){
            List<trajectoire> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  trajectoire";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int id_trajet=rs.getInt("id_trajet");
                   String ville_depart=rs.getString("ville_depart");
                   String ville_arrive=rs.getString("ville_arrive");
                   String heure_depart=rs.getString("heure_depart");
                   int prix_trajet=rs.getInt("prix_trajet");
                   String duree_estime=rs.getString("duree_estime");
                   
                   
                   trajectoire p=new trajectoire(id_trajet,ville_depart,ville_arrive,heure_depart,prix_trajet,duree_estime);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        } 
        
     //=========================================== 7.5 search_from_Trajectoire ==========================================
        public List<trajectoire> search_trajectoire(String txt){
            List<trajectoire> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  trajectoire where ville_depart LIKE ?";
            try{
                
                pstmt=con.prepareStatement(select);
                pstmt.setString(1, "%"+txt+"%");
                rs=pstmt.executeQuery();
                
               while(rs.next()){
                   int id_trajet=rs.getInt("id_trajet");
                   String ville_depart=rs.getString("ville_depart");
                   String ville_arrive=rs.getString("ville_arrive");
                   String heure_depart=rs.getString("heure_depart");
                   int prix_trajet=rs.getInt("prix_trajet");
                   String duree_estime=rs.getString("duree_estime");
                   
                   
                   trajectoire p=new trajectoire(id_trajet,ville_depart,ville_arrive,heure_depart,prix_trajet,duree_estime);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            return found_trajet;
        } 
        
    //=========================================== 7. 6 count select trajectoire ==============================================
         public int count_trajectoire(){
             String in="Select count(*) FROM trajectoire ";
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
    //--------------------------------------------------8.type_veliocule--------------------------------------------------
    //================================================= 8.1 Add type_vehicule ============================================
        public int add_type_vehicule(type_vehicule r){
                String add="INSERT INTO type_vehicule (nom_type) VALUES (?)";
                try{
                    pstmt=con.prepareStatement(add);
                    pstmt.setString(1, r.getNom_type());
                    int added=pstmt.executeUpdate();
                    return added;
                }catch(SQLException e){
                    System.err.println(e.getMessage());
                }
                return 0;
        }
    //========================================== 8.2 update type_vehicule ==============================================
        public int update_type_vehicule(type_vehicule r){
                   String up="UPDATE role SET nom_type=? WHERE id_type=?";
            try{
                pstmt=con.prepareStatement(up);
                pstmt.setString(1, r.getNom_type());
                pstmt.setInt(2, r.getId_type());

                int upd=pstmt.executeUpdate();
                return upd;
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            return 0;
        } 
        
    //========================================= 8.3 delete type_vehicule ===============================================
        public int delete_type_vehicule(type_vehicule r){
            String del="DELETE FROM  type_vehicule where id_ type=?";
            try{
                pstmt=con.prepareStatement(del);
                pstmt.setInt(1, r.getId_type());
                
                int p=pstmt.executeUpdate();
                return p;
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            return 0;
        }
        
    //=========================================== 8.4 select  type_vehicule =============================================
        public List< type_vehicule> select_type_vehicule(){
            List<type_vehicule> found=new ArrayList<>();
            String select="SELECT * FROM  type_vehicule";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int id_type=rs.getInt("id_type");
                   String nom_type=rs.getString("nom_type");
                   
                    type_vehicule pp=new  type_vehicule(id_type,nom_type);
                   found.add(pp);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found;
        }
        
    //============================================== 8.5 search type_vehicule ================================================
        public List< type_vehicule> search_type_vehicule(String txt){
            List<type_vehicule> found=new ArrayList<>();
            String select="SELECT * FROM  type_vehicule where nom_type LIKE ? ";
            try{
                pstmt=con.prepareStatement(select);
                pstmt.setString(1,"%"+txt+"%");
                rs=pstmt.executeQuery();
               
               while(rs.next()){
                   int id_type=rs.getInt("id_type");
                   String nom_type=rs.getString("nom_type");
                   
                    type_vehicule pp=new  type_vehicule(id_type,nom_type);
                   found.add(pp);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found;
        }
        
    //=========================================== 8.6 count type_vehicule ===================================================
        public int count_type_vehicule(){
            String p="SELECT count(*) FROM type_vehicule";
            try{
              stmt=con.createStatement();
              rs=stmt.executeQuery(p);
              
              if(rs.next()){
                  return rs.getInt(1);
              }
            }catch(SQLException pp){
                System.err.println(pp.getMessage());
            }
            return 0;
        }
    //-------------------------------------------------------------------------------------------------------------------
    //********************************************************************************************************************* 
    //--------------------------------------------------9.utulisateur-------------------------------------------------------
    //=================================================== 9.1 Add_utilisateur ==============================================
        public int add_utilisateur(utilisateur t){
               String add="INSERT INTO utilisateur (matricule ,nom_user,prenom_user,email_user,telephone_user,username,motdepasse) VALUES (?,?,?,?,?,?,?)";
             try{
                 pstmt=con.prepareStatement(add);
                 pstmt.setString(1, t.getMatricule());
                 pstmt.setString(2, t.getNom_user());
                 pstmt.setString(3,t.getPrenom_user());
                 pstmt.setString(4,t.getEmail_user());
                 pstmt.setString(5,t.getTelephone_user());
                 pstmt.setString(6, t.getUsername());
                 pstmt.setString(7, t.getMotdepasse());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
            return 0;
        }    
        
    //============================================== 9.2 update utilisateur ======================================================
        public int update_utilisateur(utilisateur t){
               String add="UPDATE  utilisateur SET nom_user =?,prenom_user =?,email_user =? ,telephone_user =?,username =?,motdepasse=? WHERE matricule=? ";
             try{
                 pstmt=con.prepareStatement(add);
                 pstmt.setString(2, t.getNom_user());
                 pstmt.setString(3,t.getPrenom_user());
                 pstmt.setString(4,t.getEmail_user());
                 pstmt.setString(5,t.getTelephone_user());
                 pstmt.setString(6, t.getUsername());
                 pstmt.setString(7, t.getMotdepasse());
                 pstmt.setString(1, t.getMatricule());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
            return 0;
        }   
    
    //=========================================== 9.3 delete utilisateur =========================================================
        public int delete_utilisateur(utilisateur t){
            String del="DELETE FROM utilisateur WHERE matricule=?";
            try{
                pstmt=con.prepareStatement(del);
                pstmt.setString(1, t.getMatricule());
                
                int p=pstmt.executeUpdate();
                return p;
            }catch(SQLException ppp){
                System.err.println(ppp.getMessage());
            }
            return 0;
        }
        
    //====================================== 9.4 select utilisateur ==============================================================
        public List<utilisateur> select_utilisateur(){
            List<utilisateur> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  utilisateur";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   String matricule=rs.getString("matricule");
                   String nom_user=rs.getString("nom_user");
                   String prenom_user=rs.getString("prenom_user");
                   String email_user=rs.getString("email_user");
                   String telephone_user=rs.getString("telephone_user");
                   String username=rs.getString("username");
                   String motdepasse=rs.getString("motdepasse");
                   
                   
                   utilisateur p=new utilisateur(matricule,nom_user,prenom_user,email_user,telephone_user,username,motdepasse);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }    
        
    //==========================================9 .5 search utilisateur =========================================================
        public List<utilisateur> search_utilisateur( String txt){
            List<utilisateur> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  utilisateur where matricule LIKE ?";
            try{
                pstmt=con.prepareStatement(select);
                pstmt.setString(1, "%"+txt+"%");
                
                rs=pstmt.executeQuery();
               while(rs.next()){
                   String matricule=rs.getString("matricule");
                   String nom_user=rs.getString("nom_user");
                   String prenom_user=rs.getString("prenom_user");
                   String email_user=rs.getString("email_user");
                   String telephone_user=rs.getString("telephone_user");
                   String username=rs.getString("username");
                   String motdepasse=rs.getString("motdepasse");
                   
                   
                   utilisateur p=new utilisateur(matricule,nom_user,prenom_user,email_user,telephone_user,username,motdepasse);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }     
    //===================================================== 9. 6 select_count_ utilisateur =======================================
        public int count_utilisateur(){
            String p="SELECT count(*) FROM utilisateur";
            try{
              stmt=con.createStatement();
              rs=stmt.executeQuery(p);
              
              if(rs.next()){
                  return rs.getInt(1);
              }
            }catch(SQLException pp){
                System.err.println(pp.getMessage());
            }
            return 0;
        }
        
    //----------------------------------------------------------------------------------------------------------------------
    //*********************************************************************************************************************** 
    //--------------------------------------------------10.vehicule----------------------------------------------------------
    //================================================= 10.1 Add_vehicule ===================================================
        public int add_vehicule(vehicule v){
               String add="INSERT INTO vehicule (num_matricule ,marque,capacite,color,status,id_type) VALUES (?,?,?,?,?,?)";
             try{
                 pstmt=con.prepareStatement(add);
                 pstmt.setString(1, v.getNum_matricule());
                 pstmt.setString(2, v.getMarque());
                 pstmt.setString(3,v.getCapacite());
                 pstmt.setString(4,v.getColor());
                 pstmt.setString(5,v.getStatus());
                 pstmt.setInt(6, v.getId_type());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
            return 0;
        }  
    //====================================================== 10.2 update_vehicule ==========================================
        public int update_vehicule(vehicule v){
               String add="UPDATE vehicule SET num_matricule=? ,marque=?,capacite=?,color=?,status=?,id_type=? WHERE idvehicule =? ";
             try{
                 pstmt=con.prepareStatement(add);
                 pstmt.setString(1, v.getNum_matricule());
                 pstmt.setString(2, v.getMarque());
                 pstmt.setString(3,v.getCapacite());
                 pstmt.setString(4,v.getColor());
                 pstmt.setString(5,v.getStatus());
                 pstmt.setInt(6, v.getId_type());
                 pstmt.setInt(7, v.getIdvehicule());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
            return 0;
        }  
    //========================================= 10.3 Delete_vehicule ================================================
        public int delete_vehicule(vehicule t){
            String del="DELETE FROM vehicule WHERE idvehicule =?";
            try{
                pstmt=con.prepareStatement(del);
                pstmt.setInt(1, t.getIdvehicule());
                
                int p=pstmt.executeUpdate();
                return p;
            }catch(SQLException ppp){
                System.err.println(ppp.getMessage());
            }
            return 0;
        }  
    
    //================================================ 10.4 select vehicule ==========================================
        public List<vehicule> select_vehicule(){
            List<vehicule> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  vehicule";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int idvehicule=rs.getInt("idvehicule");
                   String num_matricule=rs.getString("num_matricule");
                   String marque=rs.getString("marque");
                   String capacite=rs.getString("capacite");
                   String color=rs.getString("color");
                   String status=rs.getString("status");
                   int id_type=rs.getInt("id_type");
                   
                   
                   vehicule p=new vehicule(idvehicule,num_matricule,marque,capacite,color,status,id_type);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }
        
    //================================================ 10.5 select vehicule to voyage==========================================
        public List<vehicule> select_vehicule_voyage(){
            List<vehicule> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  vehicule";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int idvehicule=rs.getInt("idvehicule");
                   String num_matricule=rs.getString("num_matricule");
                   String marque=rs.getString("marque");
                   String capacite=rs.getString("capacite");
                   String status=rs.getString("status");
                   
                   
                   vehicule p=new vehicule(idvehicule,num_matricule,marque,capacite,status);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }
        
    //================================================= 10.6 search vehicule ============================================
        public List<vehicule> search_vehicule(String txt){
            List<vehicule> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  vehicule WHERE num_matricule Like ?";
            try{
                pstmt=con.prepareStatement(select);
                pstmt.setString(1, "%"+txt+"%");
                
                rs=pstmt.executeQuery();
               while(rs.next()){
                   int idvehicule=rs.getInt("idvehicule");
                   String num_matricule=rs.getString("num_matricule");
                   String marque=rs.getString("marque");
                   String capacite=rs.getString("capacite");
                   String color=rs.getString("color");
                   String status=rs.getString("status");
                   int id_type =rs.getInt("id_type");
                   
                   
                   vehicule p=new vehicule(idvehicule,num_matricule,marque,capacite,color,status,id_type);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        } 
        
    //================================================= 10.7 search vehicule ============================================
        public List<vehicule> search_vehicule_voyage(String txt){
            List<vehicule> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  vehicule WHERE num_matricule Like ?";
            try{
                pstmt=con.prepareStatement(select);
                pstmt.setString(1, "%"+txt+"%");
                
                rs=pstmt.executeQuery();
               while(rs.next()){
                   int idvehicule=rs.getInt("idvehicule");
                   String num_matricule=rs.getString("num_matricule");
                   String marque=rs.getString("marque");
                   String capacite=rs.getString("capacite");
                   String status=rs.getString("status");
                   
                   
                   vehicule p=new vehicule(idvehicule,num_matricule,marque,capacite,status);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }
        
    //============================================== 10.8 count vehicule ===============================================
        public int count_vehicule(){
            String p="SELECT count(*) FROM vehicule";
            try{
              stmt=con.createStatement();
              rs=stmt.executeQuery(p);
              
              if(rs.next()){
                  return rs.getInt(1);
              }
            }catch(SQLException pp){
                System.err.println(pp.getMessage());
            }
            return 0;
        }  
    //-------------------------------------------------------------------------------------------------------------------
    //******************************************************************************************************************** 
    //--------------------------------------------------11.voyage---------------------------------------------------------
    //================================================= 11.1 add voyage ==================================================
        public int add_voyage(voyage v){
               String add="INSERT INTO voyage (nom_voyage ,date_voyage,idvehicule ,id_chaufeur ,id_trajet ) VALUES (?,?,?,?,?)";
             try{
                 pstmt=con.prepareStatement(add);
                 pstmt.setString(1, v.getNom_voyage());
                 pstmt.setString(2, v.getDate_voyage());
                 pstmt.setInt(3,v.getIdvehicule());
                 pstmt.setInt(4,v.getId_chaufeur());
                 pstmt.setInt(5,v.getId_trajet());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
            return 0;
        }   
    
    //=================================================== 11.2 update voyage ==============================================
        public int update_voyage(voyage v){
               String add="UPDATE  voyage SET nom_voyage=? ,date_voyage =?,idvehicule=? ,id_chaufeur=?,id_trajet=? WHERE id_voyage =?";
             try{
                 pstmt=con.prepareStatement(add);
                 pstmt.setString(1, v.getNom_voyage());
                 pstmt.setString(2, v.getDate_voyage());
                 pstmt.setInt(3,v.getIdvehicule());
                 pstmt.setInt(4,v.getId_chaufeur());
                 pstmt.setInt(5,v.getId_trajet());
                 pstmt.setInt(6,v.getId_voyage());
                 
                 int added=pstmt.executeUpdate();
                 return added;
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
            return 0;
        }   
    
    //==================================================== 11.3 delete voyage ===========================================
        public int delete_voyage(voyage t){
            String del="DELETE FROM voyage WHERE id_voyage=?";
            try{
                pstmt=con.prepareStatement(del);
                pstmt.setInt(1, t.getId_voyage());
                
                int p=pstmt.executeUpdate();
                return p;
            }catch(SQLException ppp){
                System.err.println(ppp.getMessage());
            }
            return 0;
        }  
        
    //==================================================== 11.4 select all voyage ========================================
        public List<voyage> select_all_voyage(){
            List<voyage> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  voyage";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int id_voyage=rs.getInt("id_voyage");
                   String nom_voyage=rs.getString("nom_voyage");
                   String date_voyage=rs.getString("date_voyage");
                   int idvehicule=rs.getInt("idvehicule");
                   int id_chaufeur =rs.getInt("id_chaufeur");
                   int id_trajet =rs.getInt("id_trajet");
                   
                   
                   voyage p=new voyage(id_voyage,nom_voyage,date_voyage,idvehicule,id_chaufeur ,id_trajet);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }
     
        
     //============================ void pour le select voyage from chaufeur ==================================
        public List<voyage> select_voyage_chaufeur(){
            List<voyage> found_trajet=new ArrayList<>();
            String select="SELECT voyage.id_voyage,voyage.nom_voyage,voyage.date_voyage,chaufeur.prenom_chaufeur,chaufeur.permi_conduire FROM  voyage inner join chaufeur on chaufeur.id_chaufeur=voyage.id_chaufeur";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int id_voyage=rs.getInt("id_voyage");
                   String nom_voyage=rs.getString("nom_voyage");
                   String date_voyage=rs.getString("date_voyage");
                   String prenom_chaufeur=rs.getString("prenom_chaufeur");
                   String permi_conduire=rs.getString("permi_conduire");
                   
                   
                   voyage p=new voyage(id_voyage,nom_voyage,date_voyage,prenom_chaufeur,permi_conduire);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }    
        
        
    //========================================= 11.5 search voyage =======================================================
        public List<voyage> search_voyage(String txt){
            List<voyage> found_trajet=new ArrayList<>();
            String select="SELECT * FROM  voyage WHERE nom_voyage LIKE ? ";
            try{
               pstmt=con.prepareStatement(select);
               pstmt.setString(1, "%"+txt+"%");
               
               rs=pstmt.executeQuery();
               while(rs.next()){
                   int id_voyage=rs.getInt("id_voyage");
                   String nom_voyage=rs.getString("nom_voyage");
                   String date_voyage=rs.getString("date_voyage");
                   int idvehicule=rs.getInt("idvehicule");
                   int id_chaufeur =rs.getInt("id_chaufeur");
                   int id_trajet  =rs.getInt("id_trajet");
                   
                   
                   voyage p=new voyage(id_voyage,nom_voyage,date_voyage,idvehicule,id_chaufeur ,id_trajet);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }
        
    //=========================================== 11.6 count voyage =======================================================
        public int count_voyage(){
            String p="SELECT count(*) FROM voyage";
            try{
              stmt=con.createStatement();
              rs=stmt.executeQuery(p);
              
              if(rs.next()){
                  return rs.getInt(1);
              }
            }catch(SQLException pp){
                System.err.println(pp.getMessage());
            }
            return 0;
        }  
    //================== 1.7 select voyage from reservation =====================================
        public  List<voyage> select_voyage_reservation(){
            List<voyage> found=new ArrayList<>();
            String sql="SELECT id_voyage,nom_voyage,chaufeur.nom_chaufeur from voyage inner join chaufeur on chaufeur.id_chaufeur=voyage.id_chaufeur ";
            try{
                stmt=con.createStatement();
                rs=stmt.executeQuery(sql);
                
                while(rs.next()){
                    int id_voyage=rs.getInt("id_voyage");
                    String nom_voyage=rs.getString("nom_voyage");
                    String nom_chaufeur=rs.getString("nom_chaufeur");
                    
                    voyage ppp=new voyage(id_voyage,nom_voyage,nom_chaufeur);
                    found.add(ppp);
                }
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            return found;
        }
        
    //================== 1.8 select_search voyage from reservation ====================================================
        public List<voyage> select_seacrch_voyage_reservation(String txt){
            List<voyage>found= new ArrayList<>();
            String sql="SELECT id_voyage,nom_voyage,chaufeur.nom_chaufeur from voyage inner join chaufeur on chaufeur.id_chaufeur=voyage.id_chaufeur WHERE nom_voyage LIKE ?";
            try{
                pstmt=con.prepareStatement(sql);
                pstmt.setString(1, "%"+txt+"%");
                
                rs=pstmt.executeQuery();
                while(rs.next()){
                    int id_voyage=rs.getInt("id_voyage");
                    String nom_voyage=rs.getString("nom_voyage");
                    String nom_chaufeur=rs.getString("nom_chaufeur");
                    
                    voyage ppp=new voyage(id_voyage,nom_voyage,nom_chaufeur);
                    found.add(ppp);
                }
            
            }catch(SQLException r){
                System.err.println(r.getMessage());
            }
            return found;
        }

    //================== 1.9 select_search voyage  voyage from chaufeur ====================================================
        public List<voyage> select_seacrch_voyage_voyage(String txt){
            List<voyage>found= new ArrayList<>();
            String sql="SELECT voyage.id_voyage,voyage.nom_voyage,voyage.date_voyage,chaufeur.prenom_chaufeur,chaufeur.permi_conduire FROM voyage INNER JOIN chaufeur ON chaufeur.id_chaufeur=voyage.id_chaufeur WHERE nom_voyage LIKE ?";
            try{
                pstmt=con.prepareStatement(sql);
                pstmt.setString(1, "%"+txt+"%");
                
                rs=pstmt.executeQuery();
               while(rs.next()){
                   int id_voyage=rs.getInt("id_voyage");
                   String nom_voyage=rs.getString("nom_voyage");
                   String date_voyage=rs.getString("date_voyage");
                   String prenom_chaufeur=rs.getString("prenom_chaufeur");
                   String permi_conduire=rs.getString("permi_conduire");
                   
                   
                   voyage p=new voyage(id_voyage,nom_voyage,date_voyage,prenom_chaufeur,permi_conduire);
                   found.add(p);
               }
            
            }catch(SQLException r){
                System.err.println(r.getMessage());
            }
            return found;
        }
    
        
    //========================================== 11.10 select voyage _chaufeur ============================================
        public List<voyage> select_few_voyage_chaufeur(){
            List<voyage> found_trajet=new ArrayList<>();
            String select="SELECT voyage.id_voyage,voyage.nom_voyage,voyage.date_voyage,chaufeur.prenom_chaufeur,chaufeur.permi_conduire FROM voyage INNER JOIN chaufeur ON chaufeur.id_chaufeur=voyage.id_chaufeur";
            try{
               stmt=con.createStatement();
               rs=stmt.executeQuery(select);
               
               while(rs.next()){
                   int id_voyage=rs.getInt("id_voyage");
                   String nom_voyage=rs.getString("nom_voyage");
                   String date_voyage=rs.getString("date_voyage");
                   String prenom_chaufeur=rs.getString("prenom_chaufeur");
                   String permi_conduire=rs.getString("permi_conduire");
                   
                   
                   voyage p=new voyage(id_voyage,nom_voyage,date_voyage,prenom_chaufeur,permi_conduire);
                   found_trajet.add(p);
               }
            }catch(SQLException q){
                System.err.println(q.getMessage());
            }
            
            return found_trajet;
        }       
    //--------------------------------------------------------------------------------------------------------------------
    //####################################################################################################################
    //========================================= Login function ===========================================================
      public int login(utilisateur p){
          String log="SELECT utilisateur.email_user,utilisateur.motdepasse FROM utilisateur WHERE email_user=? AND motdepasse=?";
          String adm="SELECT utilisateur.email_user,utilisateur.motdepasse,nom_role FROM utilisateur INNER JOIN (role INNER JOIN  exercer) ON utilisateur.matricule=exercer.matricule AND role.id_role=exercer.id_role WHERE email_user=? AND motdepasse=? AND role.nom_role='DG'";
          try{
              pstmt=con.prepareStatement(log);
              pstmt.setString(1, p.getEmail_user());
              pstmt.setString(2, p.getMotdepasse());
              
              rs=pstmt.executeQuery();
              if(rs.next()){
                    pstmt=con.prepareStatement(adm);
                    pstmt.setString(1, p.getEmail_user());
                    pstmt.setString(2, p.getMotdepasse());

                   ResultSet admin=pstmt.executeQuery();
                   
                   if(admin.next()){
                       return 2;
                   }else{
                       return 1;
                   }
              }
          }catch(SQLException qr){
              System.err.println(qr.getMessage());
          }
          return 0;
      }
}
                    