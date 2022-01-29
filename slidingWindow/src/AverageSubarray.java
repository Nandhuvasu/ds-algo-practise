public class AverageSubarray {

    static double[] computeAverage(int[] input, int subArrLength){
        // combinations of subarray in an array
        double[] result = new double[input.length - subArrLength +1];
        // start window at 0
        int windowStart = 0;
        double windowSum = 0;
        for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
            windowSum += input[windowEnd];
            System.out.println("windowStart "+ windowStart);
            System.out.println("windowEnd "+ windowEnd);
            System.out.println("windowSum "+ windowSum);
            if(windowEnd >= subArrLength - 1){
                result[windowStart] = windowSum/subArrLength;
                System.out.println("sum added "+ result[windowStart]);
                // subtract first element from sum
                windowSum -= input[windowStart];
                windowStart += 1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = {1,3,2,6,-1,4,1,8,2};
        double[] result = computeAverage(input, 5);
        for(int i=0; i< result.length;i++){
            System.out.println(result[i]);
        }
    }
}
