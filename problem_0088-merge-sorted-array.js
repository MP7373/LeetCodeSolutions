/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  const copy = [...nums1]
  let index1 = 0;
  let index2 = 0;
  let i = 0
  while (index1 < m && index2 < n) {
      if (copy[index1] <= nums2[index2]) {
          nums1[i++] = copy[index1++]
      } else {
          nums1[i++] = nums2[index2++]
      }
  }
  while (index1 < m) {
      nums1[i++] = copy[index1++]
  }
  while (index2 < n) {
      nums1[i++] = nums2[index2++]
  }
}
