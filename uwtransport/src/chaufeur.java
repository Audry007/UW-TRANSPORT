/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class chaufeur {
    private int id_chaufeur;
    private String nom_chaufeur;
    private String prenonm_chaufeur;
    private String email_chaufeur;
    private String telephone_chaufeur;
    private String permi_conduire;
    private int idvehicule;

    public chaufeur() {
    }

    public chaufeur(int id_chaufeur) {
        this.id_chaufeur = id_chaufeur;
    }
    
    public chaufeur(int id_chaufeur, String nom_chaufeur, String prenonm_chaufeur, String email_chaufeur, String telephone_chaufeur, String permi_conduire, int idvehicule) {
        this.id_chaufeur = id_chaufeur;
        this.nom_chaufeur = nom_chaufeur;
        this.prenonm_chaufeur = prenonm_chaufeur;
        this.email_chaufeur = email_chaufeur;
        this.telephone_chaufeur = telephone_chaufeur;
        this.permi_conduire = permi_conduire;
        this.idvehicule = idvehicule;
    }

    public chaufeur(String nom_chaufeur, String prenonm_chaufeur, String email_chaufeur, String telephone_chaufeur, String permi_conduire, int idvehicule) {
        this.nom_chaufeur = nom_chaufeur;
        this.prenonm_chaufeur = prenonm_chaufeur;
        this.email_chaufeur = email_chaufeur;
        this.telephone_chaufeur = telephone_chaufeur;
        this.permi_conduire = permi_conduire;
        this.idvehicule = idvehicule;
    }

    public chaufeur(int id_chaufeur, String nom_chaufeur, String prenonm_chaufeur, String email_chaufeur, String telephone_chaufeur, String permi_conduire) {
        this.id_chaufeur = id_chaufeur;
        this.nom_chaufeur = nom_chaufeur;
        this.prenonm_chaufeur = prenonm_chaufeur;
        this.email_chaufeur = email_chaufeur;
        this.telephone_chaufeur = telephone_chaufeur;
        this.permi_conduire = permi_conduire;
    }

    public chaufeur(int id_chaufeur, String nom_chaufeur, String prenonm_chaufeur, String telephone_chaufeur, String permi_conduire) {
        this.id_chaufeur = id_chaufeur;
        this.nom_chaufeur = nom_chaufeur;
        this.prenonm_chaufeur = prenonm_chaufeur;
        this.telephone_chaufeur = telephone_chaufeur;
        this.permi_conduire = permi_conduire;
    }

    public chaufeur(String nom_chaufeur, String prenonm_chaufeur, String telephone_chaufeur, String permi_conduire) {
        this.nom_chaufeur = nom_chaufeur;
        this.prenonm_chaufeur = prenonm_chaufeur;
        this.telephone_chaufeur = telephone_chaufeur;
        this.permi_conduire = permi_conduire;
    }

    public chaufeur(String nom_chaufeur, String prenonm_chaufeur, String email_chaufeur, String telephone_chaufeur, String permi_conduire) {
        this.nom_chaufeur = nom_chaufeur;
        this.prenonm_chaufeur = prenonm_chaufeur;
        this.email_chaufeur = email_chaufeur;
        this.telephone_chaufeur = telephone_chaufeur;
        this.permi_conduire = permi_conduire;
    }
    
    
    
    
    public int getId_chaufeur() {
        return id_chaufeur;
    }

    public String getNom_chaufeur() {
        return nom_chaufeur;
    }

    public String getPrenonm_chaufeur() {
        return prenonm_chaufeur;
    }

    public String getEmail_chaufeur() {
        return email_chaufeur;
    }

    public String getTelephone_chaufeur() {
        return telephone_chaufeur;
    }

    public String getPermi_conduire() {
        return permi_conduire;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    @Override
    public String toString() {
        return "chaufeur{" + "id_chaufeur=" + id_chaufeur + ", nom_chaufeur=" + nom_chaufeur + ", prenonm_chaufeur=" + prenonm_chaufeur + ", email_chaufeur=" + email_chaufeur + ", telephone_chaufeur=" + telephone_chaufeur + ", permi_conduire=" + permi_conduire + ", idvehicule=" + idvehicule + '}';
    }
    
    
}
