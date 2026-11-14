class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
        // 원래 수에서 1씩 더한 것과 1의 갯수를 비교하면 된다 
        int oneCount = bitCount(n);
        
        
        // 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
        // 백만을 2씩 나누면서 시간복잡도 계산. 1024 * 1024 최대 20번 정도 연산 할 거 같음. 그래서 log 2 (n) 번 연산할거 같음 
        while(true){
            if (oneCount == bitCount(++n)){
                answer = n;
                break;
            }
        }
        
        
        // 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
        return answer;
    }
    
    private int bitCount(int num){
        int count = 0 ;
        
        while(num > 0){
            if (num % 2 == 1){
                count++;
            }
            num /= 2; 
            
        }
        return count;
    }
}