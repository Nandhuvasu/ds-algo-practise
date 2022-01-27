import java.util.*;

public class StockTradingEx {
    /**
     * This is slow method but easier to understand.
     * Time complexity is O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
     */
    static double maxProfitFirstSolution(double[] prices, int k){
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        double [][] T = new double[k+1][prices.length];
        int noOfDays = prices.length;
        for(int i=1; i <= k; i++){
            for(int j=1; j < noOfDays; j++){
                double maxVal = 0;
                for(int m =0; m<j; m++){
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]);
                }
                T[i][j] = Math.max(maxVal, T[i][j-1]);
            }
        }
        return T[k][prices.length - 1];
    }

    /**
     * This is faster method which does optimization on slower method
     * Time complexity here is O(K * number of days)
     *
     * Formula is
     * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
     * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
     */
    static double maxProfitSecondSolution(double[] prices, int k){
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        double[][] T = new double[k+1][prices.length];
        int noOfDays = prices.length;
        for(int i=1; i<= k; i++){
            double maxDiff = - prices[0];
            for(int j=1; j<noOfDays; j++){
                T[i][j] = Math.max(T[i][j-1], maxDiff+ prices[j]);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        printActualSolution(T,prices);
        return T[k][prices.length - 1];
    }

    static void printActualSolution(double T[][], double prices[]) {
        int i = T.length - 1; //3
        int j = T[0].length - 1; //no of days = 7

        Deque<Integer> stack = new LinkedList<>();
        while(true) {
            if(i == 0 || j == 0) {
                break;
            }
            if (T[i][j] == T[i][j-1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                Double maxDiff = T[i][j] - prices[j];
                for (int k = j-1; k >= 0; k--) {
                    if (T[i-1][k] - prices[k] == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            int buyAt = stack.pollFirst();
            System.out.println("Buy at price " + prices[buyAt] + " at day "+ buyAt);
            int sellAt = stack.pollFirst();
            System.out.println("Sell at price " + prices[sellAt] + " at day "+ sellAt);
        }

    }

    public static void main(String[] args){
        double [] prices = {2,5,7,1,4,3,1,3};
        double [] prices2 = {1074.42, 1073.70, 1073.43, 1074.54, 1072.90, 1070.00, 1070.00, 1069.00, 1067.89,1065.00, 1064.50,
                1060.55, 1062.54, 1064.11, 1061.82, 1064.35, 1060.01, 1061.49, 1062.61, 1060.01, 1060.00, 1060.00, 1061.49};
        int numOfTransactions = 5;
        System.out.println("Profit from first method" + " " + maxProfitFirstSolution(prices2, numOfTransactions));
        System.out.println("Profit from Second method" + " " + maxProfitSecondSolution(prices2, numOfTransactions));
    }
}
