package ConversorMoedaCarlosBaldessari;

import java.util.Map;

public class RespuestaApi {
    private String resultado;
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
    public String getResultado() {
    return resultado;}
}
