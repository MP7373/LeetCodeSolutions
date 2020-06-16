/**
 * @param {number} N
 * @return {number}
 */
function consecutiveNumbersSum(N) {
  let numberOfSequencesLengthsThatWork = 0;
  let sequenceLength = 1;

  while (N / sequenceLength - Math.floor(sequenceLength / 2) > 0) {
    if (sequenceLength % 2 === 0) {
      if ((N / (sequenceLength / 2)) % 2 === 1) {
        numberOfSequencesLengthsThatWork++;
      }
    } else {
      if (N % sequenceLength === 0) {
        numberOfSequencesLengthsThatWork++;
      }
    }
    sequenceLength++;
  }

  return numberOfSequencesLengthsThatWork;
}
