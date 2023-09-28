package com.fescfafic.pdi.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Inverter{

    public static void main(String[] args) {
        String inputPath = "C:\\Users\\jvictor\\IdeaProjects\\PDI\\src\\com\\fescfafic\\pdi\\image\\sombrinhas.jpg";
        String outputPath = "C:\\Users\\jvictor\\IdeaProjects\\PDI\\src\\com\\fescfafic\\pdi\\image";

        try {

            BufferedImage imagem = ImageIO.read(new File(inputPath));

            int largura = imagem.getWidth();
            int altura = imagem.getHeight();


            BufferedImage imagemInvertida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);


            for (int x = 0; x < largura; x++) {
                for (int y = 0; y < altura; y++) {

                    int cor = imagem.getRGB(x, y);

                    int vermelho = 255 - ((cor >> 16) & 0xFF);
                    int verde = 255 - ((cor >> 8) & 0xFF);
                    int azul = 255 - (cor & 0xFF);

                    int corInvertida = (vermelho << 16) | (verde << 8) | azul;

                    imagemInvertida.setRGB(x, y, corInvertida);
                }
            }

            
            ImageIO.write(imagemInvertida, "jpg", new File(outputPath));

            System.out.println("Imagem invertida salva em: " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
