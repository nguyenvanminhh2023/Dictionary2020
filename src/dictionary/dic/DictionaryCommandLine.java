/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.dic;

/**
 *
 * @author Tram Tram
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryCommandLine {
    static DictionaryManagement dictionaryManagement = new DictionaryManagement();
    Dictionary dictionary = new Dictionary();
    public static void showAllWords(Dictionary dictionary) {
        System.out.println("No  | English         | Vietnamese");
        for(int i = 0; i < dictionary.listOfWords.size(); i++) {
            System.out.printf("%-4d| %-16s| %s\n", i+1, dictionary.listOfWords.get(i).getWord_target(), dictionary.listOfWords.get(i).getWord_explain());
        }
    }
    
    public void dictionaryBasic(Dictionary dictionary) {
        try {
            dictionaryManagement.insertFromFile(dictionary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        System.out.println("What do you want to do?");
        System.out.println("1. Insert from commandline");
        System.out.println("2. Show all words");
        
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                dictionaryManagement.insertFromCommandLine(dictionary);
                dictionaryManagement.dictionaryExportToFile(dictionary);
                break;
            case 2:
                showAllWords(dictionary);
                break;
            default:
                System.out.println("Invalid");

        }
    }

    public void dictionaryAdvance(Dictionary dictionary) {
        try {
            dictionaryManagement.insertFromFile(dictionary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        System.out.println("What do you want to do?");
        System.out.println("3. Delete word");
        System.out.println("4. Look up for word");
        System.err.println("5. Fix word");
        System.out.println("6. Search word with string");
        
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose) {
            case 3:
                dictionaryManagement.deleteWord(dictionary);
                break;
            case 4:
                dictionaryManagement.dictionaryLookUp(dictionary);
                break;
            case 5:
                dictionaryManagement.fixWord(dictionary);
                break;
            case 6:
                dictionarySearcher(dictionary);
                break;
            default:
                System.err.println("invalid");

        }
    }

    public static void dictionarySearcher(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.print("The string that word start with: ");
        String str = sc.nextLine();
        for (Word word : dictionary.listOfWords) {
            if (word.getWord_target().startsWith(str)) {
                System.out.println(word.getWord_target() + ": " + word.getWord_explain());
            }
        }
    }
}

