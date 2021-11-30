package fes.aragon.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="facturas")
public class Facturas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_facturas")
	private int idFactura;
	
	
	@JoinColumn(name="id_clientes",referencedColumnName="id_clientes")
	@ManyToOne(fetch=FetchType.EAGER)
	private Clientes idClientes;
	
	@OneToMany(mappedBy="facturas",fetch=FetchType.EAGER)
	private List<FacturasProductos> facturasProductosList;

	public Facturas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facturasProductosList == null) ? 0 : facturasProductosList.hashCode());
		result = prime * result + ((idClientes == null) ? 0 : idClientes.hashCode());
		result = prime * result + idFactura;
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
		if (idClientes == null) {
			if (other.idClientes != null)
				return false;
		} else if (!idClientes.equals(other.idClientes))
			return false;
		if (idFactura != other.idFactura)
			return false;
		return true;
	}
	
	

}
