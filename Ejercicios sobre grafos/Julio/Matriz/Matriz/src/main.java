public class Main {
    public static void main(String[] args) throws Exception {
        String[][] satorSquare = {
                { "S", "A", "T", "O", "R" },
                { "A", "R", "E", "P", "O" },
                { "T", "E", "N", "E", "T" },
                { "O", "P", "E", "R", "A" },
                { "R", "O", "T", "A", "S" }
        };

        System.out.println("Sator Square:");
        for (int i = 0; i < satorSquare.length; i++) {
            for (int j = 0; j < satorSquare[i].length; j++) {
                System.out.print(satorSquare[i][j] + " ");
            }
            System.out.println();
        }
    }
}
