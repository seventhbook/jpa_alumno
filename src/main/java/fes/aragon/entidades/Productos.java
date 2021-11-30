package fes.aragon.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_productos")
	private int idProductos;
	
	@Column(name="nombre_productos")
	private String nombreProductos;
	
	@Column(name="precio_productos")
	private String precioProductos;
	
	@OneToMany(mappedBy = "productos",fetch = FetchType.EAGER)
	private List<FacturasProductos> facturasProductosList;
	
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}


	public int getIdProductos() {
		return idProductos;
	}


	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}


	public String getNombreProductos() {
		return nombreProductos;
	}


	public void setNombreProductos(String nombreProductos) {
		this.nombreProductos = nombreProductos;
	}


	public String getPrecioProductos() {
		return precioProductos;
	}


	public void setPrecioProductos(String precioProductos) {
		this.precioProductos = precioProductos;
	}


	public List<FacturasProductos> getFacturasProductosList() {
		return facturasProductosList;
	}


	public void setFacturasProductosList(List<FacturasProductos> facturasProductosList) {
		this.facturasProductosList = facturasProductosList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facturasProductosList == null) ? 0 : facturasProductosList.hashCode());
		result = prime * result + idProductos;
		result = prime * result + ((nombreProductos == null) ? 0 : nombreProductos.hashCode());
		result = prime * result + ((precioProductos == null) ? 0 : precioProductos.hashCode());
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
		Productos other = (Productos) obj;
		if (facturasProductosList == null) {
			if (other.facturasProductosList != null)
				return false;
		} else if (!facturasProductosList.equals(other.facturasProductosList))
			return false;
		if (idProductos != other.idProductos)
			return false;
		if (nombreProductos == null) {
			if (other.nombreProductos != null)
				return false;
		} else if (!nombreProductos.equals(other.nombreProductos))
			return false;
		if (precioProductos == null) {
			if (other.precioProductos != null)
				return false;
		} else if (!precioProductos.equals(other.precioProductos))
			return false;
		return true;
	}

	
}
