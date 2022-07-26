package com.sam.file.control;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import com.sam.file.fileserviceimpl.FileServiceImplementation;
import com.sam.file.model.FileModel;

@Controller
public class FileModelController {

	@Autowired
	FileServiceImplementation implementation;
	
	@RequestMapping("/")
	public String index() {
		return "UploadFile";
	}
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file,Model model)throws IOException
	{
		byte[] content= file.getBytes();
		String name=file.getOriginalFilename();
		String fileType=file.getContentType();
		FileModel filemodel=new FileModel(content,name,fileType);
		implementation.saveFile(filemodel);
		model.addAttribute("allFiles",implementation.getAllFiles());
		return"DisplayFiles";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id)
	{
		FileModel fm=implementation.getFile(id);
		HttpHeaders header=new HttpHeaders();
		header.add(HttpHeaders.CONTENT_TYPE,fm.getFileType());
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fm.getName());
		return ResponseEntity.ok()
				.headers(header).body(fm.getContent());
		
	}
	
}
