import java.util.Scanner;

public class Main {
    //NAO MUDAR A ORDEM, as vezes buga, pq eu nsei mas da merda na hora de compilar 

    static Scanner entrada = new Scanner(System.in);

    static String[] nomesSalas = {"", "Sala 1", "Sala 2", "Sala 3", "Sala 4"};
    static String[] horarios = {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00"};

    static String[][] reservas = new String[5][6];

    public static void main(String[] args) {

        int opcao;
        do {
            exibirCabecalho(); // <== METODO COMPARTILHADO (ponto de conflito)
            exibirMenu();
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1: reservar(); break;
                case 2: cancelarReserva(); break;
                case 3: consultar(); break;
                case 4: exibirGradeHorarios(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
        entrada.close();

    }

    public static void exibirCabecalho() {
        System.out.println("==============================");
        System.out.println(" Reserva de Salas ");
        System.out.println("==============================");
    }
    public static void exibirMenu() {
        System.out.println("1 - Reservar Sala");
        System.out.println("2 - Cancelar Reserva");
        System.out.println("3 - Consultar");
        System.out.println("4 - Exibir Grade");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
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

    // Funcionalidade do Desenvolvedor A (case 1) - reservar uma sala
    static void reservar() {

        int s;
        int h;
        while (true) {
            try {
                System.out.print("Digite o número da sala: ");
                s = entrada.nextInt();
                if (s < 0 || s > 4)
                    System.out.println("Insira um valor entre 0 a 4!");
                else
                    break;
            }
            catch (Exception e) {
                System.out.println("Digite um valor válido!");
                entrada.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("Digite o índice do horário: ");
                h = entrada.nextInt();
                if (h < 0 || h > 5)
                    System.out.println("Insira um valor entre 0 a 5!");
                else
                    break;
            }
            catch (Exception e) {
                System.out.println("Digite um valor válido!");
                entrada.nextLine();
            }
        }

        if (salaDisponivel(s, h)) {
            entrada.nextLine(); // limpa o buffer antes de ler o nome
            System.out.print("Digite seu nome para a reserva: ");
            String nome = entrada.nextLine();
            reservarSala(s, h, nome);
        } else {
            System.out.println(nomesSalas[s] + " ja esta reservada nesse horario");
        }
    }

    static void cancelarReserva() {

        int s;
        int h;
        while (true) {
            try {
                System.out.print("Digite o número da sala: ");
                s = entrada.nextInt();
                if (s < 0 || s > 4)
                    System.out.println("Insira um valor entre 0 a 4!");
                else
                    break;
            }
            catch (Exception e) {
                System.out.println("Digite um valor válido!");
                entrada.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("Digite o índice do horário: ");
                h = entrada.nextInt();
                if (h < 0 || h > 5)
                    System.out.println("Insira um valor entre 0 a 5!");
                else
                    break;
            }
            catch (Exception e) {
                System.out.println("Digite um valor válido!");
                entrada.nextLine();
            }
        }


        if (!salaDisponivel(s, h)) {
            System.out.println("Reserva de " + reservas[s][h] + " na " + nomesSalas[s]
                    + " (" + horarios[h] + ") cancelada");
            reservas[s][h] = null;
        } else {
            System.out.println(nomesSalas[s] + " ja esta livre nesse horario");
        }
    }

    static void consultarSala(int sala) {
        System.out.println("\nConsulta da " + nomesSalas[sala] + ":");
        for (int h = 0; h < horarios.length; h++) {
            String status = reservas[sala][h] != null ? "Reservado (" + reservas[sala][h] + ")" : "Livre";
            System.out.println(horarios[h] + " -- " + status);
        }
    }

    // Funcionalidade do Desenvolvedor A (case 3) - consultar uma sala
    static void consultar() {

        int s;
        while (true) {
            try {
                System.out.print("Digite o número da sala: ");
                s = entrada.nextInt();
                if (s < 0 || s > 4)
                    System.out.println("Insira um valor entre 0 a 4!");
                else
                    break;
            }
            catch (Exception e) {
                System.out.println("Digite um valor válido!");
                entrada.nextLine();
            }
        }

        consultarSala(s);
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