package peru.promart.servicios.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peru.promart.servicios.client.dominio.dto.ClienteDto;
import peru.promart.servicios.client.dominio.dto.PromedioDto;
import peru.promart.servicios.client.dominio.entity.ClientEntity;
import peru.promart.servicios.client.dominio.repository.IClienteRepository;
import peru.promart.servicios.client.dominio.services.IClienteService;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
@Service
public class ClientService implements IClienteService {
    @Autowired
    IClienteRepository repository;
    @Override
    public ClienteDto create(ClienteDto data) {
        var entity=ToClient(data);
        return ToDto(repository.save(entity));
    }

    @Override
    public PromedioDto getPromedio() {
        var dto=new PromedioDto();

        var data=repository.findAll();
        int n=data.size();
        double total = data.stream().mapToDouble(ClientEntity::getEdad).sum();
        double average = total / data.size();
        double standardDeviation=  0.0;
        double res = 0.0;
        double sq = 0.0;

        for (int i = 0; i < n; i++) {

            standardDeviation
                    = standardDeviation + Math.pow((data.get(i).getEdad() - average), 2);

        }
        sq = standardDeviation / n;
        res = Math.sqrt(sq);
        dto.setPromedio(average);
        dto.setDesviacion(res);

        return dto;
    }

    @Override
    public List<ClienteDto> listar() {
        long dd=0;
        var data=repository.findAll().stream()
                .map(this::ToDto)
                .map(clienteDto -> {
                    long minDay = LocalDate.of(2021, 04, 14).toEpochDay();
                    long maxDay = LocalDate.of(2080, 12, 31).toEpochDay();
                    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
                    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
                    System.out.println(randomDate);
                    clienteDto.setFechaMuerte(randomDate);

                    return  clienteDto;
                })
                .collect(Collectors.toList());



        return  data;

    }
    private ClienteDto ToDto(ClientEntity clientEntity){
        final var dto=new ClienteDto();
        dto.setNombre(clientEntity.getNombre());
        dto.setApellido(clientEntity.getApellido());
        dto.setEdad(clientEntity.getEdad());
        dto.setFecha(clientEntity.getFecha());
        dto.setId(clientEntity.getId());
        return  dto;
    }
    private  ClientEntity ToClient(ClienteDto clienteDto){
        final var entity=new ClientEntity();
        entity.setNombre(clienteDto.getNombre());
        entity.setApellido(clienteDto.getApellido());
        entity.setEdad(clienteDto.getEdad());
        entity.setFecha(clienteDto.getFecha());
        entity.setId(0);
        return  entity;

    }
}
