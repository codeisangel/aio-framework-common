package cn.aio1024.framework.basic.integration.user.domain;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import cn.aio1024.framework.basic.integration.user.enums.UserIdentityEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author lizhenming
 * @desc: 抽象的用户对象
 * @date 2023/6/19 16:10
 */

public class AioUser extends HashMap<String, String> {
    private static class FieldDefinition{
        public static final String USER_ID = "userId";
        public static final String USER_NAME = "userName";
        public static final String IDENTITY = "identity";
        public static final String REAL_NAME="realName";
        /**
         * 证件号
         */
        public static final String CARD_ID = "cardId";
        /**
         * 证件类型
         */
        public static final String CARD_TYPE = "cardType";
        public static final String ROLES = "roles";
        public static final String COMPANY_ID = "companyId";
        private static final String CREDIT_CODE ="creditCode";
        public static final String TERMINAL = "terminal";
        public static final String COMPANY_NAME = "companyName";
    }
    public static AioUser builder(){
        return new AioUser();
    }

    public  Boolean hasRole(String role){
        if (!this.containsKey(FieldDefinition.ROLES)) {
            return false;
        }
        String roles = get(FieldDefinition.ROLES);
        List<String> roleList = JSONArray.parseArray(roles,String.class);
        if (ObjectUtil.isEmpty(roleList)){
            return false;
        }
        return roleList.contains(role);
    }

    public void setRoles(List<String> roleList){
        if (ObjectUtil.isEmpty(roleList)){
            return;
        }
        this.put(FieldDefinition.ROLES, JSON.toJSONString(roleList));
    }
    public List<String> getRoles(){
        if (!this.containsKey(FieldDefinition.ROLES)) {
            return new ArrayList<>();
        }
        String roles = get(FieldDefinition.ROLES);
        List<String> roleList = JSONArray.parseArray(roles,String.class);
        if (ObjectUtil.isEmpty(roleList)){
            return new ArrayList<>();
        }
        return roleList;
    }

    public void addRole(String ... roles){
        List<String> roleList = getRoles();
        roleList.addAll(Arrays.asList(roles));
        this.put(FieldDefinition.ROLES, JSON.toJSONString(roleList));
    }

    public void setTerminal(String terminal){
        this.put(FieldDefinition.TERMINAL,terminal);
    }
    public AioUser terminal(String terminal){
        this.put(FieldDefinition.TERMINAL,terminal);
        return this;
    }
    public String getTerminal(){
        if (this.containsKey(FieldDefinition.TERMINAL)) {
            return this.get(FieldDefinition.TERMINAL);
        }
        return null;
    }

    public void setUserId(String userId){
        this.put(FieldDefinition.USER_ID,userId);
    }
    public AioUser userId(String userId){
        this.put(FieldDefinition.USER_ID,userId);
        return this;
    }
    public String getUserId(){
        if (this.containsKey(FieldDefinition.USER_ID)) {
            return this.get(FieldDefinition.USER_ID);
        }
        return null;
    }




    public void setUserName(String userName){
        this.put(FieldDefinition.USER_NAME,userName);
    }

    public AioUser userName(String userId){
        this.put(FieldDefinition.USER_NAME,userId);
        return this;
    }
    public String getUserName(){
        if (this.containsKey(FieldDefinition.USER_NAME)) {
            return this.get(FieldDefinition.USER_NAME);
        }
        return null;
    }

    public void setCompanyId(String companyId){
        this.put(FieldDefinition.COMPANY_ID,companyId);
    }
    public AioUser companyId(String companyId){
        this.put(FieldDefinition.COMPANY_ID,companyId);
        return this;
    }
    public String getCompanyId(){
        if (this.containsKey(FieldDefinition.COMPANY_ID)) {
            return this.get(FieldDefinition.COMPANY_ID);
        }
        return null;
    }

    /**
     * 企业社会信用代码
     * @param creditCode
     */
    public void setCreditCode(String creditCode){
        this.put(FieldDefinition.CREDIT_CODE,creditCode);
    }
    public AioUser creditCode(String creditCode){
        this.put(FieldDefinition.CREDIT_CODE,creditCode);
        return this;
    }
    public String getCreditCode(){
        if (this.containsKey(FieldDefinition.CREDIT_CODE)) {
            return this.get(FieldDefinition.CREDIT_CODE);
        }
        return null;
    }

    public void setCompanyName(String companyName){
        this.put(FieldDefinition.COMPANY_NAME,companyName);
    }
    public AioUser companyName(String companyName){
        this.put(FieldDefinition.COMPANY_NAME,companyName);
        return this;
    }
    public String getCompanyName(){
        if (this.containsKey(FieldDefinition.COMPANY_NAME)) {
            return this.get(FieldDefinition.COMPANY_NAME);
        }
        return null;
    }


    public void setIdentity(String identity){
        this.put(FieldDefinition.IDENTITY,identity);
    }
    public AioUser identity(String identity){
        this.put(FieldDefinition.IDENTITY,identity);
        return this;
    }
    public AioUser personIdentity(){
        this.put(FieldDefinition.IDENTITY, UserIdentityEnum.PERSON.getValue());
        return this;
    }
    public AioUser companyIdentity(){
        this.put(FieldDefinition.IDENTITY, UserIdentityEnum.COMPANY.getValue());
        return this;
    }
    public Boolean isCompany(){
        String identity = getIdentity();
        if (StringUtils.isBlank(identity)){
            return false;
        }
        if (UserIdentityEnum.COMPANY.eq(identity)){
            return true;
        }
        return false;
    }
    public String getIdentity(){
        if (this.containsKey(FieldDefinition.IDENTITY)) {
            return this.get(FieldDefinition.IDENTITY);
        }
        return null;
    }

    /**
     * 真实姓名
     * @param realName
     */
    public void setRealName(String realName){
        this.put(FieldDefinition.REAL_NAME,realName);
    }

    public AioUser realName(String realName){
        this.put(FieldDefinition.REAL_NAME,realName);
        return this;
    }
    public String getRealName(){
        if (this.containsKey(FieldDefinition.REAL_NAME)) {
            return this.get(FieldDefinition.REAL_NAME);
        }
        return null;
    }

    /**
     * 证件号
     * @param cardId
     */
    public void setCardId(String cardId){
        this.put(FieldDefinition.CARD_ID,cardId);
    }

    public AioUser cardId(String realName){
        this.put(FieldDefinition.CARD_ID,realName);
        return this;
    }
    public String getCardId(){
        if (this.containsKey(FieldDefinition.CARD_ID)) {
            return this.get(FieldDefinition.CARD_ID);
        }
        return null;
    }

    /**
     * 证件类型
     * @param cardType
     */
    public void setCardType(String cardType){
        this.put(FieldDefinition.CARD_TYPE,cardType);
    }

    public AioUser cardType(String cardType){
        this.put(FieldDefinition.CARD_TYPE,cardType);
        return this;
    }
    public String getCardType(){
        if (this.containsKey(FieldDefinition.CARD_TYPE)) {
            return this.get(FieldDefinition.CARD_TYPE);
        }
        return null;
    }
}
