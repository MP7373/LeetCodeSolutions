/**
 * Initialize your data structure here.
 */
var TimeMap = function() {
  this.timestamps = {}
};

/** 
* @param {string} key 
* @param {string} value 
* @param {number} timestamp
* @return {void}
*/
TimeMap.prototype.set = function(key, value, timestamp) {
  if (this.timestamps[key] === undefined) {
      this.timestamps[key] = [[value, timestamp]]
  } else {
      this.timestamps[key].push([value, timestamp])
  }
};

/** 
* @param {string} key 
* @param {number} timestamp
* @return {string}
*/
TimeMap.prototype.get = function(key, timestamp) {
  if (this.timestamps[key] !== undefined && this.timestamps[key][0][1] <= timestamp) {
      return binarySearch(this.timestamps[key], 0, this.timestamps[key].length, timestamp)
  }
  return ''
};

/** 
* Your TimeMap object will be instantiated and called as such:
* var obj = new TimeMap()
* obj.set(key,value,timestamp)
* var param_2 = obj.get(key,timestamp)
*/
function binarySearch(timestamps, start, end, value) {
  const mid = start + Math.floor((end - start) / 2)
  
  if (timestamps[mid][1] <= value) {
      if (mid + 1 === timestamps.length || timestamps[mid + 1][1] > value) {
          return timestamps[mid][0]
      }
      
      if (mid + 1 < end) {
          return binarySearch(timestamps, mid + 1, end, value)
      }
      
      return ''
  }
  
  if (start >= mid) {
      return ''
  }

  return binarySearch(timestamps, start, mid, value)
}
