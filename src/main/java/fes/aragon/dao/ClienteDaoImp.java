package fes.aragon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fes.aragon.entidades.Clientes;

@Repository
public class ClienteDaoImp implements IClienteDao{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Clientes> todosClientes() {
		return em.createNamedQuery("cliente.todos").getResultList();
	}

}
