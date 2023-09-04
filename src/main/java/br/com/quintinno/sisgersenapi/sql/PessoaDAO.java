package br.com.quintinno.sisgersenapi.sql;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class PessoaDAO {

    private final Map<String, String> queries;

    public PessoaDAO() throws Exception {
        this.queries = new HashMap<>();
        getQuery();
    }

    private void getQuery() throws Exception {
        try {
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
            Resource resource = pathMatchingResourcePatternResolver.getResource("classpath:pessoa_query.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(resource.getInputStream());

            NodeList queryNodes = document.getElementsByTagName("query");

            for (int i = 0; i < queryNodes.getLength(); i++) {
                Node queryNode = queryNodes.item(i);
                if (queryNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element queryElement = (Element) queryNode;
                    queries.put(queryElement.getAttribute("nome"), queryElement.getTextContent().trim());
                }
            }
        } catch (IOException e) {
            throw new Exception("Erro ao carregar o arquivo XML!", e);
        }
    }

    public String recuperarQuery(String name) {
        return queries.get(name);
    }

}
