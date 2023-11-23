package com.epcafes;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epcafes.service.FilesStorageService;

@SpringBootApplication
public class EpCafesApplication implements CommandLineRunner {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(EpCafesApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		//inicia o armazenamento de arquivos
		storageService.deleteAll();
		storageService.init();
	}
}