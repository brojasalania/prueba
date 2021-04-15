package peru.promart.servicios.client.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peru.promart.servicios.client.dominio.entity.ClientEntity;
@Repository
public interface IClienteRepository extends JpaRepository<ClientEntity,Long> {
}
