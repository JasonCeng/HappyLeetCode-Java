```C++
class Solution {
public:
    int removeDuplicates(vector<int>& nums){
        if(nums.empty()) return 0;
        int l=0, n=nums.size();
        for(int i=0;i<n;i++){
            if(nums[i]!=nums[l]) nums[++l]=nums[i];
        }
        return l+1;
    }
};
```
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int l=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=nums[l]) nums[++l]=nums[i];
        }
        return l+1;
    }
}
```
