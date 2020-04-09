package com.codegym.controller;

import com.codegym.model.PictureModel.Picture;
import com.codegym.model.PictureModel.PictureForm;
import com.codegym.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:global_config_app.properties")
public class PictureController {

    @Autowired
    private Environment environment;
    @Autowired
    private IPictureService pictureService;
    @GetMapping("/pictures")
    public ModelAndView showsPicture(){
        List<Picture> pictures=this.pictureService.findAll();
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("pictures",pictures);
        return modelAndView;
    }

    @GetMapping("/create-picture")
    public ModelAndView createPicture() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("pictureForm", new PictureForm());
        return modelAndView;
    }

    @PostMapping("/save-picture")
    public ModelAndView savePicture(@ModelAttribute("pictureForm") PictureForm pictureForm, BindingResult result){
        if (result.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("create");
            return modelAndView;
        }
        MultipartFile multipartFile=pictureForm.getImage();
        String fileName=multipartFile.getOriginalFilename();
        String fileUpload=environment.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(pictureForm.getImage().getBytes(),new File(fileUpload+fileName));
        } catch (IOException e){
            e.printStackTrace();
        }

        Picture picture=new Picture(fileName,pictureForm.getName());

        pictureService.add(picture);

        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("picture",new Picture());
        return modelAndView;
    }
}
