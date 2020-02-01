/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  const anagrams = [];
  const anagramIndexTable = {};
  
  strs.forEach(s =>  {
      const sorted = [...s].sort().join('');
      
      if (anagramIndexTable[sorted] != null) {
          anagrams[anagramIndexTable[sorted]].push(s);
      } else {
          anagrams.push([s]);
          anagramIndexTable[sorted] = anagrams.length - 1;
      }
  });
  
  return anagrams;
};
