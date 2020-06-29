import java.util.*;

/*
 Write a program in your preferred language that given an array of integers A
 will find all the pairs of numbers that if subtracted will result in a specific
 given number M. For example for the array A={4,5,10,11,6} and the number M=-1
 will return the following pairs: 0-1, 2-3, 1-4. This means that A[0]-A[1]=4-5=-1
 A[2]-A[3]=10-11=-1 si A[1]-A[4]=5-6=-1. Please explain the space/time performance
 and other trade-offs.

Ex:
 -1
 5
 4 5 10 11 6

 Space Complexity: O(n), where n is the size of the given array.
 Time Complexity: O(n * log(n)), because the most expensive part is to sort the arrayList(n * log(n))
                  while "solveTask" tasks O(n) and reading the array takes O(n) too.
 */

class Pair<T> {
    T first, second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

}


public class Main {
    private static int n, m;
    private static List<Pair<Integer>> solution, arrayList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt();
        n = scanner.nextInt();

        arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new Pair<>(scanner.nextInt(), i));
        }

        arrayList.sort((o1, o2) -> o1.first - o2.first);

        solution = new ArrayList<>();
        solveTask();

        for (int i = 0; i < solution.size(); i++) {
            System.out.println(solution.get(i).first + " " + solution.get(i).second);
        }
    }


    private static void solveTask() {
        int i = 0, j = 1;

        while (i < arrayList.size() && j < arrayList.size()) {
             if (i != j && (arrayList.get(i).first - arrayList.get(j).first == m ||
                    arrayList.get(j).first - arrayList.get(i).first == m)) {
                solution.add(new Pair(arrayList.get(i).second, arrayList.get(j).second));
                i++;
                j++;
            } else if (arrayList.get(j).first - arrayList.get(i).first > m) {
                i++;
            } else {
                j++;
            }
        }
    }
}
