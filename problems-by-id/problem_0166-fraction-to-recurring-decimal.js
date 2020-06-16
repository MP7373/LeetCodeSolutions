/**
 * @param {number} numerator
 * @param {number} denominator
 * @return {string}
 */
var fractionToDecimal = function(numerator, denominator) {
  if (numerator === 0) {
      return '0'
  }
  
  const negative = numerator * denominator < 0
  numerator = Math.abs(numerator)
  denominator = Math.abs(denominator)
  
  const divideResult = `${Math.floor(numerator / denominator)}`
  let remainder = numerator % denominator
  
  if (remainder === 0) {
      return (negative ? '-' : '') + divideResult
  }
  
  let decimal = ''
  
  const remainders = {};
  let index = 0
  while (remainder !== 0) {
      if (remainders[remainder] !== undefined) {
          return `${negative ? '-' : ''}${divideResult}.${decimal.slice(0, remainders[remainder])}(${decimal.slice(remainders[remainder], index)})`
      }
      remainders[remainder] = index++
      decimal += Math.floor(remainder * 10 / denominator)
      remainder = (remainder * 10) % denominator
  }
  
  return `${negative ? '-' : ''}${divideResult}.${decimal}`
};
