package Clases;

import Excepciones.NotMatchedAmountsException;
import java.util.Vector;

public class VectorAD {

	// Atributos

	private int size = 0;
	private Vector<Number> vector = new Vector<>();
	private int format = 0;

	// Constructores

	public VectorAD(double[] vec) {
		for (int i = 0; i < vec.length; i++) {
			setVector(vec[i]);
		}
	}

	public VectorAD(Number... num) {
		for (Number n : num) {
			setVector(n.doubleValue());
		}
	}

	public VectorAD(Vector<Number> vec) {
		for (int i = 0; i < vec.size(); i++) {
			setVector(vec.get(i).doubleValue());
		}
	}

	public VectorAD(VectorAD vec) {
		for (int i = 0; i < vec.getSize(); i++) {
			setVector(vec.getVectorData(i));
		}
		this.format = vec.format;
	}

	// Getters && Setters

	public int getSize() {
		return size;
	}

	protected void setSize(int size) {
		this.size = size;
	}

	protected Vector<Number> getVector() {
		return vector;
	}

	// Agrega un componente al final del vector
	protected void setVector(Number v) {
		this.vector.add(v.doubleValue());
		setSize(this.vector.size());
	}

	// Cambia el componente i
	protected void setVectorData(int i, double v) {
		this.vector.set(i, v);
	}

	// Metodos

	public double getVectorData(int i) { // Devuelve el valor number en double
		return this.vector.get(i).doubleValue();
	}

	public void changeFormat(VecFormat f) {
		// Algebraica y polar solo tienen sentido en 2D; si no, se usa la comun
		if (getSize() != 2 && f.toInteger() > 1) {
			this.format = VecFormat.COMUN.toInteger();
		} else {
			this.format = f.toInteger();
		}
	}

	public double magnitud() {
		double magnitud = 0.0;
		if (getSize() == 0) return magnitud;
		for (int i = 0; i < getSize(); i++) {
			magnitud += Math.pow(getVectorData(i), 2);
		}
		return Math.sqrt(magnitud);
	}

	// Angulo en grados respecto al eje X (atan2 para respetar el cuadrante)
	public double direccion() {
		if (getSize() < 2) return 0;
		return Math.toDegrees(Math.atan2(getVectorData(1), getVectorData(0)));
	}

	@Override
	public String toString() {
		String mensaje = "";
		switch (this.format) {
		case 1:
			mensaje += "<";
			for (int i = 0; i < getSize(); i++) {
				mensaje += String.format("%.2f", getVectorData(i));
				if (i != getSize() - 1) {
					mensaje += ", ";
				}
			}
			mensaje += ">";
			break;
		case 2:
			if (getVectorData(1) >= 0) {
				mensaje += String.format("%.2f + i%.2f", getVectorData(0), getVectorData(1));
			} else {
				mensaje += String.format("%.2f - i%.2f", getVectorData(0),
											Math.abs(getVectorData(1)));
			}
			break;
		case 3:
			mensaje += String.format("(%.2f, %.2f°)", this.magnitud(), this.direccion());
			break;
		case 0:
		default:
			for (int i = 0; i < getSize(); i++) {
				mensaje += String.format("%.2f\t", getVectorData(i));
			}
			break;
		}
		return mensaje;
	}

	// Multiplica el vector por un escalar (modifica el vector original)
	public static void escalar(VectorAD vec, double n) {
		for (int i = 0; i < vec.getSize(); i++) {
			vec.setVectorData(i, vec.getVectorData(i) * n);
		}
	}

// Transformaciones Lineales
// Todas regresan un vector nuevo y dejan el original intacto

    // Reflexión

    // Reflexion sobre el eje X: (x, y) -> (x, -y)
    public VectorAD reflexionX() {
    	VectorAD nuevo = new VectorAD(this);
    	nuevo.setVectorData(1, nuevo.getVectorData(1) * -1);
    	return nuevo;
    }

    // Reflexion sobre el eje Y: (x, y) -> (-x, y)
    public VectorAD reflexionY() {
    	VectorAD nuevo = new VectorAD(this);
    	nuevo.setVectorData(0, nuevo.getVectorData(0) * -1);
    	return nuevo;
    }

    // Reflexion sobre el plano XY: (x, y, z) -> (x, y, -z)
    public VectorAD reflexionZ() {
    	VectorAD nuevo = new VectorAD(this);
    	if (nuevo.getSize() > 2) {
    		nuevo.setVectorData(2, nuevo.getVectorData(2) * -1);
    	}
    	return nuevo;
    }

    // Rotacion (solo 2D, angulo en grados, sentido antihorario)

    public VectorAD rotar(double grados) {
    	VectorAD nuevo = new VectorAD(this);
    	if (nuevo.getSize() == 2) {
    		double rad = Math.toRadians(grados);
    		double x = getVectorData(0);
    		double y = getVectorData(1);
    		nuevo.setVectorData(0, Math.cos(rad) * x - Math.sin(rad) * y);
    		nuevo.setVectorData(1, Math.sin(rad) * x + Math.cos(rad) * y);
    	}
    	return nuevo;
    }

    // Proyeccion sobre X

    public VectorAD proyeccionX() {
    	VectorAD nuevo = new VectorAD(this);
    	for (int i = 1; i < nuevo.getSize(); i++) {
    		nuevo.setVectorData(i, 0);
    	}
    	return nuevo;
    }

    // Proyeccion sobre Y

    public VectorAD proyeccionY() {
    	VectorAD nuevo = new VectorAD(this);
    	for (int i = 0; i < nuevo.getSize(); i++) {
    		if (i != 1) nuevo.setVectorData(i, 0);
    	}
    	return nuevo;
    }

    // Expansion X

    public VectorAD expansionX(double num) {
    	VectorAD nuevo = new VectorAD(this);
    	nuevo.setVectorData(0, nuevo.getVectorData(0) * num);
    	return nuevo;
    }

    // Expansion Y

    public VectorAD expansionY(double num) {
    	VectorAD nuevo = new VectorAD(this);
    	nuevo.setVectorData(1, nuevo.getVectorData(1) * num);
    	return nuevo;
    }

    // Expansion Z

    public VectorAD expansionZ(double num) {
    	VectorAD nuevo = new VectorAD(this);
    	if (this.getSize() > 2) {
    		nuevo.setVectorData(2, nuevo.getVectorData(2) * num);
    	}
    	return nuevo;
    }

    // Shear (corte)

    // (x, y) -> (x + k*y, y)
    public VectorAD shearX(double num) {
    	VectorAD nuevo = new VectorAD(this);
    	nuevo.setVectorData(0, getVectorData(1) * num + getVectorData(0));
    	return nuevo;
    }

    // (x, y) -> (x, y + k*x)
    public VectorAD shearY(double num) {
    	VectorAD nuevo = new VectorAD(this);
    	nuevo.setVectorData(1, getVectorData(0) * num + getVectorData(1));
    	return nuevo;
    }

    // Suma

    public VectorAD sumaVectores(VectorAD vec2) throws NotMatchedAmountsException {
        if (this.getSize() != vec2.getSize()) {
        	throw new NotMatchedAmountsException(this, vec2);
        }
        VectorAD arr = new VectorAD(this);
        for (int i = 0; i < this.getSize(); i++) {
            arr.setVectorData(i, this.getVectorData(i) + vec2.getVectorData(i));
        }
        return arr;
    }

    // Resta

    public VectorAD restaVectores(VectorAD vec2) throws NotMatchedAmountsException {
        if (this.getSize() != vec2.getSize()) {
        	throw new NotMatchedAmountsException(this, vec2);
        }
        VectorAD arr = new VectorAD(this);
        for (int i = 0; i < this.getSize(); i++) {
            arr.setVectorData(i, this.getVectorData(i) - vec2.getVectorData(i));
        }
        return arr;
    }

    // Multiplicacion (componente por componente)

    public VectorAD multiplicacionVectores(VectorAD vec2) throws NotMatchedAmountsException {
        if (this.size != vec2.size) throw new NotMatchedAmountsException(this, vec2);
        VectorAD arr = new VectorAD(this);
        for (int i = 0; i < this.getSize(); i++) {
            arr.setVectorData(i, this.getVectorData(i) * vec2.getVectorData(i));
        }
        return arr;
    }

    // Potencia

    public static VectorAD potenciaVectores(VectorAD vec, double n) {
        VectorAD arr = new VectorAD(vec);
        for (int i = 0; i < vec.getSize(); i++) {
            arr.setVectorData(i, Math.pow(vec.getVectorData(i), n));
        }
        return arr;
    }

    // Raices

    public static VectorAD raizVectores(VectorAD vec, double n) {
        VectorAD arr = new VectorAD(vec);
        for (int i = 0; i < vec.getSize(); i++) {
            arr.setVectorData(i, Math.pow(vec.getVectorData(i), 1 / n));
        }
        return arr;
    }

    // ToDouble

    public double[] toDouble() {
    	double[] arr = new double[this.getSize()];
    	for (int i = 0; i < this.getSize(); i++) {
    		arr[i] = this.getVectorData(i);
    	}
    	return arr;
    }
}
