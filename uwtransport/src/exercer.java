/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class exercer {
    private int id_exercer;
    private String matricule;
    private int id_role;
    private String date_debut;
    private String nom_role;
    private String email_user;

    public exercer() {
    }

    public exercer(int id_exercer, String matricule, int id_role, String date_debut, String nom_role, String email_user) {
        this.id_exercer = id_exercer;
        this.matricule = matricule;
        this.id_role = id_role;
        this.date_debut = date_debut;
        this.nom_role = nom_role;
        this.email_user = email_user;
    }
    
    public exercer(int id_exercer, String matricule, int id_role ,String date_debut) {
        this.id_exercer = id_exercer;
        this.matricule = matricule;
        this.id_role = id_role;
        this.date_debut=date_debut;    
    }

    public exercer(String matricule, int id_role, String date_debut) {
        this.matricule = matricule;
        this.id_role = id_role;
        this.date_debut=date_debut;
    }
    

    public int getId_exercer() {
        return id_exercer;
    }

    public String getMatricule() {
        return matricule;
    }

    public int getId_role() {
        return id_role;
    }
    public String getDate_debut(){
        return date_debut;
    }

    public String getNom_role() {
        return nom_role;
    }

    public String getEmail_user() {
        return email_user;
    }
     
    
    
    @Override
    public String toString() {
        return "exercer{" + "id_exercer=" + id_exercer + ", matricule=" + matricule + ", id_role=" + id_role + ", date_debut=" + date_debut + ", nom_role=" + nom_role + ", email_user=" + email_user + '}';
    }


}
