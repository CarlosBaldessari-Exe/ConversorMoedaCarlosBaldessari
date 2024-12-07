import ConversorMoedaCarlosBaldessari.*;
import javax.swing.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //        System.out.printf("Bienvenidos a nosso conversor de moedas");
//        System.out.println("Ingrese a moeda a converter");
//        var MoedaConverter= sc.nextLine();
        try (Scanner sc = new Scanner(System.in)) {
            servicioTaxa servico = new servicioTaxa();
            Moeda[] moedas = {
                    new Moeda("USD", "Dolar Americano"),
                    new Moeda("EUR", "Europe"),
                    new Moeda("GBP", "Libra Esterlina"),
                    new Moeda("JPY", "Japan"),
                    new Moeda("BRL", "Brazil"),
                    new Moeda("UYU", "Uruguay")

            };
            System.out.print("Escolha moneda de origen");
            for (int i = 0; i < moedas.length; i++) {
                System.out.printf((i + 1) + "." + moedas[i].moeda());
            }
            System.out.printf("Digite o numero da moeda de origen");
            int origen = sc.nextInt() - 1;

            System.out.printf("Escolha moneda de destino");
            for (int i = 0; i < moedas.length; i++) {
                System.out.printf((i + 1) + "." + moedas[i].moeda());
            }
            System.out.printf("Digite o numero da moeda de destino");
            int destino = sc.nextInt() - 1;

            if (origen < 0 || origen >= moedas.length || destino < 0 || destino >= moedas.length) {
                throw new Exception("Indice invalido");
            }
            System.out.print("Digite o valor a ser converitdo");
            double valor = sc.nextDouble();

            String moedaOrigen = moedas[origen].moeda();
            String moedaDestino = moedas[destino].moeda();
            double taxaCambiario = new servico.obterTaxaCambio(moedaOrigen, moedaDestino);

            double valorMoedaConvertido = valor * taxaCambiario;

            System.out.printf("El valor convertido de las modedas es " + valor, moedas[origen], moedas[destino], valorMoedaConvertido);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
