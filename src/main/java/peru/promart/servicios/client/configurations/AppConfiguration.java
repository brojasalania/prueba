package peru.promart.servicios.client.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("peru.promart.servicios.client")
@EnableTransactionManagement

public class AppConfiguration {

}
