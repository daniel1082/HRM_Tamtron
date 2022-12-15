package com.hrm.genericUtility;

/**
 * This enum is used to store property file keys
 * @author daniel
 *
 */
public enum PropertyFileKeys {
	BROWSER("browser"),URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("timeout"),
	RANDOM_NUMBER_LIMIT("randomNumberLimit"),
	EMPLOYEENAME("employeeName"),
	USERNAMEOFFICER("usernameofficer"), PASSWORDOFFICER("passwordofficer"), COMPID("compID"),FIRSTNAME("FistName"),LASTNAME("LastName"), MIDDLENAME("MiddleName"),
	BRANCHDATE("BranchDate"),RECENTBRANCHDATE("RecentBranchDate");
	private String keys;

	private PropertyFileKeys(String keys) {
		this.keys=keys;
	}
	
	public String convertToString() {
		return keys.toString();
	}

}
