package breakthrough_parte01;
import java.util.ArrayList;
import java.util.Random;

public class Breakthrough {

	private final int ROW = 8;
	private final int COL = 8;
    public int[][] tabuleiro = new int[ROW][COL];

    /**
     * Construtor para criação do tabuleiro representado por uma matriz.
     * Preenche os valores da matriz com números 1 para as peças brancas
     * 2 para as peças pretas e 0 para as casas vazias.
     */
    public Breakthrough()
    {
        for(int i=0; i<ROW; i++)
            for(int j=0; j<COL; j++)
            {
                if(i==0 || i==1)
                    tabuleiro[i][j] = 2;
                else if(i==6 || i==7)
                    tabuleiro[i][j] = 1;
                else
                    tabuleiro[i][j] = 0;
            }
    }

    /**
     * Imprime na tela a configuração atual do tabuleiro.
     */
    public void imprimeTabuleiro()
    {
        System.out.printf("%n    %d %d %d %d %d %d %d %d %n%n", 0, 1, 2, 3, 4, 5, 6, 7);
        for(int i=0; i<ROW; i++)
        {
            System.out.printf("%d   ", i);
            for(int j=0; j<COL; j++)
            {
                System.out.printf("%d ", tabuleiro[i][j]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n    %s %s %s %s %s %s %s %s ", 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
    }
    
    /**
     * Imprime na tela as jogadas disponíves para as peças brancas.
     * @param lista
     */
    public void imprimeJogadasBrancas(ArrayList<Jogadas> lista)
    {
    	for(Jogadas j : lista)
    	{
    		System.out.print(j);
    	}
    }

    /**
     * Imprime na tela as jogadas disponíves para as peças pretas
     * @param lista
     */
    public void imprimeJogadasPretas(ArrayList<Jogadas> lista)
    {
    	for(Jogadas j : lista)
    	{
    		System.out.print(j);
    	}
    }

    /**
     * Verifica todas as jogadas válidas disponíves para as peças brancas
     * @return lista contendo todas as jogadas
     */
    public ArrayList<Jogadas> jogadasValidasBrancas(int [][] tabuleiro)
    {
    	//Lista para armazenar as jogadas disponíveis
    	ArrayList<Jogadas> lista = new ArrayList<Jogadas>();
    	
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if( tabuleiro[i][j] == 1)
                {
                    if(j==0)
                    {
                    	if(tabuleiro[i-1][j] != 1 && tabuleiro[i-1][j] != 2)
                    		lista.add(new Jogadas(i, j, i-1, j));
                    	if(tabuleiro[i-1][j+1] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j+1));
                    }
                    if(j>0 && j<7 && i!=0)
                    {
                    	if(tabuleiro[i-1][j-1] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j-1));
                    	if(tabuleiro[i-1][j] != 1 && tabuleiro[i-1][j] != 2)
                    		lista.add(new Jogadas(i, j, i-1, j));
                    	if(tabuleiro[i-1][j+1] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j+1));
                    }
                    if(j==7 && i!=0)
                    {
                    	if(tabuleiro[i-1][j] != 1 && tabuleiro[i-1][j] != 2)
                    		lista.add(new Jogadas(i, j, i-1, j));
                    	if(tabuleiro[i-1][j-1] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j-1));
                    }
                }
            }
        }
        return lista;
    }

    /**
     * Verifica todas as jogadas válidas disponíves para as peças pretas
     * @return lista contendo todas as jogadas
     */
    public ArrayList<Jogadas> jogadasValidasPretas(int [][] tabuleiro)
    {
    	//Lista para armazenar as jogadas disponíveis
    	ArrayList<Jogadas> lista = new ArrayList<Jogadas>();
    	
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if( tabuleiro[i][j] == 2)
                {
                    if(j==0)
                    {
                    	if(tabuleiro[i+1][j] != 2 && tabuleiro[i+1][j] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j));
                    	if(tabuleiro[i+1][j+1] != 2)
                    		lista.add(new Jogadas(i, j, i+1, j+1));
                    }
                    if(j>0 && j<7 && i!=7)
                    {
                    	if(tabuleiro[i+1][j-1] != 2)
                    		lista.add(new Jogadas(i, j, i+1, j-1));
                    	if(tabuleiro[i+1][j] != 2 && tabuleiro[i+1][j] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j));
                    	if(tabuleiro[i+1][j+1] != 2)
                    		lista.add(new Jogadas(i, j, i+1, j+1));
                    }
                    if(j==7 && i != 7)
                    {
                    	if(tabuleiro[i+1][j] != 2 && tabuleiro[i+1][j] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j));
                    	if(tabuleiro[i+1][j-1] != 2)
                    		lista.add(new Jogadas(i, j, i+1, j-1));
                    }
                }
            }
        }
        return lista;
    }

    /**
     * Aplica uma joga para as peças brancas. Usa os valores passados como parâmetro
     * para comparar a jogada fornecida com as disponíveis na lista de jogadas válidas para as peças brancas.
     * @param x1 coordenada X de origem
     * @param y1 coordenada Y de origem
     * @param x2 coordenada X de destino
     * @param y2 coordenada Y de destino
     */
    public boolean jogaBrancas(int x1, int y1, int x2, int y2, ArrayList<Jogadas> lista)
    {
    	for(Jogadas j : lista)
    	{
    		if(j.getX1() == x1 && j.getY1() == y1)
    			if(j.getX2() == x2 && j.getY2() == y2)
    			{
        		    tabuleiro[x1][y1] = 0;
        	    	tabuleiro[x2][y2] = 1;
        	    	return true;
    			}//Fim if
    	}//Fim for
    	return false;
    }

    /**
     * Aplica uma joga para as peças pretas. Usa os valores passados como parâmetro
     * para comparar a jogada fornecida com as disponíveis na lista de jogadas válidas para as peças pretas.
     * @param x1 coordenada X de origem
     * @param y1 coordenada Y de origem
     * @param x2 coordenada X de destino
     * @param y2 coordenada Y de destino
     */
    public boolean jogaPretas(int x1, int y1, int x2, int y2, ArrayList<Jogadas> lista)
    {
    	for(Jogadas j : lista)
    	{
    		if(j.getX1() == x1 && j.getY1() == y1)
    			if(j.getX2() == x2 && j.getY2() == y2)
    			{
        		    tabuleiro[x1][y1] = 0;
        	    	tabuleiro[x2][y2] = 2;
        	    	return true;
    			}//Fim if
    	}//Fim for
    	return false;
    }

    /**
     * Aplica uma jogada aleatória válida para as peças brancas
     * @param lista Lista com as jogadas válidas disponíveis para as peças brancas
     */
    public void jogadaAleatoriaBrancas(ArrayList<Jogadas> lista)
    {
    	Random rand = new Random();
    	int num = rand.nextInt(lista.size());
    	System.out.print("Brancas jogam ");
    	System.out.print(lista.get(num));
    	jogaBrancas( lista.get(num).getX1(), lista.get(num).getY1(), lista.get(num).getX2(), lista.get(num).getY2(), lista );
    }
    
    /**
     * Aplica uma jogada aleatória válida para as peças brancas
     * @param lista Lista com as jogadas válidas disponíveis para as peças brancas
     */
    public void jogadaAleatoriaPretas(ArrayList<Jogadas> lista)
    {
    	Random rand = new Random();
    	int num = rand.nextInt(lista.size());
    	jogaPretas( lista.get(num).getX1(), lista.get(num).getY1(), lista.get(num).getX2(), lista.get(num).getY2(), lista );
    }

    /**
     * 
     * @return True se o jogo terminou com algum vencedor. Do contrário False
     */
    public boolean fimDeJogo()
    {
        for(int i=0; i<ROW; i++)
        {
            if(tabuleiro[0][i] == 1)
            {
            	System.out.printf("%n%nBrancas ganham");
                return true;
            }
            if(tabuleiro[7][i] == 2)
            {
            	System.out.printf("%n%nPretas ganham");
                return true;
            }
        }
        return false;
    }
}
