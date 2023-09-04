package br.com.quintinno.sisgersenapi.sql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class PessoaDAO {

    public static final String QUERY_0001 = "-- QUERY_0001";
    public static final String QUERY_0002 = "-- QUERY_0002";

    private final String query;

    public PessoaDAO(@Value("classpath:pessoa_query.sql") Resource resource) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            this.query = reader.lines().collect(Collectors.joining("\n"));
        }
    }

    public String getQuery() {
        return query;
    }

}
