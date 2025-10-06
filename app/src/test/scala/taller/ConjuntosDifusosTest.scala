package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite{
  val ct = new Conjuntosdifusos()

  //----Test de funcion grande----//

  test("grande(10,2)(10000) > 0.98"){
    assert(ct.grande(10,2)(10000) > 0.98)
  }

  test("grande(10,2)(-100) = 0.0"){
    assert(ct.grande(10,2)(-100) == 0.0)
  }

  test("grande(10,2)(2)<0.1"){
    assert(ct.grande(10,2)(2)<0.1)
  }

  test("grande(1,1)(100)>0.99"){
    assert(ct.grande(1,1)(100)>0.99)
  }

  test("grande(5,2)(100)<0.99"){
    assert(ct.grande(5,2)(100)<0.99)
  }

  //----Test funcion complemento----//

  test("complemento(conjunto(10,2))(100)< 0.10"){
    assert(ct.complemento(ct.grande(5,2))(100) < 0.10)
  }

  test("complemento(conjunto(5,2))(100)>0.10"){
    assert(ct.complemento(ct.grande(10,2))(100) > 0.10)
  }

  test("complemento(conjunto(5,2))(100000)<0.1"){
    assert(ct.complemento(ct.grande(5,2))(100000) < 0.1)
  }

  test("complemento(conjunto(5,2))(2)>0.90"){
    assert(ct.complemento(ct.grande(5,2))(2) > 0.90)
  }

  test("El complemento de un complemento devuelve el valor original"){
    val com = ct.complemento(ct.complemento(ct.grande(10,2)))
    assert(com(100) == ct.grande(10,2)(100))
  }

  //----Test funcion union----//

  test("La union de ct.grande(10,2) y ct.grande(5,2) en 100 es ct.grande(5,2)") {
    val unionej = ct.union(ct.grande(10,2), ct.grande(5,2))
    assert(unionej(100) == ct.grande(5,2)(100))
  }

  test("La union de ct.grande(7,2) y ct.grande(6,3) en 100 es ct.grande(7,2)"){
    val unionej = ct.union(ct.grande(7,2), ct.grande(6,3))
    assert(unionej(250) == ct.grande(7,2)(250))
  }

  test("La union de ct.grande(2,2) y ct.grande(3,2) en 5 es ct.grande(2,2)") {
    val unionej = ct.union(ct.grande(2,2), ct.grande(3,2))
    assert(unionej(5) == ct.grande(2,2)(5))
  }

  test("La union de ct.grande(2,3) y ct.grande(3,2) en 20 es ct.grande(3,2)") {
    val unionej = ct.union(ct.grande(2,3), ct.grande(3,2))
    assert(unionej(20) == ct.grande(3,2)(20))
  }

  test("La union de ct.grande(2,2) y ct.grande(3,3) en 0 es 0.0") {
    val unionej = ct.union(ct.grande(2,2), ct.grande(3,3))
    assert(unionej(0) == 0.0)
  }

  //----Test funcion interseccion----//
  test("La interseccion de ct.grande(5,2) y ct.grande(2,2) en 100 es ct.grande(5,2)") {
    val inej = ct.interseccion(ct.grande(5,2), ct.grande(2,2))
    assert(inej(100) == ct.grande(5,2)(100))
  }

  test("La interseccion de ct.grande(9,3) y ct.grande(10,4) en 100 es ct.grande(10,4)"){
    val inej = ct.interseccion(ct.grande(9,3), ct.grande(10,4))
    assert(inej(100) == ct.grande(10,4)(100))
  }

  test("La interseccion de ct.grande(4,4) y ct.grande(15,2) en 63 es ct.grande(15,2)") {
    val inej = ct.interseccion(ct.grande(4,4), ct.grande(15,2))
    assert(inej(63) == ct.grande(15,2)(63))
  }

  test("La union de ct.grande(2,5) y ct.grande(3,4) en 340 es ct.grande(3,2)") {
    val inej = ct.interseccion(ct.grande(2,5), ct.grande(3,4))
    assert(inej(340) == ct.grande(3,4)(340))
  }

  test("La union de ct.grande(10,2) y ct.grande(2,3) en 10 es ct.grande(10,2)") {
    val inej = ct.interseccion(ct.grande(10,2), ct.grande(2,3))
    assert(inej(10) == ct.grande(10,2)(10))
  }



  //----Test funcion inclusion----//

  test("ct.grande(10,2) esta incluido en ct.grande(5,2)"){
    assert(ct.inclusion(ct.grande(10,2),ct.grande(5,2)))
  }

  test("ct.grande(5,2) no esta incluido en ct.grande(10,2)"){
    assert(!ct.inclusion(ct.grande(5,2),ct.grande(10,2)))
  }

  test("ct.grande(8,3) esta incluido en ct.grande(2,2)"){
    assert(ct.inclusion(ct.grande(8,3),ct.grande(2,2)))
  }

  test("ct.grande(5,4) no esta incluido en ct.grande(5,5)"){
    assert(!ct.inclusion(ct.grande(5,4),ct.grande(5,5)))
  }

  test("ct.grande(10,2) esta incluido en ct.grande(10,1)"){
    assert(ct.inclusion(ct.grande(10,2),ct.grande(10,1)))
  }

  //----Test igualdad----//

  test("ct.grande(10,2) es igual a ct.grande(10,2)"){
    assert(ct.igualdad(ct.grande(10,2),ct.grande(10,2)))
  }

  test("ct.grande(1,2) no es igual a ct.grande(2,1)"){
    assert(!ct.igualdad(ct.grande(1,2),ct.grande(2,1)))
  }

  test("ct.grande(5,3) es igual a ct.grande(5,3)"){
    assert(ct.igualdad(ct.grande(5,3),ct.grande(5,3)))
  }

  test("ct.grande(2,3) no es igual a ct.grande(1,3)"){
    assert(!ct.igualdad(ct.grande(2,3),ct.grande(1,3)))
  }

  test("ct.grande(10,1) es igual a ct.grande(10,1"){
    assert(ct.igualdad(ct.grande(10,1),ct.grande(10,1)))
  }









}