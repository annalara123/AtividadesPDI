import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Questao1 {
    public static void main(String[] args) {
        try {
            // Carregue a imagem
            BufferedImage image = ImageIO.read(new File("C:\\Users\\nalar\\IdeaProjects\\PDI.Activity\\src\\images\\grey_scale.jpg"));

            // Crie um vetor para armazenar os valores do histograma
            int[] histogram = new int[256];

            // Iteração sobre a imagem
            int width = image.getWidth();
            int height = image.getHeight();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Obtenha o valor de intensidade de pixel em escala de cinza
                    int pixel = image.getRGB(x, y);
                    int grayValue = (pixel >> 16) & 0xFF; // Converte para escala de cinza

                    // Contagem de ocorrências
                    histogram[grayValue]++;
                }
            }

            // Exibição do histograma
            for (int i = 0; i < 256; i++) {
                System.out.println("[Valor de intensidade: " + i + " - Frequencia: " + histogram[i] + "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
