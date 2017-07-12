//DLL

class DoublyLinkedList {

    private Node head;
    private Node rear;

    public DoublyLinkedList() {
        head = null;
        rear = null;
    }

    public boolean isEmpty() {
        return head == null;
    }
    
    public Node getHead()
    {
        return head;
    }

    public void insertFirst(String dd) {
        Node newNode = new Node(dd);
        if (isEmpty()) {
            rear = newNode;
        } else {
            head.setPrevious(newNode);
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void insertLast(String dd) {
        Node newNode = new Node(dd);
        if (isEmpty())
            head = newNode;
        else {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
        }
        rear = newNode;
    }

    public boolean insertAfter(int key, String dd) {
        //fill in the code here
        return true;
    }

    public Node deleteFirst() {
        if (isEmpty())   //empty list
            return null;
        
        Node temp = head;
        
        if (head.getNext() == null) { //one node in list
            rear = null; 
        } 
        else {
            head.getNext().setPrevious(null);
        }     
        head = head.getNext();
        return temp;
    }

    public Node deleteLast() {
        if (isEmpty())   //empty list
            return null;
        
        Node temp = rear;
        
        if (head.getNext() == null) { //one node in list
            head = null; 
        }
        else {
            rear.getPrevious().setNext(null);
        }
        rear = rear.getPrevious();
        return temp;
    }

    public Node deleteKey(int key) {
        Node current = null;
        for (current = head; current != null; current = current.getNext())
        {
            if((int)current.getData() == key)
            {
                
                if (head.getNext() == null) //one node in list
                {
                    head = null;
                    rear = null;
                }
                else if (current == head) //key at first node
                {
                    deleteFirst();
                }
                else if(current == rear) //key at last node
                {
                    deleteLast();
                }
                else
                {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
            }
        }
        return current; 
    }

    public void displayForward() {
        System.out.print("List (head to rear): ");
        Node current = head; // start at beginning
        while (current != null) // until end of list
        {
            current.displayLink(); //display data
            current = current.getNext(); // move to next link
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("List (Backwards) : ");
        Node current = rear;
        while (current != null) {
            current.displayLink();
            current = current.getPrevious();
        }
        System.out.println("");
    }

    public void shuffle() {
        for (int x = 0; x < 500; x++) {
            Node temp = head;

            int randomX = (int) (Math.random() * 53 + 1);

            //simply go until the randomX
            while (randomX-- > 0 && temp.getNext() != null) {
                temp = temp.getNext();

            }

            //remove the Nth node from the list
            if (temp.getNext() != null && temp.getPrevious() != null) {
                temp.getPrevious().setNext(temp.getNext());
                temp.getNext().setPrevious(temp.getPrevious());
                if (x % 2 != 0) {
                    temp.setNext(head);
                    head.setPrevious(temp);
                    //set it to point to the head
                    temp.setPrevious(null);
                    //now set the Head to the Nth node we found
                    head = temp;
                }
                else
                {
                    temp.setPrevious(rear);
                    rear.setNext(temp);
                    //set it to point to the rear
                    temp.setNext(null);
                    //now set the rear to the Nth node we found
                    rear = temp;
                }
            }


        }
    }

}
