package hackerrank;

import java.io.*;
import java.util.*;
public class Dragon1 {
    
    public static ArrayList<Integer> result = new ArrayList<>();
    // solution
    public static int dragon(ArrayList<Integer> nums){
        int count = 0, max = 0, nextMax = 0;
        result = new ArrayList<>();
        // handle edge case
        if (nums.size() == 0 || nums.get(0)==0 ){
            // System.out.println("failure");
            return -1;
        }
        // System.out.print(max + ", ");
        result.add(max);

        for (int i=0; i< nums.size(); i++){
            if (nums.get(i) < 0){
                return -1;
            }
            if (i > max){
                max = nextMax;
                // System.out.print(max + ", ");
                result.add(max);
                count ++ ;
            }
            
            if (i + nums.get(i) > nextMax){
                nextMax = i + nums.get(i);
            }
        }
        


        //System.out.print("out");
        return max > nums.size() - 1? count : -1;
    }    
    
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
            
        try {

            while (sc.hasNext()){

                if (sc.hasNextInt()){
                    int num = sc.nextInt();
                    list.add(num);
                    // System.out.println(num);                   
                }
            }
        } catch (InputMismatchException ime){
            System.out.println(ime.getMessage());
            // sc.nextLine();
        } catch (NumberFormatException nfe){
            System.out.println(nfe.getMessage());

        }

        
        // System.out.println(list.size());
        int count = dragon(list);
        // System.out.println(count);
        
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