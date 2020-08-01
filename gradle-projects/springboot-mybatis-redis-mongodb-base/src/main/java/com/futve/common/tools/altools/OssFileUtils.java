package com.futve.common.tools.altools;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectRequest;
import com.futve.common.tools.FileUtil;
import com.futve.common.tools.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenye
 * @date 2020-0406
 */
@Slf4j
public class OssFileUtils {

    /**
     * Endpoint以北京为例，其它Region请按实际情况填写。
     */
    private static final String ENDPOINT = "http://oss-cn-beijing.aliyuncs.com";
    /**
     * 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
     */
    @Value("${ali.oss.smsSccessKeyId}")
    private static String ACCESS_KEY_ID = "LTAI4GBjKiMZ7PpdKkSXUdvS";
    @Value("${ali.oss.accessSecret}")
    private static String ACCESS_KEY_SECRET = "oMoqLQoXLi6uTeSELQL9p2LOTsVNZd";
    @Value("${ali.oss.bucketName}")
    private static String BUCKET_NAME = "wykjdata";

    /**
     * 根据url查询 oss文件是否存在
     *
     * @param filepath 文件路径
     * @return Boolean
     */
    public static Boolean fileExistByUrl(String filepath) throws IOException {
        String[] pathlist;
        if (filepath.contains("wykjdata.oss-cn-beijing.aliyuncs.com/")) {
            pathlist = filepath.split("wykjdata.oss-cn-beijing.aliyuncs.com/");
        } else {
            pathlist = filepath.split("oss.futve.com/");
        }

        if (pathlist.length > 1) {
            return fileExist(pathlist[1]);
        } else {
            return UrlUtil.isGetUrlTrue(filepath);
        }
    }

    /**
     * 验证文件是否存在
     *
     * @param filepath 文件路径 例如 /APP/2D全景标注视频.mp4
     * @return Boolean
     */
    public static Boolean fileExist(String filepath) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 判断文件是否存在。doesObjectExist还有一个参数isOnlyInOSS，如果为true则忽略302重定向或镜像；如果
        //为false，则考虑302重定向或镜像。
        boolean found = ossClient.doesObjectExist(BUCKET_NAME, filepath);
        log.debug(filepath + ">>>" + String.valueOf(found));
        // 关闭OSSClient。
        ossClient.shutdown();
        return found;
    }

    /**
     * 查询文件文件夹下面所有文件，
     *
     * @param prefix  文件前缀
     * @param maxKeys 文件个数 最大一千个
     * @return CopyOnWriteArrayList
     */
    public static CopyOnWriteArrayList<String> queryOSSFileListByPrefix(String prefix, int maxKeys) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 列举文件。
        ObjectListing objectListing = ossClient.listObjects(
                new ListObjectsRequest(BUCKET_NAME)
                        .withMaxKeys(maxKeys)
                        .withPrefix(prefix)
        );

        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            list.add(s.getKey());
            //System.out.println("file::::>>>>>>>>>>>>>>>" + "\t" + s.getKey());
        }
        // 关闭OSSClient。
        ossClient.shutdown();
        // 关闭OSSClient。
        ossClient.shutdown();
        return list;
    }


    /**
     * 查询文件文件夹下面所有文件，
     *
     * @param prefix  文件前缀
     * @param maxKeys 文件个数 最大一千个
     * @return CopyOnWriteArrayList
     */
    public static CopyOnWriteArrayList<String> queryPageOSSFileListByPrefix(String prefix, int maxKeys) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        String nextMarker = null;
        ObjectListing objectListing;

        do {
            objectListing = ossClient.listObjects(new ListObjectsRequest(BUCKET_NAME).withMarker(nextMarker).withMaxKeys(maxKeys));

            List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
            for (OSSObjectSummary s : sums) {
                list.add(s.getKey());
                System.out.println("\t" + s.getKey());
            }
            nextMarker = objectListing.getNextMarker();

        } while (objectListing.isTruncated());
        // 关闭OSSClient。
        ossClient.shutdown();
        return list;
    }

    public static void test() {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 构造ListObjectsRequest请求。
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(BUCKET_NAME);
        // 设置prefix参数来获取fun目录下的所有文件。
        listObjectsRequest.setPrefix("Multiplelanguages/乌尔都语-4400句-20191208-传平台/Urdu-004/");
        listObjectsRequest.setMaxKeys(1100);
        // 递归列出fun目录下的所有文件。
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);
        // 遍历所有文件。
        System.out.println("Objects:");
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            System.out.println(objectSummary.getKey());
        }

        // 遍历所有commonPrefix。
        System.out.println("\nCommonPrefixes:");
        for (String commonPrefix : listing.getCommonPrefixes()) {
            System.out.println(commonPrefix);
        }

    }

    public static void uploadMultipartFile(MultipartFile multipartFile, String filePathName) throws IOException {
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        // 创建PutObjectRequest对象。
        //PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "oss://wykjdata/test/0114//code3.zip", new File("D:\\code3.zip"));
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, filePathName, FileUtil.multipartFileToInputStream(multipartFile));
        // 上传文件
        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    private static void uploadFile(File file, String filePathName) {

        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        // 创建PutObjectRequest对象。
        //PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "/test/0114//code3.zip", new File("D:\\code3.zip"));
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, filePathName, file);

        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        // 上传文件
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 测试代码
     */
    public static void main(String[] args) throws IOException {
//        System.out.println(fileExistByUrl("http://oss.futve.com/Multiple languages/Danish/2020/02/0219/DA-303_255.wav"));
//        System.out.println(fileExist("wechat测试数据2020-0304__1083.wav"));
//        System.out.println(fileExist("APP/2D全景标注视频.mp4"));
//        System.out.println(fileExist("APP/2D全景标注视频1.mp4"));
//        System.out.println(queryOSSFileListByPrefix("test/", 500));
//        System.out.println(queryPageOSSFileListByPrefix("test/", 500));
        test();
    }
}
