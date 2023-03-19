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
                    temporal=coordenadasX[i];
                    System.out.println("\nCoordenadas " + i);//ingreso de coordenadas en x
                    System.out.println("Ingrese X ");
                    coordenadasX[i] = sc.nextInt();
                } while (coordenadasX[i] < temporal);//no se puede retroceder en x
            } while (coordenadasX[i] < -10000 || coordenadasX[i] > 10000);

            do {
                System.out.println("Ingrese y: ");//ingreso de coordenadas en y
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

        double distancia = 0; double distanciaMont; double tiempoMin=0;
        for (int i = 0; i <cantidad; i++){
            distanciaMont=calcularDistanciaEntrePuntos(coordenadasX[i], coordenadasX[i+1],coordenadasY[i], coordenadasY[i+1]);
            if ((coordenadasY[i]>0&&coordenadasY[i+1]<0) || (coordenadasY[i]<0 && coordenadasY[i+1]>0)){//cueva
                distancia+=distanciaMont;// añade a la distancia la distanciA de un punto a otro cuando y es negativo, no podra atravesar una cueva
                tiempoMin+=distanciaMont/vw;// a distancia de ese tramo con la velocidad de caminata será el tiempo en ese tramo se acumulará
            }else{
                double distanciaHorizontal=calcularDistanciaHorizontal(coordenadasX[i], coordenadasX[i+1]);
                if(vw>vc || vw<vc){ // se caminaaa o se cava segun el tiempo transcurrido en ese intervalo
                    double tiempoMont=distanciaMont/vw;
                    double tiempoCueva=distanciaHorizontal/vc;
                    if (tiempoMont>tiempoCueva){
                        tiempoMin+=tiempoCueva;
                    }else{
                        tiempoMin+=tiempoMont;
                    }
                }
                if (vw==vc) {
                    //se mira la longitud de la montaña
                    if (distanciaMont > distanciaHorizontal) {
                        tiempoMin += distanciaHorizontal / vc;
                    } else {
                        tiempoMin += distanciaMont / vw;
                    }
                }

            }
        }
        System.out.println("El tiempo es: " +tiempoMin);



    }

    public static double calcularDistanciaEntrePuntos(int x1, int x2, int y1, int y2) {
        double distancia = 0;
        int elemeto1= (int) Math.pow(x2-x1,2);
        int elemeto2= (int) Math.pow(y2-y1,2);
        distancia=Math.sqrt(elemeto1+elemeto2);

        return distancia;
    }
    public static double calcularDistanciaHorizontal(int x1, int x2){
       double resultado;
       resultado=(x2-x1);
       return resultado;
    }


}