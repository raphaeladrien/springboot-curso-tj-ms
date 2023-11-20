package br.jus.tjms.funcionario.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "alvara", url = "http://localhost:8080")
@Retryable(maxAttempts = 3, backoff = @Backoff(
    delay = 1000,
    maxDelay = 30000,
    multiplier = 10)
)
public interface AlvaraGateway {

    @GetMapping("alvara")
    String getAlvara();
}
