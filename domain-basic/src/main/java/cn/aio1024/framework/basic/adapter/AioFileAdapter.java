package cn.aio1024.framework.basic.adapter;


import cn.aio1024.framework.basic.domain.adapter.file.AioFileBo;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author lzm
 * @desc 签署服务API接口
 * @date 2024/02/27
 */
public interface AioFileAdapter {
    String saveFileToLocal(String fileId);
    AioFileBo getFileInfo(String fileId);
    byte[] downloadByte(String fileId);
    AioFileBo upload(File file,String business);

    /**
     * 通过二进制流上传
     * @param bytes 二进制
     * @param fileName 文件名
     * @param business 业务标识
     * @return
     */
    AioFileBo upload4Byte(byte[] bytes ,String fileName,String business);

    /**
     * 通过base64 上传
     * @param base64
     * @param fileName 文件名
     * @param business 业务模块
     * @return
     */
    AioFileBo upload4Base64(String base64 ,String fileName,String business);
    AioFileBo update(String id, File file);
    AioFileBo update4Byte(String id, byte[] bytes ,String fileName);
    AioFileBo update4Base64(String id, String base64 ,String fileName);
    boolean delete(String fileId);

    String downloadUrl(String fileId);
    Map<String, String> batchDownloadUrl(List<String> fileIds);
}
