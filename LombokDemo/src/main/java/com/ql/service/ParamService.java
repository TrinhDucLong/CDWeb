package com.ql.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;

	/**
	 * doc gia tri tham so
	 * 
	 * @param name         ten tham so
	 * @param defaultValue gtri mac dinh
	 * @return gia tri tham so hoac gtri mac dinh neu khong ton tai
	 */
	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		return value != null ? value : defaultValue;

	}

	/**
	 * doc so nguyen gia tri cua tham so
	 * 
	 * @param name         ten tham so
	 * @param defaultValue gtri mac dinh
	 * @return gia tri tham so hoac gtri mac dinh neu khong ton tai
	 */
	public int getInt(String name, int defaultValue) {
		String value = getString(name, String.valueOf(defaultValue));
		return Integer.parseInt(value);
	}

	/**
	 * 
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public double getDouble(String name, double defaultValue) {
		String value = getString(name, String.valueOf(defaultValue));
		return Double.parseDouble(value);
	}

	/**
	 * 
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public boolean getBoolean(String name, boolean defaultValue) {
		String value = getString(name, String.valueOf(defaultValue));
		return Boolean.parseBoolean(value);
	}

	/**
	 * 
	 * @param name
	 * @param pattern
	 * @return
	 */
	public Date getDate(String name, String pattern) {
		String value = getString(name, "");
		try {
			return new SimpleDateFormat(pattern).parse(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * luu file upload vao thu muc
	 * 
	 * @param file chua file upload tu client
	 * @param path dg dan tinh tu web root
	 * @return doi tuong chua file da luu hoac null neu khong co file upload
	 * @throws RuntimeException loi luu file
	 */
	public File save(MultipartFile multipartFile, String path) {
		if (!(multipartFile.isEmpty())) {
			File dir = new File(request.getServletContext().getRealPath(path));
			if (!(dir.exists())) {
				dir.mkdir();
			}
			try {
				File saveFile = new File(dir, multipartFile.getOriginalFilename());
				multipartFile.transferTo(saveFile);
				return saveFile;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return null;

	}

	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		// duong dan cua file
		Path path = Paths.get(uploadDir);
		// kiemtra xem file co ton tai k
		if (!Files.exists(path)) {
			Files.createDirectories(path);
			// tao file moi
		}
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = path.resolve(fileName);
			// doi ali duong dan (java // trong web /) chuyen file sang dg dan moi
			//save file thay luon file da co trc do
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			// TODO: handle exception

//			throw new IOException("khong luu duoc file image nay: path =  " + fileName);
		}
	}
}
