package utils;

import DTO.ContactoDTO;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeerCSV {
 public static List<ContactoDTO> loadActorsFromCsv(String path) {
        List<ContactoDTO> actores = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] row;

            // Saltar cabecera si la hay
            reader.readNext();

            while ((row = reader.readNext()) != null) {
                String nome = row[0];
                ContactoDTO actor = new ContactoDTO();
                actor.setNomeContact(nome);
                actores.add(actor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return actores;
    }
}
