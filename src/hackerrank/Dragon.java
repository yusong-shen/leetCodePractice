package hackerrank;

import java.io.*;
import java.util.*;
public class Dragon {
    
    public static ArrayList<Integer> result = new ArrayList<>();
    // Greegy Method 
    public static int dragon(ArrayList<Integer> nums){

        // last reachable index, current reachable index, selected index 
        int lReach = 0, curReach = 0, selIndex = 0;
        result = new ArrayList<>();
        int n = nums.size();
        // handle edge case
        if (n == 0 || nums.get(0)==0 ){
            return -1;
        }
    
        
        int i;
        for (i = 0; i < nums.size(); i++){
            // handle negative number
            if (nums.get(i) < 0){
                return -1;
            }
            // if the index is beyond current reach then just break
            if (i > curReach) break;
            
            if (i > lReach){
                // update lReach
                lReach = curReach;
                result.add(selIndex);

            }
            // update current reach
            int sum = i + nums.get(i);
            if (sum > curReach){
                selIndex = i;
               
            }
            
            curReach = Math.max(curReach, sum);
        }
        
        // if i was beyond last reach and possible result exists
        if ((i > lReach) && (result.size()>0) && (result.get(result.size()-1) != selIndex)){
            result.add(selIndex);
        }
        
        // deal with corner case that stuck in last element
        if (lReach == nums.size() -1 && nums.get(nums.size() -1)==0){
            return -1;
        } else if(lReach >= nums.size() -1){
            return result.size();
        } else {
            return -1;
        }
    }    
    
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
            
        try {

            while (sc.hasNext()){
                
                String line = sc.nextLine();
                Integer num = Integer.parseInt(line);
                list.add(num);
                
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
            System.out.println("failure");
            // sc.nextLine();
        } 

        
        // System.err.println(list.size());
        int count = dragon(list);
        // System.err.println(count);
        
        if (count == -1){
            System.out.println("failure");
        } else{
            for (int i=0; i< result.size(); i++){
                System.out.print(result.get(i)+ ", ");
            }
            System.out.print("out");
        }

    }
}