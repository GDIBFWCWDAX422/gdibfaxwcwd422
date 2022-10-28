package gdi;

public class AVLTree {

    boolean isEmpty() {
        return root == null; 
    }
    Node root;
    void add (int value) {
        if (isEmpty()) {
            root = new Node();
            root.value = value;
            root.height = 0;
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
                    if(root.right.left==null) {
                        root.right=root.right.right;
                        if(root.right.height>=root.left.height) {
                            root.height--;
                        }
                    } else {
                        int removeheight = root.right.remove(min);
                        int otherheight = root.left.height;
                        int max = removeheight<otherheight ? otherheight : removeheight;
                        if(max==root.height-2) {
                            root.height--;
                        }
                        
                    }
                   
                    root.value = min;
                }
            } else {
                int removeheight = root.right.remove(value);
                int otherheight = root.left.height;
                int max = removeheight<otherheight ? otherheight : removeheight;
                if(max==root.height-2) {
                    root.height--;
                }
            }
        }
    }
    
    class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        int height;
        void rotateleft() {
            Node store = this.right.left;
            Node store2 = this.right;
            this.right.left=this;
            this.right=store;
            Node parent = this.parent;
            this.parent=store2;
            store.parent=this;
            store2.parent=parent;
            
        }
        int add (int value) {
            if(this.value > value ) {
                if(left==null) {
                    left = new Node();
                    left.value = value;
                    left.height = 0;
                    if(this.right==null) {
                        this.height++;
                    }
                }else {
                    int leftheight = left.add(value);
                    if(leftheight==height) {
                        height++;
                    }
               }
            }else {
                if(right==null) {
                    right = new Node();
                    right.value = value;
                    right.height = 0;
                    if(this.left==null) {
                        this.height++;
                    }
                }else {
                    int rightheight = right.add(value);
                    if(rightheight==height) {
                        height++;
                    }
               }
                
               
            }
            return height;
        }
        
        int remove(int value) {
            if(this.value > value ) {
                if (left.value == value) {
                    if (left.left == null) {
                        left = left.right;
                        this.height--;
                    } else if (left.right == null) {
                        left = left.left;
                        this.height--;
                    } else {
                        int min = left.right.min();
                        if(left.right.value==min) {
                            if (left.right.left == null) {
                                left.right = left.right.right;
                                left.height--;
                                if(left.height>=right.height) {
                                    this.height--;
                                }
                            } else {
                                int removeheight = left.right.remove(min);
                                int otherheight = left.left==null ? -1 : left.left.height;
                                int max = removeheight<otherheight ? otherheight : removeheight;
                                if(max==left.height-2) {
                                    left.height--;
                                }
                                if(left.height>=right.height) {
                                    this.height--;
                                }
                            } 
                        } else {
                            int removeheight = left.right.remove(min);
                            int otherheight = left.left==null ? -1 : left.left.height;
                            int max = removeheight<otherheight ? otherheight : removeheight;
                            if(max==left.height-2) {
                                left.height--;
                            }
                            if(left.height>=right.height) {
                                this.height--;
                            }
                        }
                        left.value = min;
                    }
                } else {
                    int removeheight = left.right.remove(value);
                    int otherheight = left.left==null ? -1 : left.left.height;
                    int max = removeheight<otherheight ? otherheight : removeheight;
                    if(max==left.height-2) {
                        left.height--;
                    }
                    if(left.height>=right.height) {
                        this.height--;
                    }
                }
            }else {
                if (right.value == value) {
                    if (right.left == null) {
                        right = right.right;
                        this.height--;
                    } else if (right.right == null) {
                        right = right.left;
                        this.height--;
                    } else {
                        int min = right.right.min();
                        if(right.right.value==min) {
                            if (right.right.left == null) {
                                right.right = right.right.right;
                                right.height--;
                                if(right.height>=left.height) {
                                    this.height--;
                                }
                            } else {
                                int removeheight = right.right.remove(min);
                                int otherheight = right.left==null ? -1 : right.left.height;
                                int max = removeheight<otherheight ? otherheight : removeheight;
                                if(max==right.height-2) {
                                    right.height--;
                                }
                                if(right.height>=left.height) {
                                    this.height--;
                                }
                            } 
                        } else {
                            int removeheight = right.right.remove(min);
                            int otherheight = right.left==null ? -1 : right.left.height;
                            int max = removeheight<otherheight ? otherheight : removeheight;
                            if(max==right.height-2) {
                                right.height--;
                            }
                            if(right.height>=left.height) {
                                this.height--;
                            }
                        }
                        
                        right.value = min;
                    }
                } else {
                    int removeheight = right.right.remove(value);
                    int otherheight = right.left==null ? -1 : right.left.height;
                    int max = removeheight<otherheight ? otherheight : removeheight;
                    if(max==right.height-2) {
                        right.height--;
                    }
                    if(right.height>=left.height) {
                        this.height--;
                    }
                }
            }
            return this.height;
        }

        int min() {
            if(left != null) {
                return left.min();
            }else return value;
        }
    }

}
