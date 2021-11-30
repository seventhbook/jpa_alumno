package fes.aragon.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="facturas_productos")
public class FacturasProductos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected FacturasProductosPK facturasProductosPK;
	
	@Column(name="cantidad_facturas_productos")
	private double cantidadFacturasProductos;
	
	@JoinColumn(name="id_facturas",referencedColumnName = "id_facturas",
			insertable = false,updatable = false)
	@ManyToOne(fetch=FetchType.EAGER)
	private Facturas facturas;
	
	@JoinColumn(name="id_productos",referencedColumnName = "id_productos",
			insertable = false,updatable = false)
	@ManyToOne(fetch=FetchType.EAGER)
	private Productos productos;
	
	public FacturasProductos() {
		// TODO Auto-generated constructor stub
	}

	public FacturasProductos(FacturasProductosPK facturasProductosPK) {
		this.facturasProductosPK = facturasProductosPK;
	}

	public FacturasProductos(FacturasProductosPK facturasProductosPK, double cantidadFacturasProductos) {
		this.facturasProductosPK = facturasProductosPK;
		this.cantidadFacturasProductos = cantidadFacturasProductos;
	}
	
	public FacturasProductos(int idFacturas,int idProductos) {
		this.facturasProductosPK= new FacturasProductosPK(idFacturas,idProductos);
	}

	public FacturasProductosPK getFacturasProductosPK() {
		return facturasProductosPK;
	}

	public void setFacturasProductosPK(FacturasProductosPK facturasProductosPK) {
		this.facturasProductosPK = facturasProductosPK;
	}

	public double getCantidadFacturasProductos() {
		return cantidadFacturasProductos;
	}

	public void setCantidadFacturasProductos(double cantidadFacturasProductos) {
		this.cantidadFacturasProductos = cantidadFacturasProductos;
	}

	public Facturas getFacturas() {
		return facturas;
	}

	public void setFacturas(Facturas facturas) {
		this.facturas = facturas;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	
	

	
	
}
