import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public enum FilManager {

    INSTANCE;

    public ArrayList<Object> läsFrånFil(String filnamn) {
        Path p = Paths.get(filnamn);
        ArrayList<Object> lista = new ArrayList<>();
        if (Files.exists(p)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filnamn))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList<?>) {
                    lista = (ArrayList<Object>) obj;
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return lista;
    }

    public void skrivTillFil(String filnamn, ArrayList<Object> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filnamn))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
