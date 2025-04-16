/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class trajectoire {
    
    private int id_trajet;
    private String ville_depart;
    private String ville_arrive;
    private int heure_depart;
    private int prix_trajet;
    private int duree_estime;

    public trajectoire() {
    }

    public trajectoire(int id_trajet, String ville_depart, String ville_arrive, int heure_depart, int prix_trajet, int duree_estime) {
        this.id_trajet = id_trajet;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
        this.heure_depart = heure_depart;
        this.prix_trajet = prix_trajet;
        this.duree_estime = duree_estime;
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public String getVille_arrive() {
        return ville_arrive;
    }

    public int getHeure_depart() {
        return heure_depart;
    }

    public int getPrix_trajet() {
        return prix_trajet;
    }

    public int getDuree_estime() {
        return duree_estime;
    }

    @Override
    public String toString() {
        return "trajectoire{" + "id_trajet=" + id_trajet + ", ville_depart=" + ville_depart + ", ville_arrive=" + ville_arrive + ", heure_depart=" + heure_depart + ", prix_trajet=" + prix_trajet + ", duree_estime=" + duree_estime + '}';
    }
    
    
}
