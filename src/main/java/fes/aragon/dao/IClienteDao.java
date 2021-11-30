package fes.aragon.dao;

import java.util.List;

import fes.aragon.entidades.Clientes;
import fes.aragon.formulario.ClientesFormulario;

public interface IClienteDAO {
	public List<Clientes> todosClientes();
	public Clientes datosClientes(int id);
	public void registrarClientes(Clientes cliente);
	public void modificarClientes(Clientes cliente);
	public void eliminarClientes(Clientes cliente);
}
