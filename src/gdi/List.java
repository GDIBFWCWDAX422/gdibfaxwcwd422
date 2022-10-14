package gdi;

class List {
    class ListElement{
        ListElement next;
        int value;


    }

    public static void main(final String[]args) {
          final List list =new List();

          list.add(5);
          list.add(3);
          list.add(8);
          if(list.contains(3)) {
              System.out.println("3 ist drin");
          }
          else {System.out.println("3 ist nicht drin");

          }
      }

    ListElement root;
    void add(final int v) {
        if(this.root == null) {
            this.root = new ListElement();
            this.root.value = v;
        }
        else{
            ListElement current = this.root;
            while(current.next != null) {
                current = current.next;

            }
                current.next = new ListElement();
                current.next.value = v;
        }


    }
    boolean contains(final int v) {
        if(this.root == null) {
            return false;

        }
        else {
            ListElement current = this.root;
            while(current.next !=null && current.value != v)
            {
                current=current.next;


            }
            return current.value == v;
            }
    }
  boolean isempty() {
    return this.root==null;
}
    void remove(final int v) {
        if(this.root!=null) {
            if(this.root.value == v ) {
                this.root= this.root. next;
            }else {
            ListElement current = this.root;
            while(current.next !=null && current.next.value != v)
            {
                current=current.next;


            }
            if(current.next !=null) {
            current.next=current.next.next;
            }}

        }
    }
}
