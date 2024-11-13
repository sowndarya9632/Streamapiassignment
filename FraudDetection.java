package based_on_oop;

import java.util.*;
import java.util.stream.Collectors;

public class FraudDetection {

    public static List<FraudAlert> detectFraud(List<Transaction> transactions) {
        Map<String, List<Transaction>> fraudulentTransactionsByPolicy = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        List<FraudAlert> fraudAlerts = new ArrayList<>();
        for (Map.Entry<String, List<Transaction>> entry : fraudulentTransactionsByPolicy.entrySet()) {
            String policyNumber = entry.getKey();
            List<Transaction> fraudulentTransactions = entry.getValue();
            
            int fraudCount = fraudulentTransactions.size();
            double totalFraudAmount = fraudulentTransactions.stream()
                    .mapToDouble(Transaction::getAmount)
                    .sum();

            if (fraudCount > 5 || totalFraudAmount > 50000) {
                fraudAlerts.add(new FraudAlert(policyNumber, fraudCount, totalFraudAmount));
            }
        }
        return fraudAlerts;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P001", 12000, "2024-01-10", true),
                new Transaction("T002", "P001", 15000, "2024-02-15", true),
                new Transaction("T003", "P002", 8000, "2024-03-18", true),
                new Transaction("T004", "P001", 20000, "2024-04-22", true),
                new Transaction("T005", "P003", 5000, "2024-05-25", false),
                new Transaction("T006", "P001", 11000, "2024-06-30", true),
                new Transaction("T007", "P001", 25000, "2024-07-15", true),
                new Transaction("T008", "P002", 30000, "2024-08-20", true),
                new Transaction("T009", "P001", 13000, "2024-09-05", true),
                new Transaction("T010", "P003", 45000, "2024-10-10", true)
        );

        List<FraudAlert> alerts = detectFraud(transactions);

        System.out.println("Fraud Alerts:");
        alerts.forEach(System.out::println);
    }
}

class Transaction {
    private String transactionId;
    private String policyNumber;
    private double amount;
    private String transactionDate;
    private boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}

class FraudAlert {
    private String policyNumber;
    private int fraudCount;
    private double totalFraudAmount;

    public FraudAlert(String policyNumber, int fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Fraud Count: " + fraudCount + ", Total Fraud Amount: $" + totalFraudAmount;
    }
}

