package practice;

import java.util.TreeMap;

import practice.SinglyLinkedList;
import practice.SinglyLinkedList.Entry;

/**
 * @author vinayaka
 *
 */
public class ListS1 {

	 static <T extends Comparable<? super T>> Entry<T> elementAtK(SinglyLinkedList<T> list, int k) {

		Entry<T> head = list.head;
		Entry<T> helper = list.head;

		if (head != null) {
			int count = 0;
			while (count < k) {
				helper = helper.next;
				count++;
			}
			while (helper.next != null) {
				helper = helper.next;
				head = head.next;
			}

		} else {
			System.out.println("List is empty");
		}

		return head;

	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		for(int i = 0 ; i < 100 ; i++){
			list.add(i+1);
		}
		
		Entry head = elementAtK(list, 4);
		System.out.println(head.element);
	}

}
