package based_on_oop;

import java.util.*;
import java.util.stream.Collectors;

public class ClaimsAnalysis {

    public static List<PolicyClaimSummary> analyzeClaims(List<Claim> claims) {
        List<Claim> approvedClaims = claims.stream()
                .filter(c -> "Approved".equals(c.getStatus()) && c.getClaimAmount() > 5000)
                .collect(Collectors.toList());

        Map<String, PolicyClaimSummary> policySummaryMap = approvedClaims.stream()
                .collect(Collectors.groupingBy(
                        Claim::getPolicyNumber,
                        Collectors.collectingAndThen(Collectors.toList(), claimList -> {
                            double totalAmount = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                            double averageAmount = claimList.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0);
                            return new PolicyClaimSummary(claimList.get(0).getPolicyNumber(), totalAmount, averageAmount);
                        })
                ));

        return policySummaryMap.values().stream()
                .sorted((p1, p2) -> Double.compare(p2.getTotalClaimAmount(), p1.getTotalClaimAmount()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "P1001", 7000, "2023-01-10", "Approved"),
                new Claim("C002", "P1001", 6000, "2023-02-15", "Approved"),
                new Claim("C003", "P1002", 3000, "2023-03-20", "Pending"),
                new Claim("C004", "P1003", 8000, "2023-04-25", "Approved"),
                new Claim("C005", "P1003", 5000, "2023-05-30", "Approved"),
                new Claim("C006", "P1004", 12000, "2023-06-05", "Approved")
        );

        List<PolicyClaimSummary> topPolicies = analyzeClaims(claims);

        System.out.println("Top 3 Policies with the Highest Total Claim Amounts:");
        topPolicies.forEach(System.out::println);
    }
}

class Claim {
    private String claimId;
    private String policyNumber;
    private double claimAmount;
    private String claimDate;
    private String status;

    public Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getClaimId() {
        return claimId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public String getStatus() {
        return status;
    }
}


class PolicyClaimSummary {
    private String policyNumber;
    private double totalClaimAmount;
    private double averageClaimAmount;

    public PolicyClaimSummary(String policyNumber, double totalClaimAmount, double averageClaimAmount) {
        this.policyNumber = policyNumber;
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getTotalClaimAmount() {
        return totalClaimAmount;
    }

    public double getAverageClaimAmount() {
        return averageClaimAmount;
    }

    @Override
    public String toString() {
        return "Policy: " + policyNumber + ", Total Claim Amount: $" + totalClaimAmount +
                ", Average Claim Amount: $" + averageClaimAmount;
    }
}
