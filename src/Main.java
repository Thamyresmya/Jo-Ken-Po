import java.util.Scanner;

public class Main {

	// static nao precisa instanciar o objeto (criar)
	public static JoKenPo starGame() {
		System.out.println("******* Jo-Ken-Po *******");
		Scanner scan = new Scanner(System.in);

		System.out.println("Informe seu nome");
		String playerName = scan.next().toUpperCase();

		Player user = new Player(playerName); // usuario

		Player IA = new Player("IA"); // maquina

		System.out.println(playerName + " Informe quantos rounds você deseja jogar: ");
		int rounds = scan.nextInt();

		return new JoKenPo(user, IA, rounds);

	}

	public static void main(String[] args) {
		JoKenPo joKenPo = starGame();
		joKenPo.toPlay();
		joKenPo.showFinalResult();
	}
}
