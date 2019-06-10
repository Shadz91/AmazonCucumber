package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rough {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("dsd");
		list.add("ds");
		list.add("sdnvs");

		Collections.sort(list);
		Collections.reverse(list);
		Collections.rotate(list, 2);

		String st = "I feel alive";
		String a[] = st.split(" ");

		List<String> x = Arrays.asList(a);

		List<Integer> list1 = new ArrayList<>();
		Set<Integer> set = new HashSet<>(list1);

	}

}
