import java.util.ArrayList;
import java.util.List;
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<List<Integer>>();
        ArrayList<Integer> currentRow = new ArrayList<Integer>();
        for(int i = 0; i<numRows; i++){
            currentRow.add(0,1);
            for(int j=1; j<currentRow.size()-1; j++)
                currentRow.set(j, currentRow.get(j) + currentRow.get(j+1));
            allRows.add(new ArrayList<Integer>(currentRow));
        }
        return allRows;
    }
}
//118. Pascal's Triangle