package com.example.MVC.Cat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.criteria.CriteriaBuilder;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String uploadDir = "src/main/resources/static/images/cats/";

    public Cat getCatById(@PathVariable Long catId) {
        return catRepository.getCatById(catId);
    }

    public Object getCatsByName(String name)
    {
        return catRepository.getCatsByName(name);
    }

    public Object getCatsBySex(String sex){
        return catRepository.getCatsBySex(sex);
    }

    public Object getCatsByBreed(String breed){
        return catRepository.getCatsByBreed(breed);
    }

    public Cat addCat(Cat cat, MultipartFile catImg){
        Cat newCat = catRepository.save(cat);
        String origFileName = catImg.getOriginalFilename();

        try{
            if(origFileName != null && origFileName.contains(".")){
                String fileExtension = origFileName.substring(origFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(newCat.getCatId()) + "." + fileExtension;
                Path uploadPath = Paths.get(uploadDir + fileName);

                InputStream inputStream = catImg.getInputStream();
                Files.createDirectories(Paths.get(uploadDir));
                Files.copy(inputStream, uploadPath, StandardCopyOption.REPLACE_EXISTING);
                newCat.setCatImage(fileName);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return catRepository.save(cat);
    }

    public Cat updateCat(Long catId, Cat cat, MultipartFile catImg){
        String origFileName = catImg.getOriginalFilename();

        try{
            if(origFileName != null && origFileName.contains(".")){
                String fileExtension = origFileName.substring(origFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(catId) + "." + fileExtension;
                Path uploadPath = Paths.get(uploadDir + fileName);

                InputStream inputStream = catImg.getInputStream();
                Files.deleteIfExists(uploadPath);
                Files.copy(inputStream, uploadPath, StandardCopyOption.REPLACE_EXISTING);
                cat.setCatImage(fileName);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return catRepository.save(cat);
    }



    public void deleteCat(Long catId){
        catRepository.deleteById(catId);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public String writeJson(Cat cat){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("cat.json"), cat);
            return "Cat written to JSON file successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing cat to JSON file";
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public Object readJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("cat.json"), Cat.class);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}