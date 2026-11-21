class Solution {

    public static void main(String [] args){

        Solution s = new Solution();

        int[] arr = new int[]{1, 4, 2, 5, 3};
        System.out.println(s.sumOddLengthSubarrays(arr));
    }
    public int sumOddLengthSubarrays(int[] arr) {

        // 누적합 배열 미리 만들어 두고 길이 만큼 빼서 사용하기 
        // 슬라이딩 윈도우 처럼 

        int answer = addPlus(arr);
        return answer;
        
    }
    public int [] sumArr(int [] arr){
        // 누적합 배열 만들기 
        int [] sum = new int [arr.length];

        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            sum[i] = sum[i-1] + arr[i];
        }
        return sum;

    }
    public int addPlus(int [] arr){

        int [] sum = sumArr(arr);   // 누적합 배열
        int n = arr.length;
        int total = 0;
    
        // 시작 위치 고정
        for (int start = 0; start < n; start++) {
            // 길이를 1, 3, 5... 홀수로 늘려가며, 끝이 배열을 넘지 않을 때까지
            for (int len = 1; start + len - 1 < n; len += 2) {
                int end = start + len - 1;
    
                // start ~ end 구간 합 = sum[end] - sum[start - 1]
                int rangeSum = sum[end] - (start > 0 ? sum[start - 1] : 0);
                total += rangeSum;
            }
        }
        return total;
    }
}