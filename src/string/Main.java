package string;

import java.util.Scanner;

public class Main{
    public static double averageWordLength(String sentence) {
    	sentence = sentence.replaceAll("[^a-zA-Z\\s]", "");
        String[] words = sentence.split(" ");
        int totalLetters = 0;
        for (String word : words) {
            totalLetters += word.length();
        }
        return (double) totalLetters / words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        scanner.close();

        String[] words = sentence.split(" ");
        for (String word : words) {
            System.out.println(word);
        }

        double avgLength = averageWordLength(sentence);
        System.out.printf("%.4f%n", avgLength);
    }
}
