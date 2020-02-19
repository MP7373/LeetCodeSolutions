/**
 * // Definition for an Interval.
 * function Interval(start, end) {
 *    this.start = start;
 *    this.end = end;
 * };
 */
/**
 * @param {Interval[][]} schedule
 * @return {Interval[]}
 */
var employeeFreeTime = function(schedule) {
  const events = []
  
  schedule.forEach(employee => employee.forEach(range => {
      events.push([range.start, 1])
      events.push([range.end, -1])
  }))
  
  events.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1])
  
  const freetime = []
  let previousTime = -1
  let intervalStack = 0
  events.forEach(event => {
      if (intervalStack === 0 && previousTime !== -1 && previousTime !== event[0]) {
          freetime.push(new Interval(previousTime, event[0]))
      }
      intervalStack += event[1]
      previousTime = event[0]
  })
  
  return freetime
}
