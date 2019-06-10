import java.util.ArrayList;
import java.util.Iterator;

public class TestSample {

	public static void main(String[] args) throws Exception {

		ArrayList<String> data = DataDriven.getData("Add Profile");

		Iterator<String> x = data.iterator();

		while (x.hasNext()) {
			System.out.println(x.next());
		}

	}

}