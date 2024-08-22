package com.prod.GenZ.confs;//package com.pfa.restapi.confs;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfiguration {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                // todo: cors policy
////                registry
////                        .addMapping("/**")
////                        .allowedOrigins("http://localhost:3000")
////                        .allowedMethods("*")
////                        .allowedHeaders("*");
//////                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
//
////                registry.addMapping("/**")
////                        .allowedOrigins("http://localhost:3000")
////                        .allowedMethods("GET", "POST", "PUT", "DELETE")
////                        .allowCredentials(false)
////                        .allowedHeaders("Content-Type", "Authorization")
////                        .exposedHeaders("Authorization");
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedHeaders("*")
//                        .allowedMethods("*")
//                        .allowCredentials(false);
//            }
//        };
//    }
//}