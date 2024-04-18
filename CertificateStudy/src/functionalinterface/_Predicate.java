package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

	public static void main(String[] args) {

		System.out.println(isPhoneNumValid("0700"));
		System.out.println(isPhoneNumValid("010000000000"));

		System.out.println(isPhoneNumValidFunc.test("0700"));
	}

	static boolean isPhoneNumValid(String phoneNum) {
		return phoneNum.startsWith("07") && phoneNum.length() == 4;
	}

	//returns boolean
	static Predicate<String> isPhoneNumValidFunc = phoneNum -> phoneNum.startsWith("07") && phoneNum.length() == 4;
}
