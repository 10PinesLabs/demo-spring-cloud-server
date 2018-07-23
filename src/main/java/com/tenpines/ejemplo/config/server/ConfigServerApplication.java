package com.tenpines.ejemplo.config.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

  private static final Logger logger = LoggerFactory.getLogger(ConfigServerApplication.class);

  public static void main(String[] args){
    logger.info("Inicializando Config Server de ejemplo");

    new ConfigServerApplicationBuilder().run(args);
  }
}
