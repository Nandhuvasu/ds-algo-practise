public class SmallestSubarrayWithGreaterSum {

    static int findSmallestSubarray(int[] input, int expectedSum){
        int windowLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        for(int windowEnd =0; windowEnd < input.length; windowEnd++){
            windowSum += input[windowEnd];
            // keep reducing the window size till sum < expected sum
            while(windowSum >= expectedSum){
                windowLength = Math.min(windowLength, windowEnd - windowStart + 1);
                // subtract the beginning element - shortening the window by one element
                windowSum -= input[windowStart];
                windowStart++;
            }
        }
        return (windowLength == Integer.MAX_VALUE? 0: windowLength);
    }

    public static void main(String[] args){
        int[] input = {2,1,5,2,3,2};
        int result = findSmallestSubarray(input, 7);
        System.out.println("Smallest subarray length "+ result);
    }
}
