import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pruebas {

    @Test
    public void testTranslation() {
        BinarySearchTree<String, String> dictionary = new BinarySearchTree<>();
        Transversal<String, String> transversal = new Transversal<>();

        // Agregar las palabras al diccionario
        dictionary.insert("house", "casa");
        dictionary.insert("dog", "perro");
        dictionary.insert("homework", "tarea");
        dictionary.insert("woman", "mujer");
        dictionary.insert("town", "pueblo");
        dictionary.insert("yes", "si");
       

        // Verificar la traducción de palabras conocidas
        assertEquals("casa", dictionary.search("house"));
        assertEquals("perro", dictionary.search("dog"));
        assertEquals("tarea", dictionary.search("homework"));
        assertEquals("mujer", dictionary.search("woman"));
        assertEquals("pueblo", dictionary.search("town"));
        assertEquals("si", dictionary.search("yes"));
    

        // Verificar la traducción de palabras desconocidas
        assertEquals(null, dictionary.search("car"));
        assertEquals(null, dictionary.search("book"));
        assertEquals(null, dictionary.search("computer"));
    }
}
