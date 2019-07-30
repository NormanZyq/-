package com.neuedu.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传控制器.
 *
 * @author ljq
 */
@Controller
public class FileUpController {

    //fileUp
    @RequestMapping(value = "/fileUp",method = RequestMethod.POST)
    public String up(MultipartFile img){
        System.out.println(img);
        //img  ----服务器的D://images   ---虚拟目录
        if(img!=null) {
            String fileName = img.getOriginalFilename();
            System.out.println("上传的文件名字："+fileName);
            //xxxseconds.xxx
            int index = fileName.indexOf('.');
            String newFileName = fileName.substring(0, index)+System.currentTimeMillis()+fileName.substring(index);
            File file = new File("/Users/anothertask/Downloads/images",newFileName);
            try {
                img.transferTo(file);
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return "redirect:hello.html";
    }
}
