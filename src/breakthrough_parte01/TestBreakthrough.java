package breakthrough_parte01;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestBreakthrough {

    public static void main(String args[])
    {
    	int[] movimento = new int[4];
    	Scanner input = new Scanner(System.in);
        Breakthrough breakthrough = new Breakthrough();
        ArrayList<Jogadas> jogadasBrancas = breakthrough.jogadasValidasBrancas();
        ArrayList<Jogadas> jogadasPretas = breakthrough.jogadasValidasPretas();
    }
}
