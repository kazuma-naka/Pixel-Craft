import java.awt.image.BufferedImage;

/**
 * Rotates the image 90 degrees clockwise.
 */
public class Rotate extends Converter {

    @Override
    protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage newImage = createEmptyImage(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = originalImage.getRGB(x, y);

                // 90-degree clockwise rotation:
                // (x, y) -> (height - 1 - y, x)
                newImage.setRGB(height - 1 - y, x, pixel);
            }
        }

        return newImage;
    }
}