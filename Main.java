public class Main{

    static String[][] salas = new String[5][6];

    public static void main (String[] args)
    {
        Matriz minhaMatriz = new Matriz();

        minhaMatriz.carregarSalas();
        minhaMatriz.carregarHorarios();
        minhaMatriz.imprimirMatriz();

    }

    static void cancelarReserva(int sala, int horario) {
        if ((sala < 0 || sala >= salas.length) || (horario < 0 || horario >= salas[0].length))
        {
            System.out.println("Sala ou horário inválido(s)!");
            return;
        }

        if (salas[sala][horario] == null)
        {
            System.out.println("A sala já está disponível nesse horário!");
            return;
        }

        salas[sala][horario] = null;
        System.out.println("Reserva cancelada!");

    }

}
