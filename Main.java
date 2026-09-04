public class Main{

    static String[][] salas = new String[5][6];

    public static void main (String[] args)
    {
        Matriz minhaMatriz = new Matriz();

        minhaMatriz.carregarSalas();
        minhaMatriz.carregarHorarios();
        minhaMatriz.imprimirMatriz();

    }

    static void cancelarReserva() {
        
    }

}
