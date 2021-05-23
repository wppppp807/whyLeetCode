import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class why {
    public static List<Integer> getLike(int[] arr1,int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (arr1[0] > arr2[arr2.length-1] || arr2[0] >arr1[arr1.length-1])
            return null;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j])
                    res.add(arr1[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,2,7};
        int[] arr2 = new int[]{2,3,5,4,6};
        List<Integer> like = getLike(arr1, arr2);
        for (Integer integer : like) {
            System.out.println(integer);
        }
    }


}
