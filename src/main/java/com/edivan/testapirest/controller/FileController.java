package com.edivan.testapirest.controller;


import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.edivan.testapirest.dto.FileDTO;
import com.edivan.testapirest.model.File;
import com.edivan.testapirest.service.FileService;


@RestController
@RequestMapping("/api")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload-files")
	public ResponseEntity<List<File>> create(@ModelAttribute @Valid FileDTO dto) {
		File fileOne = dto.transformToObject(fileService, 0);
		File fileTwo = dto.transformToObject(fileService, 1);
		List<File> file = Arrays.asList(fileOne, fileTwo);
		return new ResponseEntity<>(file, HttpStatus.CREATED);
	}
	
}
