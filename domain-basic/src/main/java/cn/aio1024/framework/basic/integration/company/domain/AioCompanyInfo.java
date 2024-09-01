package cn.aio1024.framework.basic.integration.company.domain;

import cn.hutool.core.util.ObjectUtil;

import java.util.HashMap;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/11/9 15:30
 */
public class AioCompanyInfo extends HashMap<String,Object> {
    private static class FieldDefinition{
        public static final String CREDIT_CODE = "creditCode";
        public static final String COMPANY_ID = "companyId";
        public static final String COMPANY_NAME = "companyName";
        public static final String COMPANY_TYPE = "companyType";
        public static final String LEGAL_NAME = "legalName";
        public static final String LEGAL_CARD_ID = "legalCardId";
        public static final String LEGAL_PHONE = "legalPhone";
        public static final String AUTHENTICATION = "authentication";
    }
    public void setAuthentication(Boolean authentication){
        put(FieldDefinition.AUTHENTICATION,authentication);
    }
    public Boolean getAuthentication(){
        if (this.containsKey(FieldDefinition.AUTHENTICATION)) {
            if (ObjectUtil.isNull(this.get(FieldDefinition.AUTHENTICATION))){
                return null;
            }
            return (Boolean) this.get(FieldDefinition.AUTHENTICATION);
        }
        return null;
    }
    public void setLegalCardPhone(String legalPhone){
        put(FieldDefinition.LEGAL_PHONE,legalPhone);
    }
    public String getLegalCardPhone(){
        if (this.containsKey(FieldDefinition.LEGAL_PHONE)) {
            if (ObjectUtil.isNull(this.get(FieldDefinition.LEGAL_PHONE))){
                return null;
            }
            return this.get(FieldDefinition.LEGAL_PHONE).toString();
        }
        return null;
    }
    public void setLegalCardId(String creditCode){
        put(FieldDefinition.LEGAL_CARD_ID,creditCode);
    }
    public String getLegalCardId(){
        if (this.containsKey(FieldDefinition.LEGAL_CARD_ID)) {
            if (ObjectUtil.isNull(this.get(FieldDefinition.LEGAL_CARD_ID))){
                return null;
            }
            return this.get(FieldDefinition.LEGAL_CARD_ID).toString();
        }
        return null;
    }
    public void setLegalCardName(String creditCode){
        put(FieldDefinition.LEGAL_NAME,creditCode);
    }
    public String getLegalCardName(){
        if (this.containsKey(FieldDefinition.LEGAL_NAME)) {
            if (ObjectUtil.isNull(this.get(FieldDefinition.LEGAL_NAME))){
                return null;
            }
            return this.get(FieldDefinition.LEGAL_NAME).toString();
        }
        return null;
    }

    public void setCompanyType(String creditCode){
        put(FieldDefinition.COMPANY_TYPE,creditCode);
    }
    public String getCompanyType(){
        if (this.containsKey(FieldDefinition.COMPANY_TYPE)) {
            if (ObjectUtil.isNull(this.get(FieldDefinition.COMPANY_TYPE))){
                return null;
            }
            return this.get(FieldDefinition.COMPANY_TYPE).toString();
        }
        return null;
    }
    public void setCreditCode(String creditCode){
        put(FieldDefinition.CREDIT_CODE,creditCode);
    }
    public String getCreditCode(){
        if (this.containsKey(FieldDefinition.CREDIT_CODE)) {
            if (ObjectUtil.isNull(this.get(FieldDefinition.CREDIT_CODE))){
                return null;
            }
            return this.get(FieldDefinition.CREDIT_CODE).toString();
        }
        return null;
    }
    public void setCompanyName(String companyName){
        put(FieldDefinition.COMPANY_NAME,companyName);
    }
    public String getCompanyName(){
        if (this.containsKey(FieldDefinition.COMPANY_NAME)) {
            if (ObjectUtil.isNull(this.get(FieldDefinition.COMPANY_NAME))){
                return null;
            }
            return this.get(FieldDefinition.COMPANY_NAME).toString();
        }
        return null;
    }
    public void setCompanyId(String companyId){
        put(FieldDefinition.COMPANY_ID,companyId);
    }
    public String getCompanyId(){
        if (this.containsKey(FieldDefinition.COMPANY_ID)) {
            if (ObjectUtil.isNull(this.get(FieldDefinition.COMPANY_ID))){
                return null;
            }
            return this.get(FieldDefinition.COMPANY_ID).toString();
        }
        return null;
    }
}
