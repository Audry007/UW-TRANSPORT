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
    private int date_voyage;
    private int idvehicule;
    private int id_chaufeur;
    private int id_trajet;

    public voyage() {
    }

    public voyage(int id_voyage, int date_voyage, int idvehicule, int id_chaufeur, int id_trajet) {
        this.id_voyage = id_voyage;
        this.date_voyage = date_voyage;
        this.idvehicule = idvehicule;
        this.id_chaufeur = id_chaufeur;
        this.id_trajet = id_trajet;
    }

    public int getId_voyage() {
        return id_voyage;
    }

    public int getDate_voyage() {
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

    @Override
    public String toString() {
        return "voyage{" + "id_voyage=" + id_voyage + ", date_voyage=" + date_voyage + ", idvehicule=" + idvehicule + ", id_chaufeur=" + id_chaufeur + ", id_trajet=" + id_trajet + '}';
    }
    
}
