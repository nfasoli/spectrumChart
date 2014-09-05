package IFft;

public interface IFft {

	//
	// Metodo astratto che deve chiamare la funzione fft associata
	// real: matrice di reali che contengono i dati in ingresso
	// samples: numero di campioni
	// sample_rate: frequenza di campionamento
	//
	// Ritorna: vettore delle ampiezze delle frequenze
	//
	double[] doFFT(double[] real, int samples, int sample_rate);
}
