import java.awt.image.BufferedImage;

/**
 * Converts an image to grayscale by averaging the red, green, and blue values
 * of each pixel while preserving the alpha channel.
 */
public class Grayscale extends Converter {

    @Override
    protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage newImage = createEmptyImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ARGB argb = new ARGB(originalImage.getRGB(x, y));
                int gray = (argb.red + argb.green + argb.blue) / 3;
                ARGB newPixel = new ARGB(argb.alpha, gray, gray, gray);
                newImage.setRGB(x, y, newPixel.toInt());
            }
        }

        return newImage;
    }
}