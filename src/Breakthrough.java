/**
 * Created by juliano on 25/08/15.
 */

public class Breakthrough {

    private int[][] tabuleiro = new int[8][8];

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

    public void imprime()
    {
        for(int i=0; i<8; i++)
        {
            System.out.printf("%n");
            for(int j=0; j<8; j++)
            {
                System.out.printf("%d ", tabuleiro[i][j]);
            }
        }
    }

    public void jogadasValidasBrancas()
    {
        /**
         * Lista jogadas disponíveis para as peças brancas
         */
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if( tabuleiro[i][j] == 1)
                {
                    if(j==0)
                    {
                        System.out.printf("%d,%d -> %d,%d %n", i, j, i-1, j);
                        System.out.printf("%d,%d -> %d,%d %n", i, j, i-1, j+1);
                    }
                    if(j!=0 && j!=7)
                    {
                        System.out.printf("%d,%d -> %d,%d %n", i, j, i-1, j-1);
                        System.out.printf("%d,%d -> %d,%d %n", i, j, i-1, j);
                        System.out.printf("%d,%d -> %d,%d %n", i, j, i-1, j+1);
                    }
                    if(j==7)
                    {
                        System.out.printf("%d,%d -> %d,%d %n", i, j, i-1, j);
                        System.out.printf("%d,%d -> %d,%d %n", i, j, i-1, j-1);
                    }
                }
            }
        }
    }

    public String jogaBrancas(int x1, int y1, int x2, int y2)
    {
        tabuleiro[x1][y1] = 0;
        tabuleiro[x2][y2] = 1;
        return "jogo";
    }

    public String jogaPretas(int x1, int y1, int x2, int y2)
    {
        tabuleiro[x1][y1] = 0;
        tabuleiro[x2][y2] = 2;
        return "jogo";
    }

    public String fimDeJogo()
    {
        for(int i=0; i<8; i++)
        {
            if(tabuleiro[0][i] == 1)
                return "Brancas ganham";
            if(tabuleiro[7][i] == 2)
                return "Pretas ganham";
        }
        return "Jogo continua";
    }
}
