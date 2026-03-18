import java.awt.image.BufferedImage;

/**
 * Mirrors the image horizontally using recursion only.
 * No loops are used in this converter.
 */
public class RecursiveMirror extends Converter {

    @Override
    protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage newImage = createEmptyImage(width, height);

        processRows(originalImage, newImage, 0, width, height);

        return newImage;
    }

    /**
     * Recursively processes one row at a time.
     *
     * @param originalImage source image
     * @param newImage      destination image
     * @param y             current row
     * @param width         image width
     * @param height        image height
     */
    private void processRows(
            BufferedImage originalImage,
            BufferedImage newImage,
            int y,
            int width,
            int height) {
        if (y >= height) {
            return;
        }

        processColumns(originalImage, newImage, 0, y, width);

        processRows(originalImage, newImage, y + 1, width, height);
    }

    /**
     * Recursively processes one column at a time within a single row.
     *
     * @param originalImage source image
     * @param newImage      destination image
     * @param x             current column
     * @param y             current row
     * @param width         image width
     */
    private void processColumns(
            BufferedImage originalImage,
            BufferedImage newImage,
            int x,
            int y,
            int width) {
        if (x >= width) {
            return;
        }

        int pixel = originalImage.getRGB(x, y);

        // Mirror horizontally: (x, y) -> (width - 1 - x, y)
        newImage.setRGB(width - 1 - x, y, pixel);

        processColumns(originalImage, newImage, x + 1, y, width);
    }
}