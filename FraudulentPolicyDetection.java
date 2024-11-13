package based_on_oop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class FraudulentPolicyDetection {

    public static List<FraudAlert> detectFraudulentPolicies(List<Policy> policies, List<Transaction> transactions) {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);

        Map<String, List<Transaction>> highValueTransactionsByPolicy = transactions.stream()
                .filter(t -> t.getAmount() > 10000 && t.getTransactionDate().isAfter(sixMonthsAgo))
                .collect(Collectors.groupingBy(Transaction::getPolicyId));

        List<Policy> suspiciousPolicies = policies.stream()
                .filter(policy -> highValueTransactionsByPolicy.containsKey(policy.getPolicyId()) &&
                        highValueTransactionsByPolicy.get(policy.getPolicyId()).size() > 3)
                .collect(Collectors.toList());

        Map<String, Double> totalHighValueAmountByPolicy = highValueTransactionsByPolicy.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 3)  // Ensure only policies with >3 transactions are considered
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Transaction::getAmount).sum()
                ));

        List<FraudAlert> fraudAlerts = suspiciousPolicies.stream()
                .filter(policy -> totalHighValueAmountByPolicy.getOrDefault(policy.getPolicyId(), 0.0) > 50000)
                .map(policy -> new FraudAlert(
                        policy.getPolicyId(),
                        policy.getPolicyHolderId(),
                        totalHighValueAmountByPolicy.get(policy.getPolicyId())))
                .collect(Collectors.toList());

        return fraudAlerts;
    }

    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("P001", "H001"),
                new Policy("P002", "H002"),
                new Policy("P003", "H003")
        );

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P001", 15000, LocalDate.now().minusMonths(1)),
                new Transaction("T002", "P001", 12000, LocalDate.now().minusMonths(2)),
                new Transaction("T003", "P001", 13000, LocalDate.now().minusMonths(3)),
                new Transaction("T004", "P001", 14000, LocalDate.now().minusMonths(4)),
                new Transaction("T005", "P002", 16000, LocalDate.now().minusMonths(1)),
                new Transaction("T006", "P002", 11000, LocalDate.now().minusMonths(5)),
                new Transaction("T007", "P003", 9000, LocalDate.now().minusMonths(1)) // Below threshold
        );

        List<FraudAlert> fraudAlerts = detectFraudulentPolicies(policies, transactions);

        System.out.println("Fraudulent Policies Detected:");
        fraudAlerts.forEach(System.out::println);
    }
}

class Policy {
    private String policyId;
    private String policyHolderId;

    public Policy(String policyId, String policyHolderId) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }
}

class Transaction {
    private String transactionId;
    private String policyId;
    private double amount;
    private LocalDate transactionDate;

    public Transaction(String transactionId, String policyId, double amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.policyId = policyId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getPolicyId() {
        return policyId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}

class FraudAlert {
    private String policyId;
    private String policyHolderId;
    private double totalHighValueAmount;

    public FraudAlert(String policyId, String policyHolderId, double totalHighValueAmount) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.totalHighValueAmount = totalHighValueAmount;
    }

    @Override
    public String toString() {
        return "PolicyID: " + policyId + ", PolicyHolderID: " + policyHolderId + ", Total High-Value Amount: $" + totalHighValueAmount;
    }
}

