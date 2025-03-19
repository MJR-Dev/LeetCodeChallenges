package com.example.dsa;

import java.util.HashSet;
import java.util.Set;

public class MyLinkedListEx {

	Node head; 
	
	void removeDuplicates()
    {
		Set<Integer> set1 = new HashSet<>();
		Node temp = head;
		Node prev = temp;
		while(temp != null) {			
			if(!set1.add(temp.data)) {
				prev.next = temp.next;			
			} else {
				prev = temp;			
			}
			temp = temp.next;
		}       
    }

    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedListEx llist = new MyLinkedListEx();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);

        System.out.println(
            "List before removal of duplicates");
        llist.printList();

        llist.removeDuplicates();

        System.out.println(
            "List after removal of elements");
        llist.printList();
	}

}
