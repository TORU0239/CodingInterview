package toru.array;

import java.util.HashMap;
import java.util.Map;

/* https://simpleprogrammer.com/programming-interview-questions/ */
public class ArrayCoding {
    public static void main(String[] args){
        ArrayCoding coding = new ArrayCoding();
        System.out.println(coding.findMissingNumber());
        int[] given = {1,2,3,4,4,5,6,6,7,7,8,9,10,10};
        coding.findDuplicatedNumber(given);

        int[] given2 = {3,1,4,19, 20,4,0, -1};
        coding.findLargestAndSmallest(given2);

        int[] given3 = {2,4,3,5,7,8,9};
        coding.findAllPairs(given3, 7);
        coding.findAllPairs(given3, 10);

        String[] arrS = {"a","b","c","d","e","f","g","h","i","j"};
        coding.reverseStrArr(arrS);
    }

    /* Problem 1 How do you find the missing number in a given integer array of 1 to 100? */
    private String findMissingNumber(){
        int[] givenArr = new int[100];
        for(int i = 0; i < 100 ; i++){
            if(i != 10){
                givenArr[i] = (i+1);
            }
        }

        int expectedSum = (givenArr.length * (givenArr.length + 1)) / 2;
        System.out.println("expected sum: " + expectedSum);

        int sumation = 0;
        for(int i : givenArr){
            sumation += i;
        }

        System.out.println("real sum: " + sumation);

        // what is missing?
        if(sumation - expectedSum == 0){
            return "Nothing";
        }
        return (expectedSum- sumation) + " is missing.";
    }

    /* Problem 2 How do you find the duplicate number of given integer array? or counting? */
    private void findDuplicatedNumber(int[] givenArr){
        HashMap<Integer,Integer> duplicated = new HashMap<>();

        for(int i : givenArr){
            if(duplicated.containsKey(i)){
                duplicated.put(i, duplicated.get(i) + 1);
            }
            else{
                duplicated.put(i, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : duplicated.entrySet()){
            System.out.printf("duplicated interger:: %d, count:: %d \n", entry.getKey(), entry.getValue());
        }
    }

    /* Problem 3 How do you find the largest and smallest number in an unsorted integer array? */
    private void findLargestAndSmallest(int[] givenArr){
        int tempLarge = 0, tempSmall = 0;
        for(int i : givenArr){
            if(i > tempLarge){
                tempLarge = i;
            }

            if(i < tempSmall){
                tempSmall = i;
            }
        }

        System.out.printf("The largest :: %d, the smallest :: %d", tempLarge, tempSmall);
    }

    /* Problem 4 How do you find all pairs of an integer array whose sum is equal to given number? */
    private void findAllPairs(int[] arr, int given){
        for (int first : arr) {
            for (int second : arr) {
                if (first + second == given) {
                    System.out.printf("(%d, %d) %n", first, second);
                }
            }
        }
    }

    /* Problem 9. How do you reverse an array in place in Java? */
    private void reverseStrArr(String[] arr){
        String[] tempArr = new String[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            tempArr[arr.length-1-i] = arr[i];
        }

        for(String s : tempArr){
            System.out.print(s);
        }
    }

    /* Different Problem. that is solution for reversing based on a pivot.*/
    private void reverseArr(String[] arr){
        String temp;
        for(int index = 0 ; index < arr.length ; index++){
            temp = arr[index];
            arr[index] = arr[arr.length-1-index];
            arr[arr.length-1-index] = temp;
            System.out.print(arr[index]);
        }
    }
}