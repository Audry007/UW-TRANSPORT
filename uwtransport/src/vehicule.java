/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class vehicule {
    private int idvehicule;
    private String num_matricule;
    private String marque;
    private String capacite;
    private String color;
    private String status;
    private int id_type;

    public vehicule(){
        
    }

    public vehicule(int idvehicule, String num_matricule, String marque, String capacite, String color, String status, int id_type) {
        this.idvehicule = idvehicule;
        this.num_matricule = num_matricule;
        this.marque = marque;
        this.capacite = capacite;
        this.color = color;
        this.status = status;
        this.id_type = id_type;
    }
    
    
    
    public int getIdvehicule() {
        return idvehicule;
    }

    public String getNum_matricule() {
        return num_matricule;
    }

    public String getMarque() {
        return marque;
    }

    public String getCapacite() {
        return capacite;
    }

    public String getColor() {
        return color;
    }

    public String getStatus() {
        return status;
    }

    public int getId_type() {
        return id_type;
    }

    @Override
    public String toString() {
        return "vehicule{" + "idvehicule=" + idvehicule + ", num_matricule=" + num_matricule + ", marque=" + marque + ", capacite=" + capacite + ", color=" + color + ", status=" + status + ", id_type=" + id_type + '}';
    }


}
