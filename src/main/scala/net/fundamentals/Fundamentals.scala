package net.fundamentals

class Fundamentals
{
  def main(args: Array[String]): Unit = {
    /** *
     * ¿Que es Mutabilidad?
     *
     * Un dato mutable puede cambiar en el futuro,
     * por el contrario algo mutable es que NO cambia con el tiempo
     */

    /**
     * var: Declarar variables mutables
     * val: Declarar variables inmutables (Constantes)
     * def: Declarar funciones (Son inmutables también)
     */

    var x = 1 // Escala es un lenguiaje tipado -> infiere el tipo de dato
    println(x)

    var y: Int = 2 // Tambien lo podemos hacer asignandole el tipo de dato

    val z = "Hola Mundo" // Declaracion de una variable Inmutable

    /** *
     * ¿Por que es importante ?
     *
     * En programacion funcional, evitamos SIEMPRE los datos mutables (de ser posibles)
     * La razon principal es que la mutabilidad va a dificultar razonar sobre el codigo
     *
     * La mutabilidad SOLO se deberia usar en casos de Optimizacion
     */

    /** *
     * Expresiones
     *
     * Son el bloque basico de construccion en nuestro codigo.
     * Scala es un lenguaje orientado a Expresiones
     * "Valor de Retorno"
     * El dato al final de una expresion siempre es su valor de retorno
     * Por esta razon no es necesario colocar un Return al final de uan expresion
     *
     */

    /** *
     * Podemos devolver nada en una expresio?
     *
     * Una expresion que no devuelve "nada", en realidad
     * devuelve un tipo llamado Unit
     *
     */

    def exp1 = (3)

    def exp2 = 3

    def exp3 = {
      3
    }

    // Las tres expresiones anteriores son lo mismos

    /** *
     * Funciones
     *
     * Hablamos de funciones en su definicion matematica
     *
     * Dominio: Datos de entrado
     * Rango: Datos de Salida
     *
     */


    /**
     * Funciones de Orden Superior
     *
     * Una funcion de orden superior es tratada como un valor mas
     * Esto implica que una funcion puede recibir y retornar otras funciones
     *
     * Una funcion puede ser parametro de otra funcion
     *
     * Tipos de Funciones:
     * 1. Funciones anonimas
     * 2. Funciones como objetos
     * 3. Funciones como metodos
     *
     */

    def function(x: Int) = x * x

    function(2) // Retornaria 4

    // Funciones anonimas
    (x: Int) =>
      x * x // Similar a una funcion Lambda

      /**
       * Pasar una funcion a un objeto
       *
       */
      val c = function _ // Transforma la funcion en un Objeto
      c.apply(4)

      /** *
       * Funciones de Orden Superior
       * Funcion que recibe una funcion como parametro
       *
       */
      def g(h: Int => Int) = h(3)

      g(function)

      def k(h: Int => Int)(x: Int) = h(x)

      object Util {
        def metodo(x: Int) = x + x

        val a = metodo _
      }

      /** *
       * Reto
       *
       * Crear una funcion que genere una funcion para calcular si un numero es mayor que el
       * parametro que se le paso
       *
       */

      def isGreater(a: Int): Int => Boolean = {
        (b: Int) =>
          a < b
      }

      val f = isGreater(10)
      f(20)

      /** *
       * Colleciones
       *
       * 1. Sequencias
       * 2. Conjuntos
       * 3. Mapas
       *
       */

      /**
       * 1. Listas
       *
       * Es el tipo de dato mas basico en lenguajes funcionales.
       * A diferencia de las listas en otros lenguajes, en scala son inmutables
       * - List, Seq, Array
       *
       */

      /**
       * 2. Conjuntos
       * Es muy similar a una lista , pero conceptualmente es distinto
       * Por definicion los elementos en un conjunto no tienen orden, ni pueden estar
       * repedtidos
       * - Set
       *
       */

      /**
       * 3. Mapas
       * Tambien se les conoce como diccionarios
       *
       * No es muy diferente a los que conocemos, solo que tambien son inmutables por defecto
       * - Map
       */

      /**
       * Loops en FP
       *
       * En programacion funcional no usaremos un for o un while como se hace en lenguajes imperativos
       *
       * Por el contrario usaremos funciones que recorran los elementos de una lista por nosotros
       *  - map()
       *  - filter()
       *  - filterNot()
       *  - forEach()
       *  - zip()
       *  - find()
       *
       */

      // Reto para hallar la Media, Moda y Mediana con las colleciones
      object colecciones {
        def main(args: Array[String]): Unit = {
          val lista: Seq[Int] = Seq(1, 3, 5, 7, 9, 9, 11, 17, 20, 20, 100)

          medidasT(lista)
        }

        //  funciones

        def media(args: Seq[Int]): Int = {
          val media = (args.sum) / (args.size)
          media
        }

        def mediana(args: Seq[Int]): Int = {
          val indice = (args.size / 2)
          args(indice)
        }

        def moda(args: Seq[Int]): Int = {
          args
            .groupBy(x => x)
            .maxBy(x => x._2.size)
            ._1
        }


        // funcion de medidas de tendencia central
        def medidasT(args: Seq[Int]): Unit = {
          val lista = args.sorted
          val mapa = Map(
            "media" -> media(lista),
            "mediana" -> mediana(lista),
            "moda" -> moda(lista)
          )
          mapa foreach (x => println(x._1 + " -> " + x._2))


        }
      }

    /**
     * Tuplas
     *
     * ¿Como agrupar distintos tipos de datos en uno?
     * Una lista no funcionara como esperamos (perdemos el tipo de dato)
     * Las tuplas son estructuras de datos flexibles y potentes
     * para agrupar datos
     */

    /**
     * Objetos
     * En Scala tenemos una manera de definir clases cuyo objetivo es agrupar informacion.
     * Programar de forma funcional implica separar  los datos de las operaciones sobre los datos
     *
     */

    /**
     * Clases en OOP vs FP
     *
     * Una clase en OOP tendra atributos y metodos juntos
     *
     * En FP hay clases que contienen unicamente atributos  y habra otras clases unicamente con operaciones
     *
     *
     */

    /**
     * Tipos de Clases en Scala
     * 1. Case Clase
     * 2. Traits
     * 3. Classes
     * 4. Abstract Classes
     *
     *
     *
     */

    case clase Persona(id: Int, nombre: String, activo: Boolean)
    val p = Persona(1, "Daniel", true)

    // Para seleccionar un valor de una tupla
    tupla._1 // elprimer valor de la tupla
    tupla._2 // segundo valor de la tupla
    tupla._3 // tercer valor de la tupla

    p.id
    p.nombre
    p.activo

    Persona.tupled(tupla)

    Persona.unapply()
  }

  /**
   * La función copy() y el concepto de Lenses
   * La función copy() viene por defecto en cualquier tupla y en cualquier Case Class.
   * Esta función es muy importante en el contexto de la inmutabilidad ya que nos permite
   * modificar los valores de un objeto sin necesidad de “sacar sus datos” con apply y tupled.
   *
   *
   *
   */

  // Dos case class
  case class A(id: Int)
  case class B(id: Int, a: A)

  // obj1 es inmutable
  val obj1 = B(1, A(0))
  // obj2 es la copia con una copia interna modificada.
  val obj2 = obj1.copy(a = obj1.a.copy(1))

  /**
   * ¿Qué es Scala Case Class?
   *
   * Una clase de caso de Scala es como una clase normal,
   * excepto que es buena para modelar datos inmutables.
   * También es útil en la coincidencia de patrones,
   * una clase de este tipo tiene un método apply ()
   * predeterminado que maneja la construcción de objetos.
   * Una clase de caso de Scala también tiene todos los valores,
   * lo que significa que son inmutables.
   */

  /**
   * Inicializacion del proyecto con uso de 3 ramas
   *
   * Caso de prueba
   *
   * 1. hacer merge de la rama feacture a la rama
   * 2. Caso de prueba 2 de git
   * 3. Caso de prueba 3
   */


}
