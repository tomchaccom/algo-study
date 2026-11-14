class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        
        // 둘다 더하고, 둘을 조합으로 만들수 있는 사각형을 찾기 
        int all = brown + yellow;
        int j = 0;
        int max = 0;
        int min = 0;
        
        // 사각형 찾기.. 방법은 어떻게 할지. garo * sero = all 
        // 시간복잡도는 O(N)이 나옵니다 왜냐면 yellow의 범위가 1보다 크기 때문에  가로가 3 이상인 케이스만 발생하고,
        // 이 배열을 순회하면서 약수를 구한 뒤 가로 세로의 넓이와 가로 세로에서 -2 만큼 뺀 값으로 계산하기 때문에 
        // 공간 복잡도는 만드는 배열이 2라서 크지 않다
        for(int i = 3; i <= all; i++){
            if (all % i == 0) 
                {j = all / i;}
            else 
                continue;
            
            if(j - 2 < 0 ) {
                continue;
            }
            if((i-2) * (j-2) == yellow){
                max = i > j ? i : j;
                min = i < j ? i : j;
            }
        }
        answer[0] = max;
        answer[1] = min;
 
        // and garo - 2  * sero - 2 == yellow
        // 가로 >= 세로 생각을 안해도 되긴해. 나중에 큰걸 먼저 반환하면 됨 
        return answer;
    }
}