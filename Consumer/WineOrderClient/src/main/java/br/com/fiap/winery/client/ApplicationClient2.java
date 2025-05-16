package br.com.fiap.winery.client;
import br.com.fiap.winery.client.order.WineStockService;
import br.com.fiap.winery.client.order.WineStockServiceImplementationService;
import br.com.fiap.winery.client.warning.WineWarningService;
import br.com.fiap.winery.client.warning.WineWarningServiceImplementationService;
import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

public class ApplicationClient2 {
    public static void main(String[] args) {
        try {
            System.out.println("Cliente 2: Realizando pedido e verificando avisos...");

            WineStockServiceImplementationService stockServiceGenerated = new WineStockServiceImplementationService();
            WineStockService wineStockServicePort = stockServiceGenerated.getWineStockServiceImplementationPort();
            String order = wineStockServicePort.placeOrder("Almejo Merlot", 3);
            System.out.println("\n--- Resposta do Pedido ---");
            System.out.println(order);

            System.out.println("\n--- Consumindo WineWarningService (abordagem simplificada) ---");
            WineWarningServiceImplementationService warningServiceGenerated = new WineWarningServiceImplementationService();
            WineWarningService wineWarningServicePortGenerated = warningServiceGenerated.getWineWarningServiceImplementationPort();
            String warn = wineWarningServicePortGenerated.sendWarn();
            System.out.println("Aviso: " + warn);

            System.out.println("\n--- Consumindo WineWarningService (abordagem manual) ---");
            URL url2 = new URL("http://localhost:8086/WineWarningService?wsdl");
            QName qName2 = new QName("http://winery.fiap.com.br/", "WineWarningServiceImplementationService");
            Service service2Manual = Service.create(url2, qName2);
            WineWarningService wineWarningServicePortManual = service2Manual.getPort(WineWarningService.class);
            String warnManual = wineWarningServicePortManual.sendWarn();
            System.out.println("Aviso (manual): " + warnManual);

        } catch (Exception e) {
            System.err.println("Erro no ApplicationClient2: " + e.getMessage());
            e.printStackTrace();
        }
    }
}