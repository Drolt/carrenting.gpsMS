package com.carrenting.gpsMS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration // Markiert die Klasse als Konfigurationsquelle
public class WebConfig {
    @Bean
    // Erstellt ein Bean für die Anwendung. Um ein Komponent (z. B. einen Service) zu definieren, der automatisch mit anderen Komponenten verbunden werden kann
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // Erstellt eine CORS-Konfigurationsquelle basierend auf URL
        CorsConfiguration config = new CorsConfiguration();      // Erstellt ein neues CORS-Konfigurationsobjekt
        config.setAllowCredentials(true);                        // Ermöglicht das Senden von Anmeldeinformationen
        config.setAllowedOriginPatterns(Arrays.asList("http://127.0.0.1:5500", "http://localhost:5500")); // Definiert erlaubte Ursprünge (Frontend-URLs)
        config.addAllowedHeader("*");                            // Erlaubt alle Kopfzeilen
        config.addAllowedMethod("*");                            // Erlaubt alle HTTP-Methoden
        source.registerCorsConfiguration("/**", config); // Registriert die CORS-Konfiguration für alle Pfade
        return new CorsFilter(source);                           // Gibt den konfigurierten CORS-Filter zurück
    }
}

