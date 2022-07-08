package smartup.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import smartup.microservices.entities.ResponseFile;
import smartup.microservices.entities.UploadFile;
import smartup.microservices.services.UploadFileService;


@RestController
@CrossOrigin
@RequestMapping
public class UploadFileController {

	@Autowired
	private UploadFileService ufs;

	

	@PostMapping("/upload/db")
	public ResponseFile uploadDb(@RequestParam("file") MultipartFile multipartFile) {

		UploadFile ufile = ufs.uploadToDb(multipartFile);
		ResponseFile response = new ResponseFile();
		if (ufile != null) {
			response.setId(ufile.getId());
			response.setType(ufile.getType());
			response.setStatus(true);
			response.setMessage("File Uploaded Successfully!");
			return response;

		}
		response.setMessage("Oops! something went wrong please re-upload.");
		return response;
	}
}
