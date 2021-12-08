package fr.ul.cardservice.model.dto;

import org.springframework.stereotype.Component;

@Component
public class CreateCardDTO {

    private int niveau = 0;     // 1 to 5 level
    private String nom = "";
    private String type = "";

    public CreateCardDTO() {

    }
    public CreateCardDTO(int niveau, String nom, String type) {
        this.niveau = niveau;
        this.nom = nom;
        this.type = type;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
