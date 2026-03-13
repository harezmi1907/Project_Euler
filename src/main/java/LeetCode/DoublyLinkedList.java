package LeetCode;

public class DoublyLinkedList {
        Node head;
        int size;

        public DoublyLinkedList() {
            this.size = 0;
            this.head = null;
        }
        public class Node {
            Node prev, next;
            int val;
            public Node(int val) {
                this.val = val;
            }
        }

        public int get(int index) {
            Node node = getNode(index);
            return node == null ? -1 : node.val;
        }

        public Node getNode(int index) {
            // if index is invalid
            if (index < 0 || index >= size) return null;

            Node node = head;
            while(index > 0) {
                node = node.next;
                index--;
            }
            return node;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (head == null) {
                head = node;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node newTail = new Node(val);
            if(size == 0) {
                head = newTail;
            } else {
                Node tail = getNode(size-1);
                tail.next = newTail;
                newTail.prev = tail;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            } else if (index == size) {
                addAtTail(val);
                return;
            } else if (index < 0 || index >= size) {
                return;
            }
            Node toAdd = new Node(val);
            Node prev = getNode(index-1);

            toAdd.next = prev.next;
            prev.next.prev = toAdd;
            prev.next = toAdd;
            toAdd.prev = prev;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (size == 0) {
                return;
            } else if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                if (size == 1){
                    head = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
                size--;
                return;
            }
            Node toDelete = getNode(index);
            Node next = toDelete.next;
            Node prev = toDelete.prev;

            if (next == null) {
                prev.next = null;
            } else {
                next.prev = prev;
                prev.next = next;
            }
            size--;
        }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);

        DoublyLinkedList.Node curr = list.head;
        System.out.print(curr.val + " -> ");
        while (curr.next != null) {
            curr = curr.next;
            System.out.print(curr.val + " -> ");
        }
        System.out.println("Size:" + list.size);
    }
    }
