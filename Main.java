public class Main{

    static boolean[][] salas = new boolean[5][6];

    public static void main (String[] args)
    {
        exibirGradeHorarios();
    }

    static void cancelarReserva(int sala, int horario) {
        if ((sala < 0 || sala >= salas.length) || (horario < 0 || horario >= salas[0].length))
        {
            System.out.println("Sala ou horário inválido(s)!");
            return;
        }

        if (!salas[sala][horario])
        {
            System.out.println("A sala já está disponível nesse horário!");
            return;
        }

        salas[sala][horario] = false;
        System.out.println("Reserva cancelada!");

    }

    static void exibirGradeHorarios() {
        System.out.print("           8:00        9:00       10:00       11:00       12:00       13:00 ");
        System.out.println();
        for (int s = 0; s < salas.length; s++)
        {
            System.out.print("Sala " + (s+1) + " ");
            for (int h = 0; h < salas[s].length; h++) {
                System.out.print(" " + (salas[s][h] ? "Reservado" : "Disponível") + " ");
            }
            System.out.println();
        }
    }

}
