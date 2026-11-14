class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int plen = p.length();
        int tlen = t.length();
        int cases = tlen - plen + 1;
        
        int left = 0;
        int right = plen;
        
        for(int c = 0; c < cases; c++){
            if(underP(t,p,left,right)) answer ++;
            left++;
            right++;
        }
        
        
        return answer;
    }
    
    private boolean underP(String t, String p, int left, int right){
        // 1. p의 길이에 맞게 부분 문자열을 구한다. 
        Long tsub = Long.parseLong(t.substring(left,right));
        Long psub = Long.parseLong(p);
        
        return tsub <= psub;
        // t.subString 이용하기 , 인덱스를 하나씩 늘려줘야 한다 . left = 0 부터, right는 부분문자열을 구할 길이로 
        // 2. p와 부분 문자열을 숫자로 만들어서 비교한다.
        
        
    }
}