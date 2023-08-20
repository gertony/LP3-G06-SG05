import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		int vida, rp;
		boolean fl = false;
		vida = 0;
		Scanner sc = new Scanner(System.in);
		do {
			vida++;
			System.out.println("Vida: " + vida + "\t¿Cuál es el número secreto?");
			rp = sc.nextInt();
			if (rp == 1234)
				fl = true;
		} while (vida < 3 && !fl);
		
		if (fl) {
			String premio = Regalo.elegir(vida);
			System.out.println("Premio: " + premio);
		} else {
			System.out.println("Ups, perdiste....");
		}
	}

	static class Regalo{
		public static String elegir(int vida) {
			String gift = "";
			switch(vida) {
			case 1: gift = "Un viaje al caribe"; break;
			case 2: gift = "Una visita al museo más cercano a tu casa"; break;
			case 3: gift = "Una entrada al cine"; break;
			}
			return gift;
		}
	}
}
