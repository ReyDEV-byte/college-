import java.util.Scanner;
public class Que_dios_nos_ampare { //Jose Javier Fernandez Bravo
    public static void main(String[] args){
        final int unending = Integer.MAX_VALUE;
        int nods=7;
        String[] values = {"A", "B", "C", "D", "E", "F", "O"};
        int[][] graph_god = new int[nods][nods];

        graph_god[6][0]=2;
        graph_god[6][1]=5;
        graph_god[6][3]=6;
        graph_god[5][4]=25;
        graph_god[5][3]=0;
        graph_god[5][1]=1;
        graph_god[4][2]=15;
        graph_god[4][3]=8;
        graph_god[4][5]=25;
        graph_god[3][4]=8;
        graph_god[3][5]=0;
        graph_god[3][1]=12;
        graph_god[2][0]=7;
        graph_god[2][3]=22;
        graph_god[2][4]=15;
        graph_god[1][6]=5;
        graph_god[1][5]=1;
        graph_god[1][3]=12;
        graph_god[0][6]=2;
        graph_god[0][2]=7;

        Scanner input = new Scanner(System.in);

        System.out.println("Deme el punto de origen: ");
        int origin_point = input.nextInt();
        System.out.println("Deme el punto final: ");
        int finish_point = input.nextInt();

        int[] minimun_distance = new int[nods];
        boolean[] ready = new boolean[nods];
        int[] possible_result = new int[nods];

        for(int i=0; i<nods; i++){
            minimun_distance[i]=unending;
            ready[i] =false;
            possible_result[i]=-1;
        }
        minimun_distance[origin_point]=0;

        for (int i = 0; i < nods - 1; i++) {
            int minimun = unending;
            int nod_index = -1;
            for (int j = 0; j < nods; j++) {
                if (!ready[j] & minimun_distance[j] < minimun) {
                    minimun = minimun_distance[j];
                    nod_index = j;
                }
            }
            if(nod_index == -1)break;
            ready[nod_index]=true;

            for(int k=0; k<nods; k++ ){
                if (!ready[k] && graph_god[nod_index][k] != 0 && (minimun_distance[nod_index] + graph_god[nod_index][k]) < minimun_distance[k]) {
                    minimun_distance[k] = minimun_distance[nod_index] + graph_god[nod_index][k];
                    possible_result[k] =nod_index;
                }
            }
        }
        System.out.println("La distancia minima a recorrer es de: " + minimun_distance[finish_point]);
        System.out.print("El camino minimo es: ");
        int[] way = new int[nods];
        int maximun=0;
        int actual_way= finish_point;
        while(actual_way!=-1){
            way[maximun++]=actual_way;
            actual_way= possible_result[actual_way];
        }
        for(int i=maximun-1 ; i>=0; i--){
            System.out.print(values[way[i]]+ " ");
        }
    }
}
