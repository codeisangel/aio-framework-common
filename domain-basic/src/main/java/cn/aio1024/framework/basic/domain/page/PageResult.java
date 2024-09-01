package cn.aio1024.framework.basic.domain.page;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author lizhenming
 * @desc:
 * @date 2022/5/25 18:00
 */
@Data
@AllArgsConstructor
public class PageResult<T> {
    private List<T> list;
    private long total;
    public PageResult(){}
}
