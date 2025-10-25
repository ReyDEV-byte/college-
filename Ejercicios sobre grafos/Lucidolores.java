//Reynaldo A. Ramos Alvarez
//心を燃やせ  KOKORO WO MOYASE
import java.util.Scanner;
public class Lucidolores {
    public static void main (String[]args){
        Scanner in= new Scanner(System.in);
        final int inf = Integer.MAX_VALUE;
        final int n=7;
        String[] nodos = {"A","B","C","D","E","F","O"};
        int[][] graph = new int[n][n];
        boolean[] seen = new boolean[n];
        graph[6][0]=2;
        graph[0][6]=2;
        graph[6][1]=5;
        graph[1][6]=5;
        graph[6][3]=6;
        graph[3][6]=6;
        graph[0][2]=7;
        graph[2][0]=7;
        graph[2][3]=22;
        graph[3][2]=22;
        graph[2][4]=15;
        graph[4][2]=15;
        graph[4][3]=8;
        graph[3][4]=8;
        graph[4][5]=25;
        graph[5][4]=25;
        graph[5][3]=0;
        graph[3][5]=0;
        graph[5][1]=1;
        graph[1][5]=1;
        graph[1][3]=12;
        graph[3][1]=12;
System.out.println("Ingrese el punto de partida");
        int origin = in.nextInt();
System.out.println("Ingrese el punto de llegada");
        int llegada = in.nextInt();

        int[] dist_min = new int[n];

        int[] possible = new int[n];

        for(int i=0; i<n; i++){
            dist_min[i]=inf;
            seen[i] =false;
            possible[i]=-1;
        }
        dist_min[origin]=0;

        for (int i = 0; i < n - 1; i++) {
            int min = inf;
            int index_nod = -1;
            for (int j = 0; j < n; j++) {
                if (!seen[j] && dist_min[j] < min) {
                    min = dist_min[j];
                    index_nod = j;
                }
            }
            if(index_nod == -1)break;
            seen[index_nod]=true;

            for(int k=0; k<n; k++ ){
                if (!seen[k] && graph[index_nod][k] != 0 && (dist_min[index_nod] + graph[index_nod][k]) < dist_min[k]) {
                    dist_min[k] = dist_min[index_nod] + graph[index_nod][k];
                    possible[k] =index_nod;
                }
            }
        }
        System.out.println("Distancia a recorrer es: " + dist_min[llegada]);
        System.out.print("Los caminos son: ");
        int[] camino = new int[n];
        int max=0;
        int ahora= llegada;
        while(ahora!=-1){
            camino[max++]=ahora;
            ahora= possible[ahora];
        }
        for(int i=max-1 ; i>=0; i--){
            System.out.print(nodos[camino[i]]+ " ");
        }
        System.out.println("\n");
        System.out.println("Reconocimientos especiales a DeepSeek, Copilot, qwen, entre otros");
    }
}
