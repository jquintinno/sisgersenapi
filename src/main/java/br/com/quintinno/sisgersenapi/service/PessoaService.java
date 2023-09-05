package br.com.quintinno.sisgersenapi.service;

import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDomain create(PessoaDomain pessoaDomain) {
        return pessoaRepository.create(pessoaDomain);
    }

    public List<PessoaDomain> findAll() {
        return pessoaRepository.findAll();
    }

    public PessoaDomain findOne(Long codigo) {
        return pessoaRepository.findOne(codigo);
    }

}
