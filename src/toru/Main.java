package toru;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* https://javarevisited.blogspot.com/2015/01/top-20-string-coding-interview-question-programming-interview.html
*/

public class Main {

    public static void main(String[] args){
        Main main = new Main();

        // No.1
        main.printDuplicateCharacters("Programming");
        main.printDuplicateCharacters("Osama Silk");
        main.printDuplicateCharacters("Toru Choi");

        // No.2
        System.out.println("this is result for " + main.checkIfAnagramWithSorting("word", "wrdo"));
        System.out.println("this is result for " + main.checkIfAnagramWithSorting("mary", "army"));
        System.out.println("this is result for " + main.checkIfAnagramWithSorting("stop", "tops"));
        System.out.println("this is result for " + main.checkIfAnagramWithSorting("boat", "btoa"));
        System.out.println("this is result for " + main.checkIfAnagramWithSorting("pure", "in"));

        // No.3
        System.out.println("this is result for number 3 " + main.checkPrintFirstNonRepeated("abcdefghija"));
        System.out.println("this is result for number 3 " + main.checkPrintFirstNonRepeated("hello"));
        System.out.println("this is result for number 3 " + main.checkPrintFirstNonRepeated("Java"));
        System.out.println("this is result for number 3 " + main.checkPrintFirstNonRepeated("simplest"));

        // No.4
        System.out.println("This is resulf for number 4 " + main.reverseString("Java"));
        System.out.println("This is resulf for number 4 " + main.reverseStringWithRecursion("abcdefghija"));

        // No.5
        main.countNumberOfVowelsAndConsonant("Java");
        main.countNumberOfVowelsAndConsonant("123456ToruJK");

        // No.6
        System.out.println("contains digit? " + main.containsDigit("simplest"));
        System.out.println("contains digit? " + main.containsDigit("Toru3fkj35"));

        // No. 13
        main.isPalindrome("madam");
        main.isPalindrome("java");
        main.isPalindrome("madadm");
        main.isPalindrome("bbbb");
        main.isPalindrome("radar");

        // No. 17
        main.catchHighsetOccurence("abcdaaaaabbbbbbbbbbbbcdeeeeeeeeeeeeeeeeee");

        // No. 18
        main.removeParticularCharacter("I get up at six in the morning", 'a');
        main.removeParticularCharacter("abracadabra", 'a');
    }

    /* Problem 1, finding duplicated character */
    private void printDuplicateCharacters(String word){
        System.out.println("Hello World!!");
        char[] characters = word.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();

        for(Character c: characters){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c) + 1);
            }
            else{
                charMap.put(c, 1);
            }
        }

        for(Character c : charMap.keySet()){
            if(charMap.get(c) > 1){
                System.out.printf("%s is %d time! \n", c, charMap.get(c));
            }
        }
    }

    /* Problem 2, Checking whether given two strings are anagram or not. */
    private boolean checkIfAnagram(String first, String second){
        if(first.length() != second.length()){
            return false;
        }

        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        int sameCount = 0;
        for(Character c : firstArr){
            for(Character c2 : secondArr){
                if(c.equals(c2)){
                    sameCount+=1;
                }
            }
        }

        return (sameCount == first.length());
    }
    /* Problem 2, Checking whether given two strings are anagram or not, with using Sorting provided by Java */
    private boolean checkIfAnagramWithSorting(String first, String second){
        if(first.length() != second.length()) return false;
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        return Arrays.equals(firstArr, secondArr);
    }

    /* problem 3, How to program to print first non repeated character from String? */
    private char checkPrintFirstNonRepeated(String given){
        HashMap<Character, Integer> count = new HashMap<>();
        for(char c: given.toCharArray()){
            if(count.containsKey(c)){
                count.put(c, count.get(c) + 1);
            }
            else{
                count.put(c, 1);
            }
        }

        // it is also okay.
//        for(Map.Entry<Character, Integer> entry : count.entrySet()){
//            if(entry.getValue() == 1) return entry.getKey();
//        }

        for(int i = 0 ; i < given.length() ; i++){
            char c = given.charAt(i);
            if(count.get(c) == 1) return c;
        }
        throw new RuntimeException("WTF?");
    }

    /* problem 4, How to reverse String in java using iteration and Recursion? */
    private String reverseString(String given){
//        char[] temp = new char[given.toCharArray().length];
//        int index = given.toCharArray().length-1;
//        for(char c : given.toCharArray()){
//            temp[index] = c;
//            --index;
//        }

        StringBuilder sb = new StringBuilder();
        char[] givenArr = given.toCharArray();

        for(int i = givenArr.length -1 ; i >= 0 ; i--){
            sb.append(givenArr[i]);
        }
        return sb.toString();
    }

    private String reverseStringWithRecursion(String given){
        if(given.length() < 2){
            return given;
        }
        return reverseStringWithRecursion(given.substring(1)) + given.charAt(0);
    }

    /* Problem 5, How to count number of vowels and consonants in a String? */
    private void countNumberOfVowelsAndConsonant(String given){
        int vowel = 0;
        int consonant = 0;

        for(char c : given.toLowerCase().toCharArray()){
//            if(c == 'a'
//                    || c ==('e')
//                    || c == ('i')
//                    || c == ('o')
//                    || c == ('u')){
//                vowel += 1;
//            }
//            else if(!Character.isDigit(c)){
//                consonant += 1;
//            }

            switch (c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowel+=1;
                    break;

                default:
                    if(!Character.isDigit(c)){
                        consonant += 1;
                    }
                    break;
            }
        }

        System.out.println("Vowel:: " + vowel + ", Consonant:: " + consonant);
    }

    /* Problem 6, How to check if a String contains only digits? */

    private boolean containsDigit(String given){
        for(char c: given.toCharArray()){
            return c >= '0' && c <= '9';

        }
        throw new RuntimeException("WTF?");
    }

    /* Problem 13. How to check if String is Palindrome? */
    private void isPalindrome(String given){
        char[] givenArr = given.toCharArray();

        int index = 0;
        int count = 0;
        for(char c : givenArr){
            if(c == givenArr[(givenArr.length - 1-index)]){
                count++;
            }
            index++;
        }

        if(count == givenArr.length){
            System.out.println("palindrome!!!!!!");
        }
        else{
            System.out.println("This is not palindrome!!!!!!");
        }
    }

    /* Problem 17, How to return highest occurred character in a String? */
    private void catchHighsetOccurence(String given){
        char[] givenArr = given.toCharArray();
        HashMap<Character, Integer> occurrenceMap = new HashMap<>();

        for(char c : givenArr){
            if(occurrenceMap.containsKey(c)){
                occurrenceMap.put(c, occurrenceMap.get(c) + 1);
            }
            else{
                occurrenceMap.put(c, 1);
            }
        }

        char maxChar = 'a';
        int maxCnt = 1;
        for (Map.Entry<Character, Integer> e : occurrenceMap.entrySet()){
            if(e.getValue() > maxCnt){
                maxChar = e.getKey();
                maxCnt = e.getValue();
            }
        }
        System.out.println("Maximum::" + maxChar);
    }

    /* Problem 18, How to remove a given characters from String */
    private void removeParticularCharacter(String given, char ch){
        char[] givenArr = given.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(char c : givenArr){
            if(c != ch){
                sb.append(c);
            }
        }

        System.out.println("result:: " + sb.toString());
    }
}