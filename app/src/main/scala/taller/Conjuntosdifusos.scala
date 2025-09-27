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



  def complemento(c: ConjuntoDifuso): ConjuntoDifuso = {
    def definec(x:Int): Double = {
      1-c(x)
    }
    definec
  }



  def union(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): ConjuntoDifuso = {
    def defineu(x: Int): Double = {
      math.max(cd1(x),cd2(x))
    }
    defineu
  }



  def interseccion(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): ConjuntoDifuso = {
    def definein(x: Int): Double = {
      math.min(cd1(x),cd2(x))
    }
    definein
  }



}
