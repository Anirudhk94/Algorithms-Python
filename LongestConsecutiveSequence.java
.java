class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(neighbourExists(data, nums[i])) {
                data = updateNeighbour(data, nums[i]);
                printData(data);
            } else if(alreadyInData(data, nums[i])) {
                continue;
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                data.add(temp);
                printData(data);
            }
        }
        
        for(ArrayList<Integer> set : data) {
            if(set.size() > maxLen)
                maxLen = set.size();
        }
        
        return maxLen;
    }
    
    public ArrayList<ArrayList<Integer>> updateNeighbour(ArrayList<ArrayList<Integer>> data, int num) {
        int pos = -99999;
        int neg = -99999;
        
        for(int i = 0 ; i < data.size() ; i++) {
            if(data.get(i).contains(num)) {
                return data;
            } else if(data.get(i).contains(num + 1)) {
                pos = i;
            } else if(data.get(i).contains(num - 1)) {
                neg = i;
            }
        }
        
        if(pos != -99999 & neg == -99999) {
            data.get(pos).add(num); 
        } else if(pos == -99999 & neg != -99999) {
            data.get(neg).add(num);
        } else {
            data.get(neg).add(num);
            data.get(pos).addAll(data.get(neg));
            data.remove(neg);
        }
        
        return data;
    }
        
    public boolean neighbourExists(ArrayList<ArrayList<Integer>> data, int num) {
        for(ArrayList<Integer> set : data) {
            if(set.contains(num+1) || set.contains(num-1))
                return true;
        }
        return false;
    }   
    
    public boolean alreadyInData(ArrayList<ArrayList<Integer>> data, int num) {
        for(ArrayList<Integer> set : data) {
            if(set.contains(num) )
                return true;
        }
        return false;
    }   
    
    public void printData(ArrayList<ArrayList<Integer>> data) {
        for(ArrayList<Integer> set : data) {
            for(int i = 0 ; i < set.size() ; i++)
                System.out.print(set.get(i) + " ");
            System.out.println("");
        }
        System.out.println("");
    }   
    
}


//Solution 2 

class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashSet<Integer> data = new HashSet<Integer>();
        
        for(int num : nums)
            data.add(num);
        
        for(int num : nums) {
            if(!data.contains(num - 1)) {
                int curr = num;
                int temp = 0;
                while(data.contains(curr)) {
                    curr++;
                    temp++;
                }
                if(temp > result) {
                    result = temp;
                }
            }
        }
        return result;   
    }
}