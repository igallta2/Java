package 素数;

public class PrimeNumbers {
	public static void main(String arg[]) {
		for(int i=2;i<=100;i++) {
			if (isPrime(i)) {
                System.out.print(i + " ");
			}
		}
	}
	 public static boolean isPrime(int n) {
	        if (n <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(n); i++) {
	            if (n % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

}
