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
public class ClienteDAOImp implements IClienteDAO{
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Clientes> todosClientes() {
		return em.createNamedQuery("cliente.todos").getResultList();
	}

	@Override
	public Clientes datosClientes(int id) {
		return (Clientes) em.createNamedQuery("cliente.datos").setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional(readOnly = false)
	public void registrarClientes(Clientes cliente) {
		em.persist(cliente);
	}

	@Override
	@Transactional(readOnly = false)
	public void modificarClientes(Clientes cliente) {
		em.merge(cliente);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void eliminarClientes(Clientes cliente) {
		em.remove(cliente);
	}
	
	
}
