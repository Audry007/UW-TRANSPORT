/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class ticket {
    private int id_ticket;
    private String numero_ticket;
    private String date_emission;
    private String nom_client;
    private String prenom_client;
    private String email_client; 
    private int id_reservation;

    public ticket() {
    }

    public ticket(int id_ticket, String numero_ticket, String date_emission,int id_reservation) {
        this.id_ticket = id_ticket;
        this.numero_ticket = numero_ticket;
        this.date_emission = date_emission;
        this.id_reservation = id_reservation;
    }

    public ticket(String numero_ticket, String date_emission, int id_reservation) {
        this.numero_ticket = numero_ticket;
        this.date_emission = date_emission;
        this.id_reservation = id_reservation;
    }

    public ticket(String numero_ticket, String nom_client, String prenom_client, String email_client, int id_reservation) {
        this.numero_ticket = numero_ticket;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.email_client = email_client;
        this.id_reservation = id_reservation;
    }

    public ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public ticket(String date_emission,String numero_ticket, String nom_client, String prenom_client, String email_client, int id_reservation) {
        this.date_emission = date_emission;
        this.numero_ticket = numero_ticket;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.email_client = email_client;
        this.id_reservation = id_reservation;
    }

    
    
    public int getId_ticket() {
        return id_ticket;
    }

    public String getNumero_ticket() {
        return numero_ticket;
    }

    public String getDate_emission() {
        return date_emission;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public String getNom_client() {
        return nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public String getEmail_client() {
        return email_client;
    }
    
    

    @Override
    public String toString() {
        return "ticket{" + "id_ticket=" + id_ticket + ", numero_ticket=" + numero_ticket + ", date_emission=" + date_emission + ", id_reservation=" + id_reservation + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + ", email_client=" + email_client + '}';
    }

    
            
}
