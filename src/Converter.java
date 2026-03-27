import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Converter {

    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage originalImage = readImage(inputFileName);
        BufferedImage processedImage = process(originalImage);
        writeImage(processedImage, outputFileName);
    }

    protected abstract BufferedImage process(BufferedImage originalImage);

    protected BufferedImage readImage(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        BufferedImage image = ImageIO.read(inputFile);

        if (image == null) {
            throw new IOException("Unsupported image file: " + inputFileName);
        }

        return image;
    }

    protected void writeImage(BufferedImage image, String outputFileName) throws IOException {
        File outputFile = new File(outputFileName);
        ImageIO.write(image, "PNG", outputFile);
    }

    protected BufferedImage createEmptyImage(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    protected int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }
}