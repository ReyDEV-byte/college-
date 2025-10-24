public class Escuela{
    public static void main(String args[]){
    String Sator = "Sator";
    int contador = 0;
    char [][] matriz = {
        
                {'s', 'a', 't', 'o', 'r'},
                {'a', 'r', 'e', 'p', 'o'},
                {'t', 'e', 'n', 'e', 't'},
                {'o', 'p', 'e', 'r', 'a'},
                {'r', 'o', 't', 'a', 's'},
        };
       for(int i=0;i<5;i++){

            if(matriz[i][2]=='t'){

                if(matriz[i][0]=='s' || matriz[i][0]=='r' && matriz[i][1]=='a' || matriz[i][1]=='o' && matriz[i][3]=='o' || matriz[i][3]=='a' && matriz[i][4]=='s' || matriz[i][4]=='r')
                    contador++; 
            }
        }

        for(int i=0;i<5;i++){

            if(matriz[2][i]=='t'){

                if(matriz[0][i]=='s' || matriz[0][i]=='r' && matriz[1][i]=='a' || matriz[1][i]=='o' && matriz[3][i]=='o' || matriz[3][i]=='a' && matriz[4][i]=='s' || matriz[4][i]=='r')
                    contador++;
            }
        }

        if(matriz[2][2]=='t')
            if(matriz[0][0]=='s' || matriz[0][0]=='r' && matriz[1][1]=='a' || matriz[1][1]=='o' && matriz[3][3]=='a' || matriz[3][3]=='o' &&  matriz[4][4]=='r' || matriz[0][0]=='s')
                contador++;

        if(matriz[2][2]=='t')
            if(matriz[0][4]=='s' || matriz[0][4]=='r' && matriz[1][3]=='a' || matriz[1][3]=='o' && matriz[3][1]=='a' || matriz[3][1]=='o' &&  matriz[4][0]=='r' || matriz[4][0]=='s')
                contador++;
System.out.print("la cantidad de sator es: ");
        System.out.print(contador);
    }
}
//Adrian Jesus Pelaez Rodriguez 
    

