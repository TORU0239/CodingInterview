package toru.list;

public class ToruDoubleLinkedList {
    private Node header;

    private static class Node{
        private Object data;
        private Node previousNode;
        private Node nextNode;

        public Node(Object data) {
            this.data = data;
            this.previousNode = null;
            this.nextNode = null;
        }
    }

    public static void main(String[] args){
        ToruDoubleLinkedList doubleLinkedList = new ToruDoubleLinkedList();
    }
}