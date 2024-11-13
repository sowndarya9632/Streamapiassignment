package based_on_oop;

import java.util.*;
import java.util.stream.Collectors;

public class PolicyHolderRiskAssessment {

	public static Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> policyHolders) {
		List<RiskAssessment> riskAssessments = policyHolders.stream()
				.filter(ph -> "Life".equals(ph.getPolicyType()) && ph.getAge() > 60)

				.map(ph -> new RiskAssessment(ph.getHolderId(), ph.getName(), ph.getPremiumAmount() / ph.getAge()))

				.sorted((ra1, ra2) -> Double.compare(ra2.getRiskScore(), ra1.getRiskScore()))
				.collect(Collectors.toList());

		return riskAssessments.stream()
				.collect(Collectors.groupingBy(ra -> ra.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));
	}

	public static void main(String[] args) {
		List<PolicyHolder> policyHolders = Arrays.asList(new PolicyHolder("H001", "Alice", 65, "Life", 40000),
				new PolicyHolder("H002", "Bob", 70, "Health", 30000),
				new PolicyHolder("H003", "Charlie", 66, "Life", 35000),
				new PolicyHolder("H004", "David", 75, "Life", 50000),
				new PolicyHolder("H005", "Eve", 62, "Auto", 20000),
				new PolicyHolder("H006", "Frank", 68, "Life", 33000));

		Map<String, List<RiskAssessment>> riskCategories = assessRisk(policyHolders);

		System.out.println("Risk Assessment Results:");
		riskCategories.forEach((riskCategory, assessments) -> {
			System.out.println(riskCategory + ":");
			assessments.forEach(System.out::println);
		});
	}
}

class PolicyHolder {
	private String holderId;
	private String name;
	private int age;
	private String policyType;
	private double premiumAmount;

	public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
		this.holderId = holderId;
		this.name = name;
		this.age = age;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
	}

	public String getHolderId() {
		return holderId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPolicyType() {
		return policyType;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}
}

class RiskAssessment {
	private String holderId;
	private String name;
	private double riskScore;

	public RiskAssessment(String holderId, String name, double riskScore) {
		this.holderId = holderId;
		this.name = name;
		this.riskScore = riskScore;
	}

	public String getHolderId() {
		return holderId;
	}

	public String getName() {
		return name;
	}

	public double getRiskScore() {
		return riskScore;
	}

	@Override
	public String toString() {
		return "HolderID: " + holderId + ", Name: " + name + ", Risk Score: " + riskScore;
	}
}
