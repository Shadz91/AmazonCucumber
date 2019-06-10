package revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(12);
		list.add(8);

		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.rotate(list, 2);
		System.out.println(list);

	}

}
