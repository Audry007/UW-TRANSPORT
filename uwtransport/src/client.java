/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class client {
    private int id_client;
    private String nom_client;
    private String prenom_client;
    private String telephone_client;
    private String email;

    public client() {
    }

    public client(int id_client, String nom_client, String prenom_client, String telephone_client, String email) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone_client = telephone_client;
        this.email = email;
    }

    public client(String nom_client, String prenom_client, String telephone_client, String email) {
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.telephone_client = telephone_client;
        this.email = email;
    }

    public client(int id_client, String nom_client, String email) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.email = email;
    }

    public client(int id_client) {
        this.id_client = id_client;
    }

    
    
    public int getId_client() {
        return id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public String getTelephone_client() {
        return telephone_client;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public String toString() {
        return "client{" + "id_client=" + id_client + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + ", telephone_client=" + telephone_client + ", email=" + email + '}';
    }
    
}
