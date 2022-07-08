package smartup.microservices.services;

import org.springframework.web.multipart.MultipartFile;

import smartup.microservices.entities.UploadFile;

public interface UploadFileService {
	public void uploadToLocal(MultipartFile file);
	public UploadFile uploadToDb(MultipartFile file);
}
