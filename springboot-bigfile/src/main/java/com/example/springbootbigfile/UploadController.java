package com.example.springbootbigfile;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Controller
public class UploadController{
	
	@Value("${uploadFolder}")
	private String filePath;

	private  final String MODEL="upload";
	/**
	 * 上传文件
	 * @param request
	 * @param response
	 * @param guid
	 * @param chunk
	 * @param file
	 * @param chunks
	 */
	@RequestMapping( MODEL+ "/upload")
	public void bigFile(HttpServletRequest request, HttpServletResponse response, String guid, Integer chunk, MultipartFile file, Integer chunks){
		try {  
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
            if (isMultipart) {  
                // 临时目录用来存放所有分片文件  
                String tempFileDir = filePath + guid;  
                File parentFileDir = new File(tempFileDir);  
                if (!parentFileDir.exists()) {  
                    parentFileDir.mkdirs();  
                }  
                // 分片处理时，前台会多次调用上传接口，每次都会上传文件的一部分到后台  
                File tempPartFile = new File(parentFileDir, guid + "_" + chunk + ".part");  
                FileUtils.copyInputStreamToFile(file.getInputStream(), tempPartFile);  
            }  
        } catch (Exception e) {  
        	e.printStackTrace();
        }  
	}
	
	/**
	 * 合并文件
	 * @param guid
	 * @param fileName
	 * @throws Exception
	 */
	@RequestMapping( MODEL+"/merge")
	@ResponseBody
	public JsonResult mergeFile(String guid,String fileName){
		 // 得到 destTempFile 就是最终的文件  
		try {
			File parentFileDir = new File(filePath + guid);
			if(parentFileDir.isDirectory()){
				File destTempFile = new File(filePath + "/merge", fileName);
				if(!destTempFile.exists()){
					//先得到文件的上级目录，并创建上级目录，在创建文件,
					destTempFile.getParentFile().mkdir();
					try {
						//创建文件
						destTempFile.createNewFile(); //上级目录没有创建，这里会报错
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println(parentFileDir.listFiles().length);
		        for (int i = 0; i < parentFileDir.listFiles().length; i++) {  
		            File partFile = new File(parentFileDir, guid + "_" + i + ".part");
		            FileOutputStream destTempfos = new FileOutputStream(destTempFile, true);
		            //遍历"所有分片文件"到"最终文件"中  
		            FileUtils.copyFile(partFile, destTempfos);  
		            destTempfos.close();  
		        }  
		        // 删除临时目录中的分片文件  
		        FileUtils.deleteDirectory(parentFileDir);
		        return JsonResult.success();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail();
		}
		return null;
	}

}
