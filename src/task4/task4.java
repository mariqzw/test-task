package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File (args[0]));
        List<Integer> listOfNums = new ArrayList<>();

        while (sc.hasNextInt()) {
            listOfNums.add(sc.nextInt());
        }
        sc.close();

        int[] nums = listOfNums.stream().mapToInt(i -> i).toArray();
        Arrays.sort(nums);

        int median = nums[nums.length/2];

        int resultMoves = 0;
        for (int num : nums) {
            resultMoves += Math.abs(num - median);
        }

        System.out.println(resultMoves);
    }
}
