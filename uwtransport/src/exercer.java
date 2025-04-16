/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class exercer {
    private int id_exercer;
    private String matricule;
    private int id_role;

    public exercer() {
    }

    public exercer(int id_exercer, String matricule, int id_role) {
        this.id_exercer = id_exercer;
        this.matricule = matricule;
        this.id_role = id_role;
    }

    public int getId_exercer() {
        return id_exercer;
    }

    public String getMatricule() {
        return matricule;
    }

    public int getId_role() {
        return id_role;
    }

    @Override
    public String toString() {
        return "exercer{" + "id_exercer=" + id_exercer + ", matricule=" + matricule + ", id_role=" + id_role + '}';
    }
    
}
