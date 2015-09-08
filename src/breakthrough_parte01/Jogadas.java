package breakthrough_parte01;
/**
 * Created by juliano on 02/09/15.
 */
public class Jogadas {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /**
     * Construtor da classe jogada
     * @param x1 coordenada X de origem
     * @param y1 coordenada Y de origem
     * @param x2 coordenada X de destino
     * @param y2 coordenada Y de destino
     */
    public Jogadas(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    /**
     * Método get para coordenada X de origem
     * @return valor da coordenada X de origem
     */
    public int getX1()
    {
    	return this.x1;
    }

    /**
     * Método get para coordenada Y de origem
     * @return valor da coordenada Y de origem
     */
    public int getY1()
    {
    	return this.y1;
    }

    /**
     * Método get para coordenada X de destino
     * @return valor da coordenada X de destino
     */
    public int getX2()
    {
    	return this.x2;
    }

    /**
     * Método get para coordenada Y de destino
     * @return valor da coordenada Y de destino
     */
    public int getY2()
    {
    	return this.y2;
    }
    /**
     * Método toString para imprimir objetos do tipo Jogadas
     */
    @Override
    public String toString()
    {
    	return String.format("%n(%s,%s)->(%s,%s)", x1, y1, x2, y2);
    }
}
