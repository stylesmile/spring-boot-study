package com.futve.common.tools;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author chenye
 */
public class FileUtil {

    public static void copy(InputStream input, OutputStream os) {
        try {
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                input.close();
                os.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    /**
     * MultipartFile 转 File
     *
     * @param file
     * @throws Exception
     */
    public static void multipartFileToFile(@RequestParam MultipartFile file) throws Exception {
        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
    }

    /**
     * File 转 MultipartFile
     *
     * @param file
     * @throws Exception
     */
//    public static void fileToMultipartFile(File file) throws Exception {
//        FileInputStream fileInput = new FileInputStream(file);
//        MultipartFile toMultipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
//                IOUtils.toByteArray(fileInput));
//        toMultipartFile.getInputStream();
//    }

    /**
     * InputStream 转 File
     *
     * @param ins
     * @param file
     */
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static InputStream multipartFileToInputStream(MultipartFile sourceFile) throws IOException {
        InputStream inputStream = null;
        File file = null;
        file = File.createTempFile("temp", null);
        //sourceFile为传入的MultipartFile
        sourceFile.transferTo(file);
        inputStream = new FileInputStream(file);
        file.deleteOnExit();
        return inputStream;
    }
}