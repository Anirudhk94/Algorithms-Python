//Given a string, find the length of the longest substring without repeating characters.

//Examples:
//Given "abcabcbb", the answer is "abc", which the length is 3.
//Given "bbbbb", the answer is "b", with the length of 1.
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> arr = new ArrayList<Character>();
        
        char[] input = s.toCharArray();
        int i = 0;
        
        int maxLen = 0;
        
        while(i < input.length) {
            int j = i;
            while(j < input.length && !arr.contains(input[j])) {
                arr.add(input[j]);
                //System.out.println("Added : "+ input[j]);
                j++;
            }
            if (maxLen < arr.size()) {
                maxLen = arr.size();
                //System.out.println("Max : "+ maxLen);
            }
            arr = new ArrayList<Character>();
            i++;
        }
        
        
        return maxLen;
    }
}