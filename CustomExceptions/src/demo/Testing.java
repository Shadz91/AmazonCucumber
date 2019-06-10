package demo;

public class Testing {

	public static void main(String[] args) {

		int k = 15;

		try {
			if (k < 18)
				throw new MyException();
		} catch (MyException e) {
			System.out.println("Invalid Age");
		}

	}

}
