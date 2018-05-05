//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".

//Example 1:
//Input: ["flower","flow","flight"]
//Output: "fl"

//Example 2:
//Input: ["dog","racecar","car"]
//Output: ""

//Explanation: There is no common prefix among the input strings.
//Note: All given inputs are in lowercase letters a-z.


class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minLen = 100000;
        String minStr = "";
        
        for(int i = 0 ; i < strs.length ; i++) {
            if(strs[i].length() < minLen) {
                minLen = strs[i].length();
                minStr = strs[i];
            }       
        }
        
        //System.out.println(minLen+ " "+ minStr);
        char[] input = minStr.toCharArray();
        String result = "";
        
        for(int i = 0 ; i < input.length ; i++) {
            int sum = 0;
            for(int j=0 ; j < strs.length ; j++) {
                if(input[i] == strs[j].charAt(i)) {
                    sum++;
                }
            }
            if(sum == strs.length) {
                result += input[i]; 
            } else {
                break; 
            }
        }
        
        return result;
    }
}