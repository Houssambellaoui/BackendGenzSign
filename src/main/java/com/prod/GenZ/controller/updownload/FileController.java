package com.prod.GenZ.controller.updownload;

import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@CrossOrigin(origins = "*", maxAge = 3600)
@Data
//@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/ncn/files/")
@RestController
public class FileController {
    //    @Autowired
//    private ResourceLoader resourceLoader;
    // private static final String baseDirectory = "src/main/resources";
    private static final String baseDirectory = "src/main/resources/public/";

    private static final String usersPicturesDirectory = "users_pictures/";
    private static final String usersSignaturesDirectory = "signatures/";
    private static final String documentsDirectory = "docs/";
    // private static final String documentsDirectory = "";
    private static final String tamponsDirectory = "tampons/";
    private static final String facesDirectory = "faces/";

    @PostMapping(value = "/upload/{type}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(
            @RequestParam MultipartFile file,
            @PathVariable String type) {
        try {
            String fileName = file.getOriginalFilename();
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
            String uniqueFileName = "";

            Path directory = null;
            switch (type) {
                case "PDP" -> {
                    uniqueFileName = "pdp_" + System.currentTimeMillis() + fileExtension;
                    directory = Paths.get(baseDirectory + usersPicturesDirectory);
                }
                case "SIGN" -> {
                    uniqueFileName = "sign_" + System.currentTimeMillis() + fileExtension;
                    directory = Paths.get(baseDirectory + usersSignaturesDirectory);
                }
                case "TMP" -> {
                    uniqueFileName = "tmp_" + System.currentTimeMillis() + fileExtension;
                    directory = Paths.get(baseDirectory + tamponsDirectory);
                }
                case "POST_DOC_INIT" -> {
                    uniqueFileName = "doc_init_" + System.currentTimeMillis() + fileExtension;
                    directory = Paths.get(baseDirectory + documentsDirectory);
                }
                case "POST_DOC_FIN" -> {
                    uniqueFileName = "doc_fin_" + System.currentTimeMillis() + fileExtension;
                    directory = Paths.get(baseDirectory + documentsDirectory);
                }
                default -> throw new Exception("Path invalide");
            }

            Path filePath = directory.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), filePath);
            return ResponseEntity.ok(uniqueFileName);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/multiple-upload/{type}/{folder}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFiles(
            @RequestParam(name = "file") MultipartFile[] files,
            @PathVariable String type,
            @PathVariable String folder) {
        try {
            String fileName = "";
            String fileExtension = "";
            String uniqueFileName = "";
            folder = System.currentTimeMillis()+"";
            String folderToCreate = baseDirectory + facesDirectory + folder;

            Path directory = Paths.get(folderToCreate);
            switch (type) {
                case "FACES" -> {
                    try{
                        Files.createDirectories(directory);
                    } catch (FileAlreadyExistsException error){
                        return ResponseEntity.badRequest().body("FOLDER-ALREADY-EXISTS");
                    }

                    for(int i = 0; i < files.length; i++){
                        fileName = files[i].getOriginalFilename();
                        fileExtension = fileName.substring(fileName.lastIndexOf("."));
                        uniqueFileName = (i + 1) + fileExtension;
                        Path filePath = directory.resolve(uniqueFileName);
                        Files.copy(files[i].getInputStream(), filePath);
                    }
//                    directory = Paths.get(baseDirectory + usersPicturesDirectory);
                }
//                case "SIGN" -> {
//                    uniqueFileName = "sign_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory + usersSignaturesDirectory);
//                }
//                case "TMP" -> {
//                    uniqueFileName = "tmp_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory + tamponsDirectory);
//                }
//                case "POST_DOC_INIT" -> {
//                    uniqueFileName = "doc_init_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory + documentsDirectory);
//                }
//                case "POST_DOC_FIN" -> {
//                    uniqueFileName = "doc_fin_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory + documentsDirectory);
//                }
                default -> throw new Exception("Path invalide");
            }

            return ResponseEntity.ok(folder);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


}
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.nio.file.*;
//
////@CrossOrigin(origins = "*", maxAge = 3600)
//@Data
////@AllArgsConstructor
//@NoArgsConstructor
//@RequestMapping("/api/ncn/files/")
//@RestController
//public class FileController {
//    //    @Autowired
////    private ResourceLoader resourceLoader;
//    private static final String baseDirectory = "src/main/resources/";
//    private static final String usersPicturesDirectory = "users_pictures/";
//    private static final String usersSignaturesDirectory = "signatures/";
////    private static final String documentsDirectory = "docs/";
//    private static final String tamponsDirectory = "tampons/";
//    private static final String facesDirectory = "faces/";
//
//    @PostMapping(value = "/upload/{type}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<String> uploadFile(
//            @RequestParam MultipartFile file,
//            @PathVariable String type) {
//        try {
//
//            System.out.println(file.getOriginalFilename());
//            String fileName = file.getOriginalFilename();
//            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
//            String uniqueFileName = "";
//
//            Path directory = null;
//            switch (type) {
//                case "PDP" -> {
//                    uniqueFileName = "pdp_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory + usersPicturesDirectory);
//                }
//                case "SIGN" -> {
//                    uniqueFileName = "sign_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory + usersSignaturesDirectory);
//                }
//                case "TMP" -> {
//                    uniqueFileName = "tmp_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory + tamponsDirectory);
//                }
//                case "POST_DOC_INIT" -> {
//                    uniqueFileName= "test.pdf";
//
//                   // uniqueFileName = "doc_init_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory /*+ documentsDirectory*/);
//                }
//                case "POST_DOC_FIN" -> {
//                    uniqueFileName= "test.pdf";
//                   // uniqueFileName = "doc_fin_" + System.currentTimeMillis() + fileExtension;
//                    directory = Paths.get(baseDirectory /*+ documentsDirectory*/);
//                }
//                default -> throw new Exception("Path invalide");
//            }
//
//            Path filePath = directory.resolve(uniqueFileName);
////            Path filePath =Path.of("src\\main\\resources\\public\\docs\\").toAbsolutePath();
//        //  Files.copy(file.getInputStream(), Path.of("src\\main\\resources\\public\\docs\\"));
//           Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//       //    Path path = Paths.get("src/test/resources");
////            byte[] buffer = java.nio.file.Files.readAllBytes(path);
//
//           /*File targetFile = new File(baseDirectory + "targetFile.tmp");
//
//            byte[] buffer = file.getInputStream().readAllBytes();
//            OutputStream outStream = new FileOutputStream(targetFile);
//            outStream.write(buffer);
////            while (file.getInputStream().read())
//
//            IOUtils.closeQuietly(outStream);*/
//            return ResponseEntity.ok(uniqueFileName);
//        } catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//    @PostMapping(value = "/multiple-upload/{type}/{folder}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Object> uploadFiles(
//            @RequestParam(name = "file") MultipartFile[] files,
//            @PathVariable String type,
//            @PathVariable String folder) {
//        try {
//            String fileName = "";
//            String fileExtension = "";
//            String uniqueFileName = "";
//            folder = System.currentTimeMillis()+"";
//            String folderToCreate = baseDirectory + facesDirectory + folder;
//
//            Path directory = Paths.get(folderToCreate);
//            switch (type) {
//                case "FACES" -> {
//                    try{
//                        Files.createDirectories(directory);
//                    } catch (FileAlreadyExistsException error){
//                        return ResponseEntity.badRequest().body("FOLDER-ALREADY-EXISTS");
//                    }
//
//                    for(int i = 0; i < files.length; i++){
//                        fileName = files[i].getOriginalFilename();
//                        fileExtension = fileName.substring(fileName.lastIndexOf("."));
//                        uniqueFileName = (i + 1) + fileExtension;
//                        Path filePath = directory.resolve(uniqueFileName);
//                        Files.copy(files[i].getInputStream(), filePath);
//                    }
////                    directory = Paths.get(baseDirectory + usersPicturesDirectory);
//                }
////                case "SIGN" -> {
////                    uniqueFileName = "sign_" + System.currentTimeMillis() + fileExtension;
////                    directory = Paths.get(baseDirectory + usersSignaturesDirectory);
////                }
////                case "TMP" -> {
////                    uniqueFileName = "tmp_" + System.currentTimeMillis() + fileExtension;
////                    directory = Paths.get(baseDirectory + tamponsDirectory);
////                }
////                case "POST_DOC_INIT" -> {
////                    uniqueFileName = "doc_init_" + System.currentTimeMillis() + fileExtension;
////                    directory = Paths.get(baseDirectory + documentsDirectory);
////                }
////                case "POST_DOC_FIN" -> {
////                    uniqueFileName = "doc_fin_" + System.currentTimeMillis() + fileExtension;
////                    directory = Paths.get(baseDirectory + documentsDirectory);
////                }
//                default -> throw new Exception("Path invalide");
//            }
//
//            return ResponseEntity.ok(folder);
//        } catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//
//}