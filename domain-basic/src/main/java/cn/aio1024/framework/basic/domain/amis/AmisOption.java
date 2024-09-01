package cn.aio1024.framework.basic.domain.amis;

import lombok.Data;

/**
 * @author lizhenming
 * @desc:
 * @date 2022/4/15 9:25
 */
@Data
public class AmisOption<T> {
    private String label;
    private T value;
    /**  是否被选择  */
    private Boolean selected;
    public AmisOption(){

    }
    public AmisOption(T value){
        this.label = value.toString();
        this.value = value;
    }
    public AmisOption(String label, T value){
        this.label = label;
        this.value = value;
    }
    public AmisOption(String label, T value, Boolean selected){
        this.label = label;
        this.value = value;
        this.selected = selected;
    }
}
