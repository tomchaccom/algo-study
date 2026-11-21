import java.util.*;

class Solution {

    // public static void main(String [] args){
        

    //     Solution s = new Solution();
    //     int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
    //     int[][] target = new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};

    //     System.out.println(s.findRotation(mat,target));
        
    //     // System.out.println(s.check(target,target));
    //     // System.out.println(s.check(s.rotate(target),mat));
    //     // System.out.println(s.check(s.rotate(s.rotate(target)),mat));
    //     // System.out.println(s.check(s.rotate(s.rotate(s.rotate(target))),mat));
        
        


        
    // }

    public boolean findRotation(int[][] mat, int[][] target) {
        
        // 회전 시 열이 행이되고 행이 열이된다. 이걸 이용해서 먼저 뒤집고 완탐?
        // 해도 괜찮을거 같은게 회전 n번 비교 n번 이긴 함

        // n = 1 이면 true 반환 
        // n == 2 한번만 돌려서 비교하기 
        // n >= 3 총 3번까지 돌려서 비교하기
        int n = mat.length;
        Solution s = new Solution();
        int [][] result = target;

        for(int i = 0; i < 4; i++){
            
            if (s.check(result, mat)) {
                return true;
            }
            result = s.rotate(result);
        }

        return false;

    }

    // 돌리는 함수 하나 만들기 
    private int[][] rotate(int [][] source){
        int n = source.length;
        int [][] rotated= new int [n][n];
        
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                // 행이 열이 되고 열이 행이된다 
                rotated[i][j] = source[n-j-1][i];

            }
        }
        
        return rotated;


    }

    // 두 배열을 비교하는 함수 만들기 
    // 많이 해도 3 * 100 * 100  
    private boolean check(int [][] source, int [][] target){
        for(int i = 0; i < source.length; i ++){
            for(int j = 0; j < source.length; j++){
                if(source[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        // Solution.print(source);
        // Solution.print(target);

        return true;
    }
    
    public static void print(int [][] source){

        for(int i = 0; i < source.length; i ++){
            for(int j = 0; j < source.length; j++){
                System.out.print(source[i][j]);
            }
            System.out.println();
        }

    }

}