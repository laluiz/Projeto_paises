package model;

public class Main {
    public static void main(String[] args) {
        // Criando países
        Pais brasil = new Pais("BRA", "Brasil", 8515767.049);
        brasil.setPopulacao(213000000);

        Pais argentina = new Pais("ARG", "Argentina", 2780400);
        argentina.setPopulacao(45380000);

        Pais uruguai = new Pais("URY", "Uruguai", 176215);
        uruguai.setPopulacao(3473730);

        Pais chile = new Pais("CHL", "Chile", 756102);
        chile.setPopulacao(19116209);

        Pais paraguai = new Pais("PRY", "Paraguai", 406752);
        paraguai.setPopulacao(7132530);

        Pais bolivia = new Pais("BOL", "Bolívia", 1098581);
        bolivia.setPopulacao(12015690);

        Pais peru = new Pais("PER", "Peru", 1285216);
        peru.setPopulacao(33700000);

        Pais venezuela = new Pais("VEN", "Venezuela", 916445);
        venezuela.setPopulacao(28303625);

        Pais colombia = new Pais("COL", "Colômbia", 1141748);
        colombia.setPopulacao(52215500);

        Pais equador = new Pais("ECU", "Equador", 256370);
        equador.setPopulacao(18554800);

        // Definindo fronteiras
        brasil.adicionarFronteira(argentina);
        brasil.adicionarFronteira(uruguai);
        brasil.adicionarFronteira(paraguai);
        brasil.adicionarFronteira(bolivia);
        brasil.adicionarFronteira(peru);
        brasil.adicionarFronteira(colombia);
        brasil.adicionarFronteira(venezuela);

        argentina.adicionarFronteira(uruguai);
        argentina.adicionarFronteira(chile);
        argentina.adicionarFronteira(paraguai);
        argentina.adicionarFronteira(bolivia);

        chile.adicionarFronteira(peru);
        chile.adicionarFronteira(bolivia);

        venezuela.adicionarFronteira(colombia);

        colombia.adicionarFronteira(equador);
        colombia.adicionarFronteira(peru);

        equador.adicionarFronteira(peru);

        // Criando um continente
        Continente americaDoSul = new Continente("América do Sul");
        americaDoSul.adicionarPais(brasil);
        americaDoSul.adicionarPais(argentina);
        americaDoSul.adicionarPais(uruguai);
        americaDoSul.adicionarPais(chile);
        americaDoSul.adicionarPais(paraguai);
        americaDoSul.adicionarPais(bolivia);
        americaDoSul.adicionarPais(peru);
        americaDoSul.adicionarPais(venezuela);
        americaDoSul.adicionarPais(colombia);
        americaDoSul.adicionarPais(equador);

        // Exibindo informações dos países
        System.out.println("Informações dos países:");
        for (Pais pais : americaDoSul.getPaises()) {
            System.out.printf(
                "Código ISO: %s | Nome: %s | População: %d | Dimensão: %.2f km²\n",
                pais.getCodigoISO(),
                pais.getNome(),
                pais.getPopulacao(),
                pais.getDimensao()
            );
        }

        // Testando funcionalidades
        System.out.println("\nDensidade populacional do Brasil: " + brasil.densidadePopulacional());
        System.out.println("Vizinhos comuns entre Brasil e Argentina: ");
        for (Pais vizinho : brasil.vizinhosComuns(argentina)) {
            System.out.println(vizinho.getNome());
        }

        System.out.println("\nDimensão total do continente: " + americaDoSul.dimensaoTotal());
        System.out.println("População total do continente: " + americaDoSul.populacaoTotal());
        System.out.println("País com maior população: " + americaDoSul.maiorPopulacao().getNome());
        System.out.println("País com menor população: " + americaDoSul.menorPopulacao().getNome());
        System.out.println("País de maior dimensão territorial: " + americaDoSul.maiorDimensao().getNome());
        System.out.println("País de menor dimensão territorial: " + americaDoSul.menorDimensao().getNome());
        System.out.println("Razão territorial (maior/menor): " + americaDoSul.razaoTerritorial());
    }
}
