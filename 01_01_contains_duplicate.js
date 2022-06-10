/**
 * @param {number[]} nums
 * @return {boolean}
 */
 var containsDuplicate = function(nums) {
    let s = new Set()
    nums.sort()
    for(let i = 0; i<=nums.length; i++) {
        if(s.has(nums[i])) return true
            s.add(nums[i])
    }
    return false
};