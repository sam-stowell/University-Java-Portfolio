package CIS2206.Unit_20;

public class Carpet {
    static int size = (243);
    // 27 243

//    static int overallCount = 5;
    static char[][] carpet = new char[size][size];

    public static void carpetUpdateRow(int x, int y, int size) {
        if (x < 0) {
            return;
        }
        if (size == 1) {
            carpet[x][y] = '*';
            return;
        }


        int newSize = size / 3;
        for (int i = x; i < x + size; i += newSize) {
            for (int j = y; j < y + size; j += newSize) {
                if (i != x + newSize || j != y + newSize) {
                    carpetUpdateRow(i, j, newSize);
                }
            }
        }



        // recursive case, progress (through columns)
//        carpetUpdateRow(x-1, y-1);
    }
    public static void generateCarpet(int n) {
        carpetUpdateRow(0, 0, size);
    }

    public static void main(String[] args) {
        // Initialize the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                carpet[i][j] = ' ';
            }
        }

        generateCarpet(size / 3);

        // Print final board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(carpet[i][j] + " ");
            }
            System.out.println();
        }

    }
}
