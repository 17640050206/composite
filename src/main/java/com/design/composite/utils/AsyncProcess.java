package com.design.composite.utils;


import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author liuyajun
 */
public class AsyncProcess {

    public static BufferedImage overlapImage(BufferedImage background, BufferedImage frontgroud,int x,int y) {
        try {
            //获取底板
            Graphics2D g = background.createGraphics();
            //在底板上绘制图形
            g.drawImage(frontgroud, x, y, frontgroud.getWidth(), frontgroud.getHeight(), null);
            g.dispose();
            return background;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
