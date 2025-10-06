# Argumentacion de correcion de programas

## Funcion grande

### Definicion

```Scala
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
```
### Correccion

- La funcion grande crea un conjunto difuso de numeros grandes donde d y e controlan la pertenencia de un numero x al conjunto

#### Caso base
$$
  (x \leq 0).
  [
  grande(d,e)(x) \to 0.0
  ]
$$
- Como en la definicion teorica, ningun numero menor a 0 es considerado grande

#### Caso inductivo
$$
(x > 0).
[
grande(d,e)(x) \to \left(\frac{x}{x+d}\right)^e
]
$$
- Esta esta expresion esta entre 0 y 1, cumpliendo con la idea de funcion de pertenencia

## Funcion complemento

### Definicion

```Scala
def complemento(c: ConjuntoDifuso): ConjuntoDifuso = {
    def definec(x:Int): Double = {
      1-c(x)
    }
    definec
  }
```
- El complemento de un conjunto, por cada numero x, debe devolver:
$$
  (1 - \mu_A(x))
$$

### Correccion
$$
[
complemento(c)(x) = 1 - c(x)
]
$$
- Esto es igual a la definicion del complemento de un conjunto difuso

## Funcion union

### Definicion

```Scala
def union(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): ConjuntoDifuso = {
    def defineu(x: Int): Double = {
      math.max(cd1(x),cd2(x))
    }
    defineu
  }
```
### Especificacion

- La union de dos conjuntos difusos se define como:
$$
  [
  \forall x, ; \mu_{A \cup B}(x) = \max(\mu_A(x), \mu_B(x))
  ]
$$

### Correccion

- Para todo numero x mayor a cero, la funcion devuelve el maximo de los grados de pertenencia de x en cd1 y cd2.
- Esto es igual a la definicion teorica de la union de dos conjuntos difusos
$$
  [
  union(cd1, cd2)(x) = \max(cd1(x), cd2(x)) = \mu_{A \cup B}(x)
  ]
$$

## Funcion interseccion

### Definicion
```Scala
def interseccion(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): ConjuntoDifuso = {
    def definein(x: Int): Double = {
      math.min(cd1(x),cd2(x))
    }
    definein
  }
```
### Especificacion
- La interseccion de dos conjuntos difusos se define como:
$$
  [
  \forall x, ; \mu_{A \cap B}(x) = \min(\mu_A(x), \mu_B(x))
  ]
$$

### Correccion
- Para todo numero x mayor a cero, la funcion devuelve el minimo de los grados de pertenencia de x en cd1 y cd2
- Esto coincide con la definicion de la interseccion de los conjuntos difusos

$$
[
interseccion(cd1, cd2)(x) = \min(cd1(x), cd2(x)) = \mu_{A \cap B}(x)
]
$$

## Funcion inlcusion

### Definicion
```Scala
def inclusion(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): Boolean = {
  @tailrec
  def definirIn(numero: Int): Boolean = {
    if (numero > 1000) {
      true
    }
    else if (cd1(numero) > cd2(numero)) {
      false
    }
    else {
      definirIn(numero + 1)
    }
    definirIn()
  }
  
  definirIn(0)
}
```

### Especificacion
- Un conjunto difuso esta incluido en otro si:
$$
  [
  \forall x, ; \mu_A(x) \leq \mu_B(x)
  ]
$$
### Correccion

#### Caso base
- (x = 0) se compara si:
$$
  (\mu_A(0) \leq \mu_B(0)).
$$

#### Caso inductivo

- Considerando valido para (x = k), se comprueba (x = k+1)
- La funcion devuelve false si en algun punto:
$$
  (\mu_A(x) > \mu_B(x))
$$
- La funcion devuelve true si alcanza x = 1001
- Esto cumple con la definicion de inclusion

## Funcion igualdad

### Definicion
```Scala
def igualdad(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): Boolean = {
  if(inclusion(cd1, cd2) && inclusion(cd2,cd1))true
  else false
}
```

### Especificacion
- Dos conjuntos difusos son iguales si uno esta incluido dentro del otro
$$
  [
  \mu_A(x) = \mu_B(x) \quad \forall x
  ]
$$
### Correccion
- La funcion expresa directamente la definicion de igualdad de conjuntos difusos

## Conclusion
- Todas las funciones cumplen correctamente con las definiciones matematicas de la teoria de conjuntos difusos
































