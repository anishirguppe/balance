package com.balance.hib.bean;
// Generated 24 Jul, 2012 10:36:07 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserDetails generated by hbm2java
 */
public class UserDetails  implements java.io.Serializable {


     private Integer userId;
     private String userName;
     private String userProfileName;
     private Date userDob;
     private String userGender;
     private Integer userRelevantId;
     private String userAddress;
     private String marriedStatus;
     private String noOfChild;

    public Set getTransfers() {
        return transfers;
    }

    public void setTransfers(Set transfers) {
        this.transfers = transfers;
    }
 private Set transfers = new HashSet(0);
 
     private String password;  
  
     private String mobileNo;
     private String mailId;
     private Set<IncomeEntry> incomeEntries = new HashSet<IncomeEntry>(0);
     private Set<UserAccountDetails> userAccountDetailses = new HashSet<UserAccountDetails>(0);
     private Set<ExpenseEntry> expenseEntries = new HashSet<ExpenseEntry>(0);
     
     
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public UserDetails() {
    }

	
    public UserDetails(String userName) {
        this.userName = userName;
    }
    public UserDetails(String userName, String userProfileName, Date userDob, String userGender, Integer userRelevantId, String userAddress, String marriedStatus, String noOfChild, Set<IncomeEntry> incomeEntries, Set<UserAccountDetails> userAccountDetailses, Set<ExpenseEntry> expenseEntries) {
       this.userName = userName;
       this.userProfileName = userProfileName;
       this.userDob = userDob;
       this.userGender = userGender;
       this.userRelevantId = userRelevantId;
       this.userAddress = userAddress;
       this.marriedStatus = marriedStatus;
       this.noOfChild = noOfChild;
       this.incomeEntries = incomeEntries;
       this.userAccountDetailses = userAccountDetailses;
       this.expenseEntries = expenseEntries;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserProfileName() {
        return this.userProfileName;
    }
    
    public void setUserProfileName(String userProfileName) {
        this.userProfileName = userProfileName;
    }
    public Date getUserDob() {
        return this.userDob;
    }
    
    public void setUserDob(Date userDob) {
        this.userDob = userDob;
    }
    public String getUserGender() {
        return this.userGender;
    }
    
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    public Integer getUserRelevantId() {
        return this.userRelevantId;
    }
    
    public void setUserRelevantId(Integer userRelevantId) {
        this.userRelevantId = userRelevantId;
    }
    public String getUserAddress() {
        return this.userAddress;
    }
    
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public String getMarriedStatus() {
        return this.marriedStatus;
    }
    
    public void setMarriedStatus(String marriedStatus) {
        this.marriedStatus = marriedStatus;
    }
    public String getNoOfChild() {
        return this.noOfChild;
    }
    
    public void setNoOfChild(String noOfChild) {
        this.noOfChild = noOfChild;
    }
    public Set<IncomeEntry> getIncomeEntries() {
        return this.incomeEntries;
    }
    
    public void setIncomeEntries(Set<IncomeEntry> incomeEntries) {
        this.incomeEntries = incomeEntries;
    }
    public Set<UserAccountDetails> getUserAccountDetailses() {
        return this.userAccountDetailses;
    }
    
    public void setUserAccountDetailses(Set<UserAccountDetails> userAccountDetailses) {
        this.userAccountDetailses = userAccountDetailses;
    }
    public Set<ExpenseEntry> getExpenseEntries() {
        return this.expenseEntries;
    }
    
    public void setExpenseEntries(Set<ExpenseEntry> expenseEntries) {
        this.expenseEntries = expenseEntries;
    }




}


