package cn.aio1024.aio.framework.basic.spring.discover;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.aio1024.framework.basic.domain.amis.AmisResult;
import cn.aio1024.framework.basic.discover.AioDiscover;
import cn.aio1024.framework.basic.discover.domain.ModuleDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhenming
 * @desc:
 * @date 2023/12/1 18:38
 */
@RestController
@RequestMapping("aio/framework/discover")
public class AioDiscoverController {
    @GetMapping("module/list")
    public AmisResult getModules(){
        List<ModuleDetails> moduleDetails = new ArrayList<>();
        String[] beanNamesForType = SpringUtil.getBeanNamesForType(AioDiscover.class);
        if (ObjectUtil.isEmpty(beanNamesForType)){
            return AmisResult.success(moduleDetails);
        }
        for (String beanName : beanNamesForType) {
            AioDiscover bean = SpringUtil.getBean(beanName, AioDiscover.class);
            moduleDetails.add(bean.getDetails());
        }
        return AmisResult.success(moduleDetails);
    }
}
