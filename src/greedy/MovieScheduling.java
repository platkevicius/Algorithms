package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MovieScheduling {

    public static void main(String[] args) {
        MovieScheduling movieScheduling = new MovieScheduling();

        System.out.println(movieScheduling.decideOffer(Arrays.asList(new Pair(1, 2), new Pair(3, 4), new Pair(5, 6), new Pair(7, 8),
                                                                     new Pair(0, 8), new Pair(10, 14), new Pair(12, 16), new Pair(15, 19))).size());
    }

    public List<Pair> decideOffer(List<Pair> offers) {

        List<Pair> modifiable = new ArrayList<>(offers);
        List<Pair> solution = new ArrayList<>();
        while (!modifiable.isEmpty()) {
            int index = 0;
            int minEnd = Integer.MAX_VALUE;

            for (int i = 0; i < modifiable.size(); i++) {
                if (modifiable.get(i).y < minEnd) {
                    minEnd = modifiable.get(i).y;
                    index = i;
                }
            }

            solution.add(modifiable.get(index));
            Pair compare = modifiable.get(index);
            modifiable.remove(modifiable.get(index));

            modifiable.removeIf(pair -> (pair.x >= compare.x && pair.x <= compare.y) || (pair.y <= compare.y && pair.y >= compare.x));
        }

        return solution;
    }

    private static class Pair {
        private final int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                   "x=" + x +
                   ", y=" + y +
                   '}';
        }
    }
}
