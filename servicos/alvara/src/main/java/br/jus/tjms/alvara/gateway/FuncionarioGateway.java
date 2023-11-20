package br.jus.tjms.alvara.gateway;

import br.jus.tjms.alvara.gateway.dto.FuncionarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FuncionarioGateway {

    private static final String PATH = "http://localhost:8081/funcionario";

    private final RestTemplate restTemplate;

    public FuncionarioGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FuncionarioDTO obterFuncionario(Integer id) {
        String url = PATH + "/" + id;
        FuncionarioDTO funcionarioDTO = restTemplate
            .getForEntity(url, FuncionarioDTO.class).getBody();
        return funcionarioDTO;
    }

    public FuncionarioDTO enviarFuncionario(FuncionarioDTO funcionarioDTO) {
        return restTemplate.postForEntity(PATH, funcionarioDTO, FuncionarioDTO.class).getBody();
    }

}
