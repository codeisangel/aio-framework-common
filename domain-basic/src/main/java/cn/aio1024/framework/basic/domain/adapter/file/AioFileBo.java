package cn.aio1024.framework.basic.domain.adapter.file;

import lombok.Data;

/**
 * @author lzm
 * @desc 文件信息
 * @date 2024/03/06
 */
@Data
public class AioFileBo {
    /**
     * 文件ID
     */
    private String fileId;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件MD5
     */
    private String md5;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件类型，文件扩展名
     */
    private String type;
    /**
     * 访问令牌
     */
    private String permanentTicket;
}
