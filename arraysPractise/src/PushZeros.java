public class PushZeros {

    public static int[] pushZeros(int[] input){
        int count =0;
        for(int i=0; i< input.length;i++){
            if(input[i] != 0){
                input[count] = input[i];
                count++;
            }
        }
        System.out.println(count);
        while(count < input.length){
            input[count] = 0;
            count++;
        }
        return input;
    }

    public static void main(String[] args){
        int[] input = {2,0,4,5,0,0,7,8};
        int[] result = pushZeros(input);
        for(int i=0; i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
