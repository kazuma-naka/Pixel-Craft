import java.awt.image.BufferedImage;

/**
 * Applies a simple box blur using the 3x3 neighbourhood around each pixel.
 * For edge pixels, only valid neighbouring pixels are included in the average.
 */
public class Blur extends Converter {

    @Override
    protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage newImage = createEmptyImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int alphaSum = 0;
                int redSum = 0;
                int greenSum = 0;
                int blueSum = 0;
                int count = 0;

                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                            ARGB neighbour = new ARGB(originalImage.getRGB(nx, ny));
                            alphaSum += neighbour.alpha;
                            redSum += neighbour.red;
                            greenSum += neighbour.green;
                            blueSum += neighbour.blue;
                            count++;
                        }
                    }
                }

                ARGB blurred = new ARGB(
                        alphaSum / count,
                        redSum / count,
                        greenSum / count,
                        blueSum / count);

                newImage.setRGB(x, y, blurred.toInt());
            }
        }

        return newImage;
    }
}