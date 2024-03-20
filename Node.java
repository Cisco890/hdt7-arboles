/** Juan Francisco Martínez 23617
 * Crea nodos para el árbol binario
 *
 * @param <k>  claves almacenadas en el árbol.
 * @param <t>  valores asociados a las claves.
 */
class Node<k,t> {
    k key;
    t value;
    Node<k,t> left;
    Node <k,t> right;
     public Node(k key, t value) {
         this.key = key;
         this.value = value;
         this.left = null;
         this.right = null;
     }
}