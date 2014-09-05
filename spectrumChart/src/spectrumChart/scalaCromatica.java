package spectrumChart;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class scalaCromatica {
	public int[] raw;
	public Color[] colori;

	public static void getColorFromImage(String s, String out) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(s));
		} catch (IOException e) {
			JOptionPane
					.showMessageDialog(null, e.toString(),
							"InfoBox: " + e.toString(),
							JOptionPane.INFORMATION_MESSAGE);
		}

		// creates a FileWriter Object
		FileWriter writer;
		int i;
		try {
			writer = new FileWriter(out, false);

			for (i = 0; i < img.getWidth(); i++)
				writer.write(String.format("0x%x,\n", img.getRGB(i, 2)));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// Writes the content to the file
			// TODO Auto-generated catch block
			JOptionPane
					.showMessageDialog(null, e.toString(),
							"InfoBox: " + e.toString(),
							JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
