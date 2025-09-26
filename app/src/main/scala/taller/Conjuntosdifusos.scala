package taller

class Conjuntosdifusos {
  type ConjuntoDifuso = Int => Double



  def pertenece(elem: Int, s:ConjuntoDifuso): Double = {
    s(elem)
  }



  def grande(d: Int, e: Int): ConjuntoDifuso = {
    def define(x: Int): Double = {
      if(x <= 0){
        0.0
      }
      else{
        math.pow(x/(x+d).toDouble,e)
      }
    }
    define
  }



}
