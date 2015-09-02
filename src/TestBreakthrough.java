public class TestBreakthrough {

    public static void main(String args[])
    {
        Breakthrough breakthrough = new Breakthrough();
        breakthrough.imprime();
        System.out.printf("%n%n%n");

        breakthrough.jogadasValidasBrancas();
        System.out.println("Pressione qualquer tecla para efetuar uma jogada e imprimir o novo tabuleiro");
        new java.util.Scanner(System.in).nextLine();

        System.out.printf(breakthrough.fimDeJogo());
        breakthrough.jogaBrancas(6, 6, 0, 6);
        System.out.printf("%n%s%n", "Joga 6,6 -> 0,6");
        System.out.printf(breakthrough.fimDeJogo());

        System.out.printf("%n%n%n");
        breakthrough.imprime();
    }
}
