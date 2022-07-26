package com.sam.file.fileservice;

import java.util.List;

import com.sam.file.model.FileModel;

public interface FileService {
	public void saveFile(FileModel filemodel);
	public List<FileModel> getAllFiles();
	public FileModel getFile(Long id);
	
}
