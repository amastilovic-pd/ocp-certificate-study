public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
        isValid("s");
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * qweqweqwe
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (counter > 0) {
                return false;
            }
            char c = s.charAt(i);
            if (c == '(' && s.substring(i).contains(")")) {
                counter++;
            } else if (c == '{' && s.charAt(i + 1) != '}') {
                counter++;
            } else if (c == '[' && s.charAt(i + 1) != ']') {
                counter++;
            }
        }
        return true;
    }
}
