import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = { "controller", "service" })
@EntityScan("model")
@EnableJpaRepositories("repository")
@ImportResource({"applicationContext.xml"})

public class Application {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	
		SpringApplication.run(Application.class, args);

	}

}
