package fes.aragon.dao;


import java.util.List;

import fes.aragon.entidades.Clientes;
import fes.aragon.entidades.Facturas;

public interface IFacturasDAO {
	public void registrarFacturas(Facturas factura);
	public void modificarFacturas(Facturas factura);
	public void eliminarFacturas(Facturas factura);
	public List<Facturas> facturasXCliente(Clientes cliente);
	public Facturas facturaXId(int id);
}
