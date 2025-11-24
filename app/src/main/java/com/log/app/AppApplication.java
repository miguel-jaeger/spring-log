package com.log.app;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppApplication {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		logger.info("La aplicación ha iniciado exitosamente.");
	}

	/**
	 ** Endpoint que demuestra el uso de diferentes niveles de registro.
	 * 
	 */

	@GetMapping("/api/demo-logs")
	public String demoLogs() {
		logger.trace("Este es un mensaje de TRACE.");
		logger.debug("Este es un mensaje de DEBUG.");

		logger.info("Se ha recibido una petición al endpoint /api/demo-logs.");
		logger.warn("Advertencia: Posible cuello de botella en la operación.");
		try {
			int resultado = 10 / 0;
		} catch (Exception e) {
			logger.error("Error: Se ha intentado una división por cero.", e);
		}
		return "Revisa la consola para ver los logs.";
	}
}
