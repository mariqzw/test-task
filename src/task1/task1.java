package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число для создания размерности массива: ");
        int n = sc.nextInt();
        System.out.println("Введите значение для интервала: ");
        int m = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        System.out.println("Круговой массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }

        List<Integer> path = new ArrayList<>();
        int index = 0;
        do {
            path.add(arr[index]);
            index = (index + m - 1) % n;

        } while (index != 0);

        System.out.println("\nРезультат: ");
        for (int num : path) {
            System.out.print(num);
        }
    }
}
