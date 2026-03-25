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

	    // stop when all rows are done being processed
	    if (y >= height) {
	        return;
	    }
	    // processing current pixel
	    int rgb = originalImage.getRGB(x, y);

	 // only invert pixels in a checkerboard kind of way
	 if ((x + y) % 2 == 0) {
	     int r = 255 - ((rgb >> 16) & 0xFF);
	     int g = 255 - ((rgb >> 8) & 0xFF);
	     int b = 255 - (rgb & 0xFF);

	     int newRGB = (r << 16) | (g << 8) | b;
	     newImage.setRGB(x, y, newRGB);
	 } else {
	     // keep original pixel
	     newImage.setRGB(x, y, rgb);
	 }

	    //move to next pixel
	    if (x < width - 1) {
	    	// move right
	        invertHelper(originalImage, newImage, x + 1, y);
	    } else {
	    	//move next row
	        invertHelper(originalImage, newImage, 0, y + 1);
	    }
	 }
	

	}

