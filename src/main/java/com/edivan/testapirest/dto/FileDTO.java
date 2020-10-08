package com.edivan.testapirest.dto;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edivan.testapirest.model.File;
import com.edivan.testapirest.service.FileService;

public class FileDTO {
	
	
	@NotNull
	private MultipartFile[] file; 
	
	
	public FileDTO(@NotNull MultipartFile[] file) {
		super();
		this.file = file;
	}

	

	public MultipartFile[] getFile() {
		return file;
	}

	public void setFile(MultipartFile[] file) {
		this.file = file;
	}

	public File transformToObject(FileService fileService, int i) {
		
		String fileName = fileService.storeFile(this.file[i]);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        
		return new File(fileName, fileDownloadUri);
	}


}
