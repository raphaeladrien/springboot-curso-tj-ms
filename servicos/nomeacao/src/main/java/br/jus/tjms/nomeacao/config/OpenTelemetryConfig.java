package br.jus.tjms.nomeacao.config;


import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTelemetryConfig {



    @Bean
    public BatchSpanProcessor batchSpanProcessor(SpanExporter spanExporter) {
        return BatchSpanProcessor.builder(spanExporter).build();
    }
}
