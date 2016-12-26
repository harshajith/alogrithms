/**
  * Created by Harsha on 22/12/16.
  */
class Test {





}

object Test{

  def main(arry: Array[String]) = {
    val x = Array(1,4,3,4,2,4,43,2,4,54,6)

    print(getMaxElements(x, 8))

  }


  def getMaxElements(noArray : Array[Int], total :Int) : Int =  {

    var sum = 0
    var counter = 1
    val sortedArray = noArray.sortWith(_ < _)


    var x = 0
    sortedArray.foldLeft(x)((aggr, num) => {
      aggr + num
    })

    for(i <- sortedArray){
      sum += i
      if(sum == total){
        return counter
      }
      counter += 1
    }
    0
  }
}
