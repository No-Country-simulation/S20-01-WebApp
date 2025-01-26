/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nutriwise02.receta.spring.nutriwise02.receta.service;

import com.nutriwise02.receta.spring.nutriwise02.receta.service.GeminiNutri02Response.Candidate;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Elsa
 */

@Service
public class GeminiNutri02Service {

    @Value("${gemini.api.url}")
    private String urlApi;

    @Value("${gemini.api.key}")
    private String keyApi;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getReceta(String tipocomida, String tipodieta) {

        String prompt = String.format("Genera una receta para %s en una dieta %s.", tipocomida, tipodieta);

        String requestBody = String.format(
                """
            {
              "contents": [
                {
                  "parts": [
                    {
                      "text": "%s"
                    }
                  ]
                }
              ]
            }
            """, prompt.replace("\"", "\\\"")
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<GeminiNutri02Response> response;
        try {
            response = restTemplate.exchange(
                    String.format(urlApi, keyApi),
                    HttpMethod.POST,
                    entity,
                    GeminiNutri02Response.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la API de Gemini: " + e.getMessage());
        }

        //System.out.println("Respuesta de Gemini: " + response.getBody());
        if (response.getBody() == null || response.getBody().getCandidates() == null) {
            throw new RuntimeException("No se recibió contenido válido de Gemini IA");
        }

        List<Candidate> candidates = response.getBody().getCandidates();

        if (candidates.isEmpty()) {
            throw new RuntimeException("La respuesta de Gemini IA está vacía");
        }

        return candidates.get(0).getContent().getParts().get(0).getText();
    }

}
