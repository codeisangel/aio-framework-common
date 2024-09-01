package cn.aio1024.framework.basic.integration.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/11/29 11:41
 */
@Getter
@AllArgsConstructor
public enum  UserIdentityEnum {
    /**  身份   */
    PERSON("person","个人"),
    COMPANY("company","企业");
    private String value;
    private String desc;
    public Boolean eq(String status){
        return StringUtils.equals(status,this.value);
    }
}
