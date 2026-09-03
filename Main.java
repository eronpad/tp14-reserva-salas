import java.util.Scanner;
public class Main{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Matriz minhaMatriz = new Matriz();
        minhaMatriz.carregarSalas();
        minhaMatriz.carregarHorarios();
        minhaMatriz.imprimirMatriz();

        System.out.println("Digite uma sala para a sua reserva (de 1 a 4): ");
        int sala = scan.nextInt();
        System.out.println("Digite um horario (1 a 6)");
        int horario = scan.nextInt();
        horario -= 1;

        boolean disponivel = minhaMatriz.salaDisponivel(sala, horario);
        if (disponivel)
        {
            System.out.println("Digite seu nome para a reserva: ");
            scan.nextLine();
            String nome = scan.nextLine();
            minhaMatriz.reservarSala(sala, horario, nome);
        }
        else{
            System.out.println("Nao");
        }

        minhaMatriz.consultarSala(sala);
        minhaMatriz.exibirGradeHorarios();

        scan.close();
    }
}