package peru.promart.servicios.client.dominio.services;

import peru.promart.servicios.client.dominio.dto.ClienteDto;
import peru.promart.servicios.client.dominio.dto.PromedioDto;

import java.util.List;

public interface IClienteService {

    ClienteDto create(ClienteDto data);
    PromedioDto getPromedio();
    List<ClienteDto> listar();
}
