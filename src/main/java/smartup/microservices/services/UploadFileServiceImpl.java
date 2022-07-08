package smartup.microservices.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import smartup.microservices.entities.UploadFile;
import smartup.microservices.repositories.UploadFileRepository;
@Service
public class UploadFileServiceImpl implements UploadFileService{

	 private String uploadFolderPath ="/Users/rached/Documents/imageAnnonces";
	 
	 @Autowired
		private UploadFileRepository ufrep;
	
	 @Override
	public void uploadToLocal(MultipartFile file) {
		try {
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public UploadFile uploadToDb(MultipartFile mfile) {
		UploadFile ufile = new UploadFile();
		try{
			
		ufile.setImage(mfile.getBytes());
        ufile.setType(mfile.getContentType());
        ufile.setName(mfile.getOriginalFilename());
        UploadFile fileToRet = ufrep.save(ufile);
        return fileToRet;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
	}

}
