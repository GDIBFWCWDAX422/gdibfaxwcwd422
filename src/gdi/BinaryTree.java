package gdi;

public class BinaryTree {

    boolean isEmpty() {
        return root == null; 
    }
    Node root;
    void add (int value) {
        if (isEmpty()) {
            root = new Node();
            root.value = value;
        } else {
            root.add(value);
            
        }
    }
    
    void remove(int value) {
        if (!isEmpty()) {
            if (root.value == value) {
                if (root.left == null) {
                    root = root.right;
                } else if (root.right == null) {
                    root = root.left;
                } else {
                    int min = root.right.min();
                    root.right.remove(min);
                    root.value = min;
                }
            } else {
                root.remove(value);
            }
        }
    }
    
    class Node {
        int value;
        Node left;
        Node right;
        void add (int value) {
            if(this.value > value ) {
                if(left==null) {
                    left = new Node();
                    left.value = value;
                }else {
                    left.add(value);
               }
            }else {
                if(right==null) {
                    right = new Node();
                    right.value = value;
                }else {
                    right.add(value);
               }
                
               
            }
        }
        
        void remove(int value) {
            if(this.value > value ) {
                if (left.value == value) {
                    if (left.left == null) {
                        left = left.right;
                    } else if (left.right == null) {
                        left = left.left;
                    } else {
                        int min = left.right.min();
                        if(left.right.value==min) {
                            if (left.right.left == null) {
                                left.right = left.right.right;
                            } else {
                                left.right.remove(min);
                            } 
                        } else {
                            left.right.remove(min);
                        }
                        left.value = min;
                    }
                } else {
                    left.remove(value);
                }
            }else {
                if (right.value == value) {
                    if (right.left == null) {
                        right = right.right;
                    } else if (right.right == null) {
                        right = right.left;
                    } else {
                        int min = right.right.min();
                        if(right.right.value==min) {
                            if (right.right.left == null) {
                                right.right = right.right.right;
                            } else {
                                right.right.remove(min);
                            } 
                        } else {
                            right.right.remove(min);
                        }
                        
                        right.value = min;
                    }
                } else {
                    right.remove(value);
                }
            }

        }

        int min() {
            if(left != null) {
                return left.min();
            }else return value;
        }
    }
    
}
