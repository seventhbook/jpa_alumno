package fes.aragon.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fes.aragon.dao.IClienteDAO;
import fes.aragon.entidades.Clientes;
import fes.aragon.entidades.Facturas;
import fes.aragon.entidades.FacturasProductos;
import fes.aragon.formulario.ClientesFormulario;

@Controller
public class ClienteController {
	// indica la inyeccion
	@Autowired
	private IClienteDAO clientes;

	@GetMapping(value = "listaclientes")
	public String listaclientes(Model modelo) {
		modelo.addAttribute("titulo","Lista Clientes");
		modelo.addAttribute("cls", clientes.todosClientes());
		return "clientes/listacliente";
	}

	@GetMapping(value="/")
	public String inicio(Model modelo) {
		modelo.addAttribute("titulo","Inicio");
		return "inicio";
	}
	
	@GetMapping(value = "listaclientesInsertar")
	public String listaclientesInsertar(Model modelo) {
		Clientes cliente=new Clientes();
		modelo.addAttribute("titulo","Nuevo Cliente");
		modelo.addAttribute("cliente",cliente);
		return "clientes/listaclienteInsertar";
	}

	@PostMapping(value = "/formInsertar")
	public String formClientesInsertar(@Valid @ModelAttribute("cliente") Clientes cliente,
			BindingResult resultado ,Model modelo) {
		if(resultado.hasErrors()) {
		
			modelo.addAttribute("titulo","Error Crear o modificar cliente");
			
			return "/clientes/listaclienteInsertar";
		}
		if(cliente.getIdClientes()>0) {
			this.clientes.modificarClientes(cliente);
		}else {
			this.clientes.registrarClientes(cliente);
		}
		modelo.addAttribute("cls", this.clientes.todosClientes());
		modelo.addAttribute("titulo","Insertar Cliente");
		return "clientes/listacliente";
	}
	
	@GetMapping(value = "listaclientesmodificar")
	public String listaclientesModificar(Model modelo) {
		modelo.addAttribute("cls",clientes.todosClientes());
		modelo.addAttribute("titulo","Modificar Clientes");
		return "clientes/listaclientemodificar";
	}
	
	@RequestMapping(value = "/formInsertar/{id}")
	public String editarClientes(@PathVariable(value = "id")int id, Model modelo) {
		Clientes cliente= null;
		if(id>0) {
			cliente= clientes.datosClientes(id);
		}else {
			modelo.addAttribute("cls",clientes.todosClientes());
			modelo.addAttribute("titulo","Modificar Clientes");
			return "clientes/listaclientemodificar";
		}
		modelo.addAttribute("cls", this.clientes.todosClientes());
		modelo.addAttribute("cliente",cliente);
		modelo.addAttribute("titulo","Modificar Cliente "+id);
		return "/clientes/listaclienteInsertar";
	}
	
	@GetMapping(value = "listaclienteseliminar")
	public String listaclientesEliminar(Model modelo) {
		modelo.addAttribute("cls",clientes.todosClientes());
		modelo.addAttribute("titulo","Eliminar Clientes");
		return "clientes/listaclienteeliminar";
	}
	
	@RequestMapping(value = "/formEliminar/{id}")
	public String eliminarClientes(@PathVariable(value = "id")int id, Model modelo) {
		Clientes cliente= null;
		if(id>0) {
			cliente= clientes.datosClientes(id);
			clientes.eliminarClientes(cliente);
		}
		modelo.addAttribute("cls", this.clientes.todosClientes());
		modelo.addAttribute("titulo","Eliminar Clientes");
		
		return "redirect:/listaclienteseliminar";
	}
}
