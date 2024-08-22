package com.prod.GenZ.service.updownload;//package com.pfa.restapi.service.updownload;
//
//import com.pfa.restapi.model.fetchData.FileBase64;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UploadDownloadService {
//    private static final String path = "/home/user/Desktop/files";
//
//    public List<String> uploadFile(MultipartFile file)
//            throws Exception {
//
//        // Save file on system
//        if (!file.getOriginalFilename().isEmpty()) {
//
//            BufferedOutputStream outputStream =
//                    new BufferedOutputStream(
//                            new FileOutputStream(new File(path,
//                                    file.getOriginalFilename())));
//
//            outputStream.write(file.getBytes());
//            outputStream.flush();
//            outputStream.close();
//
//        } else {
//            throw new Exception();
//        }
//
//        List<String> list = new ArrayList<>();
//        File files = new File(path);
//        String[] fileList = files.list();
//        for (String name : fileList) {
//            list.add(name);
//        }
//
//        return list;
//
//    }
//
//    public List<String> getListofFiles() throws Exception {
//
//        List<String> list = new ArrayList<String>();
//        File files = new File(path);
//        String[] fileList = ((File) files).list();
//        for (String name : fileList) {
//            list.add(name);
//        }
//
//        return list;
//
//    }
//
//
//    public String uploadFile64Base(FileBase64 fileBase64){
//        ClassLoader classLoader = getClass().getClassLoader();
//
//        File file = new File(classLoader.getResource("depot/users_oictures/").getFile() + "/test.xml");
//        byte[] data = Base64.decodeBase64(fileBase64.getBase64File());
//        try (OutputStream stream = new FileOutputStream("path to file ")) {
//            stream.write(data);
//            return
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}