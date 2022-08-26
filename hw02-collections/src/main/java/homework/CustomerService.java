package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final TreeMap<Customer, String> map = new TreeMap<>(Comparator.comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Customer key = map.firstEntry().getKey();
        String value = map.firstEntry().getValue();

        return Map.entry(new Customer(key.getId(), key.getName(), key.getScores()), value);
    }


    public Map.Entry<Customer, String> getNext(Customer customer) {
        Customer higherKeyCustomer = map.higherKey(customer);
        if (higherKeyCustomer == null) {
            return null;
        }

        String value = map.get(higherKeyCustomer);

        return Map.entry(new Customer(higherKeyCustomer.getId(), higherKeyCustomer.getName(), higherKeyCustomer.getScores()), value);
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }
}
