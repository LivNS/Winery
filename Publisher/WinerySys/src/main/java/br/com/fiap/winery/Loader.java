package br.com.fiap.winery;

import jakarta.xml.ws.Endpoint;

public class Loader {
    public static void main(String[] args) {
        WineStockServiceImplementation wineStock = new WineStockServiceImplementation();
        String addressStock = "http://localhost:8085/WineStockService";
        Endpoint.publish(addressStock, wineStock);
        System.out.println("Servico WineStockService publicado em: " + addressStock + "?wsdl");

        WineWarningServiceImplementation wineWarning = new WineWarningServiceImplementation();
        String addressWarning = "http://localhost:8086/WineWarningService"; // Nova porta
        Endpoint.publish(addressWarning, wineWarning);
        System.out.println("Servico WineWarningService publicado em: " + addressWarning + "?wsdl");
        System.out.println("\nAcesse os WSDLs no navegador para verificar.");
    }
}