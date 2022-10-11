/** Clase que permite leer un archivo de texto y almacenarlo en
 *  un arreglo de tipo String.
 *  Se vacía cada linea del archivo en una lista tipo ArrayList
 *  y luego la lista se coloca en el arreglo, el cual se retorna
 *  a la clase Cliente.
 */

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo
{
    public static String[] leer(String nombreArchivo) {
        /** crear la lista */
        ArrayList<String> lista = new ArrayList<String>();
        
        /** declarar el arreglo */
        String[] arreglo;
        
        try {
            /** preparar el archivo de texto para lectura */
            File f = new File(nombreArchivo);
            
            /** si el archivo existe en el directorio dado */
            if (f.exists())
            {
                /** preparar el lector y buffer de lectura */
                FileReader     fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                
                /** variable que recibe el string a leer */
                String linea = "";
                while((linea = br.readLine()) !=null)
                {
                    /** agregar a la lista la linea leida */
                    lista.add(linea);
                }
                
                /** al llegar al final del archivo, cerrarlo */
                fr.close();                
            } else
            {
                System.out.println("Archivo no Existe: " + nombreArchivo);
                return null;
            }
        } catch (Exception e) { 
            System.out.println(e);
        }
        
        /** crear el arreglo y vaciarle la lista */
        arreglo = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++)
            arreglo[i] = lista.get(i);

        return arreglo;
    }
    
    public static void escribir (String nombreArchivo, String arreglo[]) {
        BufferedWriter bw = null;
        FileWriter     fw = null; 
        
        try {
            fw = new FileWriter(nombreArchivo);
            bw = new BufferedWriter(fw);
            
            for(String s: arreglo)
                bw.write(s + "\n");
            
            bw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
