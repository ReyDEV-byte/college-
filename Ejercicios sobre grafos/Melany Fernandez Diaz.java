public class CABEZADEESKELETO {
    public static void main (String [] args) {
        String Sator = "Sator";
        int contador = 0;
        char[][] cabezadeeskeleto = {
                {'s', 'a', 't', 'o', 'r'},
                {'a', 'r', 'e', 'p', 'o'},
                {'t', 'e', 'n', 'e', 't'},
                {'o', 'p', 'e', 'r', 'a'},
                {'r', 'o', 't', 'a', 's'},
        };
        for(int i=0;i<5;i++){

            if(cabezadeeskeleto[i][2]=='t'){

                if(cabezadeeskeleto[i][0]=='s' || cabezadeeskeleto[i][0]=='r' && cabezadeeskeleto[i][1]=='a' || cabezadeeskeleto[i][1]=='o' && cabezadeeskeleto[i][3]=='o' || cabezadeeskeleto[i][3]=='a' && cabezadeeskeleto[i][4]=='s' || cabezadeeskeleto[i][4]=='r')
                    contador++;
            }
        }

        for(int i=0;i<5;i++){

            if(cabezadeeskeleto[2][i]=='t'){

                if(cabezadeeskeleto[0][i]=='s' || cabezadeeskeleto[0][i]=='r' && cabezadeeskeleto[1][i]=='a' || cabezadeeskeleto[1][i]=='o' && cabezadeeskeleto[3][i]=='o' || cabezadeeskeleto[3][i]=='a' && cabezadeeskeleto[4][i]=='s' || cabezadeeskeleto[4][i]=='r')
                    contador++;
            }
        }

        if(cabezadeeskeleto[2][2]=='t')
            if(cabezadeeskeleto[0][0]=='s' || cabezadeeskeleto[0][0]=='r' && cabezadeeskeleto[1][1]=='a' || cabezadeeskeleto[1][1]=='o' && cabezadeeskeleto[3][3]=='a' || cabezadeeskeleto[3][3]=='o' &&  cabezadeeskeleto[4][4]=='r' || cabezadeeskeleto[0][0]=='s')
                contador++;

        if(cabezadeeskeleto[2][2]=='t')
            if(cabezadeeskeleto[0][4]=='s' || cabezadeeskeleto[0][4]=='r' && cabezadeeskeleto[1][3]=='a' || cabezadeeskeleto[1][3]=='o' && cabezadeeskeleto[3][1]=='a' || cabezadeeskeleto[3][1]=='o' &&  cabezadeeskeleto[4][0]=='r' || cabezadeeskeleto[4][0]=='s')
                contador++;
            System.out.print("la cantidad de sator es: ");
            System.out.print(contador);
    }
}
//MELANY FERNANDEZ DIAZ