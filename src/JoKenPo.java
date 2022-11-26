import java.util.Random;
import java.util.Scanner;

//record não precisa ter os gets e sets
public record JoKenPo(Player user, Player IA, int rounds) {

	public void toPlay() {
		System.out.println("\n******* SEJA BEM-VINDO(A), " + user.getName() + " *******\n");

		for (int i = 1; i <= rounds; i++) {
			int choiceUser = choiceUser();
			if (choiceUser < 1 || choiceUser > 3) {
				System.out.println("\nJOGADA INVÁLIDA! (1, 2 ou 3): ");
				System.out.println("\tPONTO PARA " + IA.getName() + "\n");
				IA.incrementScore();
				continue;  
			}

			int choiceIA = choiceIA();

			System.out.println("\n" + choiceUser + " X " + choiceIA + "\n");

			int result = choiceUser - choiceIA;
			
			winnerRound(result);
		}
				
	}
	
	//comparação do resultado final
	public void showFinalResult() {
		System.out.println("\n*******************************************\n");
		
		Integer finalUserScore = user.getScore();
		Integer finalIAScore = IA.getScore();
		
		System.out.println("\n\tPLACAR FINAL: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());
		
		if(finalIAScore == finalUserScore) {
			System.out.println("\t\t\tEMPATE!");		
		} else {
			//if ternario se a condição for vdd ? a IA vendeu, : falso usuario venceu
			String finalWinner = (finalIAScore > finalUserScore) ? IA.getName() : user.getName();			
			System.out.println("\t\tVENCENDOR = " + finalWinner.toUpperCase());
		}	
		
		System.out.println("\n*******************************************\n");
	}
	
	

	// metodo para fazer comparação de quem ganhou
	private void winnerRound(int result) {
		String winnerRound;
		if (result == 0) {
			winnerRound = "EMPATE";
		} else {
			if (result == -1 || result == 2) {
				IA().incrementScore();
				winnerRound = IA().getName();
			} else {
				user.incrementScore();
				winnerRound = user.getName();
			}
		}
		
		System.out.println("\nVencedor do Round: " + winnerRound + "\n");
	}

	// escolha da maquina
	private int choiceIA() {
		Random random = new Random();
		return random.nextInt(3) + 1; // random gera numero a partir do 0
	}

	// escolha do usuario
	private int choiceUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - PEDRA");
		System.out.println("2 - PAPEL");
		System.out.println("3 - TESOURA");

		System.out.println("\nInforme sua jogada: ");

		return scan.nextInt();
	}

}
