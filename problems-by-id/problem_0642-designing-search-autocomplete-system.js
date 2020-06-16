/**
 * @param {string[]} sentences
 * @param {number[]} times
 */
var AutocompleteSystem = function(sentences, times) {
  this.trie = {};
  
  this.saveSentences = function(sentences, times) {
      for (let i = 0; i < sentences.length; i++) {
          let trieRef = this.trie;
          [...sentences[i]].forEach(c => {
             let cur = sentences[i];
             if (trieRef[c] === undefined) {
                 trieRef[c] = { 
                     count: times[i],
                     sentences: {
                        [cur]: times[i]
                     } 
                  };
             } else {
                 trieRef[c].count += times[i];
                 if (trieRef[c].sentences[cur] === undefined) {
                     trieRef[c].sentences[cur] = times[i];
                 } else {
                     trieRef[c].sentences[cur] += times[i];
                 }
             }
              trieRef = trieRef[c];
          });
      }
  };
  
  this.saveSentences(sentences, times);
  
  this.currentSentence = '';
  
  this.currentTrieNode = this.trie;
};

/** 
* @param {character} c
* @return {string[]}
*/
AutocompleteSystem.prototype.input = function(c) {
  
  if (c === '#') {
      this.saveSentences([this.currentSentence], [1]);
      this.currentSentence = '';
      this.currentTrieNode = this.trie;
      return [];
  }

  this.currentSentence += c;
  
  if (this.currentTrieNode == null || this.currentTrieNode[c] === undefined) {
      this.currentTrieNode = null;
      return [];
  } else {
      this.currentTrieNode = this.currentTrieNode[c];
      
      const sentences = Object.keys(this.currentTrieNode.sentences);
      if (sentences.length > 0) {
          sentences.sort((a, b) => {
              const dif = this.currentTrieNode.sentences[b] - this.currentTrieNode.sentences[a];
              
              if (dif !== 0) {
                  return dif;
              }
              
              for (let i = 0; i < a.length && i < b.length; i++) {
                  if (a[i] > b[i]) {
                      return 1;
                  } else if (b[i] > a[i]) {
                      return -1;
                  }
              }
              
              return a.length > b.length ? 1 : -1;
          });
          
          const result = [];
          for (let i = 0; i < 3 && i < sentences.length; i++) {
              result.push(sentences[i]);
          }
          
          return result;
      }
      
      return [];
  }
};

/** 
* Your AutocompleteSystem object will be instantiated and called as such:
* var obj = new AutocompleteSystem(sentences, times)
* var param_1 = obj.input(c)
*/
