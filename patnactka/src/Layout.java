import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Layout {
    Random r = new Random();
    private int size = 4;
    private int fifteenSize = 16;
    private int[][] fifteen = new int[size][size];
    private int zeroX = 0;
    private int zeroY = 0;


    public Layout() {
        setFifteen();
    }

    public void setFifteen() {

        ArrayList<Integer> help = new ArrayList<>();
        while (help.size() != fifteenSize) {
            int helpNumber = r.nextInt(16);
            if (!help.contains(helpNumber)) {
                help.add(helpNumber);
            }
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                fifteen[i][j] = help.get(count);
                count++;
            }
        }
    }

    public String drawLayout() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (fifteen[i][j] < 10) {
                    text.append(" ");
                }
                if (fifteen[i][j] == 0) {
                    zeroX = i;
                    zeroY = j;
                    if (j == 3) {
                        text.append(" ");
                        text.append("\n");
                    } else {
                        text.append("  * ");
                    }

                } else {
                    if (j == 3) {
                        text.append(fifteen[i][j]);
                        text.append("\n");
                    } else {
                        text.append(fifteen[i][j] + " * ");
                    }
                }

            }

        }
        return text.toString();
    }

    public void swapNumber(int number) {
        if (number == 0) {
            throw new InputMismatchException();
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (fifteen[i][j] == number) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        if (a > 0 && b > 0 && a < 3 && b < 3) {
            if (fifteen[zeroX][zeroY] == fifteen[a - 1][b] || fifteen[zeroX][zeroY] == fifteen[a + 1][b] || fifteen[zeroX][zeroY] == fifteen[a][b - 1] || fifteen[zeroX][zeroY] == fifteen[a][b + 1]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        } else if (a == 0 && b == 0) {
            if (fifteen[zeroX][zeroY] == fifteen[a + 1][b] || fifteen[zeroX][zeroY] == fifteen[a][b + 1]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        } else if (a == 3 && b == 3) {
            if (fifteen[zeroX][zeroY] == fifteen[a - 1][b] || fifteen[zeroX][zeroY] == fifteen[a][b - 1]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        } else if (a == 0 && b == 3) {
            if (fifteen[zeroX][zeroY] == fifteen[a + 1][b] || fifteen[zeroX][zeroY] == fifteen[a][b - 1]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        } else if (a == 3 && b == 0) {
            if (fifteen[zeroX][zeroY] == fifteen[a - 1][b] || fifteen[zeroX][zeroY] == fifteen[a][b + 1]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        } else if ((b == 1 || b == 2) && (a == 0)) {
            if (fifteen[zeroX][zeroY] == fifteen[a][b + 1] || fifteen[zeroX][zeroY] == fifteen[a][b - 1] || fifteen[zeroX][zeroY] == fifteen[a + 1][b]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        } else if ((b == 1 || b == 2) && (a == 3)) {
            if (fifteen[zeroX][zeroY] == fifteen[a - 1][b] || fifteen[zeroX][zeroY] == fifteen[a][b - 1] || fifteen[zeroX][zeroY] == fifteen[a][b + 1]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        } else if ((a == 1 || a == 2) && (b == 0)) {
            if (fifteen[zeroX][zeroY] == fifteen[a - 1][b] || fifteen[zeroX][zeroY] == fifteen[a + 1][b] || fifteen[zeroX][zeroY] == fifteen[a][b + 1]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        } else if ((a == 1 || a == 2) && (b == 3)) {
            if (fifteen[zeroX][zeroY] == fifteen[a - 1][b] || fifteen[zeroX][zeroY] == fifteen[a + 1][b] || fifteen[zeroX][zeroY] == fifteen[a][b - 1]) {
                fifteen[a][b] = 0;
                fifteen[zeroX][zeroY] = number;
                zeroX = a;
                zeroY = b;
            } else {
                throw new RuntimeException("Your number isn't neighboring with space");
            }
        }

    }

    public boolean check() {
        int count = 0;
        int help = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (fifteen[i][j] == help) {
                    count++;
                }
                help++;
            }
        }
        if (fifteen[3][3] == 0) {
            count++;
        }
        if (count == 16) {
            return true;
        } else {
            return false;
        }
    }
}
