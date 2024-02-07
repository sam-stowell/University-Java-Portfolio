package CIS2206.Unit_13.hanoi;


import java.util.Stack;

/**
 * Tower of Hanoi
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class TowerOfHanoi {

    // Number of disks
    public static int numOfDisks = 3;

    // Stacks representing towers
    static Stack<Integer> s1 = new Stack();
    static Stack<Integer> s2 = new Stack();
    static Stack<Integer> s3 = new Stack();

    public static void main(String[] args) {

        // Push disks into first tower (minimum number at the top)
        for (int i = numOfDisks; i > 0; i--) {
            s1.push(i);
        }

        // Print initial state
        printTowers();

        // Solve Tower of Hanoi by moving disks
        solve(numOfDisks, s1, s2, s3);
    }

    /**
     * Solve Hanoi Tower
     *
     * @param n Disk to be moved
     * @param source Stack indicating the source
     * @param auxiliary Stack used as middle point
     * @param destination Stack indicating the destination
     */
    public static void solve(int n,
                             Stack<Integer> source,
                             Stack<Integer> auxiliary,
                             Stack<Integer> destination) {
        if (n > 0) {
            // Solve Hanoi Tower for n-1, move top n-1 elements
            // from source to auxiliary (using destination as middle point)
            solve(n - 1, source, destination, auxiliary);

            // Move disk n from source to destination
            destination.push(source.pop());

            // Print towers to show change
            printTowers();

            // Solve Hanoi Tower for n-1, move top n-1 elements
            // from auxiliary to destination (using source as middle point)
            solve(n - 1, auxiliary, source, destination);
        }
    }


    /**
     * Print Towers
     */
    public static void printTowers() {

        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");

        for (int i = numOfDisks - 1; i >= 0; i--) {
            String a = (i < s1.size()) ? s1.get(i).toString() : " ";
            String b = (i < s2.size()) ? s2.get(i).toString() : " ";
            String c = (i < s3.size()) ? s3.get(i).toString() : " ";
            System.out.println("  " + a + "  |  " + b + "  |  " + c);
        }
        System.out.println("\n");
    }
}
