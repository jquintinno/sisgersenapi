package br.com.quintinno.sisgersenapi.resource;

import br.com.quintinno.sisgersenapi.domain.CofreDomain;
import br.com.quintinno.sisgersenapi.service.CofreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cofre")
public class CofreResource {

    @Autowired
    private CofreService cofreService;

    @PostMapping("/v1")
    public CofreDomain create(@RequestBody CofreDomain cofreDomain) {
        return cofreService.create(cofreDomain);
    }

    @GetMapping("/v1")
    public List<CofreDomain> findAll() {
        return cofreService.findAll();
    }

    @GetMapping("/v1/{codigo}")
    public CofreDomain findOne(@PathVariable("codigo") Long codigo) {
        return this.cofreService.findOne(codigo);
    }

    @GetMapping("/v1/filtro/{chave}")
    public CofreDomain findOne(@PathVariable("chave") String chave) {
        return this.cofreService.findOne(chave);
    }

}
