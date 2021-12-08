package fr.ul.cardservice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private int niveau = 0;     // 1 to 5 level
    private String nom = "";
    private String type = "";

    public Card() {

    }

    public Card(int niveau, String nom, String type) {
        this.niveau = niveau;
        this.nom = nom;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return niveau == card.niveau && Objects.equals(id, card.id) && Objects.equals(nom, card.nom) && Objects.equals(type, card.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, niveau, nom, type);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", niveau=" + niveau +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
