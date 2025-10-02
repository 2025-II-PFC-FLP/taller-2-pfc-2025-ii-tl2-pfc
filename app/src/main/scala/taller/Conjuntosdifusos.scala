package taller
import annotation.tailrec

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



  def inclusion(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): Boolean = {
    @tailrec
    def definirIn(numero: Int): Boolean = {
      if(numero > 1000){
        true
      }
      else if(cd1(numero)>cd2(numero)){
        false
      }
      else{
        definirIn(numero+1)
      }
    }

    definirIn(0)
  }



  def igualdad(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): Boolean = {
    if(inclusion(cd1, cd2) && inclusion(cd2,cd1))true
    else false
  }



}
