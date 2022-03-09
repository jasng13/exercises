import java.util.HashMap
import java.util.Arrays

/*Write a function that asks the user for a string containing multiple words.
Print back to the user the same string except with the words in backwards order.
For ex: Hello World => World Hello*/

fun printReverse(input: String) String {
    return input.split(" ").reversed().joinToString(" ")
}

/*Create a function that accepts an array of integers and prints the highest (and lowest value)
without using predefined array functions like sort(), ksort() etc
Sample Array Input
[43,7,23,32,6,62,-1]

Output
Highest: 62
Lowest : -1*/

fun printMinMax(arr : IntArray) : String{
 	var min : Int = arr.get(0)
    var max : Int = arr.get(0)
    
    //loop each item in array and compare 
    for (item in 1 until arr.size) {
        if (min > arr.get(item)){
            min = arr.get(item)
        }
        
        if (max < arr.get(item)){
            max = arr.get(item)
        }
    }
    return "Highest: " + max + " Lowest: " + min
}
/*Create a function that will sort the given array without using any predefined array functions

Sample Input:
[34,7,23,5,62]

Output
[5,7,23,32,34,62]*/

fun sortArray(arr : IntArray){
   
    var temp :Int 
    var num : Int
    
    //loop through each and arrange by ascending
    for (i in arr.indices) {
        
        for (j in i until arr.size){
            if (arr[i] > arr[j]){
                temp = arr[i]
            	arr[i] = arr[j]
            	arr[j] = temp
            }
            
        }
    }
    println(Arrays.toString(arr))
}




/*Create a function that will return the first recurring character of a set string
"ABCA" = A
"CABDBA" = B
"CBAD" = null*/

fun printRecurringLetter(input: String) : String {
    val hashSet : HashSet<Char> = HashSet()
    
    //loop the input 
    for (letter in 0..input.toCharArray().size - 1) {
        val character = input[letter]
        
        //if letter is found update and break
        if (hashSet.contains(character)) return character.toString() 
        else hashSet.add(character)
    }
    
    if (hashSet.size == 1) 
        return hashSet.toString()
    else 
    return "no recurring letter found"
    
}

/*Create a function that will check an array of numbers for all combinations of 2 numbers
and tell if any combination is equal to 8

Sample Arrays
[1,2,3,4] = No
[4,2,4,1] = Yes
[7,2,4,6,7] = Yes*/

fun isSumOfEight(arr : IntArray) : Boolean{
   
    val num = 8
    var hasSumOfEight = false 
    
    for (i in arr.indices) {
        
        for (j in i until arr.size) {
            //compute sum
            if(arr[i] + arr[j] == num && i != j){
                //print which index is a sum of 8
                println("$i,$j")
                
                hasSumOfEight = true
            }
        }
    }    
    return hasSumOfEight
}

fun main() {
    
    //1
    println(printReverse("This is Test"))
    
    //2
    val arr : IntArray= intArrayOf(34,7,23,32,5,62,-1)
	println(printMinMax(arr))	
    
    //3
    val numbers: IntArray = intArrayOf(34,7,23,32,5,62)
    sortArray(numbers)
    
    //4
    println(printRecurringLetter("CBAD"))
    
    //5
    val arrSet: IntArray = intArrayOf(7,2,4,6,7)
    println(isSumOfEight(arrSet))

}
