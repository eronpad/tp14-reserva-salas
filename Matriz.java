public class Matriz {
    private String[][] matriz = new String[5][6];

    public void carregarSalas(){
        matriz[1][0] = "Sala A-1";
        matriz[1][1] = "Sala A-2";
        matriz[1][2] = "Sala A-3";
        matriz[1][3] = "Sala B-1";
        matriz[1][4] = "Sala B-2";
        matriz[1][5] = "Sala B-3";
        matriz[2][0] = "Sala C-1";
        matriz[2][1] = "Sala C-2";
        matriz[2][2] = "Sala C-3";
        matriz[2][3] = "Sala D-1";
        matriz[2][4] = "Sala D-2";
        matriz[2][5] = "Sala D-3";
        matriz[3][0] = "Sala E-1";
        matriz[3][1] = "Sala E-2";
        matriz[3][2] = "Sala E-3";
        matriz[3][3] = "Sala F-1";
        matriz[3][4] = "Sala F-2";
        matriz[3][5] = "Sala F-3";
        matriz[4][0] = "Sala G-1";
        matriz[4][1] = "Sala G-2";
        matriz[4][2] = "Sala G-3";
        matriz[4][3] = "Sala H-1";
        matriz[4][4] = "Sala H-2";
        matriz[4][5] = "Sala H-3";
    }

    public void carregarHorarios(){
        matriz[0][0] = "12:00 --";
        matriz[0][1] = "12:30 --";
        matriz[0][2] = "13:00 --";
        matriz[0][3] = "13:30 --";
        matriz[0][4] = "14:00 --";
        matriz[0][5] = "14:30 --";
    }



    public void imprimirMatriz()
    {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
    }
}
}