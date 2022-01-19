public class LLConstruct {
    Node head;

    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    void insertAtFront(int num){
        Node temp = new Node(num);
        if(head == null){
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        return;
    }

    void insertAtBack(int num){
        Node temp = new Node(num);
        if(head == null){
            head = temp;
        } else {
            head.next = temp;
        }
        return;
    }

    void insertBefore(Node node, Node nodeToInsert){
        if(head == null){
            head = nodeToInsert;
        }
        Node temp = head;
        Node prevNode = null;
        while(temp != null){
            if(node.data == temp.data){
                // its head
                if(prevNode == null){
                    nodeToInsert.next = head;
                    head = nodeToInsert;
                    break;
                } else {
                    prevNode.next = nodeToInsert;
                    nodeToInsert.next = node;
                    break;
                }
            }
            prevNode = temp;
            temp = temp.next;
        }
        // its a tail
        if(temp == null){
            prevNode.next = nodeToInsert;
        }
    }

    void insertAfter(Node node, Node nodeToInsert){
        if(head == null){
            head = nodeToInsert;
        }
        Node temp = head;

        while(temp != null){
            if(node.data == temp.data){
                Node nextNode = temp.next;
                temp.next = nodeToInsert;
                nodeToInsert.next = nextNode;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        System.out.println("Starting construction of a linkedList");

    }
}
