import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Filhanterare {

    public void skrivTillFil(List<Object> objektLista, String filnamn) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filnamn))) {
            for (Object objekt : objektLista) {
                oos.writeObject(objekt);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void läsFrånFil(List<Object> objektLista, String filnamn) {
        Path p = Paths.get(filnamn);
        if (Files.exists(p)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filnamn))) {
                Object obj;
                while ((obj = ois.readObject()) != null) {
                    if (obj instanceof Bokning) {
                        Bokning b = (Bokning) obj;
                        objektLista.add(b);
                    } else if (obj instanceof Recension) {
                        Recension r = (Recension) obj;
                        objektLista.add(r);
                    }
                }
            } catch (EOFException e) {
                //slut på inläsning
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
