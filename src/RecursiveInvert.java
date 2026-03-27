import java.awt.image.BufferedImage;

public class RecursiveInvert extends Converter {
	
	@Override
	protected BufferedImage process(BufferedImage originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage newImage = createEmptyImage(width, height);
        
        //start recursion from first pixel
        invertHelper(originalImage, newImage, 0, 0);
        	
		return newImage;
	}
	
	private void invertHelper(BufferedImage originalImage, BufferedImage newImage, int x, int y) {
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();

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

