package br.com.quintinno.sisgersenapi.service;

import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDomain create(PessoaDomain pessoaDomain) {
        return pessoaRepository.create(pessoaDomain);
    }

}
