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
    private int date_emission;
    private int id_client;
    private int id_reservation;

    public ticket() {
    }

    public ticket(int id_ticket, String numero_ticket, int date_emission, int id_client, int id_reservation) {
        this.id_ticket = id_ticket;
        this.numero_ticket = numero_ticket;
        this.date_emission = date_emission;
        this.id_client = id_client;
        this.id_reservation = id_reservation;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public String getNumero_ticket() {
        return numero_ticket;
    }

    public int getDate_emission() {
        return date_emission;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    @Override
    public String toString() {
        return "ticket{" + "id_ticket=" + id_ticket + ", numero_ticket=" + numero_ticket + ", date_emission=" + date_emission + ", id_client=" + id_client + ", id_reservation=" + id_reservation + '}';
    }
    
            
}
