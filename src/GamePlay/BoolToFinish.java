package GamePlay;

import java.util.List;

public class BoolToFinish {
    private boolean[] boolArray;

    public BoolToFinish(char[] letters){
        boolArray = new boolean[letters.length];
    }

    public void addToBoolIsFinish(List<Integer> positions){
        for(int pos : positions){
            boolArray[pos] = true;
        }
    }

    public boolean isFinish(){
        for(boolean b : boolArray){
            if(b == true){
                continue;
            }
            return false;
        }
        return true;
    }
    
}
