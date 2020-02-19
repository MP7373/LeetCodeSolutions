/**
 * @param {number[]} asteroids
 * @return {number[]}
 */
var asteroidCollision = function(asteroids) {
  let collisionOccurred = false

  do {
      collisionOccurred = false
      const newAsteroids = []
      
      for (let i = 0; i < asteroids.length; i++) {
          const asteroid = asteroids[i]
          
          if (asteroid < 0) {
              newAsteroids.push(asteroid)
              continue
          }
          
          if (i + 1 < asteroids.length && asteroids[i + 1] < 0) {
              if (asteroid + asteroids[i + 1] < 0) {
                  newAsteroids.push(asteroids[i + 1])
              } else if (asteroid + asteroids[i + 1] > 0) {
                  newAsteroids.push(asteroid)
              }
              i++
              collisionOccurred = true
          } else {
              newAsteroids.push(asteroid)
          }
      }
      
      asteroids = newAsteroids
  } while (collisionOccurred)
      
  return asteroids
}
