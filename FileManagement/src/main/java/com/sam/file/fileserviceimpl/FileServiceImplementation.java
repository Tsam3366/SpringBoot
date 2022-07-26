package com.sam.file.fileserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.file.filemodelrepo.FileModelRepository;
import com.sam.file.fileservice.FileService;
import com.sam.file.model.FileModel;
@Service

public class FileServiceImplementation implements FileService
{

	@Autowired
	FileModelRepository filemodelrepo;
	@Override
	public void saveFile(FileModel filemodel) {
		// TODO Auto-generated method stub
		filemodelrepo.save(filemodel);
		
	}

	@Override
	public List<FileModel> getAllFiles() {
		// TODO Auto-generated method stub
		return filemodelrepo.findAll();
	}

	@Override
	public FileModel getFile(Long id) {
		// TODO Auto-generated method stub
		return filemodelrepo.findById(id).get();
	}

}
