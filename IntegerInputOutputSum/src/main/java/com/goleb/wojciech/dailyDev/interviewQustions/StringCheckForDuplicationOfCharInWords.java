package com.goleb.wojciech.dailyDev.interviewQustions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This program has to take String as an input,
 * find the word that has the biggest number of char repetitions
 * before printing the chosen word it has to
 * delete letters that are present in a given String.
 */
public class StringCheckForDuplicationOfCharInWords {

    public static String SearchingChallenge(String str) {
        String onlyWords = str.replaceAll("[^A-Za-z0-9,]", " ").toLowerCase();
        String[] words = onlyWords.split("\\s");
        String chosenWord = null;
        int maxRepetition = 0;
        for (
                int i = 0;
                i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            int repetition = 0;
            for (int j = 0; j < chars.length; j++) {
                if (j > 0 && chars[j] == chars[j - 1]) {
                    repetition++;
                }
            }
            if (repetition > maxRepetition) {
                maxRepetition = repetition;
                chosenWord = words[i];
            }
        }
        String toDelete = "rety3p6w89";
        char[] toDeleteChars = toDelete.toCharArray();
        for (
                int k = 0;
                k < toDeleteChars.length; k++) {
            chosenWord = chosenWord.replaceAll(String.valueOf(toDeleteChars[k]), "");
        }
        return chosenWord;
    }
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(SearchingChallenge(s.nextLine()));
    }
}
