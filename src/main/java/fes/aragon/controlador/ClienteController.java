package fes.aragon.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fes.aragon.dao.IClienteDao;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteDao clientes;
	
	@GetMapping(value = "/listaclientes")
	public String listaClientes(Model modelo) {
		modelo.addAttribute("cls",clientes.todosClientes());
		return "listacliente";
	}

}
