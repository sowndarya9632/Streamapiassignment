package based_on_oop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerLifetimeValue {

    public static List<CustomerLifetime> calculateLifetimeValue(List<CustomerTransaction> transactions) {
        LocalDate today = LocalDate.now();

        List<CustomerTransaction> recentTransactions = transactions.stream()
                .filter(transaction -> ChronoUnit.MONTHS.between(transaction.getTransactionDate(), today) <= 12)
                .collect(Collectors.toList());

        Map<String, CustomerLifetime> customerLifetimeMap = recentTransactions.stream()
                .collect(Collectors.groupingBy(
                        CustomerTransaction::getCustomerId,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                trans -> {
                                    double totalAmount = trans.stream().mapToDouble(CustomerTransaction::getTransactionAmount).sum();
                                    double averageAmount = totalAmount / trans.size();
                                    return new CustomerLifetime(trans.get(0).getCustomerId(), totalAmount, averageAmount);
                                }
                        )
                ));

        List<CustomerLifetime> sortedCustomers = customerLifetimeMap.values().stream()
                .sorted((c1, c2) -> Double.compare(c2.getTotalAmount(), c1.getTotalAmount()))
                .collect(Collectors.toList());

        return sortedCustomers.stream().limit(10).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<CustomerTransaction> transactions = Arrays.asList(
                new CustomerTransaction("C001", LocalDate.now().minusMonths(1), 200.0),
                new CustomerTransaction("C002", LocalDate.now().minusMonths(5), 450.0),
                new CustomerTransaction("C001", LocalDate.now().minusMonths(3), 150.0),
                new CustomerTransaction("C003", LocalDate.now().minusMonths(10), 300.0),
                new CustomerTransaction("C002", LocalDate.now().minusMonths(2), 550.0),
                new CustomerTransaction("C004", LocalDate.now().minusMonths(14), 600.0), // Beyond 12 months
                new CustomerTransaction("C005", LocalDate.now().minusMonths(7), 400.0)
        );

        List<CustomerLifetime> topCustomers = calculateLifetimeValue(transactions);

        System.out.println("Top 10 Customers by Total Transaction Amount:");
        topCustomers.forEach(System.out::println);
    }
}

class CustomerTransaction {
    private String customerId;
    private LocalDate transactionDate;
    private double transactionAmount;

    public CustomerTransaction(String customerId, LocalDate transactionDate, double transactionAmount) {
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
}

class CustomerLifetime {
    private String customerId;
    private double totalAmount;
    private double averageAmount;

    public CustomerLifetime(String customerId, double totalAmount, double averageAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getAverageAmount() {
        return averageAmount;
    }

    @Override
    public String toString() {
        return "CustomerID: " + customerId + ", Total Amount: $" + totalAmount + ", Average Amount: $" + averageAmount;
    }
}

