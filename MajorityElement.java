import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;

public class MajorityElement {

    
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){


            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num,1);
            }
            if(map.get(num) > (nums.length)/2){
                System.out.println(num);
                return num;


            }
        }
        return 0;


    }

    public static void main(String[] args) {

        int [] number = {2,2,1,1,1,2,2};
        MajorityElement me = new MajorityElement();
        me.majorityElement(number);
    }
}
