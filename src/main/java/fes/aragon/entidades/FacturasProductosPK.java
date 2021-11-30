package fes.aragon.entidades;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacturasProductosPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional=false)
	@Column(name="id_facturas")
	private int idFacturas;
	
	@Basic(optional=false)
	@Column(name="id_productos")
	private int idProductos;
	
	
	public FacturasProductosPK() {
		// TODO Auto-generated constructor stub
	}

	public FacturasProductosPK(int idFacturas, int idProductos) {
		this.idFacturas = idFacturas;
		this.idProductos = idProductos;
	}

	public int getIdFacturas() {
		return idFacturas;
	}

	public void setIdFacturas(int idFacturas) {
		this.idFacturas = idFacturas;
	}

	public int getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFacturas;
		result = prime * result + idProductos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturasProductosPK other = (FacturasProductosPK) obj;
		if (idFacturas != other.idFacturas)
			return false;
		if (idProductos != other.idProductos)
			return false;
		return true;
	}
	
	

}
