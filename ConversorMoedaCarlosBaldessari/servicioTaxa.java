package ConversorMoedaCarlosBaldessari;

public class servicioTaxa {

public class ServicioTaxa {

    private ConsultaMoedas consultaMoedas;

    public ServicioTaxa() {
        this.consultaMoedas = new ConsultaMoedas();
    }

    public double obterTaxaCambio(String moedaOrigen, String moedaDestino) throws Exception {
        return consultaMoedas.obterMoeda(moedaOrigen, moedaDestino);
    }

}

}
