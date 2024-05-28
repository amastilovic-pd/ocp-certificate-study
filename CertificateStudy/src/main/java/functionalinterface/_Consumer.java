package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {
		Customer customer = new Customer("name", "phone num");

		greet(customer);

		greetCustomerConsumer.accept(customer);
		greetCustomerConsumerV2.accept(customer, false);
	}

	static Consumer<Customer> greetCustomerConsumer = customer -> {
		System.out.println("hello " + customer.customerName + ", phone num: " + customer.customerPhone);
	};

	static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNum) -> {
		System.out.println("hello " + customer.customerName + ", phone num: " + (showPhoneNum
				? customer.customerPhone
				: "************"));
	};

	static void greet(Customer customer) {
		System.out.println("hello " + customer.customerName + ", phone num: " + customer.customerPhone);
	}

	static class Customer {
		private final String customerName;
		private final String customerPhone;

		Customer(String customerName, String customerPhone) {
			this.customerName = customerName;
			this.customerPhone = customerPhone;
		}
	}
}
