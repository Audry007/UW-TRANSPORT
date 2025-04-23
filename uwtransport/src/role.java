/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class role {
   private int id_role;
   private String nom_role;

    public role() {
    }

    public role(int id_role, String nom_role) {
        this.id_role = id_role;
        this.nom_role = nom_role;
    }

    public role(String nom_role) {
        this.nom_role = nom_role;
    }
    
    
    
    public int getId_role() {
        return id_role;
    }

    public String getNom_role() {
        return nom_role;
    }

    @Override
    public String toString() {
        return "role{" + "id_role=" + id_role + ", nom_role=" + nom_role + '}';
    }
   
}
