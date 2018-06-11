package toru;

public class BasicAlgorithm {

    public static void main(String[] args){
        BasicAlgorithm algorithm = new BasicAlgorithm();
        int[] given = {1,10,3,4,5,6,4,9};
        algorithm.linearSearch(10, given);
        algorithm.linearSearch(9, given);

        int[] sorted = {1,2,3,4,5,6,7,8,9};
        algorithm.binarySearch(6, sorted);
        algorithm.binarySearch(3, sorted);

        int[] arr = {10,4, 5, 1, 3, 6,11,20, 40,30, 54};
        algorithm.bubbleSorting(arr);

    }

    /* Problem 1. Linear Search, O(n) */
    private void linearSearch(int given, int[] givenArr){
        int index = 1;
        for(int i : givenArr){
            if(i == given){
                break;
            }
            index++;
        }
        System.out.println("index you want is " + index);
    }

    /* Problem 2. Binary Search */
    private void binarySearch(int given, int[] givenArr){
        int left = 0, right = givenArr.length - 1;
        int mid;

        while(right >= left){
            mid = (right + left)/2;
            if(given == givenArr[mid]){
                System.out.printf("%d is in the array with index value : %d \n", given, mid);
                break;
            }

            if(given > givenArr[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
    }

    /* Fibonacci by recursion */
    private int fibonacci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    /* Bubble Sorting */
    private void bubbleSorting(int[] givenArr){
        int temp;

        for(int i = 0 ; i < givenArr.length - 1 ; i++){
            for(int j = 0 ; j < givenArr.length - i - 1 ; j++){
                if(givenArr[j] > givenArr[j+1]){
                    temp = givenArr[j+1];
                    givenArr[j+1] = givenArr[j];
                    givenArr[j] = temp;
                }
            }
        }

        for(int a : givenArr){
            System.out.print(a);
        }
    }

    /* Merge Sort */
    private void mergeSorting(int[] givenArr){

    }
}