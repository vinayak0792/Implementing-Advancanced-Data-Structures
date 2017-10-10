/**
 * 
 */
package practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author vinayaka
 *
 */
public class ListSet {

	static <T extends Comparable<? super T>> T nextItem(Iterator<T> it) {
		return it.hasNext() ? it.next() : null;
	}

	public static <T extends Comparable<? super T>> List<T> union(List<T> list1, List<T> list2) {

		List<T> unionList = new LinkedList<T>();
		Iterator<T> it1 = list1.iterator();
		Iterator<T> it2 = list2.iterator();
		T node1 = nextItem(it1);
		T node2 = nextItem(it2);

		while (node1 != null && node2 != null) {
			if (node1.compareTo(node2) < 0) {
				unionList.add((node1));
				node1 = nextItem(it1);
			} else if (node1.compareTo(node2) > 0) {
				unionList.add((node2));
				node2 = nextItem(it2);
			} else {
				unionList.add(node1);
				node1 = nextItem(it1);
				node2 = nextItem(it2);
			}
		}

		// The following conditions check if for any remaining elements in the
		// respective lists and append it to the union list.
		while (node1 != null) {
			unionList.add(node1);
			node1 = nextItem(it1);
		}

		while (node2 != null) {
			unionList.add(node2);
			node2 = nextItem(it2);
		}

		return unionList;

	}

	public static <T extends Comparable<? super T>> List<T> intersect(List<T> list1, List<T> list2) {
		List<T> intresectList = new LinkedList<T>();
		Iterator<T> it1 = list1.iterator();
		Iterator<T> it2 = list2.iterator();
		T node1 = nextItem(it1);
		T node2 = nextItem(it2);

		while (node1 != null && node2 != null) {
			if (node1.compareTo(node2) < 0) {
				node1 = nextItem(it1);
			} else if (node1.compareTo(node2) > 0) {
				node2 = nextItem(it2);
			} else {
				intresectList.add(node1);
				node1 = nextItem(it1);
				node2 = nextItem(it2);
			}
		}
		return intresectList;

	}

	public static <T extends Comparable<? super T>> List<T> difference(List<T> list1, List<T> list2) {
		List<T> diffList = new LinkedList<>();
		Iterator<T> it1 = list1.iterator();
		Iterator<T> it2 = list2.iterator();
		T node1 = nextItem(it1);
		T node2 = nextItem(it2);

		while (node1 != null && node2 != null) {
			if (node1.compareTo(node2) == 0) {
				node1 = nextItem(it1);
				node2 = nextItem(it2);
			} else if (node1.compareTo(node2) < 0) {
				diffList.add(node1);
				node1 = nextItem(it1);
			} else if (node1.compareTo(node2) > 0) {
				node2 = nextItem(it2);
			}
		}
		
		while (node1 != null) {
			diffList.add(node1);
			node1 = nextItem(it1);
		}
		return diffList;

	}

}
