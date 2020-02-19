/**
 * @param {string[]} paths
 * @return {string[][]}
 */
var findDuplicate = function(paths) {
    const uniqueFileContents = {}
    
    paths.forEach(path => {
        const pathAndFiles = path.split(' ')
        const pathWithoutFile = pathAndFiles[0]
        
        for (let i = 1; i < pathAndFiles.length; i++) {
            const fileNameAndContent = pathAndFiles[i].split('(')
            const fileContent = fileNameAndContent[1].slice(0, fileNameAndContent[1].length - 1)

            if (uniqueFileContents[fileContent] === undefined) {
                uniqueFileContents[fileContent] = [`${pathWithoutFile}/${fileNameAndContent[0]}`]
            } else {
                uniqueFileContents[fileContent].push(`${pathWithoutFile}/${fileNameAndContent[0]}`)
            }
        }
    })
    
    return Object.keys(uniqueFileContents)
        .map(key => uniqueFileContents[key])
        .filter(filesThatContainContent => filesThatContainContent.length > 1)
}
