import java.util.Scanner;

public class RutaEnTiempo {
    public static void main(String[] args) {
        int cantidad=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese la cantidad de coordenadas: ");
        cantidad= sc.nextInt();

        String[][] coordenadas = new String[cantidad][cantidad];
        int xi; int yi;

        for (int i = 0; i <cantidad ; i++) {
            System.out.println("\nCoordenadas "+i);
            System.out.println("Ingrese X ");
            xi=sc.nextInt();

            for (int j = 0; j <1 ; j++) {
                System.out.println("Ingrese y: ");
                yi=sc.nextInt();
                coordenadas[i][j]="("+xi+","+yi+")";
            }

        }
        for (int i = 0; i <cantidad ; i++) {
            for (int j = 0; j <1 ; j++) {
                System.out.println(coordenadas[i][j]);
            }

        }

    }


    public static double calcularDistanciaEntrePuntos(int x1, int y1, int x2, int y2) {
        double distancia = 0;
        int elemeto1= (int) Math.pow(x2-x1,2);
        int elemeto2= (int) Math.pow(y2-y1,2);
        distancia=Math.sqrt(elemeto1+elemeto2);

        return distancia;
    }

}