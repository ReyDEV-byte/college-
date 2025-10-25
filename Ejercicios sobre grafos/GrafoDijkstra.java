class Grafo {

        public static void main(String[] args) {

                int[][] matriz = {

                                { 0, 2, 5, 0, 6, 0, 0 },
                                { 2, 0, 0, 7, 0, 0, 0 },
                                { 5, 0, 0, 0, 12, 0, 1 },
                                { 0, 7, 0, 0, 22, 15, 0 },
                                { 6, 0, 12, 22, 0, 8, 0 },
                                { 0, 0, 0, 15, 8, 0, 25 },
                                { 0, 0, 1, 0, 1, 25, 0 }

                };

                int[] recorrido = new int[10];

                boolean[] verificar = new boolean[7];

                int costoDelRecorrido = 0;

                int iniciO = 0;
                int finaL = 6;

                for (int i = 0; i < 7; i++) {

                        if (matriz[iniciO][i] > 0 && !verificar[i]) {

                                recorrido[0] = iniciO;
                                recorrido[1] = i;
                                verificar[iniciO] = true;
                                verificar[i] = true;
                                costoDelRecorrido += matriz[iniciO][i];

                                for (int j = 0; j < 7; j++) {

                                        if (matriz[i][j] > 0 && !verificar[j]) {

                                                recorrido[2] = j;

                                                verificar[j] = true;

                                                costoDelRecorrido += matriz[i][j];

                                                if (j == finaL) {

                                                        System.out.print(recorrido[0] + "→");
                                                        System.out.print(recorrido[1] + "→");
                                                        System.out.println(recorrido[2]);
                                                        System.out.println("Total del costo: " + costoDelRecorrido);

                                                }

                                                for (int k = 0; k < 7; k++) {

                                                        if (matriz[j][k] > 0 && !verificar[k]) {

                                                                recorrido[3] = k;

                                                                verificar[k] = true;

                                                                costoDelRecorrido += matriz[j][k];

                                                        }

                                                }

                                                verificar[j] = false;
                                                costoDelRecorrido -= matriz[i][j];

                                        }

                                }

                        }

                }

        }

}
