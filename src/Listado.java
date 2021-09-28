import java.io.*;
import java.util.Scanner;

public class Listado {
    public static void main(String[] args) {
        File archivoEntrada = null;
        File archivoSalida = null;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            //CARGA DE ARCHIVO DE ENTRADA
            archivoEntrada = new File("C:\\Users\\joseg\\Desktop\\Carpeta Compartida W10\\D.A.M\\2º\\Goyo\\Programacion multimedia y dispositivos moviles\\Practica1-1\\src\\ListadoDeNombres.csv");
            fr = new FileReader(archivoEntrada);
            br = new BufferedReader(fr);
            Scanner s = null;

            //CARGA DE ARCHIVO DE SALIDA
            archivoSalida = new File("C:\\Users\\joseg\\Desktop\\Carpeta Compartida W10\\D.A.M\\2º\\Goyo\\Programacion multimedia y dispositivos moviles\\Practica1-1\\src\\Notas.txt");
            fw = new FileWriter(archivoSalida);
            pw = new PrintWriter(archivoSalida);


            //ARRAYS DE NOMBRES
            String[] names;

            //VARIABLES GLOBALES
            String linea;
            int registro = 0;
            int count = 0;
            int personas = 10;

            //ADIVINAR REGISTROS EN EL ARCHIVO
            s = new Scanner(archivoEntrada);
            while (s.hasNextLine()) {
                s.nextLine();
                registro++;
            }
            //INICIALIZAR EL ARRAYS CON LOS REGISTROS CALCULADOS ANTERIORMENTE
            names = new String[registro];
            System.out.println(names.length);

            //INTRODUCIR EN EL ARRAYS LOS DATOS DEL ARCHIVO
            while ((linea = br.readLine()) != null) {
                if (count < registro) {
                    names[count] = linea;
                    count++;
                }
            }

            //MOSTRAR 10 PERSONAS ALEATORIAS Y 4 NOTAS ALEATORIAS
            for (int i = 0; i < personas; i++) {
                //ELEGIR UNA POSICION ALEATORIA DEL ARRAY
                int posRandom = (int) Math.floor(Math.random()*((registro-1)-1+1)+1);

                //CALCULAR NOTAS RANDOM -> Formula redondear X decimales -> Math.round(NUMERO*Math.pow(10,X)/Math.pow(10.X);
                double nota1 = truncXDecimales((Math.random()*10),2);
                double nota2 = truncXDecimales((Math.random()*10),2);
                double nota3 = truncXDecimales((Math.random()*10),2);
                double nota4 = truncXDecimales((Math.random()*10),2);
                double notaMedia = truncXDecimales(((nota1 + nota2 + nota3 + nota4)/4),2);
                //GUARDAR TODA LA INFORMACIÓN EN EL ARCHIVO
                pw.println(names[posRandom] + "\t Nota 1: " + nota1 + " Nota 2: " + nota2 + " Nota 3: " + nota3 + " Nota 4: " + nota4 + " Nota Media: " + notaMedia);

            }
        } catch (Exception e) {
            //MOSTRAR ERROR
            e.printStackTrace();
        } finally {
            //CIERRE
            try {
                if (null != br) {
                    br.close();
                }
                if (null != fr) {
                    fr.close();
                    pw.close();
                }
            } catch (Exception e2) {
                //MOSTRAR ERROR
                e2.printStackTrace();
            }
        }
    }

    //FUNCION PARA TRUNCAR SEGUN LOS DECIMALES QUE LE PASEMOS
    public static double truncXDecimales(double num,int decimales) {
        return Math.round(num*Math.pow(10,decimales))/Math.pow(10,decimales);
    }
}
