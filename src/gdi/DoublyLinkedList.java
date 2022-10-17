package gdi;

public class DoublyLinkedList {
    
    class ListElement{
        int value;
        ListElement previous;
        ListElement next;
    }
    
    ListElement root;
    
    boolean isEmpty() {
        if(root==null)
        {
            return true;
            
        }   
        else {
            return false;
        }
        //return root == null;
    }
    void add(int v) {
        if(isEmpty()) {
            root = new ListElement();
            root.value = v;
        }
        else {
            ListElement current = root;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new ListElement();
            current.next.value = v;
            current.next.previous = current;
        }
    }
    
    void remove(int v) {
        if(!isEmpty()) {
            ListElement current = root;
            while(current.next != null && current.value != v) {
                current = current.next;
            }if(current.value == v) {
                if(current.previous != null) {
                current.previous.next = current.next;
                    }else {
                        root = current.next;
                    }
                if(current.next != null) {
                current.next.previous = current.previous;
                }
                
            }
        }
    }
    
    public static void main(String[] args) {
       DoublyLinkedList liste = new DoublyLinkedList();
       liste.add(4);
       liste.add(5);
       liste.add(3);
       liste.remove(5);
       System.out.println(liste);
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.isEmpty()) {
            return "";
        }
        result.append(root.value);
        ListElement current = root.next;
        while (current != null) {
            result.append(",");
            result.append(current.value);
            current = current.next;
        }
        return result.toString();
    }
    
    boolean contains(int v) {
        if (isEmpty()) {
            return false;
            
                
        } 
        else {
            ListElement current = root;
            while(current.next != null && current.value != v)
           { 
                current = current.next;
            }
            return current.value == v;
        }
    }
    
}
