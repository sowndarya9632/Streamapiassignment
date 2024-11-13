package based_on_oop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class PolicyRenewalAnalysis {

    public static List<RenewalReminder> getRenewalReminders(List<Policy> policies) {
        LocalDate today = LocalDate.now();

        List<RenewalReminder> reminders = policies.stream()
                .filter(policy -> policy.getStatus().equals("Active") && 
                        policy.getExpiryDate().isAfter(today) &&
                        ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30)
                
                .map(policy -> new RenewalReminder(
                        policy.getPolicyId(), 
                        policy.getPolicyHolderId(), 
                        ChronoUnit.DAYS.between(today, policy.getExpiryDate())))
                
                 .sorted(Comparator.comparingLong(RenewalReminder::getDaysUntilExpiry))
                
                .collect(Collectors.toList());

        return reminders;
    }

    public static Map<String, List<RenewalReminder>> groupByPolicyHolder(List<RenewalReminder> reminders) {
        return reminders.stream()
                .collect(Collectors.groupingBy(RenewalReminder::getPolicyHolderId));
    }

    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("P001", "H001", LocalDate.now().plusDays(10), 500.0, "Active"),
                new Policy("P002", "H002", LocalDate.now().plusDays(25), 700.0, "Active"),
                new Policy("P003", "H001", LocalDate.now().plusDays(5), 450.0, "Active"),
                new Policy("P004", "H003", LocalDate.now().plusDays(40), 300.0, "Inactive"),
                new Policy("P005", "H002", LocalDate.now().plusDays(15), 600.0, "Active")
        );

        List<RenewalReminder> renewalReminders = getRenewalReminders(policies);
        System.out.println("Renewal Reminders (Sorted by Days Until Expiry):");
        renewalReminders.forEach(System.out::println);

        Map<String, List<RenewalReminder>> groupedReminders = groupByPolicyHolder(renewalReminders);
        System.out.println("\nGrouped by Policy Holder:");
        groupedReminders.forEach((holderId, reminders) -> {
            System.out.println("Policy Holder " + holderId + ": " + reminders);
        });
    }
}

class Policy {
    private String policyId;
    private String policyHolderId;
    private LocalDate expiryDate;
    private double premiumAmount;
    private String status;

    public Policy(String policyId, String policyHolderId, LocalDate expiryDate, double premiumAmount, String status) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
        this.status = status;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public String getStatus() {
        return status;
    }
}

class RenewalReminder {
    private String policyId;
    private String policyHolderId;
    private long daysUntilExpiry;

    public RenewalReminder(String policyId, String policyHolderId, long daysUntilExpiry) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.daysUntilExpiry = daysUntilExpiry;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public long getDaysUntilExpiry() {
        return daysUntilExpiry;
    }

    @Override
    public String toString() {
        return "Policy ID: " + policyId + ", Policy Holder ID: " + policyHolderId + ", Days Until Expiry: " + daysUntilExpiry;
    }
}

