package com.futve.common.tools.altools;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.File;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author chenye
 * @date 2020-0406
 */
public class OssFileUtilTest {

    public static void main(String a) {

    }

    public static void main2(String[] args) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GBjKiMZ7PpdKkSXUdvS";
        String accessKeySecret = "oMoqLQoXLi6uTeSELQL9p2LOTsVNZd";
        String bucketName = "wykjdata";
        String KeyPrefix = "20191227";

//        // 创建OSSClient实例
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        // 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
//        ObjectListing objectListing = ossClient.listObjects(bucketName, KeyPrefix);
//        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
//        for (OSSObjectSummary s : sums) {
//            System.out.println("file::::>>>>>>>>>>>>>>>"+"\t" + s.getKey());
//        }

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 设置最大个数。
        final int maxKeys = 500;
        // 列举文件。
        ObjectListing objectListing = ossClient.listObjects(
                new ListObjectsRequest(bucketName)
                        .withMaxKeys(maxKeys)
                        .withPrefix("Multiplelanguages/")
        );
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("file::::>>>>>>>>>>>>>>>" + "\t" + s.getKey());
        }

        // 关闭OSSClient。
        ossClient.shutdown();

    }

    public static void main(String[] args) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        //String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        String endpoint = "http://oss.hongkong.futve.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GBjKiMZ7PpdKkSXUdvS";
        String accessKeySecret = "oMoqLQoXLi6uTeSELQL9p2LOTsVNZd";
        String bucketName = "wykjdata";
        String KeyPrefix = "20191227";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String fileName = "D:\\code3.zip";
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 生成上传文件名
        String finalFileName = System.currentTimeMillis() + "" + new SecureRandom().nextInt(0x0400) + suffixName;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String objectName = "test/" + sdf.format(new Date()) + "/" + finalFileName;

        // 创建PutObjectRequest对象。
        //PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "oss://wykjdata/test/0114//code3.zip", new File("D:\\code3.zip"));
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new File(fileName));

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
}

//需要的jar
/*
<dependency>
    <groupId>com.aliyun.oss</groupId>
    <artifactId>aliyun-sdk-oss</artifactId>
    <version>3.8.0</version>
</dependency>
*/
