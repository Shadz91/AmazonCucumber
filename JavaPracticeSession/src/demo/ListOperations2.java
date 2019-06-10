package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOperations2 {

	public static void main(String args[]) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(8);

		Collections.sort(list);
		Collections.reverse(list);
		Collections.rotate(list, 2);
		Collections.frequency(list, 8);

		Set<Integer> set = new HashSet<>(list);
		System.out.println(set);

		String arr[] = { "hi", "bye", "go" };
		List<String> list2 = Arrays.asList(arr);
		System.out.println(list2);

	}

}