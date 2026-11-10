package Clases;

// Formatos en los que se puede imprimir un VectorAD
public enum VecFormat {
	NUMERICA(0),   // 1.00	2.00	3.00
	COMUN(1),      // <1.00, 2.00, 3.00>
	ALGEBRAICA(2), // 1.00 + i2.00   (solo vectores de 2 componentes)
	POLAR(3);      // (magnitud, angulo°) (solo vectores de 2 componentes)

	private final int f;

	private VecFormat(int f) {
		this.f = f;
	}

	public int toInteger() {
		return this.f;
	}
}
