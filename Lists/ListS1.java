package practice;

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
}
