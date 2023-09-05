package br.com.quintinno.sisgersenapi.resource;

import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/v1")
    public PessoaDomain create(@RequestBody PessoaDomain pessoaDomain) {
        return pessoaService.create(pessoaDomain);
    }

    @GetMapping("/v1")
    public List<PessoaDomain> findAll() {
        return pessoaService.findAll();
    }

}
