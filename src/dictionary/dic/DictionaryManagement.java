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
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Collections;

public class DictionaryManagement {
    public Dictionary insertFromCommandLine(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of words: ");
        int numberOfWords = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberOfWords; i++) {
            System.out.println("Word " + (i + 1) + " and Vietnamese meaning:");
            String eng = sc.nextLine();
            eng = eng.toLowerCase();
            String vn = sc.nextLine();
            vn = vn.toLowerCase();
            Word word = new Word(eng, vn);
            dictionary.listOfWords.add(word);
        }
        return dictionary;
    }

    public Dictionary insertFromFileForFrame(Dictionary dictionary) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\tramt\\OneDrive\\Documents\\NetBeansProjects\\Dictionary\\src\\tudien.txt")).useDelimiter("\t");
        while (sc.hasNext()) {
            String eng = sc.next();
            String vn = sc.nextLine();
            vn = vn.substring(1);
            vn = vn.toLowerCase();
            String replace = vn.replace('*', '\n');
            eng = eng.toLowerCase();
            dictionary.listOfWords.add(new Word(eng, replace));
        }
        
        Collections.sort(dictionary.listOfWords, new Word());
        return dictionary;
    }
    
    public Dictionary insertFromFile(Dictionary dictionary) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\tramt\\OneDrive\\Documents\\NetBeansProjects\\Dictionary\\src\\tudien.txt")).useDelimiter("\t");
        while (sc.hasNext()) {
            String eng = sc.next();
            String vn = sc.nextLine();
            //vn = vn.substring(1);
            vn = vn.toLowerCase();
            eng = eng.toLowerCase();
            dictionary.listOfWords.add(new Word(eng, vn));
        }
        
        Collections.sort(dictionary.listOfWords, new Word());
        return dictionary;
    }

    public void dictionaryLookUp(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.print("English word: ");
        String word_input = sc.nextLine();
        int start = 0;
        int end = dictionary.listOfWords.size();
        int i = (start + end) / 2;
        while ((i != start && i != end)) {
            if (dictionary.listOfWords.get(i).getWord_target().compareTo(word_input) > 0){
                end = i;
                i = (start + end) / 2;
            }
            else {
                start = i;
                i = (start + end) / 2;
            }
        }
        if (dictionary.listOfWords.get(i).getWord_target().compareTo(word_input) == 0) {
            System.out.println(dictionary.listOfWords.get(i).getWord_target() + "|" + dictionary.listOfWords.get(i).getWord_explain());
        } else {
            System.out.println("Word not found!");
        }
        
    }
    
    public String dictionaryFrameLookUp(Dictionary dictionary, String wordFind) {
        Scanner sc = new Scanner(System.in);
        /*int i = 0;
        boolean canFindWord = false;
        while (!canFindWord && i < dictionary.listOfWords.size()) {
            if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordFind) == 0) {
                canFindWord = true;
                break;
            }
            i++;
        }
        if (!canFindWord) {
            return "Word not found!!!";
        } else {
            return dictionary.listOfWords.get(i).getWord_explain();
        }*/
        int start = 0;
        int end = dictionary.listOfWords.size();
        int i = (start + end) / 2;
        while ((i != start && i != end)) {
            if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordFind) > 0){
                end = i;
                i = (start + end) / 2;
            }
            else {
                start = i;
                i = (start + end) / 2;
            }
        }
        if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordFind) == 0) {
            return dictionary.listOfWords.get(i).getWord_explain();
        } else {
            return "Word not found!!!";
        }
    }

    public Dictionary fixWord(Dictionary dictionary) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Word need to be fixed:");
            String wordBeFixed = sc.nextLine();
            /*int i = 0;
            boolean canFindWord = false;
            while (!canFindWord && i < dictionary.listOfWords.size()) {
                if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordBeFixed) == 0) {
                    canFindWord = true;
                    break;
                }
                i++;
            }*/
            
            int start = 0;
            int end = dictionary.listOfWords.size();
            int i = (start + end) / 2;
            while ((i != start && i != end)) {
                if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordBeFixed) > 0){
                    end = i;
                    i = (start + end) / 2;
                }
                else {
                    start = i;
                    i = (start + end) / 2;
                }
            }
            if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordBeFixed) != 0) {
                System.out.println("Word not found!!!");
            } else {
                System.out.println("Word is found!!!");
                System.out.print("Fix the English word: ");
                String eng = sc.nextLine();
                System.out.print("Fix the Vietnamese meaning: ");
                String vn = sc.nextLine();
                Word newWord = new Word(eng, vn);
                dictionary.listOfWords.set(i, newWord);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dictionary;
    }

    public void deleteWord(Dictionary dictionary) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Word need to be deleted: ");
            String wordBeDeleted = sc.nextLine();
            /*int i = 0;
            boolean canFindWord = false;
            while (!canFindWord && i < dictionary.listOfWords.size()) {
                if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordBeDeleted) == 0) {
                    canFindWord = true;
                    break;
                }
                i++;
            }*/
            
            int start = 0;
            int end = dictionary.listOfWords.size();
            int i = (start + end) / 2;
            while ((i != start && i != end)) {
                if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordBeDeleted) > 0){
                    end = i;
                    i = (start + end) / 2;
                }
                else {
                    start = i;
                    i = (start + end) / 2;
                }
            }
            if (dictionary.listOfWords.get(i).getWord_target().compareTo(wordBeDeleted) != 0) {
                System.out.println("Word not found!!!");
            } else {
                dictionary.listOfWords.remove(i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dictionaryExportToFile(Dictionary dictionary) {
        try {
            File file = new File("C:\\Users\\tramt\\OneDrive\\Documents\\NetBeansProjects\\Dictionary\\src\\tudien.txt");
            FileWriter fwrite = new FileWriter(file);
            for (int i = 0; i < dictionary.listOfWords.size(); i++) {
                fwrite.write(dictionary.listOfWords.get(i).getWord_target() + "\t"
                        + dictionary.listOfWords.get(i).getWord_explain() + "\n");
            }
            fwrite.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

