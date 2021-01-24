import java.util.Arrays;

public class Eratosthenes {
	private int max;
	private boolean[] isPrime;

	public Eratosthenes(int max) {
		this.max =max;
		isPrime = new boolean[max + 1];

		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		int sqrtn = (int) Math.sqrt(max);

		for (int i = 2; i <= sqrtn; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= max; j += i)
					isPrime[j] = false;
			}
		}
	}

	public boolean isPrime(int num) {
		return isPrime[num];
	}
}
