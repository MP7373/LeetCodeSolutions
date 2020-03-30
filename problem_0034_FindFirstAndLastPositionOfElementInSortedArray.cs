public class Solution
{
    public int[] SearchRange(int[] nums, int target)
    {
        if (nums.Length < 1)
        {
            return new int[] { -1, -1 };
        }

        return new int[]
        {
            BinarySearchLeft(nums, target, 0, nums.Length - 1),
            BinarySearchRight(nums, target, 0, nums.Length - 1)
        };
    }

    private int BinarySearchLeft(int[] nums, int target, int start, int end)
    {
        if (start >= end)
        {
            return nums[start] == target ? start : -1;
        }

        var middle = start + (end - start) / 2;
        var val = nums[middle];

        if (val == target)
        {
            if (middle == 0 || nums[middle - 1] < val)
            {
                return middle;
            }

            return BinarySearchLeft(nums, target, start, middle - 1);
        }

        if (val < target)
        {
            return BinarySearchLeft(nums, target, middle + 1, end);
        }

        return BinarySearchLeft(nums, target, start, middle - 1);
    }

    private int BinarySearchRight(int[] nums, int target, int start, int end)
    {
        if (start >= end)
        {
            return nums[start] == target ? start : -1;
        }

        var middle = start + (end - start) / 2;
        var val = nums[middle];

        if (val == target)
        {
            if (middle == nums.Length - 1 || nums[middle + 1] > val)
            {
                return middle;
            }

            return BinarySearchRight(nums, target, middle + 1, end);
        }

        if (val < target)
        {
            return BinarySearchRight(nums, target, middle + 1, end);
        }

        return BinarySearchRight(nums, target, start, middle - 1);
    }
}
