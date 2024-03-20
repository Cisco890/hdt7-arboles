/** Juan Francisco Martínez 23617
 *Busca palabras y las inserta en el árbol
 *
 * @param <k>  claves almacenadas en el árbol.
 * @param <t>  valores asociados a las claves.
 */
public class BinarySearchTree<k extends Comparable<k>, t> { //k es comparable para poder ordenar el árbol basado en esta
    Node<k, t> root;

    public void insert(k key, t value) {
        if (root == null) {
            root = new Node<>(key, value);
            return;
        }

        insertNode(root, key, value);
    }

    private void insertNode(Node<k, t> current, k key, t value) {
        int compare = key.compareTo(current.key);

        if (compare == 0) {
            throw new IllegalArgumentException("Palabra que ya existe: " + key);// se verifica si ya existe la palabra
        }

        if (compare < 0) {//lógica de insertar como se vio en clase
            if (current.left != null) {
                insertNode(current.left, key, value);
            } else {
                current.left = new Node<>(key, value);
            }
        } else {
            if (current.right != null) {
                insertNode(current.right, key, value);
            } else {
                current.right = new Node<>(key, value);
            }
        }
    }

    public t search(k key) {//lógica de búsqueda como se vio en clase
        return searchNode(root, key);
    }

    private t searchNode(Node<k, t> current, k key) {
        if (current == null) {
            return null;
        }

        int compare = key.compareTo(current.key);

        if (compare == 0) {
            return current.value;
        }

        if (compare < 0) {
            return searchNode(current.left, key);
        } else {
            return searchNode(current.right, key);
        }
    }
}
