package com.balance.hib.bean;
// Generated 24 Jul, 2012 10:36:07 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * BsSubHead generated by hbm2java
 */
public class BsSubHead  implements java.io.Serializable {


     private Integer bsSubHeadId;
     private BsHead bsHead;
     private String bsSubHeadName;
     private String bsSubHeadInitial;
     private Set<IncomeEntry> incomeEntries = new HashSet<IncomeEntry>(0);
     private Set<ExpenseEntry> expenseEntries = new HashSet<ExpenseEntry>(0);

    public BsSubHead() {
    }

	
    public BsSubHead(BsHead bsHead, String bsSubHeadName, String bsSubHeadInitial) {
        this.bsHead = bsHead;
        this.bsSubHeadName = bsSubHeadName;
        this.bsSubHeadInitial = bsSubHeadInitial;
    }
    public BsSubHead(BsHead bsHead, String bsSubHeadName, String bsSubHeadInitial, Set<IncomeEntry> incomeEntries, Set<ExpenseEntry> expenseEntries) {
       this.bsHead = bsHead;
       this.bsSubHeadName = bsSubHeadName;
       this.bsSubHeadInitial = bsSubHeadInitial;
       this.incomeEntries = incomeEntries;
       this.expenseEntries = expenseEntries;
    }
   
    public Integer getBsSubHeadId() {
        return this.bsSubHeadId;
    }
    
    public void setBsSubHeadId(Integer bsSubHeadId) {
        this.bsSubHeadId = bsSubHeadId;
    }
    public BsHead getBsHead() {
        return this.bsHead;
    }
    
    public void setBsHead(BsHead bsHead) {
        this.bsHead = bsHead;
    }
    public String getBsSubHeadName() {
        return this.bsSubHeadName;
    }
    
    public void setBsSubHeadName(String bsSubHeadName) {
        this.bsSubHeadName = bsSubHeadName;
    }
    public String getBsSubHeadInitial() {
        return this.bsSubHeadInitial;
    }
    
    public void setBsSubHeadInitial(String bsSubHeadInitial) {
        this.bsSubHeadInitial = bsSubHeadInitial;
    }
    public Set<IncomeEntry> getIncomeEntries() {
        return this.incomeEntries;
    }
    
    public void setIncomeEntries(Set<IncomeEntry> incomeEntries) {
        this.incomeEntries = incomeEntries;
    }
    public Set<ExpenseEntry> getExpenseEntries() {
        return this.expenseEntries;
    }
    
    public void setExpenseEntries(Set<ExpenseEntry> expenseEntries) {
        this.expenseEntries = expenseEntries;
    }




}


