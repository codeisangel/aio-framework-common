package cn.aio1024.framework.basic.discover;

import cn.aio1024.framework.basic.discover.domain.ModuleDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author lizhenming
 * @desc: 模块发现管理
 * @date 2023/12/1 16:50
 */
public class GovernModuleDiscover {
    public List<ModuleDetails> getModules() {
        List<ModuleDetails> moduleDetails = new ArrayList<>();
        ServiceLoader<AioDiscover> serviceLoader = ServiceLoader.load(AioDiscover.class);

        Iterator<AioDiscover> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            AioDiscover search = iterator.next();
            moduleDetails.add(search.getDetails());
        }
        return moduleDetails;
    }
}
