package com.tenpines.ejemplo.config.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.StringUtils;

public class ConfigServerApplicationBuilder {

  private static final Logger logger = LoggerFactory.getLogger(ConfigServerApplicationBuilder.class);
  private SpringApplicationBuilder springApplication;

  public ConfigServerApplicationBuilder() {
    this(new SpringApplicationBuilder());
  }

  public ConfigServerApplicationBuilder(SpringApplicationBuilder springApplication) {
    this.springApplication = configure(springApplication);
  }

  public ConfigServerApplicationBuilder additionalSources(Object... sources) {
    springApplication.sources(sources);
    return this;
  }

  public SpringApplication build() {
    return springApplication.build();
  }

  public void run(String[] args) {
    build().run(args);
  }

  public static SpringApplicationBuilder configure(SpringApplicationBuilder springApplication) {
    springApplication
        .sources(ConfigServerApplication.class)
        .properties("spring.config.name=config-server");

    String profile = System.getenv("PROFILE");
    logger.info("Variable de entorno PROFILE=" + profile);

    if (!StringUtils.isEmpty(profile)) {
      springApplication.profiles("config-server", profile);
    }

    return springApplication;
  }
}
