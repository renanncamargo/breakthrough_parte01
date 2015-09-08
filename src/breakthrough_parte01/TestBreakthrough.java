package breakthrough_parte01;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestBreakthrough {

    public static void main(String args[])
    {
    	int x1 = 0;
    	int y1 = 0;
    	int x2 = 0;
    	int y2 = 0;
    	int escolha = 0;
    	Scanner input = new Scanner(System.in);
        Breakthrough breakthrough = new Breakthrough();
        ArrayList<Jogadas> jogadasBrancas = breakthrough.jogadasValidasBrancas(breakthrough.tabuleiro);
        ArrayList<Jogadas> jogadasPretas = breakthrough.jogadasValidasPretas(breakthrough.tabuleiro);
        
        //Primeira jogada. Brancas começam
        breakthrough.jogadaAleatoriaBrancas(jogadasBrancas);
        
        while(!breakthrough.fimDeJogo())
        {
        	System.out.println("\n\n\nEscolha uma das opções seguintes: ");
        	System.out.println("1 - Imprime a configuração do tabuleiro");
        	System.out.println("2 - Imprime as jogadas disponíveis para as peças brancas");
        	System.out.println("3 - Imprime as jogadas disponíveis para as peças pretas");
        	System.out.println("4 - Aplica uma jogada para as peças pretas");
        	escolha = input.nextInt();
        	switch (escolha) {
			case 1:
				breakthrough.imprimeTabuleiro();
				System.out.print("\n\nPressione \"Enter\" para continuar");
				
				break;
			case 2:
				breakthrough.imprimeJogadasBrancas(jogadasBrancas);
				break;
			case 3:
				breakthrough.imprimeJogadasPretas(jogadasPretas);
				break;
			case 4:
				//Aplica jogada para as peças pretas
				System.out.printf("%nInsira as jogadas uma por linha");
				x1 = input.nextInt();
				y1 = input.nextInt();
				x2 = input.nextInt();
				y2 = input.nextInt();
				breakthrough.jogaPretas(x1, y1, x2, y2, jogadasPretas);
				jogadasPretas = breakthrough.jogadasValidasPretas(breakthrough.tabuleiro);
				
				//Brancas respondem automaticamente aplicando uma jogada aleatória
		        breakthrough.jogadaAleatoriaBrancas(jogadasBrancas);
				jogadasBrancas = breakthrough.jogadasValidasBrancas(breakthrough.tabuleiro);
		        break;
			default:
				System.out.println("Escolha uma opção válida.");
				break;
			}//Fim switch case
        }//Fim While
        
    }//Fim main
}//Fim TestBreakthrough
