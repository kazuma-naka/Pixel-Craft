import java.awt.image.BufferedImage;

public class Darker extends Converter {

    @Override
    protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage newImage = createEmptyImage(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ARGB argb = new ARGB(originalImage.getRGB(x, y));
                ARGB darker = new ARGB(
                        argb.alpha,
                        clamp((int) (argb.red * 0.7)),
                        clamp((int) (argb.green * 0.7)),
                        clamp((int) (argb.blue * 0.7)));
                newImage.setRGB(x, y, darker.toInt());
            }
        }

        return newImage;
    }
}