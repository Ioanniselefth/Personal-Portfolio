//1572. Matrix Diagonal Sum

class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int counter = 0;
        
        for (int i =0; i<mat.length; i++){
            for(int j =0; j<mat[i].length; j++){
                if(i==j || (i+j)==mat[i].length-1){
                    counter += mat[i][j];
                }
            }
        }
        System.out.println(counter);
        return counter;
    }
}