class Solution171 {
    public int titleToNumber(String columnTitle) {
        int temp = 0;
        for(int i = 0; i<columnTitle.length(); i++){
            temp *= 26;
            temp += ((columnTitle.charAt(i)-'A') +1);
        }
        return temp;
    }
}
//171. Excel Sheet Column Number
//Time Complexity: O(n)
/*
 * 171. Excel Sheet Column Number
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 *  For example:
        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28 
        ...

        Example 1:
        Input: columnTitle = "A"
        Output: 1
        Example 2:
        Input: columnTitle = "AB"
        Output: 28
        Example 3:
        Input: columnTitle = "ZY"
        Output: 701
 */