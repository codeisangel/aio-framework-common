package cn.aio1024.framework.basic.integration.company;

import cn.aio1024.framework.basic.integration.company.domain.AioCompanyInfo;

/**
 * @author lizhenming
 * @desc: 企业
 * @date 2023/11/9 15:29
 */
public interface AioCompanyApi {
    AioCompanyInfo getCurrentCompany();
    AioCompanyInfo getByCompanyId(String companyId);
    AioCompanyInfo getByCreditCode(String creditCode);
}
