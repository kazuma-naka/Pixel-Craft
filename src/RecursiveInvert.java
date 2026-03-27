import java.awt.image.BufferedImage;

public class RecursiveInvert extends Converter {

	@Override
	protected BufferedImage process(BufferedImage originalImage) {
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		BufferedImage newImage = createEmptyImage(width, height);

		processRows(originalImage, newImage, 0, width, height);

		return newImage;
	}

	private void processRows(BufferedImage originalImage, BufferedImage newImage, int y, int width, int height) {
		if (y >= height) {
			return;
		}

		processColumns(originalImage, newImage, 0, y, width);
		processRows(originalImage, newImage, y + 1, width, height);
	}

	private void processColumns(BufferedImage originalImage, BufferedImage newImage, int x, int y, int width) {
		if (x >= width) {
			return;
		}

		ARGB argb = new ARGB(originalImage.getRGB(x, y));
		ARGB inverted = new ARGB(
				argb.alpha,
				255 - argb.red,
				255 - argb.green,
				255 - argb.blue);
		newImage.setRGB(x, y, inverted.toInt());

		processColumns(originalImage, newImage, x + 1, y, width);
	}
}