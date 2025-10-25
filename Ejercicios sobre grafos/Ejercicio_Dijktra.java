//Ray Sanjudo Mesa.

public class Ejercicio_Dijktra {
    public static void main (String[]args){
        final int inf = Integer.MAX_VALUE;
        int n=7;
        String[] valores = {"A","B","C","D","E","F","O"};
        int[][] grafo_pandora = new int[n][n];

        grafo_pandora[6][0]=2;
        grafo_pandora[0][6]=2;
        grafo_pandora[6][1]=5;
        grafo_pandora[1][6]=5;
        grafo_pandora[6][3]=6;
        grafo_pandora[3][6]=6;
        grafo_pandora[0][2]=7;
        grafo_pandora[2][0]=7;
        grafo_pandora[2][3]=22;
        grafo_pandora[3][2]=22;
        grafo_pandora[2][4]=15;
        grafo_pandora[4][2]=15;
        grafo_pandora[4][3]=8;
        grafo_pandora[3][4]=8;
        grafo_pandora[4][5]=25;
        grafo_pandora[5][4]=25;
        grafo_pandora[5][3]=0;
        grafo_pandora[3][5]=0;
        grafo_pandora[5][1]=1;
        grafo_pandora[1][5]=1;
        grafo_pandora[1][3]=12;
        grafo_pandora[3][1]=12;

        int punto_origen = 6;

        int punt_llegada = 4;

        int[] distancia_min = new int[n];
        boolean[] revisado = new boolean[n];
        int[] posible_resultado = new int[n];

        for(int i=0; i<n; i++){
            distancia_min[i]=inf;
            revisado[i] =false;
            posible_resultado[i]=-1;
        }
        distancia_min[punto_origen]=0;

        for (int i = 0; i < n - 1; i++) {
            int min = inf;
            int indice_del_nodo = -1;
            for (int j = 0; j < n; j++) {
                if (!revisado[j] && distancia_min[j] < min) {
                    min = distancia_min[j];
                    indice_del_nodo = j;
                }
            }
            if(indice_del_nodo == -1)break;
            revisado[indice_del_nodo]=true;

            for(int k=0; k<n; k++ ){
                if (!revisado[k] && grafo_pandora[indice_del_nodo][k] != 0 && (distancia_min[indice_del_nodo] + grafo_pandora[indice_del_nodo][k]) < distancia_min[k]) {
                    distancia_min[k] = distancia_min[indice_del_nodo] + grafo_pandora[indice_del_nodo][k];
                    posible_resultado[k] =indice_del_nodo;
                }
            }
        }
        System.out.println("Distancia a recorrer es: " + distancia_min[punt_llegada]);
        System.out.print("Los caminos son: ");
        int[] camino = new int[n];
        int max=0;
        int lugar_actual= punt_llegada;
        while(lugar_actual!=-1){
            camino[max++]=lugar_actual;
            lugar_actual= posible_resultado[lugar_actual];
        }
        for(int i=max-1 ; i>=0; i--){
            System.out.print(valores[camino[i]]+ " ");
        }
    }
}
//Gracias por leer <3
//Un recconocimiento especial a :Copilot.