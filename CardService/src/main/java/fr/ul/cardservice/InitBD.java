package fr.ul.cardservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InitBD implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Création et intialisation de la base de données");

        String sqlStatments[] = {
                "DROP TABLE CARD IF EXISTS",
                "CREATE TABLE CARD(id serial, nom varchar(255), niveau int(8), type varchar(255))",
                "INSERT INTO CARD (nom, niveau, type) VALUES('Djessy', 1, 'WOW');",
                "INSERT INTO CARD (nom, niveau, type) VALUES('PC DE G@M3R5', 2, 'ORDINATEUR');",
                "INSERT INTO CARD (nom, niveau, type) VALUES('ZERATOR', 3, 'STREAMER');",
                "INSERT INTO CARD (nom, niveau, type) VALUES('Brigitte', 4, 'PROFESSEUR');",
        };

        for (String sql: sqlStatments) {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        }

        System.out.println("Toutes les cards : ");
        jdbcTemplate.query("SELECT * FROM CARD",
                (rs, rowNum) -> {
                    System.out.println("id : " + rs.getString("id") + "\n" +
                            "nom" + rs.getString("nom") + "\n" +
                            "niveau" + rs.getString("niveau") + "\n" +
                            "type" + rs.getString("type") + "\n");
                    return null;
                });
    }
}
