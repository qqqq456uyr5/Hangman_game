package GamePlay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadFromDictionary {

    /**Строка слова */
    private String myWord; 

    /**Возвращает слово */
    public String getWorld(){
        return myWord;
    }

    private char[] myWordLetter;

    /**Возвращает массив букв слова */
    public char[] getWorldLetter(){
        return myWordLetter;
    }

    /**Строка категории */
    private String myCategory;

    /**Возвращает категорию */
    public String getCategory(){
        return myCategory;
    }

    /**Список слов */
    List<String> wordsList;

    /**Список категорий*/
    List<String> categoryList;

    /**Название файла*/
    String filePath = "src/Resources/Dictionary.txt";

    public ReadFromDictionary(){

        wordsList = new ArrayList<>();

        categoryList = new ArrayList<>();

         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                String[] parts = line.split("\\|");
                wordsList.add(parts[0].trim());
                categoryList.add((parts.length > 1) ? parts[1].trim() : "неизвестно");

            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
         
        Random rnd = new Random();
        int tempIndex = rnd.nextInt(wordsList.size());

        myCategory = categoryList.get(tempIndex);
        myWord = wordsList.get(tempIndex);
        myWordLetter = myWord.toCharArray();
    }

   
}

    
    

