import java.io.*;

public class Listado {
    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("C:\\Users\\joseg\\Desktop\\Carpeta Compartida W10\\D.A.M\\2º\\Goyo\\Programacion multimedia y dispositivos moviles\\Practica1-1\\src\\ListadoDeNombres.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null)
                System.out.println(linea);

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
