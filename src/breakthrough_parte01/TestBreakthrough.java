import java.util.ArrayList;
import java.util.Random;

public class TestBreakthrough {

    public static void main(String args[])
    {
        Breakthrough breakthrough = new Breakthrough();
        breakthrough.imprime();

        ArrayList<Jogadas> lista = breakthrough.jogadasValidasBrancas();
        
        breakthrough.jogadaAleatoriaBrancas(lista);
        breakthrough.jogadaAleatoriaBrancas(lista);
        breakthrough.jogadaAleatoriaBrancas(lista);
        breakthrough.imprime();
        //System.out.println("Pressione qualquer tecla para efetuar uma jogada e imprimir o novo tabuleiro");
        //new java.util.Scanner(System.in).nextLine();

    }
}
