package br.com.fiap.winery;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")
public class WineStockServiceImplementation implements WineStockService {

    @Override
    public String getMenu() {
        StringBuilder menu = new StringBuilder("Menu de Vinhos (por tipo de uva):\n");
        menu.append("Tintos:\n");
        menu.append("  - Wakefield Promisse Land Cabernet Sauvignon (R$ 110,90)\n");
        menu.append("  - Almejo Merlot (R$ 69,90)\n");
        menu.append("  - Soils Maipo Malbec  (R$ 169,00)\n");
        menu.append("Brancos:\n");
        menu.append("  - Frisante Mayos Green(R$ 43,90)\n");
        menu.append("  - Bebber Sauvignon Blanc(R$ 97,90)\n");
        menu.append("  - Busy Bee Chenin(R$ 89,90)\n");
        menu.append("Rosés:\n");
        menu.append("  - Piscine (R$ 70,00)\n");
        menu.append("  - Voga Trevenezie IGT (R$ 169,90)\n");
        menu.append("  - Classic Nederburg (R$ 64,90\n");
        return menu.toString();
    }

    @Override
    public String placeOrder(String name, int quantity) {
        System.out.println("LOG: Pedido recebido - Vinho: " + name + ", Quantidade: " + quantity);
        return "Pedido para " + quantity + " unidade(s) do vinho '" + name + "' confirmado!";
    }
}