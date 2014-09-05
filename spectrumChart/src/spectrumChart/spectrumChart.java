package spectrumChart;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Date;

import javax.swing.JPanel;

public class spectrumChart extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 970597668830207523L;
	private static final int dim = 3; // Dimensioni del quadrato
	private final scalaCromatica k;
	// private final Random rnd = new Random();
	private float[][] data = null;

	public void setData(float[][] data) {
		this.data = data;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// Ora possiamo utilizzare metodi di g, che è un Graphics, o di g2, che
		// è un Graphics2D, a seconda di quello che dobbiamo ottenere

		if (data == null)
			return;
		System.out.println("Start: " + new Date().toString());
		g2.setColor(k.colori[0]);
		g2.fillRect(0, 0, getWidth(), getHeight());

		int x, y;
		for (x = 0; x < data.length; x++)
			for (y = 0; y < data[x].length; y++) {
				int c = (int) Math.ceil((float) k.colori.length * data[x][y]);
				/*
				 * int c = (int) ((k.colori.length * (float) i / getHeight()) +
				 * rnd .nextGaussian() * k.colori.length / 20.);
				 */
				c = (c < 0) ? 0 : c; // min
				c = (c >= k.colori.length) ? k.colori.length - 1 : c; // max

				g2.setColor(k.colori[c]);
				// g2.fill3DRect(j, i, dim, dim, false);

				int dim_x = data.length, dim_y = data[0].length, size_x = getWidth(), size_y = getHeight();
				int lato_x = (int) ((Math.ceil((float) size_x / (float) dim_x) < dim) ? dim
						: Math.ceil((float) size_x / (float) dim_x)), lato_y = (Math
						.ceil((float) size_y / (float) dim_y) < dim) ? dim
						: (int) Math.ceil((float) size_y / (float) dim_y);

				if (c != 0 && data[x][y] > 0.1)
					System.out.format(
							"c=%d, x=%d, y=%d, sx=%d, sy=%d,freq=%g\n", c, x,
							y, lato_x, lato_y, data[x][y]);

				g2.fillRect(
						(int) Math.ceil((float) size_x * (float) x
								/ (float) dim_x),
						(int) Math.ceil((float) size_y * (float) y
								/ (float) dim_y), lato_x, lato_y);

			}
		System.out.println("Stop: " + new Date().toString());
	}

	public spectrumChart() {
		k = new scalaCromaticaPippo();
	}

	/*
	 * public static void main(String[] args) { JFrame jFrame = new JFrame();
	 * jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * jFrame.setTitle("spectrumChart"); jFrame.add(new spectrumChart());
	 * 
	 * Toolkit mioToolkit = Toolkit.getDefaultToolkit(); Dimension
	 * dimensioniSchermo = mioToolkit.getScreenSize();
	 * 
	 * int larghezzaFrame, altezzaFrame; larghezzaFrame = (int)
	 * (dimensioniSchermo.getWidth() / 2); altezzaFrame = (int)
	 * (dimensioniSchermo.getHeight() / 2);
	 * 
	 * jFrame.setSize(larghezzaFrame, altezzaFrame); jFrame.setLocation(((int)
	 * dimensioniSchermo.getWidth() / 4), ((int) dimensioniSchermo.getHeight() /
	 * 4));
	 * 
	 * jFrame.setVisible(true); }
	 */
}
