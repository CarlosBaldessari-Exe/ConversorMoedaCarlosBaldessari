package ConversorMoedaCarlosBaldessari;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoedas {
    private static final String CHAVE_API = "e540efba31e197595d9d882d";
    private static final String ENDERECO = "https://v6.exchangerate-api.com/v6/" + CHAVE_API + "/latest/";

    public double obterMoeda(String moedaOrigen, String moedaDestino) throws Exception {
        String url = ENDERECO + moedaOrigen;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Respuesta de la API: " + response.body());

        Gson gson = new Gson();
        RespuestaApi respuesta = gson.fromJson(response.body(), RespuestaApi.class);

        if (respuesta.getConversion_rates() == null || !respuesta.getConversion_rates().containsKey(moedaDestino)) {
            throw new Exception("Datos de conversión no disponibles para la moneda: " + moedaDestino);
        }
        return respuesta.getConversion_rates().get(moedaDestino);
    }
}
