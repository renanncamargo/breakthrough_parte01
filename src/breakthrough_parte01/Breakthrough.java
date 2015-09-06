package breakthrough_parte01;
import java.util.ArrayList;
import java.util.Random;

public class Breakthrough {

    private int[][] tabuleiro = new int[8][8];

    /**
     * Construtor da classe Breakthrough
     * 
     * Preenche a matriz que repesenta o tabuleiro com 1s para representar as peças pretas
     * com 2s para representar as peças brancas e com 0s para representar casas vazias.
     */
    public Breakthrough()
    {
        for(int i=0; i<8; i++)
            for(int j=0; j<8; j++)
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
     * Método para imprimir a configuração atual do tabuleiro (posição de peças brancas, pretas e casas vazias
     */
    public void imprimeTabuleiro()
    {
        for(int i=0; i<8; i++)
        {
            System.out.printf("%d%t", i);
            for(int j=0; j<8; j++)
            {
                System.out.printf("%d ", tabuleiro[i][j]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n%n");
    }
    
    public void imprimeJogadasBrancas()
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if( tabuleiro[i][j] == 1)
                {
                    if(j==0)
                    {
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i-1, j);
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i-1, j+1);
                    }
                    if(j!=0 && j!=7)
                    {
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i-1, j-1);
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i-1, j);
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i-1, j+1);
                    }
                    if(j==7)
                    {
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i-1, j);
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i-1, j-1);
                    }
                }
            }
        }
    	
    }

    public void imprimeJogadasPretas()
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if( tabuleiro[i][j] == 2)
                {
                    if(j==0)
                    {
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i+1, j);
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i+1, j+1);
                    }
                    if(j>0 && j<7)
                    {
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i+1, j-1);
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i+1, j);
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i+1, j+1);
                    }
                    if(j==7)
                    {
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i+1, j);
                        System.out.printf("(%d,%d)->(%d,%d)%n", i, j, i+1, j-1);
                    }
                }
            }
        }
    	
    }

    
    /**
     * Verifica quais as jogadas válidas para as peças brancas e devolve um vetor com todas as jogadas disponíveis.
     * @param ArrayList<Jogadas>
     * @return ArrayList<Jogadas>
     */
    public ArrayList<Jogadas> jogadasValidasBrancas()
    {
    	//Lista para armazenar as jogadas disponíveis
    	ArrayList<Jogadas> lista = new ArrayList<Jogadas>();
    	
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if( tabuleiro[i][j] == 1)
                {
                    if(j==0)
                    {
                    	if(tabuleiro[i-1][j] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j));
                    	if(tabuleiro[i-1][j+1] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j+1));
                    }
                    if(j>0 && j<7)
                    {
                    	if(tabuleiro[i-1][j-1] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j-1));
                    	if(tabuleiro[i-1][j] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j));
                    	if(tabuleiro[i-1][j+1] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j+1));
                    }
                    if(j==7)
                    {
                    	if(tabuleiro[i-1][j] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j));
                    	if(tabuleiro[i-1][j-1] != 1)
                    		lista.add(new Jogadas(i, j, i-1, j-1));
                    }
                }
            }
        }
        return lista;
    }
    
    public ArrayList<Jogadas> jogadasValidasPretas()
    {
    	//Lista para armazenar as jogadas disponíveis
    	ArrayList<Jogadas> lista = new ArrayList<Jogadas>();
    	
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if( tabuleiro[i][j] == 2)
                {
                    if(j==0)
                    {
                    	if(tabuleiro[i-1][j] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j));
                    	if(tabuleiro[i-1][j+1] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j+1));
                    }
                    if(j>0 && j<7)
                    {
                    	if(tabuleiro[i-1][j-1] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j-1));
                    	if(tabuleiro[i-1][j] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j));
                    	if(tabuleiro[i-1][j+1] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j+1));
                    }
                    if(j==7)
                    {
                    	if(tabuleiro[i-1][j] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j));
                    	if(tabuleiro[i-1][j-1] != 1)
                    		lista.add(new Jogadas(i, j, i+1, j-1));
                    }
                }
            }
        }
        return lista;
    }
    
    public void jogaBrancas(int x1, int y1, int x2, int y2)
    {
//        tabuleiro[jogada.getX1()][jogada.getY1()] = 0;
//        tabuleiro[jogada.getX2()][jogada.getY2()] = 1;
    	
    	tabuleiro[x1][y1] = 0;
    	tabuleiro[x2][y2] = 1;
    }

    public void jogaPretas(Jogadas jogada)
    {
//        tabuleiro[jogada.getX1()][jogada.getY1()] = 0;
//        tabuleiro[jogada.getX2()][jogada.getY2()] = 2;
    }

    public void jogadaAleatoriaBrancas(ArrayList<Jogadas> lista)
    {
    	Random rand = new Random();
    	int num = rand.nextInt(lista.size());
    	jogaBrancas( lista.get(num).getX1(), lista.get(num).getY1(), lista.get(num).getX2(), lista.get(num).getY2() );
    }
    
    public boolean fimDeJogo()
    {
        for(int i=0; i<8; i++)
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
