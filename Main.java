/** Juan Francisco Martínez 23617
 *Main del programa, acá se llama al search y Transversal para el correcto funcionamiento, se leen los archivos txt
 *
 * @param <k>  claves almacenadas en el árbol.
 * @param <t>  valores asociados a las claves.
 * @param diccionario.txt  se definen las palabras que se deben de poder leer.
 * @param texto.txt  se definen las oraciones para ser traducidas                       
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<String, String> diccionario = new BinarySearchTree<>();
        Transversal<String, String> transversal = new Transversal<>();

        // Cargar el diccionario desde el archivo diccionario.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] partes = line.split(",");
                    String key = partes[0].trim().substring(1);
                    String value = partes[1].trim().substring(0, partes[1].length() - 2);
                    diccionario.insert(key.toLowerCase(), value.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Mostrar el diccionario en orden
        System.out.println("Diccionario ordenado:");
        transversal.InOrder(diccionario.root);
        System.out.println();

        // Traducir el archivo texto.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] palabras = line.split("\\s+");
                for (String word : palabras) {
                    String traduccion = diccionario.search(word.toLowerCase());
                    if (traduccion != null) {
                        System.out.print(traduccion + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}