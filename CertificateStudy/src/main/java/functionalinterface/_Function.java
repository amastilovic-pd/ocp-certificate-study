package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

	public static void main(String[] args) {
		int increment = incrementByOne(1);
		System.out.println(increment);

		Integer increment2 = incrementByOneFunction.apply(1);
		System.out.println(increment2);

		Integer multiply = multiplyBy10Function.apply(increment2);
		System.out.println(multiply);

		Function<Integer, Integer> incrementThenMultiply = incrementByOneFunction.andThen(multiplyBy10Function);

		System.out.println(incrementThenMultiply.apply(1));

        //BI Function
        incrementThenMultiplyFunc.apply(4,5);
	}

	//takes parameter and return type
	static Function<Integer, Integer> incrementByOneFunction = num -> num + 1;

	static Function<Integer, Integer> multiplyBy10Function = num -> num * 10;

	static BiFunction<Integer, Integer, Integer> incrementThenMultiplyFunc = (toIncrement, toMultiply) -> (toIncrement + 1) * toMultiply;

	static int incrementByOne(int num) {
		return num + 1;
	}
}
