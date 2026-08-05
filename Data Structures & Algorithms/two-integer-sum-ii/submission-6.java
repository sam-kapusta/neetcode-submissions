class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int i = 0;
        int j = 1;

        while(i < numbers.length) {
            System.out.println("i,j: " + i + " " + j);

            if(j >= numbers.length) {
                i++;
                j = i + 1;
                continue;
            }

            if(numbers[i] + numbers[j] < target) {
                j++;
            } else if(numbers[i] + numbers[j] > target) {
                i++;
                j = i + 1;
            } else {
                return new int[]{i+1, j+1};
            }
        }
    return new int[]{};
    } 
}
