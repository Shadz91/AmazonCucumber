package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface InterfaceDemo {

	abstract void x();

	abstract void y();

	abstract void z();

}

class k implements InterfaceDemo {

	public void x() {
		System.out.println("1");
	}

	public void y() {
		System.out.println("2");
	}

	public void z() {
		System.out.println("3");

		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>(list);

	}

}