/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class voyage {
    private int id_voyage;
    private String nom_voyage;
    private String date_voyage;
    private int idvehicule;
    private int id_chaufeur;
    private int id_trajet;
    private String nom_chaufeur;
    private String prenom_chaufeur;
    private String permi_conduire;

    public voyage() {
    }

    public voyage(int id_voyage, String nom_voyage, String date_voyage, int idvehicule, int id_chaufeur, int id_trajet) {
        this.id_voyage = id_voyage;
        this.nom_voyage = nom_voyage;
        this.date_voyage = date_voyage;
        this.idvehicule = idvehicule;
        this.id_chaufeur = id_chaufeur;
        this.id_trajet = id_trajet;
    }

    public voyage(String nom_voyage, String date_voyage, int idvehicule, int id_chaufeur, int id_trajet) {
        this.nom_voyage = nom_voyage;
        this.date_voyage = date_voyage;
        this.idvehicule = idvehicule;
        this.id_chaufeur = id_chaufeur;
        this.id_trajet = id_trajet;
    }

    public voyage(int id_voyage, String nom_voyage, String date_voyage, String prenom_chaufeur, String permi_conduire) {
        this.id_voyage = id_voyage;
        this.nom_voyage = nom_voyage;
        this.date_voyage = date_voyage;
        this.prenom_chaufeur = prenom_chaufeur;
        this.permi_conduire = permi_conduire;
    }

    
    
    public voyage(int id_voyage, String nom_voyage, String date_voyage, String nom_chaufeur, String prenom_chaufeur, String permi_conduire) {
        this.id_voyage = id_voyage;
        this.nom_voyage = nom_voyage;
        this.date_voyage = date_voyage;
        this.nom_chaufeur = nom_chaufeur;
        this.prenom_chaufeur = prenom_chaufeur;
        this.permi_conduire = permi_conduire;
    }

    public voyage(int id_voyage, String nom_voyage, String nom_chaufeur) {
        this.id_voyage = id_voyage;
        this.nom_voyage = nom_voyage;
        this.nom_chaufeur = nom_chaufeur;
    }
    
    
    
    public int getId_voyage() {
        return id_voyage;
    }

    public String getDate_voyage() {
        return date_voyage;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public int getId_chaufeur() {
        return id_chaufeur;
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public String getNom_voyage() {
        return nom_voyage;
    }

    public String getNom_chaufeur() {
        return nom_chaufeur;
    }

    public String getPrenom_chaufeur() {
        return prenom_chaufeur;
    }

    public String getPermi_conduire() {
        return permi_conduire;
    }
    
    @Override
    public String toString() {
        return "voyage{" + "id_voyage=" + id_voyage + ", nom_voyage=" + nom_voyage + ", date_voyage=" + date_voyage + ", idvehicule=" + idvehicule + ", id_chaufeur=" + id_chaufeur + ", id_trajet=" + id_trajet + ", nom_chaufeur=" + nom_chaufeur + ", prenom_chaufeur=" + prenom_chaufeur + ", permi_conduire=" + permi_conduire + '}';
    }


    
    
}
