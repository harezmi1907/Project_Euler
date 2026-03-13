package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListEx2 {

    static class MyLinkedList {

        ListNode head;
        int size;

        public MyLinkedList() {
            size = 0;
        }
        public static class ListNode {
            ListNode next;
            int val;
            public ListNode(int val) {
                this.val = val;
            }
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            ListNode curr = head;
            for(int i=0; i < index && curr != null; i++) curr = curr.next;
            return curr == null ? -1 : curr.val;
        }

        public void addAtHead(int val) {
            // addAtIndex(0, val);
            ListNode toAdd = new ListNode(val);
            if (head == null) {
                head = toAdd;
                size++;
                return;
            }
            toAdd.next = head;
            head = toAdd;
            size++;
        }

        public void addAtTail(int val) {
            // addAtIndex(size, val);
            if (head == null) {
                addAtHead(val);
                return;
            }
            ListNode toAdd = new ListNode(val);
            ListNode curr = head;
            while (curr != null && curr.next != null) curr = curr.next;
            curr.next = toAdd;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (index > size) {
                return;
            }
            ListNode curr = head;
            ListNode toAdd = new ListNode(val);
            for(int i=0; i < index-1 && curr != null; i++) curr = curr.next;

            toAdd.next = curr.next;
            curr.next = toAdd;
            size++;

        }

        public void deleteAtIndex(int index) {
            if (index >= size || size == 0) {
                return;
            }
            ListNode curr = head;
            if (index == 0) {
                head = curr.next;
                size--;
                return;
            }
            for(int i=0; i < index-1 && curr != null; i++) curr = curr.next;
            curr.next = curr.next.next;
            size--;
        }
    }


    public static boolean hasCycle(MyLinkedList.ListNode head) {
        if(head == null || head.next == null) return false;

        MyLinkedList.ListNode temp = head;
        Set<MyLinkedList.ListNode> set = new HashSet<>();
        set.add(temp);
        while (temp != null && temp.next != null) {
            temp = temp.next;
            if(!set.add(temp)) return true;
        }
        return false;
    }

    public static boolean hasCycle2(MyLinkedList.ListNode head) {
        if(head == null || head.next == null) return false;

        MyLinkedList.ListNode slow = head;
        MyLinkedList.ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static boolean hasCycle3(MyLinkedList.ListNode head) {
        MyLinkedList.ListNode slow = head;
        MyLinkedList.ListNode mark = new MyLinkedList.ListNode(-1);
        while (mark != slow) {
            if (slow == null) return false;
            MyLinkedList.ListNode temp = slow;
            slow = slow.next;
            temp.next = mark;
        }
        return true;
    }

    public static MyLinkedList.ListNode detectCycle(MyLinkedList.ListNode head) {
        MyLinkedList.ListNode temp = head;

        System.out.println("val:" + temp.val);
        Set<MyLinkedList.ListNode> set = new HashSet<>();
        while (temp != null) {
            System.out.println("val:" + temp.val);
            if(!set.add(temp)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public static MyLinkedList.ListNode detectCycle2(MyLinkedList.ListNode head) {
        if(head == null || head.next == null) return null;

        MyLinkedList.ListNode slow = head;
        MyLinkedList.ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // Check if there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {

        // Creating individual MyLinkedLists
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(-4);
        myLinkedList.addAtHead(0);
        myLinkedList.addAtHead(8);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(10);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        System.out.println(myLinkedList.get(4));
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);


//        myLinkedList.addAtIndex(1, 0);
//        System.out.println(myLinkedList.get(0));
//        System.out.println("Size:" + myLinkedList.size);
        MyLinkedList.ListNode curr = myLinkedList.head;
        System.out.print(curr.val + " -> ");
        MyLinkedList.ListNode temp = null;
        while (curr != null && curr.next != null) {
            curr = curr.next;
            System.out.print(curr.val + " -> ");
            if(curr != null && curr.val == 2) temp = curr;

            System.out.println("Temp:" + temp.val);
        }
        curr.next = temp;
//        System.out.print(temp.val + " -> ");
//        System.out.print(temp.next.val + " -> ");
//        System.out.print(curr.val + " -> ");
        System.out.println(myLinkedList.head.val + " -> ");
//        System.out.println(hasCycle3(myLinkedList.head));

        System.out.println(detectCycle2(myLinkedList.head).val);

        Set<MyLinkedList.ListNode> set = new HashSet<>();
        set.add(null);
        System.out.println(set);
        System.out.println(set.add(null));
        System.out.println(set);

    }
}
