package teil_C;

import java.util.regex.Pattern;
import teil_A.WaehrungsSymbole;
import teil_A.*;

public class auslesen {

	public static void main(String[] args) {
		
		String[] eingaben = { "5 € 20 ct", "5.69 € ", "800 ct ", "8,89$   ", "8 $ 89 ¢", "70 £ 67p", "70,67 £" };
		WaehrungsSymbole[] waehrung = { new Euro().getSymbols(), new USD().getSymbols(), new GBP().getSymbols() };

		
		for (int i = 0; i < eingaben.length; i++) {

			for (int j = 0; j < waehrung.length; j++) {

				if (erkennen(eingaben[i].replace(" ", ""), waehrung[j]) == true) {
					System.out.println(eingaben[i] + " \tgehört zur Währung:\t " + waehrung[j].getName());
					break;
				}
			}
		}
	}

	protected static Boolean erkennen(String text, WaehrungsSymbole waehrung) {

		  String first = Pattern.quote(waehrung.getFirst());
		  String second = Pattern.quote(waehrung.getSecond());


		//00€00ct | 00ct | 0.00€
		return Pattern.matches("(\\d*" + first + "\\d*" + second + ")|(\\d*" + second	+ ")|(\\d+(,|\\.)\\d{2}" + first + ")", text);
	}
}
