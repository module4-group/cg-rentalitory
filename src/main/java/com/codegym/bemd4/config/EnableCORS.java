package com.codegym.bemd4.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({com.codegym.bemd4.config.CorsAutoConfiguration.class})
public @interface EnableCORS {
}