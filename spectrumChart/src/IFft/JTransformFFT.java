package IFft;

import org.jtransforms.fft.DoubleFFT_1D;

public class JTransformFFT implements IFft {

	@Override
	public double[] doFFT(double[] real, int samples, int sample_rate) {
		// TODO Auto-generated method stub
		double[] vector = new double[samples * 2];
		for (int i = 0; i < samples; i++) {
			vector[2 * i] = real[i];
			vector[2 * i + 1] = 0.0;
		}

		DoubleFFT_1D fft = new DoubleFFT_1D(samples);
		fft.complexForward(vector);
		return vector;
	}

}
