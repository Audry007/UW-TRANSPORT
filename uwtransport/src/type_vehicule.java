/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class type_vehicule {
    private int id_type;
    private String nom_type;

    public type_vehicule() {
    }

    public type_vehicule(int id_type, String nom_type) {
        this.id_type = id_type;
        this.nom_type = nom_type;
    }

    public int getId_type() {
        return id_type;
    }

    public String getNom_type() {
        return nom_type;
    }

    @Override
    public String toString() {
        return "type_vehicule{" + "id_type=" + id_type + ", nom_type=" + nom_type + '}';
    }
    
}
