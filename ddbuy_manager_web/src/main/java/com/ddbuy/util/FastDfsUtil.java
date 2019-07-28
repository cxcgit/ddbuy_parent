package com.ddbuy.util;


import org.csource.fastdfs.*;


/**
 * @author caixincheng
 * @Classname FastDfsUtil
 * @Date 2019-07-22 18:38
 * @Created by cxc
 */
public class FastDfsUtil {
    private static final String fastDfsPath="fastdfs.properties";//定义配置文件路径为静态常量
    private static StorageClient storageClient=null;
    //静态代码块获取StorageClient 对象
    static {
        try {
            //1.加载配置文件
            ClientGlobal.init(fastDfsPath);
            // 2、创建一个 TrackerClient 对象。直接 new 一个。
            TrackerClient trackerClient = new TrackerClient();
            // 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
            TrackerServer trackerServer = trackerClient.getConnection();
            // 4、创建一个 StorageServer 的引用，值为 null
            StorageServer storageServer = null;
            // 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
            storageClient = new StorageClient(trackerServer, storageServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 文件上传
     * @param bytes   文件转化的字节数组
     * @param extName 文件扩展名
     * @return 字符串数组 非null上传成功 null上传失败
     */
    public static String[] upLoad(byte[] bytes,String extName) {
        // 6、使用 StorageClient 对象上传图片。
        try {
            if (storageClient!=null){
                String[] strings = storageClient.upload_file(bytes, extName,null);
                return strings;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件删除
     * @param groupName 组名
     * @param filePath  文件路径
     * @return 整型 0代表成功删除  其他删除失败
     */
    public static int delete(String groupName,String filePath){
        int i=-1;
        // 6、使用 StorageClient 对象上传图片。
        try {
            if (storageClient!=null){
                i = storageClient.delete_file(groupName, filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
