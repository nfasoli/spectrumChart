package spectrumChart;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import IFft.IFft;
import IFft.JTransformFFT;

public class prova extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -291059236407451543L;
	private static spectrumChart c = null;
	private static final int sizeof_short = 2;
	private short[] wav;

	public double[] doFrequencyAnalysis(IFft fft, double[] scores,
			int sample_rate) {
		double m[] = fft.doFFT(scores, scores.length, sample_rate);
		// double freq[] = new double[sample_rate / 2];
		double freq[] = new double[m.length / 2];

		// determine the fundamental frequency
		// look for the maximum absolute value in the complex array
		double fundamental_frequency = 0;
		// for (int i = 2; i <= sample_rate; i += 2) {
		for (int i = 2; i < m.length; i += 2) { // TODO in teoria ogni fft
												// ritorna qualche byte in piu
												// per le proprie cose....
												// Andrà gestito in seguito
			freq[(i - 2) / 2] = Math.sqrt(Math.pow(m[i], 2)
					+ Math.pow(m[i + 1], 2));
			if ((Math.pow(m[i], 2) + Math.pow(m[i + 1], 2)) > (Math.pow(
					m[(int) fundamental_frequency], 2) + Math.pow(
					m[(int) (fundamental_frequency + 1)], 2))) {
				fundamental_frequency = i;
			}
			/*
			 * if (Math.abs(freq[(i - 2) / 2]) > 0.1) System.out .format(i/2 +
			 * ".\tr:" + Double.toString((Math.abs(m[i]) > 0.1 ? m[i] : 0)) +
			 * " i:" + Double.toString((Math.abs(m[i + 1]) > 0.1 ? m[i + 1] :
			 * 0)) + "\t\t" + (Math.abs(freq[(i - 2) / 2]) > 0.1 ? freq[(i - 2)
			 * / 2] : 0) + "hz \t\t " + "\n");
			 */

		}
		fundamental_frequency /= 2.;
		System.out.println("Freq dominante: " + fundamental_frequency);

		return freq;
	}

	public prova(spectrumChart c) {
		int sample_rate = 44100, sample = 8192, sec = 5;
		double freq_resolution = (float) sample_rate / (float) sample;
		double[] samples = new double[sample];

		// wav =
		// fromPCMtoArray("c:\\users\\nicola\\desktop\\16Hz-1600Hz-Exp-1f-10sec.pcm");
		// Convertiamo il pcm per intero in un array
		// TODO: andrà fatto a piccoli chunk, magari della dimensione dei
		// campioni
		wav = fromPCMtoArray("c:\\users\\nicola\\desktop\\440.pcm");
		wav = fromPCMtoArray("c:\\users\\nicola\\desktop\\16.pcm");

		int i = 0, j = wav.length, max_freq = sample_rate / 2, u, v = 0;
		double[] freq = null;
		IFft fft = new JTransformFFT();
		float[][] d = new float[(int) Math.ceil((float) sample_rate * sec
				/ (float) sample)][max_freq]; // TODO.... non sappiamo quanti
												// secondi siano, pro bono pacis
		// poi si toglie
		int len = 0;

		System.out.println(d.length + " : " + d[0].length);
		while (i < wav.length) {
			for (j = 0; j < sample && i < wav.length; i++, j++)
				samples[j] = wav[i];

			for (; j < sample; j++)
				samples[j] = 0;

			freq = doFrequencyAnalysis(fft, samples, sample_rate);

			// normalizziamo secondo samples/2
			for (j = 0; j < freq.length; j++) {
				freq[j] /= (float) (sample_rate * sample) / 4.;
				if (freq[len] < freq[j])
					len = j;
			}

			System.out.println("len: " + (float) len * freq_resolution
					+ ", val = " + freq[len]);
			for (u = 0; u < d[v].length; u++)
				// TODO possiamo evitare una copia
				d[v][u] = (float) (freq[(int) (u / freq_resolution)]);
			v++;
		}

		prova.c = c;
		c.setData(d);
	}

	public static void fromPCMtoArray(String s, String d) {
		// creates a FileReader Object
		FileReader reader;
		FileWriter writer;
		int i;
		char[] c = new char[2];
		try {
			reader = new FileReader(s);
			writer = new FileWriter(d, false);
			while (reader.read(c) > 0) {
				i = c[0] | c[1] << 8;
				writer.write(String.format("0x%x,\n", i));
			}
			writer.flush();
			reader.close();
			writer.close();
		} catch (IOException e) {
			JOptionPane
					.showMessageDialog(null, e.toString(),
							"InfoBox: " + e.toString(),
							JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public static short[] fromPCMtoArray(String s) {
		// creates a FileReader Object
		FileReader reader;

		short[] d = new short[(int) (new File(s).length() / 2)]; // TODO invece
																	// di due
																	// mettere
																	// sizeof
																	// (short)
		System.out.println("fromPCMtoArray: lunghezza = " + d.length
				+ " - a 48k sono " + (float) d.length / 48000.);

		int i, j = 0;
		char[] c = new char[2];
		try {
			reader = new FileReader(s);
			while (reader.read(c) > 0) {
				i = c[0] | c[1] << 8;
				d[j++] = (short) i;
			}
			reader.close();
		} catch (IOException e) {
			JOptionPane
					.showMessageDialog(null, e.toString(),
							"InfoBox: " + e.toString(),
							JOptionPane.INFORMATION_MESSAGE);

		}
		return d;
	}

	public static void main(String[] args) {
		prova jFrame = new prova(new spectrumChart());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle("spectrumChart");
		jFrame.add(c);

		Toolkit mioToolkit = Toolkit.getDefaultToolkit();
		Dimension dimensioniSchermo = mioToolkit.getScreenSize();

		int larghezzaFrame, altezzaFrame;
		larghezzaFrame = (int) (dimensioniSchermo.getWidth() / 2);
		altezzaFrame = (int) (dimensioniSchermo.getHeight() / 2);
		System.out.println(larghezzaFrame + " : " + altezzaFrame);
		jFrame.setSize(larghezzaFrame, altezzaFrame);
		jFrame.setLocation(((int) dimensioniSchermo.getWidth() / 4),
				((int) dimensioniSchermo.getHeight() / 4));

		jFrame.setVisible(true);
	}
}
