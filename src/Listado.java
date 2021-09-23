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

            double registroRandom = Math.floor(Math.random()*(registro-2+1)+2);

            while ((linea = br.readLine()) != null) {
                //System.out.println("Registro random: " + registroRandom);
                //System.out.println("Contador: " + count);
                count++;
                if (count == registroRandom) {
                    double nota1 = truncXDecimales((Math.random()*10),2);
                    double nota2 = truncXDecimales((Math.random()*10),2);
                    double nota3 = truncXDecimales((Math.random()*10),2);
                    double nota4 = truncXDecimales((Math.random()*10),2);
                    //Formula redondear X decimales -> Math.round(NUMERO*Math.pow(10,X)/Math.pow(10.X);
                    double notaMedia = truncXDecimales(((nota1 + nota2 + nota3 + nota4)/4),2);


                    System.out.println(linea);
                    System.out.println("Nota 1: " + nota1);
                    System.out.println("Nota 2: " + nota2);
                    System.out.println("Nota 3: " + nota3);
                    System.out.println("Nota 4: " + nota4);
                    System.out.println("Nota Media: " + notaMedia);
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

    public static double truncXDecimales(double num,int decimales) {
        return Math.round(num*Math.pow(10,decimales))/Math.pow(10,decimales);
    }
}
