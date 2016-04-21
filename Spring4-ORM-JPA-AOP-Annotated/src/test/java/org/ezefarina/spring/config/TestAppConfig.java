package org.ezefarina.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(AppConfig.class)
@ComponentScan("org.ezefarina.spring.repository")
public class TestAppConfig {
}
