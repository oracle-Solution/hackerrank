package graphs.medium;

import java.io.*;
import java.util.*;

public class JourneyToTheMoon {

    static List<List<Integer>> list;

    static boolean[] visited;

    // Complete the journeyToMoon function below. n < 10^5; p < 10^4 -> can't go for adj matrix
    static long journeyToMoon(int n, int[][] astronaut) {
        list = new ArrayList<>(n);
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            visited[i] = false;
            list.add(new ArrayList<>());
        }

        int length = astronaut.length;

        for(int i = 0; i < length; i++) {
            List<Integer> list1 = list.get(astronaut[i][0]);
            List<Integer> list2 = list.get(astronaut[i][1]);

            list1.add(astronaut[i][1]);
            list2.add(astronaut[i][0]);

            list.set(astronaut[i][0], list1);
            list.set(astronaut[i][1], list2);
        }

        long count = 0;

        for(int i = 0; i < n; i++) {
            int val = DFS(visited, i);
            count += val * (n - val);
        }

        return count/2;
    }

    private static int DFS(boolean[] visited, int startIndex) {
        int count = 0;
        if(!visited[startIndex]) {
            visited[startIndex] = true;
            count += 1;
            List<Integer> listOfIndex = list.get(startIndex);
            Iterator<Integer> iterator = listOfIndex.iterator();
            while(iterator.hasNext()) {
                int currentIndex = iterator.next();
                if(!visited[currentIndex]) {
                    count += DFS(visited, currentIndex);
                }
            }
        }

        return  count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);
        System.out.println(result);

        scanner.close();
    }
}