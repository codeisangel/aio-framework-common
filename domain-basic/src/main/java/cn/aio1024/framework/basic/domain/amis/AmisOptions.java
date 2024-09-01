package cn.aio1024.framework.basic.domain.amis;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lizhenming
 * @desc:
 * @date 2022/4/15 9:25
 */
@Data
public class AmisOptions<T> {
    private List<AmisOption<T>> options = new ArrayList<>();

    public void addOption(String key,T value){
        options.add(new AmisOption(key,value));
    }
    public void addOption(String key,String value){
        options.add(new AmisOption(key,value));
    }

    public void addOption(String key,T value,Boolean selected){
        options.add(new AmisOption(key,value,selected));
    }



    public static AmisOptions listToOptions(List<String> itemList){
        AmisOptions amisOptions = new AmisOptions();
        if (ObjectUtil.isEmpty(itemList)){
            return amisOptions;
        }
        for (String item :itemList) {
            amisOptions.getOptions().add(new AmisOption(item));
        }
        return amisOptions;
    }

    public static AmisOptions MapToOptions(Map<String,String> map){
        AmisOptions amisOptions = new AmisOptions();
        if (ObjectUtil.isEmpty(map)){
            return amisOptions;
        }
        for (String key :map.keySet()) {
            amisOptions.getOptions().add(new AmisOption(map.get(key),key));
        }
        return amisOptions;
    }
}
