package toru.list;

public class ToruLInkedList {

    private Node head;

    public ToruLInkedList() {
        head = new Node(null);
    }

    public void printList()
    {
        Node n = head;
        while (n != null)
        {
            System.out.print(n.data+" ");
            n = n.nextNode;
        }
    }

    private static class Node{
        private Object data;
        private Node nextNode;

        Node(Object data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    public void deleteNode(Object key){
        Node temp = head;
        Node previous = null;

        if(temp != null && temp.data == key){
            head = temp.nextNode;
            return;
        }

        while(temp != null && temp.data != key){
            previous = temp;
            temp = temp.nextNode;
        }

        if(temp == null) return;
        previous.nextNode = temp.nextNode;
    }

    public void insertNode(Object key){
        Node newNode = new Node(key);
        newNode.nextNode = head;
        head = newNode;
    }

    /* Adding node after given node */
    public void insertNode(Node prev, Object key){
        if(prev == null) return;

        Node newNode = new Node(key);
        newNode.nextNode = prev.nextNode;
        prev.nextNode = newNode;
    }

    /* Adding node at the end of given list */
    public void append(Object newData){
        Node newNode = new Node(newData);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.nextNode = null;
        Node last = head;
        while(last.nextNode != null){
            last = last.nextNode;
        }

        last.nextNode = newNode;
    }

    public static void main(String[] args){

        ToruLInkedList list = new ToruLInkedList();
        list.head = new Node("6");

//        Node second = new Node("2");
//        Node third = new Node("3");
//        Node fourth = new Node("4");

//        list.head.nextNode = second;
//        second.nextNode = third;
//        third.nextNode = fourth;

        list.append("5");
        list.append("4");
        list.append("3");
        list.append("2");
        list.append("1");
        list.append("0");

        list.printList();

        list.deleteNode("2");
        list.printList();
    }
}