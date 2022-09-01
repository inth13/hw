package homework;

import java.util.Deque;
import java.util.LinkedList;

public class CustomerReverseOrder {

    private Deque<Customer> customerList = new LinkedList<>();
    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"

    public void add(Customer customer) {
        customerList.push(customer);
    }

    public Customer take() {
        return customerList.pop();
    }
}
