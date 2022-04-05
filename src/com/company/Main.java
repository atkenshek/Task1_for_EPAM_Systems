package com.company;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    
    //Количество цифр в строке
    public static int numberOfDigits(String testString){
        int numberOfDigits =0;
        for(int i = 0; i < testString.length(); i++){
            if(testString.charAt(i) >= 48 && testString.charAt(i) <= 57){
                numberOfDigits++;
            }
        }
        return numberOfDigits;
    }
    //Частота встречаемости символа в строке
    public static int numberOfSpecialChar(String testString, char character){
        int count = 0;
        for(int i = 0; i < testString.length(); i++){
            if(character == testString.charAt(i)){
                count++;
            }
        }
        return count;
    }
    //Вводится строка из букв и цифр, построить новую только из цифр
    public static String onlyDigitsFromString(String testString){
        return testString.replaceAll("\\D", "");
    }

    //Удаление одинаковых символов
    public static String removeDuplicateCharsFromString(String testString){
        StringBuilder res = new StringBuilder();
        char[] chars = testString.toCharArray();

        for (char ch : chars) {
            if (res.indexOf(String.valueOf(ch)) != -1)
                continue;
            else
                res.append(ch);
        }
        return res.toString();
    }
    //Переворот строки
    public static String reverseString(String testString){
        StringBuilder res = new StringBuilder();
        char ch;
        for (int i=0; i<testString.length(); i++)
        {
            ch= testString.charAt(i);
            res.insert(0, ch);
        }
        return res.toString();
    }
    //Вывести слова строки в обратном порядке
    public static String reverseWordsInString(String testString){
        String[] words = testString.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
        {
            res.append(words[i]).append(" ");
        }
        return res.toString();
    }
    //Количество вхождений подстроки в строку
    public static int countOccurrencesOfSubstring(String testString, String substring){
        int index = 0;
        int count = 0;
        while ((index = testString.indexOf(substring, index)) != -1 ){
            count++;
            index++;
        }
        return count;
    }

    //Сортировка массива строк по алфавиту
    public static String stringArraySort(String testString) {
        String[] str = testString.split(" ");
        str = Stream.of(str)
                .sorted()
                .toArray(String[] :: new);
        return Arrays.toString(str);
    }

    //Определить длину самого короткого слова в строке
    public static int shortestWordInString(String testString){
        String[] words = testString.split(" ");
        String shorTestWord = words[0];
        for (int i = 1; i < words.length; i++){
            if (words[i].length() < shorTestWord.length()){
                shorTestWord = words[i];
            }
        }
        return shorTestWord.length();
    }
    //Подсчет количества слов в строк
    public static int numberOfWordsInString(String testString){
        String[] str = testString.split(" ");
        return str.length;
    }

    //Добавление пробелов в строку
    //Здесь я добавил пробелы перед каждой UpperCase буквой
    public static String addSpacesToString(String testString) {
        StringBuilder result = new StringBuilder();
        result.append(testString.charAt(0));
        for (int i = 1; i < testString.length(); i++) {
            if (Character.isUpperCase(testString.charAt(i)))
                result.append(" ");
            result.append(testString.charAt(i));
        }
        return result.toString();
    }

    //Является ли строка палиндромом
    public static boolean isPalindrome(String testString) {
        StringBuilder str = new StringBuilder();
        for(int i = testString.length()-1; i >= 0 ; i--) {
            str.append(testString.charAt(i));
        }
        if(testString.equalsIgnoreCase(str.toString())) {
            return true; //Строка является палиндромом
        } else {
            return false; //Строка не является палиндромом
        }
    }
    //Замена подстроки в строке
    public static String replaceSubstring(String testString, String substring) {
        return testString.replaceAll(substring, "DDD");
    }
    //Расстояние между подстроками
    public static int distanceBetweenSubstrings(String testString, String substring1, String substring2) {
        if (substring1.equals(substring2)) return 0;
        String[] words = testString.split(" ");
        int res = (words.length) + 1;
        for (int i = 0; i < words.length ; i ++) {
            if (words[i] .equals(substring1)) {
                for (int j = 0; j < words.length; j ++) {
                    if (words[j] .equals(substring2)) {
                        int curr = Math.abs(i - j) - 1;
                        if (curr < res) res = curr;
                    }
                }
            }
        }
        return res;
    }
    //Четные и нечетные символы разделить по разным строкам
    public static String evenOrOddCharacters(String testString){
        String[] str = new String[2];
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for(int i = 0; i < testString.length(); i++)
        {
            if(i % 2 == 0) odd.append(testString.charAt(i));
            else even.append(testString.charAt(i));
        }
        str[0] = even.toString();
        str[1] = odd.toString();
        return Arrays.toString(str);
    }
    public static void main(String[] args) {
	// write your code here
        String testString = "bbcDaeFGhijklmoNp1234567890 substring1 Abcasd dASASD substring2";
        char testChar = 'a';
        String testSubstring = "Abc";

        System.out.println("Example string is: " + testString);
        System.out.println("Example char is: " + testChar);
        System.out.println("Example substring is: " + testSubstring);

        System.out.println("Total number of digits: " + numberOfDigits(testString));
        System.out.println("Extracted digits: " + onlyDigitsFromString(testString));
        System.out.println("Removed duplicate characters: " + removeDuplicateCharsFromString(testString));
        System.out.println("Number of " + '"' + testChar + '"' + " is: " + numberOfSpecialChar(testString, testChar));
        System.out.println("Reversed string: " + reverseString(testString));
        System.out.println("Reversed words in a string: " + reverseWordsInString(testString));
        System.out.println("Count occurrences of substring Abc: " + countOccurrencesOfSubstring(testString, testSubstring));
        System.out.println("Sorted array of string in alphabetical order: " + stringArraySort(testString));
        System.out.println("The length of shortest word: " + shortestWordInString(testString));
        System.out.println("Number of words in string: " + numberOfWordsInString(testString));
        System.out.println("Seperated by spaces: " + addSpacesToString("testString"));
        System.out.println("Is string a palindrome: " + isPalindrome(testString));
        System.out.println("Replacing substring in string: " +replaceSubstring(testString, testSubstring));
        System.out.println("Distance between substrings: " + distanceBetweenSubstrings(testString, "substring1", "substring2"));
        System.out.println("Split characters with even and odd order: " + evenOrOddCharacters("alfabet"));
    }
}
