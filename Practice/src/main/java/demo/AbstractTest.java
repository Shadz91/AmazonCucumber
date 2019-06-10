package demo;

abstract class AbstractTest {

	public void x() {

	}

	abstract void y();

}

class z extends AbstractTest {

	void y() {
		System.out.println("hi");
	}

}