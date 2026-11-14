class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int len = number.length;
        
        for(int first = 0; first < len; first++){
            for(int second = first + 1; second < len; second++){
                for(int third = second + 1; third < len; third++){
                    if (number[first] + number[second] + number[third]  == 0 ) answer ++ ;
                    
                }
            }
        }
        
        
        
        
        return answer;
    }
}