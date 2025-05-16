package br.com.fiap.client;
import br.com.fiap.winery.client.order.WineStockService;
import br.com.fiap.winery.client.order.WineStockServiceImplementationService;

import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

public class ApplicationClient1 {
    public static void main(String[] args) {
        try {
            System.out.println("Cliente 1: Buscando menu de vinhos...");


            WineStockServiceImplementationService serviceGenerated = new WineStockServiceImplementationService();
            WineStockService wineStockServicePortGenerated = serviceGenerated.getWineStockServiceImplementationPort();

            String menu = wineStockServicePortGenerated.getMenu();
            System.out.println("\n--- Menu  ---");
            System.out.println(menu);


            System.out.println("\n--- Tentando com abordagem manual (URL e QName) ---");
            URL url = new URL("http://localhost:8085/WineStockService?wsdl");
            QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");
            Service serviceManual = Service.create(url, qName);
            WineStockService wineStockServicePortManual = serviceManual.getPort(WineStockService.class);

            String menuManual = wineStockServicePortManual.getMenu();
            System.out.println("\n--- Menu (via abordagem manual) ---");
            System.out.println(menuManual);

        } catch (Exception e) {
            System.err.println("Erro no ApplicationClient1: " + e.getMessage());
            e.printStackTrace();
        }
    }
}