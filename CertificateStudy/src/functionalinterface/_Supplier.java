package functionalinterface;

import java.util.function.Supplier;

public class _Supplier {

	public static void main(String[] args) {

		System.out.println(getDBConnectionURL());
		System.out.println(getDBConnectionURLFunc.get());
	}

	static String getDBConnectionURL() {

		return "jdbc://localhost:5435/db";
	}

	//returns a value
	static Supplier<String> getDBConnectionURLFunc = () -> "jdbc://localhost:5435/db";
}
