package fes.aragon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fes.aragon.entidades.Clientes;
import fes.aragon.entidades.Facturas;
import fes.aragon.formulario.ClientesFormulario;

@Repository
public class FacturasDAOImp implements IFacturasDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = false)
	public void registrarFacturas(Facturas factura) {
		em.persist(factura);
	}

	@Override
	@Transactional(readOnly = false)
	public void modificarFacturas(Facturas factura) {
		em.merge(factura);
	}

	@Override
	@Transactional(readOnly = false)
	public void eliminarFacturas(Facturas factura) {
		System.out.println("Elimine la factura "+factura.getIdFacturas());
		em.remove(factura);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Facturas> facturasXCliente(Clientes cliente) {
		return em.createNamedQuery("facturas.datos").setParameter("id", cliente).getResultList();
	}

	@Override
	public Facturas facturaXId(int id) {
		return (Facturas) em.find(Facturas.class, id);
	}

	
}
