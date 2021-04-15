package peru.promart.servicios.client.dominio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ClienteDto {

    private long id;

    private String nombre;

    private String apellido;

    private Integer edad;
    @JsonFormat(pattern = "yyyy-MM-dd")

    private LocalDate fecha;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaMuerte;
}
