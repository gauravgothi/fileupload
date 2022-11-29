package com.gaurav.boot.restapi.image.imageupload.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

@Component
public class FileUploadHelper {
//    public final String UPLOAD_DIR="C:\\Users\\HP\\IdeaProjects\\imageupload\\src\\main\\resources\\static\\image";
public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean uploadFile(MultipartFile file)   {
        boolean success = false;
        try {
//            InputStream inputStream=file.getInputStream();
//            byte[] data = new byte[inputStream.available()];
//            inputStream.read(data);
//
//            //writing of file
//            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + "\\" + file.getOriginalFilename());
//            fileOutputStream.write(data);
//
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            success=true;

            //nio package is alternative of this traditional file upload approch
            Files.copy(file.getInputStream(), Path.of(UPLOAD_DIR+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            success =true;

        }catch(Exception exception){
            System.out.println(Arrays.toString(exception.getStackTrace()));
        }
        return success;
    }
}

