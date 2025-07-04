package task2;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) throws IOException {
        Scanner scCircle = new Scanner(new File(args[0]));
        BigDecimal cx = new BigDecimal(scCircle.next());
        BigDecimal cy = new BigDecimal(scCircle.next());
        BigDecimal radius = new BigDecimal(scCircle.next());
        BigDecimal radiusSq = radius.pow(2);

        Scanner scPoints = new Scanner(new File(args[1]));
        while(scPoints.hasNext()){
            BigDecimal x = new BigDecimal(scPoints.next());
            BigDecimal y = new BigDecimal(scPoints.next());

            BigDecimal dx = x.subtract(cx);
            BigDecimal dy = y.subtract(cy);
            BigDecimal distanceSquared = dx.pow(2).add(dy.pow(2));

            int cmp = distanceSquared.compareTo(radiusSq);
            System.out.println(cmp == 0 ? 0 : (cmp < 0 ? 1 : 2));
        }
    }
}
