import java.awt.image.BufferedImage;

public class Warmer extends Converter {

    @Override
    protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage newImage = createEmptyImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ARGB argb = new ARGB(originalImage.getRGB(x, y));
                ARGB warmer = new ARGB(
                        argb.alpha,
                        clamp(argb.red + 30),
                        argb.green,
                        clamp(argb.blue - 20));
                newImage.setRGB(x, y, warmer.toInt());
            }
        }

        return newImage;
    }
}