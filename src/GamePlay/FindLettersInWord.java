package GamePlay;

import java.util.ArrayList;
import java.util.List;

public class FindLettersInWord {
    private char[] Letters;

    public FindLettersInWord(char[] Letters){
        this.Letters = Letters;
    }

    public List<Integer> findLetter(char character) {
        List<Integer> positions = new ArrayList<>();
    
        for (int i = 0; i < Letters.length; i++) {
            if (Letters[i] == character) {
            positions.add(i);
            }
        }
    
    return positions;
    }   
}
