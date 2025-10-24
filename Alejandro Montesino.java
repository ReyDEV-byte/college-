//Alejandro Montesino
import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int contador = 0;
        char[][]craneo = {{"S", "A", "T", "O", "R"},
                          {"A", "R", "E", "P", "O"},
                          {"T", "E", "N", "E", "T"},
                          {"O", "P", "E", "R", "A"},
                          {"R", "O", "T", "A", "S"}};

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                String s=scanner.next();
                craneo[i][j]=s.charAt(0);
            }
        }

        for(int i=0;i<5;i++){

            if(craneo[i][2]=='t'){

                if(craneo[i][0]=='s' || craneo[i][0]=='r' && craneo[i][1]=='a' || craneo[i][1]=='o' && craneo[i][3]=='o' || craneo[i][3]=='a' && craneo[i][4]=='s' || craneo[i][4]=='r')
                    contador++;
            }
        }

        for(int i=0;i<5;i++){

            if(craneo[2][i]=='t'){

                if(craneo[0][i]=='s' || craneo[0][i]=='r' && craneo[1][i]=='a' || craneo[1][i]=='o' && craneo[3][i]=='o' || craneo[3][i]=='a' && craneo[4][i]=='s' || craneo[4][i]=='r')
                    contador++;
            }
        }

        if(craneo[2][2]=='t')
            if(craneo[0][0]=='s' || craneo[0][0]=='r' && craneo[1][1]=='a' || craneo[1][1]=='o' && craneo[3][3]=='a' || craneo[3][3]=='o' &&  craneo[4][4]=='r' || craneo[0][0]=='s')
                contador++;

        if(craneo[2][2]=='t')
            if(craneo[0][4]=='s' || craneo[0][4]=='r' && craneo[1][3]=='a' || craneo[1][3]=='o' && craneo[3][1]=='a' || craneo[3][1]=='o' &&  craneo[4][0]=='r' || craneo[4][0]=='s')
                contador++;

        System.out.println("La cantidad de veces que aprece la palabara SATOR en la tabla es "+ contador + ".");
    }
}