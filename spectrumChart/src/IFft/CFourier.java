package IFft;

/********************************************************/
/* WARNING:												*/
/* This code cannot be used in any application			*/
/* without permission of the author						*/
/* for more information please read the license in the	*/
/* Numerical Recipies in C book or go to www.nr.com		*/
/* this is nearly an example of how to use it			*/
/********************************************************/

public class CFourier implements IFft {
	double pi;
	int fundamental_frequency;
	double vector[];

	// FFT 1D
	// void ComplexFFT(float data[], unsigned long number_of_samples, unsigned
	// int sample_rate, int sign);

	CFourier() {
		pi = Math.PI;
	}

	// FFT 1D
	private double[] ComplexFFT(double data[], int number_of_samples,
			int sample_rate, int sign) {

		// variables for the fft
		int n, mmax, m, j, istep, i;
		double wtemp, wr, wpr, wpi, wi, theta, tempr, tempi;

		// the complex array is real+complex so the array
		// as a size n = 2* number of complex samples
		// real part is the data[index] and
		// the complex part is the data[index+1]
		vector = new double[2 * sample_rate];

		// put the real array in a complex array
		// the complex part is filled with 0's
		// the remaining vector with no data is filled with 0's
		for (n = 0; n < sample_rate; n++) {
			if (n < number_of_samples)
				vector[2 * n] = data[n];
			else
				vector[2 * n] = 0;
			vector[2 * n + 1] = 0;
		}

		// binary inversion (note that the indexes
		// start from 0 witch means that the
		// real part of the complex is on the even-indexes
		// and the complex part is on the odd-indexes)
		n = sample_rate << 1;
		j = 0;
		for (i = 0; i < n / 2; i += 2) {
			if (j > i) {
				double tmp;

				tmp = vector[j];
				vector[j] = vector[i];
				vector[i] = tmp;
				tmp = vector[j + 1];
				vector[j + 1] = vector[i + 1];
				vector[i + 1] = tmp;
				if ((j / 2) < (n / 4)) {
					tmp = vector[(n - (i + 2))];
					vector[(n - (i + 2))] = vector[(n - (j + 2))];
					vector[(n - (j + 2))] = tmp;
					tmp = vector[(n - (i + 2)) + 1];
					vector[(n - (i + 2)) + 1] = vector[(n - (j + 2)) + 1];
					vector[(n - (j + 2)) + 1] = tmp;
				}
			}
			m = n >> 1;
			while (m >= 2 && j >= m) {
				j -= m;
				m >>= 1;
			}
			j += m;
		}
		// end of the bit-reversed order algorithm

		// Danielson-Lanzcos routine
		mmax = 2;
		while (n > mmax) {
			istep = mmax << 1;
			theta = sign * (2 * pi / mmax);
			wtemp = Math.sin(0.5 * theta);
			wpr = -2.0 * wtemp * wtemp;
			wpi = Math.sin(theta);
			wr = 1.0;
			wi = 0.0;
			for (m = 1; m < mmax; m += 2) {
				for (i = m; i <= n; i += istep) {
					j = i + mmax;
					tempr = wr * vector[j - 1] - wi * vector[j];
					tempi = wr * vector[j] + wi * vector[j - 1];
					vector[j - 1] = vector[i - 1] - tempr;
					vector[j] = vector[i] - tempi;
					vector[i - 1] += tempr;
					vector[i] += tempi;
				}
				wr = (wtemp = wr) * wpr - wi * wpi + wr;
				wi = wi * wpr + wtemp * wpi + wi;
			}
			mmax = istep;
		}
		// end of the algorithm

		return vector;
	}

	@Override
	public double[] doFFT(double[] real, int samples, int sample_rate) {
		// TODO Auto-generated method stub
		return ComplexFFT(real, samples, sample_rate, 1);
	}
}
