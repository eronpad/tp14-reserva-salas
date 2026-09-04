import java.util.Scanner;

public class Main {
    //NAO MUDAR A ORDEM, as vezes buga, pq eu nsei mas da merda na hora de compilar 

    static String[] nomesSalas = {"", "Sala 1", "Sala 2", "Sala 3", "Sala 4"};
    static String[] horarios = {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00"};

    static String[][] reservas = new String[5][6];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        exibirGradeHorarios();

        System.out.println("\nDigite uma sala para a sua reserva (de 1 a 4): ");
        int sala = scan.nextInt();
        System.out.println("Digite um horario (1 a 6): ");
        int horario = scan.nextInt();
        horario -= 1;

        if (salaDisponivel(sala, horario)) {
            System.out.println("Digite seu nome para a reserva: ");
            scan.nextLine();
            String nome = scan.nextLine();
            reservarSala(sala, horario, nome);
        } else {
            System.out.println("Nao disponivel");
        }

        consultarSala(sala);
        exibirGradeHorarios();

        scan.close();
    }

    static boolean salaDisponivel(int sala, int horario) {
        return reservas[sala][horario] == null;
    }

    static void reservarSala(int sala, int horario, String responsavel) {
        if (salaDisponivel(sala, horario)) {
            reservas[sala][horario] = responsavel;
            System.out.println(nomesSalas[sala] + " reservada para " + responsavel + " no horario " + horarios[horario]);
        } else {
            System.out.println(nomesSalas[sala] + " ja esta reservada nesse horario");
        }
    }

    static void cancelarReserva(int sala, int horario) {
        if (!salaDisponivel(sala, horario)) {
            System.out.println("Reserva de " + reservas[sala][horario] + " na " + nomesSalas[sala]
                    + " (" + horarios[horario] + ") cancelada");
            reservas[sala][horario] = null;
        } else {
            System.out.println(nomesSalas[sala] + " ja esta livre nesse horario");
        }
    }

    static void consultarSala(int sala) {
        System.out.println("\nConsulta da " + nomesSalas[sala] + ":");
        for (int h = 0; h < horarios.length; h++) {
            String status = reservas[sala][h] != null ? "Reservado (" + reservas[sala][h] + ")" : "Livre";
            System.out.println(horarios[h] + " -- " + status);
        }
    }

    static void exibirGradeHorarios() {
        System.out.print("          ");
        for (int h = 0; h < horarios.length; h++) {
            System.out.print(horarios[h] + "  ");
        }
        System.out.println();
        for (int s = 1; s < nomesSalas.length; s++) {
            System.out.print(nomesSalas[s] + "  ");
            for (int h = 0; h < horarios.length; h++) {
                String status = reservas[s][h] != null ? "OCUPADO " : "LIVRE   ";
                System.out.print(status);
            }
            System.out.println();
        }
    }
}