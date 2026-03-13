class Solution:
    def twoSum(self, nums, target):
        for i in range(len(nums)):              # pick the first number
            for j in range(i + 1, len(nums)):   # pick the second number (after i)
                if nums[i] + nums[j] == target: # check if they add up to target
                    return [i, j]               # return their positions