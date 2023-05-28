package com.ql;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	// luu file
	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		// duong dan cua file
		Path path = Paths.get(uploadDir);
		//kiemtra xem file co ton tai k
		if (!Files.exists(path)) {
			Files.createDirectories(path);
			//tao file moi
		}
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = path.resolve(fileName);
			// doi ali duong dan (java // trong web /)
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			// TODO: handle exception
			
//			throw new IOException("khong luu duoc file image nay: path =  " + fileName);
		}
	}
}
