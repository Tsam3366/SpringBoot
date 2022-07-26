package com.sam.file.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="filemodel")
public class FileModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	private byte[] content;
	private String name;
	private String fileType;
	
	public FileModel( byte[] content, String name, String fileType) {
		this.content = content;
		this.name = name;
		this.fileType = fileType;
	}
	public FileModel() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	@Override
	public String toString() {
		return "FileModel [id=" + id + ", content=" + Arrays.toString(content) + ", name=" + name + ", fileType="
				+ fileType + "]";
	}
	
	
}
