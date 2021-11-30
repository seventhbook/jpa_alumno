package fes.aragon.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
@NamedQueries({
	@NamedQuery(name="cliente.todos",query = "SELECT u FROM Clientes u")
})
public class Clientes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clientes")
	private int idCliente;
	
	@Column(name="nombre_clientes")
	private String nombreCliente;
	
	@Column(name="apellido_clientes")
	private String apellidoCliente;
	
	@OneToMany(mappedBy="idClientes",fetch=FetchType.EAGER)
	private List<Facturas> facturasList;

	public Clientes() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public List<Facturas> getFacturasList() {
		return facturasList;
	}

	public void setFacturasList(List<Facturas> facturas) {
		this.facturasList = facturas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoCliente == null) ? 0 : apellidoCliente.hashCode());
		result = prime * result + ((facturasList == null) ? 0 : facturasList.hashCode());
		result = prime * result + idCliente;
		result = prime * result + ((nombreCliente == null) ? 0 : nombreCliente.hashCode());
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
		Clientes other = (Clientes) obj;
		if (apellidoCliente == null) {
			if (other.apellidoCliente != null)
				return false;
		} else if (!apellidoCliente.equals(other.apellidoCliente))
			return false;
		if (facturasList == null) {
			if (other.facturasList != null)
				return false;
		} else if (!facturasList.equals(other.facturasList))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (nombreCliente == null) {
			if (other.nombreCliente != null)
				return false;
		} else if (!nombreCliente.equals(other.nombreCliente))
			return false;
		return true;
	}
	
	
	

}
