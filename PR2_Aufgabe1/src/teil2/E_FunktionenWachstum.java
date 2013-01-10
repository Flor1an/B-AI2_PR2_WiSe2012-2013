package teil2;

public class E_FunktionenWachstum {
	public static void main(String[] args) {
		System.out.println("\tlog(n)\t\t\tn*log(n)\t\tn²\t\tn³\t\t2^n");
		System.out.println("######################################################################################################");
		int i;
		for (i = 16; i <= 2048; i += i) {
			System.out.print(i);
			System.out.print(":\t");
			System.out.print(Math.log(i));
			System.out.print("\t");
			System.out.print(i * Math.log(i));
			System.out.print("\t");
			System.out.print(Math.round(Math.pow(i, 2)));
			System.out.print("\t\t");
			System.out.print(Math.round(Math.pow(i, 3)));
			System.out.print("\t\t");
			System.out.println(Math.pow(2, i));
		}
	}
}
