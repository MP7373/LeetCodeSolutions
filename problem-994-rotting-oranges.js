/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function(grid) {
    let minutesTillAllRotten = 0;

    for (let y = 0; y < grid.length; y++) {
        for (let x = 0; x < grid[y].length; x++) {
            if (grid[y][x] === 1) {
                const minutes =  findMinutesUntilRotten(y, x, grid);

                if (minutes === 0) {
                    return -1;
                }

                if (minutes > minutesTillAllRotten) {
                    minutesTillAllRotten = minutes;
                }
            }
        }
    }
    
    return minutesTillAllRotten;
};

function findMinutesUntilRotten(y, x, grid) {
    const queue = [[y, x, 0]];
    let index = 0;
    const visited = new Set();
    
    while(queue.length > index) {
        const [y, x, steps] = queue[index++];
        visited.add(`${y},${x}`);
        
        if (grid[y][x] === 2) {
            return steps;
        }

        if (x + 1 < grid[y].length && grid[y][x + 1] !== 0 && !visited.has(`${y},${x + 1}`)) {
            queue.push([y, x + 1, steps + 1])
        }
        
        if (x - 1 >= 0 && grid[y][x - 1] !== 0 && !visited.has(`${y},${x - 1}`)) {
            queue.push([y, x - 1, steps + 1])
        }
        
        if (y + 1 < grid.length && grid[y + 1][x] !== 0 && !visited.has(`${y + 1},${x}`)) {
            queue.push([y + 1, x, steps + 1])
        }
        
        if (y - 1 >= 0 && grid[y - 1][x] !== 0 && !visited.has(`${y - 1},${x}`)) {
            queue.push([y - 1, x, steps + 1])
        }
    }
    
    return 0;
}
