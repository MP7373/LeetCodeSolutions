/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  if (beginWord.length !== endWord.length || beginWord === endWord) {
      return 0
  }
  
  const words = {}
  const partials = {}
  wordList.filter(word => word.length === beginWord.length && word !== beginWord)
      .forEach(word => {
          words[word] = false
          for (let i = 0; i < word.length; i++) {
              const partial = word.slice(0, i) + ',' + word.slice(i + 1)
              if (partials[partial] === undefined) {
                  partials[partial] = new Set([word[i]])
              } else {
                  partials[partial].add(word[i])
              }
          }
      })
  
  const next = [[beginWord, 1]]
  do {
      const [word, steps] = next.shift()
      
      console.log(word + ', ' + steps)
      if (word === endWord) {
          return steps
      }
      
      for (let i = 0; i < word.length; i++) {
          const part1 = word.slice(0, i)
          const part2 = word.slice(i + 1)
          const partial = part1 + ',' + part2
          if (partials[partial] !== undefined) {
              for (const char of partials[partial]) {
                  const newWord = part1 + char + part2
                  if (!words[newWord]) {
                      next.push([newWord, steps + 1])
                      words[newWord] = true
                  }
              }
          }
      }
  } while (next.length > 0)
  
  return 0
};
