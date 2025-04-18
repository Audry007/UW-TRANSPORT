/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class reservation {
    private int id_reservation;
    private int date_reservation;
    private String nom_place;
    private int id_voyage;
    private int id_client;
    private String matricule;

    public reservation() {
    }

    public reservation(int id_reservation, int date_reservation, String nom_place, int id_voyage, int id_client, String matricule) {
        this.id_reservation = id_reservation;
        this.date_reservation = date_reservation;
        this.nom_place = nom_place;
        this.id_voyage = id_voyage;
        this.id_client = id_client;
        this.matricule = matricule;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public int getDate_reservation() {
        return date_reservation;
    }

    public String getNom_place() {
        return nom_place;
    }

    public int getId_voyage() {
        return id_voyage;
    }

    public int getId_client() {
        return id_client;
    }

    public String getMatricule() {
        return matricule;
    }

    @Override
    public String toString() {
        return "reservation{" + "id_reservation=" + id_reservation + ", date_reservation=" + date_reservation + ", nom_place=" + nom_place + ", id_voyage=" + id_voyage + ", id_client=" + id_client + ", matricule=" + matricule + '}';
    }
    
}
