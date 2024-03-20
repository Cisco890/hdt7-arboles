/** Juan Francisco Martínez 23617
 *Manera de ordenamiento In Order
 *
 * @param <k>  claves almacenadas en el árbol.
 * @param <t>  valores asociados a las claves.
 */
 public class Transversal<k, t> {
    // Método de recorrido in order
    public void InOrder (Node<k, t> current) {
        if (current == null) {
            return;
        }

        if (current.left != null) {
            InOrder(current.left);
        }

        System.out.print(current.value );

        if (current.right != null) {
            InOrder(current.right);
        }
    }
}