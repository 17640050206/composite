package com.design.composite.utils;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Lists;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.design.composite.utils.AsyncProcess.overlapImage;


@RestController
@CrossOrigin
public class PicUtil {


    public static void test(){
        String beijing1 = "/Users/liuyajun/pics/背景1.png";
        String beijing2 = "/Users/liuyajun/pics/背景2.png";
        String jichu = "/Users/liuyajun/pics/基础模型.png";
        String yanjing1 = "/Users/liuyajun/pics/眼镜1.png";
        String yanjing2 = "/Users/liuyajun/pics/眼镜2.png";
        String yanjing3 = "/Users/liuyajun/pics/眼镜3.png";
        String yifu1 = "/Users/liuyajun/pics/衣服1.png";
        String yifu2 = "/Users/liuyajun/pics/衣服2.png";
        String yifu3 = "/Users/liuyajun/pics/衣服3.png";
        List<String> bjList = new ArrayList();
        bjList.add(beijing1);
        bjList.add(beijing2);
        List<String> jichuList = new ArrayList();
        jichuList.add(jichu);
        List<String> yjList = new ArrayList();
        yjList.add(yanjing1);
        yjList.add(yanjing2);
        yjList.add(yanjing3);
        List<String> yfList = new ArrayList();
        yfList.add(yifu1);
        yfList.add(yifu2);
        yfList.add(yifu3);
        Map<Integer,List<String>> map = new HashMap<>();
        map.put(1,bjList);
        map.put(2,jichuList);
        map.put(3,yjList);
        map.put(4,yfList);
        int i =1;
        jichuList.forEach(s -> {
            try {
                List<String> compositeList = new ArrayList<>();
                compositeList.add(s);
                generateBufferImages(map, 3, compositeList);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }

    public static void generateBufferImages(Map<Integer,List<String>> map,Integer index,List<String> compositeList) throws IOException {
        if(map.get(index)!=null){
            map.get(index).forEach(s -> {
                try {
                    List<String> tempList = new ArrayList<>();
                    compositeList.forEach(c -> tempList.add(c));
                    tempList.add(s);
                    generateBufferImages(map, index+1,tempList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }else {
            String result = compositeList.get(0);
            BufferedImage image = ImageIO.read(new File(result));
            for (int i=1 ;i< compositeList.size();i++){
                BufferedImage temp = ImageIO.read(new File(compositeList.get(i)));
                BufferedImage bufferedImage = null;
                if(index>2){
                    bufferedImage = overlapImage(image, temp,0,0);
                }else {
                    bufferedImage = overlapImage(image, temp,0,0);
                }
                image=bufferedImage;
            }
            ImageIO.write(image, "png", new FileOutputStream("/Users/liuyajun/pics/aaa/"+System.currentTimeMillis()+".png"));
        }
    }

    public static void main(String[] args) {
        test();
    }





}
