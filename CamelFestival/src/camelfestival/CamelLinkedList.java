package camelfestival;

/**
 * CamelLinkedList - our own singly linked list with head AND tail.
 * OWNER: Part 1
 * Rule: no ArrayList / LinkedList / any built-in collection.
 */
public class CamelLinkedList {

    // TODO (Part 1): Node class, head, tail, size counter

    // Adds a camel at the END of the list. Must be O(1) (use the tail).
    public void addLast(Camel c) {
        // TODO
    }

    // Number of camels in the list. Must be O(1) (keep a counter).
    public int size() {
        return 0; // TODO
    }

    // Returns the camel with this ID, or null if it is not in the list.
    public Camel search(String camelId) {
        return null; // TODO
    }

    // Removes the camel with this ID. true = removed, false = not found.
    public boolean delete(String camelId) {
        return false; // TODO
    }

    // Returns a NEW array holding the same Camel objects, in list order.
    // Called once per sort, so each sort gets its own array.
    public Camel[] toArray() {
        return new Camel[0]; // TODO
    }
}
