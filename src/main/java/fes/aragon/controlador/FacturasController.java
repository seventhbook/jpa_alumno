package fes.aragon.controlador;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import fes.aragon.dao.IFacturasDAO;
import fes.aragon.entidades.Clientes;
import fes.aragon.entidades.Facturas;
import fes.aragon.entidades.FacturasProductos;
import fes.aragon.formulario.ClientesFormulario;

@Controller
public class FacturasController {
	// indica la inyeccion
	@Autowired
	private IFacturasDAO facturas;

	@Autowired
	private IClienteDAO clientes;
	
	@GetMapping(value="facturasClientes")
	public String listaFacturas(Model modelo) {
		modelo.addAttribute("titulo","Lista Clientes Facturas");
		modelo.addAttribute("cls", clientes.todosClientes());
		return "facturas/listaClienteFactura";
	}
	
	@GetMapping(value = "listaFacturas/{id}")
	public String listaFacturas(@PathVariable(value = "id") int id, Model modelo) {
		Clientes cliente=null;
		List<Facturas> listaFact=null;
		if(id>0) {
			cliente= this.clientes.datosClientes(id);
			listaFact=this.facturas.facturasXCliente(cliente);
		}
		modelo.addAttribute("titulo","Lista Facturas");
		modelo.addAttribute("facturas",listaFact);
		modelo.addAttribute("cliente",cliente);
		return "facturas/listaFacturas";
	}
	
	
	@GetMapping(value="insertarFactura/{idCliente}")
	public String IngresarFactura(@PathVariable(value = "idCliente") int idCliente,Model modelo) {
		Clientes cliente= this.clientes.datosClientes(idCliente);
		Facturas factura=new Facturas();
		factura.setIdClientes(cliente);
		modelo.addAttribute("factura",factura);
		modelo.addAttribute("cliente",cliente);
		modelo.addAttribute("titulo","Insertar Factura");
		return "facturas/facturaInsertar";
	}
	
	
	
	@PostMapping(value = "/formFactInsertar")
	public String formFacturasInsertar(@Valid @ModelAttribute(value="factura") Facturas factura,
			BindingResult resultado ,@RequestParam(value="id") int id,Model modelo) {
		if(resultado.hasErrors()) {
			Clientes cliente= this.clientes.datosClientes(id);
			factura.setIdClientes(cliente);
			modelo.addAttribute("factura",factura);
			modelo.addAttribute("cliente",cliente);
			modelo.addAttribute("titulo","Error al agregar Factura");
			return "facturas/facturaInsertar";
		}
		System.out.println("Dentro de insertar:"+factura);
		Clientes cliente= this.clientes.datosClientes(id);
		factura.setIdClientes(cliente);
		if(factura.getIdFacturas()==null ||factura.getIdFacturas()<1) {
			this.facturas.registrarFacturas(factura);
			modelo.addAttribute("titulo","Lista Facturas");
		}else {
			//Factura en base de datos y le llenamos con lo del formulario
			Facturas facAux=this.facturas.facturaXId(factura.getIdFacturas());
			facAux.setReferenciaFacturas(factura.getReferenciaFacturas());
			facAux.setFechaFacturas(factura.getFechaFacturas());
			this.facturas.modificarFacturas(facAux);
			modelo.addAttribute("titulo","Editar Factura");
			System.out.println("Se modifico la factura");
		}
		
		List<Facturas> listaFact=this.facturas.facturasXCliente(cliente);
		modelo.addAttribute("facturas",listaFact);
		modelo.addAttribute("cliente",cliente);
		return "redirect:/listaFacturas/"+cliente.getIdClientes();
		
	}
	
	@RequestMapping(value="modificarFactura/{idFactura}")
	public String modificarFactura(@PathVariable(value = "idFactura") int idFactura, Model modelo) {
		Facturas factura=this.facturas.facturaXId(idFactura);
		System.out.println(factura);
		Clientes cliente= factura.getIdClientes();
		System.out.println(factura.getIdFacturas()+" "+factura.getReferenciaFacturas()+" "+factura.getFechaFacturas());
		modelo.addAttribute("factura",factura);
		modelo.addAttribute("cliente",cliente);
		modelo.addAttribute("titulo","Modificar Factura: "+factura.getIdFacturas());
		modelo.addAttribute("idFacturas",idFactura);
		return "facturas/facturaInsertar";
	}
	
		
	@RequestMapping(value = "/formFactEliminar/{id}")
	public String eliminarFacturas(@PathVariable(value = "id")int id, Model modelo) {
		Facturas factura=null;
		Clientes cliente=null;
	
		factura= facturas.facturaXId(id);
		System.out.println(factura.getFechaFacturas()+" "+factura.getIdFacturas());
		cliente=factura.getIdClientes();
		cliente.getFacturasList().remove(factura);
		facturas.eliminarFacturas(factura);
		
		List<Facturas> listaFact=this.facturas.facturasXCliente(cliente);
		modelo.addAttribute("titulo","Lista Facturas");
		modelo.addAttribute("facturas",listaFact);
		modelo.addAttribute("cliente",cliente);
		return "/facturas/listaFacturas";
	}
}
