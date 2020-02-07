/**
 * @param {string[]} words
 * @return {number[][]}
 */
var palindromePairs = function(words) {
    const indices = [];

    for (let i = 0; i < words.length; i++) {
        for (let j = 0; j < words.length; j++) {
            if (j !== i) {
                const combined = words[i] + words[j];

                if (isPalindrome(combined)) {
                    indices.push([i, j]);
                }
            }
        }
    }
    
    return indices;
};

function isPalindrome(word) {
    let start = 0;
    let end = word.length - 1;
    
    while (start <= end) {
        if (word[start] !== word[end]) {
            return false;
        }
        start++;
        end--;
    }
    
    return true;
}