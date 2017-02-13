package com.example.demo.batch;

import java.util.Date;

/**
 * Created by jesse on 2017/2/13.
 */
public class CompanyEntity {
    private String companyName;
    private String province;
    private Date establishDate;
    private String companyType;
    private String legalPerson;
    private String companyAddress;

    public CompanyEntity(String companyName, String province, Date establishDate, String companyType, String legalPerson, String companyAddress) {
        this.companyName = companyName;
        this.province = province;
        this.establishDate = establishDate;
        this.companyType = companyType;
        this.legalPerson = legalPerson;
        this.companyAddress = companyAddress;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

}
