# API: Álgebra Lineal

Librería de álgebra lineal en Java: vectores, matrices de hasta 3×3 y transformaciones lineales. La hicimos como proyecto final de Programación Orientada a Objetos.

> **Nota:** la carpeta original se perdió. Este código se reconstruyó a partir de los fragmentos que nos mandamos por Teams mientras lo hacíamos. Las clases, los nombres, la estructura y la mayoría del código son los originales. La reconstruccion, coherencia y compilación del codigo recuperado se hizo con IA. 

## Alcance

Es, en esencia, una calculadora de álgebra lineal de nivel introductorio, la de un primer curso de la carrera, organizada como librería orientada a objetos. Cubre operaciones con vectores, matrices cuadradas de hasta 3×3, determinantes, inversas, sistemas de 2 o 3 ecuaciones por Cramer y transformaciones lineales básicas.

Queda fuera: matrices mayores a 3×3 o no cuadradas, producto punto y cruz, eliminación de Gauss, rango, y valores y vectores propios.

### Recomendación de la evaluación

En la evaluación, el profesor recomendó generalizar la librería para trabajar con matrices de *n* elementos. Para no modificar lo que se hizo en su momento, aquí solo se deja anotada la recomendación y el proyecto no se extiende más.

## Estructura

```
src/
├── Clases/
│   ├── VectorAD.java        Vectores de n componentes
│   ├── MatrixAD.java        Matrices cuadradas de 1x1 a 3x3
│   ├── VecFormat.java       Formatos de impresión de vectores
│   └── TiposMatrices.java   Matrices predefinidas (identidad, cero, triangulares)
├── Excepciones/
│   ├── NotMatchedAmountsException.java   Operar objetos de tamaños distintos
│   └── NotPermitedSizeException.java     Matriz no cuadrada o mayor a 3x3
└── Test.java                Demo y pruebas
```

## Qué hace

**VectorAD**
- Suma, resta, multiplicación por componente, potencia, raíz y escalar
- Magnitud y dirección
- Impresión en formato numérico, común `<x, y>`, algebraico `x + iy` y polar `(r, θ°)`
- Transformaciones lineales: reflexión, rotación, proyección, expansión y shear

**MatrixAD**
- Suma, resta, escalar, transpuesta y multiplicación
- Determinante, submatriz (menor), cofactor y adjunta
- Inversa
- Sistemas de ecuaciones por la regla de Cramer

## Compilar y correr

Se necesita Java 8 o más reciente.

```bash
javac -encoding UTF-8 -d out $(find src -name '*.java')
java -cp out Test
```

## Ejemplo

```java
MatrixAD A = new MatrixAD(new double[][] {{2, 1, 1}, {1, 3, 2}, {1, 0, 0}});
System.out.println(MatrixAD.determinant(A));   // -1.0
System.out.println(A.inverse());

VectorAD x = MatrixAD.cramer(A, new VectorAD(7, 13, 1));
x.changeFormat(VecFormat.COMUN);
System.out.println(x);                          // <1.00, 2.00, 3.00>

VectorAD v = new VectorAD(1, 0).rotar(90);     // <0, 1>
```


