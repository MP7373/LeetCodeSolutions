/**
 * @param {string[]} words
 * @param {string} order
 * @return {boolean}
 */
var isAlienSorted = function(words, order) {
  const charValueTable = {};
  order.split('').forEach((c, i) => charValueTable[c] = i);
  
  let returnVal = true;
  let last = '';
  words.forEach((word, i) => {
      if (firstBigger(last, word, charValueTable)) {
          returnVal = false;
      }
      last = word;
  });
  
  return returnVal;
};
               
function firstBigger(first, last, table) {
  for (let i = 0; i < first.length && i < last.length; i++) {
      if (table[first[i]] > table[last[i]]) return true;
      if (table[first[i]] < table[last[i]]) return false;
  }
  return first.length > last.length;
}
