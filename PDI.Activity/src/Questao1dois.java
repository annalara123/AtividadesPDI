import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Questao1dois
{
    public static void main(String[] args)
    {
        try
        {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\nalar\\IdeaProjects\\PDI.Activity\\src\\images\\sombrinhas.jpg"));

            int[] redHistogram = new int[256];
            int[] greenHistogram = new int[256];
            int[] blueHistogram = new int[256];

            int width = image.getWidth();
            int height = image.getHeight();

            for (int y = 0; y < height; y++)
            {
                for (int x = 0; x < width; x++)
                {

                    int pixel = image.getRGB(x, y);
                    int redValue = (pixel >> 16) & 0xFF;
                    int greenValue = (pixel >> 8) & 0xFF;
                    int blueValue = pixel & 0xFF;

                    redHistogram[redValue]++;
                    greenHistogram[greenValue]++;
                    blueHistogram[blueValue]++;
                }
            }

            for (int i = 0; i < 256; i++)
            {
                System.out.println("[Cor Vermelha - Valor de intensidade: " + i + " - Frequencia: " + redHistogram[i] + "]");
                System.out.println("[Cor Verde - Valor de intensidade: " + i + " - Frequencia: " + greenHistogram[i] +"]");
                System.out.println("[Cor Azul - Valor de intensidade: " + i + " - Frequencia: " + blueHistogram[i] + "]");
                System.out.println(" ");
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
