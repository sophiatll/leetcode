class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        char[][] puzzle = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                puzzle[i][j]='.';
        }
        
        putQueens(result, puzzle, n, 0);
        
        //System.out.println("total solution is "+ result.size());
        //System.out.println(result);
        return result;
    }
    
    private void putQueens(List<List<String>> result, char[][] puzzle, int n, int row){
        if(row==n){
            //all rows are ready, put this solution into the result list
            List<String> s = new ArrayList(n);
            for(int i=0; i<n; i++){
                s.add(new String(puzzle[i]));
            }
            result.add(s);
            return;
        }
        
        for(int j=0; j<n; j++){
            //put queen on column j
            puzzle[row][j]='Q';
            //if it matches the limitation
            if(isOk(puzzle,n,row,j)){
                //continue to put queen on next row
                putQueens(result,puzzle,n, row+1);
            }
            //move queen from column j and try next column
            puzzle[row][j]='.';
        }
    }
    
    private boolean isOk(char[][] puzzle, int n, int i, int j){
        int leftup = j-1; 
        int rightup = j+1;
        for(int r=i-1; r>=0; r--){
            if(puzzle[r][j] == 'Q'){
                return false;
            }
            if(leftup>=0 && puzzle[r][leftup] == 'Q'){
                return false;
            }
            if(rightup<n && puzzle[r][rightup] == 'Q'){
                return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }
}
