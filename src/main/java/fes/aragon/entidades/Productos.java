package fes.aragon.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
	private Integer idProductos;
	
	@Column(name="nombre_productos")
	private String nombreProductos;
	
	@Column(name="precio_productos")
	private String precioProductos;
	
	@OneToMany(mappedBy = "productos", fetch=FetchType.EAGER)
	private List<FacturasProductos> facturasProductosList;
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(Integer idProductos) {
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
		return Objects.hash(facturasProductosList, idProductos, nombreProductos, precioProductos);
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
		return Objects.equals(facturasProductosList, other.facturasProductosList)
				&& Objects.equals(idProductos, other.idProductos)
				&& Objects.equals(nombreProductos, other.nombreProductos)
				&& Objects.equals(precioProductos, other.precioProductos);
	}
	
}
