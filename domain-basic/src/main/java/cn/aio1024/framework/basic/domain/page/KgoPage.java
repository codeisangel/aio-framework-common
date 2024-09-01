package cn.aio1024.framework.basic.domain.page;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import lombok.Data;

import java.util.HashMap;

/**
 * @author lizhenming
 * @desc: 分页参数
 * @date 2022/6/20 18:11
 */
@Data
public class KgoPage {
    private static final String PAGE_NUM = "pageNum";
    private static final String PAGE_SIZE = "pageSize";

    private Integer pageNum = 1;
    private Integer pageSize = 10;
    public void initPage(HashMap<String,Object> processQueryParams){
        if (ObjectUtil.isEmpty(processQueryParams)){
            return;
        }
        if (processQueryParams.containsKey(PAGE_NUM) && NumberUtil.isInteger(processQueryParams.get(PAGE_NUM).toString())){
            pageNum = NumberUtil.parseInt(processQueryParams.get(PAGE_NUM).toString());

        }
        if (processQueryParams.containsKey(PAGE_SIZE) && NumberUtil.isInteger(processQueryParams.get(PAGE_SIZE).toString())){
            pageSize = NumberUtil.parseInt(processQueryParams.get(PAGE_SIZE).toString());
        }
    }
}
