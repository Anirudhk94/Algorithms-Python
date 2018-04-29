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