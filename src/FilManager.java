import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public enum FilManager {

    INSTANCE;

    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> läsFrånFil(String filnamn) {
        Path p = Paths.get(filnamn);
        ArrayList<T> lista = new ArrayList<>();
        if (Files.exists(p)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filnamn))) {
                Object obj = ois.readObject();
                if (obj instanceof ArrayList<?>) {
                    lista = (ArrayList<T>) obj;
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return lista;
    }

    public <T> void skrivTillFil(String filnamn, ArrayList<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filnamn))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
