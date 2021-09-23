import java.io.*;
import java.util.Scanner;

public class Listado {
    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("C:\\Users\\joseg\\Desktop\\Carpeta Compartida W10\\D.A.M\\2º\\Goyo\\Programacion multimedia y dispositivos moviles\\Practica1-1\\src\\ListadoDeNombres.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            Scanner s = null;

            String linea;
            double registro = 0;
            int count = 0;

            s = new Scanner(archivo);
            while (s.hasNextLine()) {
                linea = s.nextLine();
                registro++;
            }

            double registroRandom = Math.floor(Math.random()*(registro-2+2)+2);

            while ((linea = br.readLine()) != null) {
                //System.out.println("Registro random: " + registroRandom);
                //System.out.println("Contador: " + count);
                count++;
                if (count == registroRandom) {
                    System.out.println(linea);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
