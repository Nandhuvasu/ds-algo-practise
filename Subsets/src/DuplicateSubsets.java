import java.util.*;

public class DuplicateSubsets {

    public  static List<List<Integer>> findSubsets(int[] input){
        List<List<Integer>> results = new ArrayList<>();
        int startSubset = 0;
        int endSubset = 0;
        results.add(new ArrayList<>());
        for(int i=0; i< input.length; i++){
            int num = input[i];
            endSubset = results.size() -1;
            if(i >0) {
                // check if prev nnum is same as curr
                if (num == input[i - 1]) {
                    // update the subset pointers
                    startSubset = (endSubset / 2) + 1;
                }
            }
            System.out.println(startSubset);
            System.out.println(endSubset);
            // look through the subsets & add new num
            for(int j=startSubset; j<= endSubset; j++){
                List<Integer> currSubset = new ArrayList<>(results.get(j));
                currSubset.add(num);
                results.add(currSubset);
            }
        }
        return results;
    }

    public static void main(String[] args){
        List<List<Integer>> result = findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
