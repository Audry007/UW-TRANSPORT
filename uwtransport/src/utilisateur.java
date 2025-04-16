/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author audry
 */
public class utilisateur {
    
private String matricule;
    private String nom_user;
    private String prenom_user;
    private String email_user;
    private String telephone_user;
    private String username;
    private String motdepasse;

    public utilisateur() {
    }
    
    public utilisateur(String matricule, String nom_user, String prenom_user, String email_user, String telephone_user, String username, String motdepasse) {
        this.matricule = matricule;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.email_user = email_user;
        this.telephone_user = telephone_user;
        this.username = username;
        this.motdepasse = motdepasse;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom_user() {
        return nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public String getTelephone_user() {
        return telephone_user;
    }

    public String getUsername() {
        return username;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    @Override
    public String toString() {
        return "utilisateur{" + "matricule=" + matricule + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", email_user=" + email_user + ", telephone_user=" + telephone_user + ", username=" + username + ", motdepasse=" + motdepasse + '}';
    }
    
}
