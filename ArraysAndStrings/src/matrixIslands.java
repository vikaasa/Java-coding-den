import java.util.Stack;

/**
 * Created by Vikaasa on 25/02/2017.
 */
public class matrixIslands {
    public int countIslands(int[][] matrix){
        if(matrix == null){
            return 0;
        }
        int count = 0, m = matrix.length, n = matrix[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if (matrix[i][j] == 1){
                    count++;
                    Stack<Integer[]> stack = new Stack<Integer[]>();
                    Integer[] currentCoordinates = {i,j};
                    stack.push(currentCoordinates);
                    while(!stack.isEmpty()){
                        Integer[] poppedCoordinates = stack.pop();
                        int p = poppedCoordinates[0]; int q = poppedCoordinates[1];
                        if((p>0) && matrix[p-1][q]==1){
                            Integer[] discoveredCoordinate = {p-1,q};
                            stack.push(discoveredCoordinate);
                        }
                        if((p<m-1)&&matrix[p+1][q]==1){
                            Integer[]discoveredCoordinate = {p+1,q};
                            stack.push(discoveredCoordinate);
                        }
                        if((q>0) && matrix[p][q-1]==1){
                            Integer[] discoveredCoordinate = {p,q-1};
                            stack.push(discoveredCoordinate);
                        }
                        if((q<n-1)&&matrix[p][q+1]==1){
                            Integer[]discoveredCoordinate = {p,q+1};
                            stack.push(discoveredCoordinate);
                        }
                        matrix[p][q] = '#';
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        matrixIslands ci = new matrixIslands();
        int[][] islandMatrix = {{1,1,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,1}};
        int finalResult = ci.countIslands(islandMatrix);
        System.out.println(finalResult);
    }
}
