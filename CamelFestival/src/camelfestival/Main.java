package camelfestival;

/**
 * Main - runs the whole program in order and times each step.
 * OWNER: Part 1
 */
public class Main {

    public static void main(String[] args) {
    CamelLinkedList list = new CamelLinkedList();
list.addLast(new Camel("CM-0001A", 'A', 50.0, 2026, 3, "KSA", 0.0));
list.addLast(new Camel("CM-0002M", 'M', 60.0, 2027, 4, "TAF", 5.0));
list.addLast(new Camel("CM-0003W", 'W', 70.0, 2028, 5, "RIY", -5.0));

System.out.println("Size: " + list.size());        // 3
System.out.println(list.search("CM-0002M"));      // the CM-0002M line
System.out.println(list.search("CM-9999X"));      // null
System.out.println(list.delete("CM-0003W"));      // true  (deleting the LAST wagon)
System.out.println("Size: " + list.size());        // 2
list.addLast(new Camel("CM-0004H", 'H', 80.0, 2029, 2, "OMN", 1.0));
for (Camel c : list.toArray()) {
    System.out.println(c);                         // 0001, 0002, 0004
}
    }
}
