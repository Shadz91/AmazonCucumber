import java.util.ArrayList;
import java.util.Iterator;

public class CopyTestSample {

	public static void main(String[] args) throws Exception {

		ArrayList<String> data = CopyDataDriven.getData("TestData", "Add Profile");

		Iterator<String> x = data.iterator();

		while (x.hasNext()) {
			System.out.print(x.next() + "    ");
		}

	}

}