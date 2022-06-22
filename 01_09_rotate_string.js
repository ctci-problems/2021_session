/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
 var rotateString = function(s, goal) {
     let newS = s.split('')
     //['a', 'b', 'c', 'd', 'e']
     let count = 0
     let arrayLengthCount = 0 
      while(arrayLengthCount < newS.length) {
        //   console.log(newS)
          //['a', 'b', 'c', 'd', 'e']
        newS[newS.length] = newS[count]
        //['a', 'b', 'c', 'd', 'e', 'a']
        newS.splice(count, 1)
        let newString = newS.join('')
        // console.log(newS)
        if(newString === goal) {
            console.log(newString)
            return true;
        }
        arrayLengthCount++
    }
    return false;
};


