package peru.promart.servicios.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peru.promart.servicios.client.dominio.dto.ClienteDto;
import peru.promart.servicios.client.dominio.dto.PromedioDto;
import peru.promart.servicios.client.dominio.services.IClienteService;

import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    IClienteService service;

    @PostMapping(path = "/creacliente")
    public ClienteDto create(@RequestBody ClienteDto client){

        return service.create(client);

    }
    @GetMapping(path = "/listclientes")
    public List<ClienteDto> get(){
        return  service.listar();

    }
    @GetMapping(path = "/kpideclientes")
    public PromedioDto getPromedio(){
        return  service.getPromedio();

    }
}
