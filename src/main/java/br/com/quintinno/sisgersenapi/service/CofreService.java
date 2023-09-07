package br.com.quintinno.sisgersenapi.service;

import br.com.quintinno.sisgersenapi.domain.CofreDomain;
import br.com.quintinno.sisgersenapi.domain.PessoaDomain;
import br.com.quintinno.sisgersenapi.repository.CofreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CofreService {

    @Autowired
    private CofreRepository cofreRepository;

    public CofreDomain create(CofreDomain cofreDomain) {
        return cofreRepository.create(cofreDomain);
    }

    public List<CofreDomain> findAll() {
        return cofreRepository.findAll();
    }

    public CofreDomain findOne(String chave) {
        return cofreRepository.findOne(chave);
    }

}
