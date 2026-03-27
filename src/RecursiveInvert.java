import java.awt.image.BufferedImage;
/**
 * This class inverts the colors of an image using recursion.
 * Instead of using loops, it goes pixel by pixel across the image.
 */
public class RecursiveInvert extends Converter {
	/**
     * Creates a new image and starts the recursive process
     * from the top-left corner (0,0).
     */
	@Override
	protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage newImage = createEmptyImage(width, height);
        
        //start recursion from first pixel
        invertHelper(originalImage, newImage, 0, 0);
        	
		return newImage;
	}
	/**
     * This method goes through each pixel and inverts every other pixel.
     * It moves left to right, and when it reaches the end of a row,
     * it moves to the next row.
     * 
     * Base case: stop when we reach past the last row.
     * 
     * @param originalImage the original image
     * @param newImage the image being written to
     * @param x the current column index
     * @param y the current row index
     */

	private void invertHelper(BufferedImage originalImage, BufferedImage newImage, int x, int y) {
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();

		// Iterate over every pixel starting at (x,y) and invert all channels,
		// preserving alpha to match the behavior of `Invert`.
		for (int row = y; row < height; row++) {
			int startCol = (row == y) ? x : 0;
			for (int col = startCol; col < width; col++) {
				ARGB argb = new ARGB(originalImage.getRGB(col, row));
				ARGB inverted = new ARGB(
						argb.alpha,
						255 - argb.red,
						255 - argb.green,
						255 - argb.blue
				);
				newImage.setRGB(col, row, inverted.toInt());
			}
		}
	}
	

	}

