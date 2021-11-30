package fes.aragon.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="facturas")
@NamedQueries({
	@NamedQuery(name="facturas.todos",query="SELECT u FROM Facturas u"),
	@NamedQuery(name="facturas.datos",query="SELECT u FROM Facturas u WHERE u.idClientes=:id")
})
public class Facturas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_facturas")
	private Integer idFacturas;
	
	
	@JoinColumn(name="id_clientes",referencedColumnName = "id_clientes")
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.MERGE)
	//así se le llama al mapeo en la clase Clientes
	//debe ser el mismo nombre, a huevo
	private Clientes idClientes;
	
	@OneToMany(mappedBy = "facturas", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<FacturasProductos> facturasProductosList;
	
	@NotEmpty(message = "La referencia no debe ser vacia")
	@Column(name="referencia_facturas")
	private String referenciaFacturas;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="La Fecha no debe ser vacia")
	@Column(name="fecha_facturas")
	private Date fechaFacturas;
	
	public Facturas() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdFacturas() {
		return idFacturas;
	}

	public void setIdFacturas(Integer idFacturas) {
		this.idFacturas = idFacturas;
	}

	public Clientes getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(Clientes idClientes) {
		this.idClientes = idClientes;
	}

	public List<FacturasProductos> getFacturasProductosList() {
		return facturasProductosList;
	}

	public void setFacturasProductosList(List<FacturasProductos> facturasProductosList) {
		this.facturasProductosList = facturasProductosList;
	}

	public String getReferenciaFacturas() {
		return referenciaFacturas;
	}

	public void setReferenciaFacturas(String referenciaFacturas) {
		this.referenciaFacturas = referenciaFacturas;
	}

	public Date getFechaFacturas() {
		return fechaFacturas;
	}

	public void setFechaFacturas(Date fechaFacturas) {
		this.fechaFacturas = fechaFacturas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facturasProductosList == null) ? 0 : facturasProductosList.hashCode());
		result = prime * result + ((fechaFacturas == null) ? 0 : fechaFacturas.hashCode());
		result = prime * result + ((idClientes == null) ? 0 : idClientes.hashCode());
		result = prime * result + ((idFacturas == null) ? 0 : idFacturas.hashCode());
		result = prime * result + ((referenciaFacturas == null) ? 0 : referenciaFacturas.hashCode());
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
		Facturas other = (Facturas) obj;
		if (facturasProductosList == null) {
			if (other.facturasProductosList != null)
				return false;
		} else if (!facturasProductosList.equals(other.facturasProductosList))
			return false;
		if (fechaFacturas == null) {
			if (other.fechaFacturas != null)
				return false;
		} else if (!fechaFacturas.equals(other.fechaFacturas))
			return false;
		if (idClientes == null) {
			if (other.idClientes != null)
				return false;
		} else if (!idClientes.equals(other.idClientes))
			return false;
		if (idFacturas == null) {
			if (other.idFacturas != null)
				return false;
		} else if (!idFacturas.equals(other.idFacturas))
			return false;
		if (referenciaFacturas == null) {
			if (other.referenciaFacturas != null)
				return false;
		} else if (!referenciaFacturas.equals(other.referenciaFacturas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Facturas [idFacturas=" + idFacturas + ", idClientes=" + idClientes + ", facturasProductosList="
				+ facturasProductosList + ", referenciaFacturas=" + referenciaFacturas + ", fechaFacturas="
				+ fechaFacturas + "]";
	}

	
	 
}
