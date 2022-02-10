public class BinarySearchWithStrings {

    static int stringCompare(String str1, String str2){
        // if str1 > str2 => return 1
        // if str1< str2 => return -1
        // if equal return 0
        int i=0;
        while(i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)){
            i++;
        }
        if(str1.charAt(i) > str1.charAt(i)){
            return -1;
        } else if(str1.charAt(i) < str1.charAt(i)){
            return 1;
        } else {
            return 0;
        }
    }

    static int binarySearch(String[] input, String target){
        int left = 0;
        int right = input.length -1;
        while(left <= right){
            int position = (left + right) / 2;
            System.out.println(left);
            System.out.println(right);
            System.out.println(position);
            // determine position
            if(input[position].isEmpty()){
                int midLeft = position-1;
                int midRight = position+1;
                System.out.println(midLeft);
                System.out.println(midRight);
                while(true){
                    // update position
                    // No non-empty string on either side
                    if(midLeft < left && midRight > right){
                        return -1;
                    } else if(midLeft >= left && input[midLeft] != ""){
                        position = midLeft;
                        break;
                    } else if(midRight  <= right && input[midRight] != ""){
                        position = midRight;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            String match = input[position];
            System.out.println(match);
            if(target.compareTo(match) < 0){
                right = position-1;
            } else if(target.compareTo(match) > 0){
                left = position + 1;
            } else {
                return position;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String[] input = { "for", "", "", "", "geeks",
                "ide", "", "practice", "",
                "", "quiz", "", "" };
        String target = "quiz";
        int result = binarySearch(input, target);
        System.out.println(result);
    }
}
