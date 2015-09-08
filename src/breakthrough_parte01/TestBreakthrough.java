package breakthrough_parte01;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestBreakthrough {

    public static void main(String args[])
    {
    	int[] movimento = new int[4];
    	int escolha = 0;
    	Scanner input = new Scanner(System.in);
        Breakthrough breakthrough = new Breakthrough();
        ArrayList<Jogadas> jogadasBrancas = breakthrough.jogadasValidasBrancas();
        ArrayList<Jogadas> jogadasPretas = breakthrough.jogadasValidasPretas();
        //Primeira jogada. Brancas começam
        breakthrough.jogadaAleatoriaBrancas(jogadasBrancas);
        while(!breakthrough.fimDeJogo())
        {
        	System.out.println("\nEscolha uma das opções seguintes: ");
        	System.out.println("1 - Imprime a configuração do tabuleiro");
        	System.out.println("2 - Imprime as jogadas disponíveis para as peças brancas");
        	System.out.println("3 - Imprime as jogadas disponíveis para as peças pretas");
        	System.out.println("4 - Aplica uma jogada para as peças pretas");
        	escolha = input.nextInt();
        	switch (escolha) {
			case 1:
				breakthrough.imprimeTabuleiro();
				break;
			case 2:
				breakthrough.imprimeJogadasBrancas(jogadasBrancas);
				break;
			case 3:
				breakthrough.imprimeJogadasPretas(jogadasPretas);
				break;
			case 4:
				//Aplica jogada para as peças pretas
				breakthrough.jogadaAleatoriaPretas(jogadasPretas);
				//Brancas respondem automaticamente aplicando uma jogada aleatória
		        breakthrough.jogadaAleatoriaBrancas(jogadasBrancas);
		        break;
			default:
				System.out.println("Escolha uma opção válida.");
				break;
			}//Fim switch case
        }//Fim While
        
    }//Fim main
}//Fim TestBreakthrough
