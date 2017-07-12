public class Node {

    private Object data;
    private Node next;
    private Node previous;              // previous link in list

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }

}
