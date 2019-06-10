package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOperations {

	public static void main(String args[]) {

		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(9);
		list.add(5);
		System.out.println("Original: " + list);

		Collections.sort(list);
		System.out.println("Sorted: " + list);

		Collections.reverse(list);
		System.out.println("Reversed: " + list);

		Collections.rotate(list, 2);
		System.out.println("Rotated: " + list);

		System.out.println("Max: " + Collections.max(list));

		System.out.println("Min: " + Collections.min(list));

		System.out.println("Frequency of 9: " + Collections.frequency(list, 9));

		// Part-Two
		String a[] = { "and", "the", "best", "award", "goes", "to" };
		List<String> list1 = Arrays.asList(a);
		System.out.println("New List: " + list1);

	}

}
