import java.util.Scanner;

public class RutaEnTiempo {
    public static void main(String[] args) {
        int cantidad = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese la cantidad de coordenadas: ");
            cantidad = sc.nextInt();
        } while (cantidad < 1 || cantidad > 1000);

        int[] coordenadasX = new int[cantidad];
        int[] coordenadasY = new int[cantidad];
       int vc=0, vw=0; //vc es velocidad de cueva y vw es velocidad de la caminada
        int temporal = 0;

        for (int i = 0; i < cantidad; i++) {
            do {
                do {
                    System.out.println("\nCoordenadas " + i);
                    System.out.println("Ingrese X ");
                    coordenadasX[i] = sc.nextInt();
                } while (coordenadasX[i] < coordenadasX[i - 1]);
            } while (coordenadasX[i] < -10000 || coordenadasX[i] > 10000);

            do {
                System.out.println("Ingrese y: ");
                coordenadasY[i] = sc.nextInt();
            } while (coordenadasY[i] < -10000 || coordenadasY[i] > 10000);
        }

        //Ingresa la velocidad de la caminata normal
        do {
            System.out.println("Ingrese la velocidad de caminata: ");
            vw=sc.nextInt();
        }while(vw<1||vw>10);
        //ingresa la velocidad de la cueva
        do {
            System.out.println("Ingrese la velocidad de la cueva: ");
            vc=sc.nextInt();
        }while(vc<1||vc>10);



    }


    public static double calcularDistanciaEntrePuntos(int x1, int y1, int x2, int y2) {
        double distancia = 0;
        int elemeto1= (int) Math.pow(x2-x1,2);
        int elemeto2= (int) Math.pow(y2-y1,2);
        distancia=Math.sqrt(elemeto1+elemeto2);

        return distancia;
    }

}