import java.awt.image.BufferedImage;

public class Invert extends Converter {

    @Override
    protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage newImage = createEmptyImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ARGB argb = new ARGB(originalImage.getRGB(x, y));
                ARGB inverted = new ARGB(
                        argb.alpha,
                        255 - argb.red,
                        255 - argb.green,
                        255 - argb.blue);
                newImage.setRGB(x, y, inverted.toInt());
            }
        }

        return newImage;
    }
}