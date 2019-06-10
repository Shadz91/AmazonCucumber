package demo;

import java.util.HashMap;

public class ListOperations3 {

	public static void main(String args[]) {

		String st = "Shasassadadab";
		st = st.toLowerCase();
		char ch;
		HashMap<Character, Integer> hmap = new HashMap<>();

		for (int i = 0; i < st.length(); i++) {
			ch = st.charAt(i);

			Integer val = hmap.get(ch);

			if (val == null) {
				hmap.put(ch, 1);
			} else {
				hmap.put(ch, val + 1);
			}

		}
		System.out.println(hmap);
	}

}
