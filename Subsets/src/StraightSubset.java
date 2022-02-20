import java.util.*;

public class StraightSubset {
    // Breadth first search approach
    public static List<List<Integer>> findSubsets(int[] input){
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for(int i=0; i< input.length; i++){
            int num = input[i];
            int subsetSize = results.size();
            // add the num to all subsets in result
            for(int j=0; j < subsetSize; j++){
                // grab the list
                List<Integer> subset = new ArrayList<>(results.get(j));
                subset.add(num);
//                // add subset to end of results
                results.add(subset);
            }
        }
        return results;
    }

    public static void main(String[] args){
        List<List<Integer>> result = findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
