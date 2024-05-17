package labTwo.dataStructures.linkedList;

public class Program {
    public static void main(String... args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addToTail("Fredrick Amoako");
        linkedList.addToTail("Kweku Amoako");
        System.out.println(linkedList.search("Fredrick Amoako"));
        linkedList.delete("Fredrick Amoako");
        linkedList.printList();
    }
}
