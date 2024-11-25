package model;



import java.util.ArrayList;
import java.util.List;



public class Continente {
    private String nome;
    private List<Pais> paises;
    public List<Pais> getPaises() {
        return paises;
    }

    // Construtor
    public Continente(String nome) {
        this.setNome(nome);
        this.paises = new ArrayList<>();
    }

    // Método para adicionar países
    public void adicionarPais(Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }

    // Dimensão total
    public double dimensaoTotal() {
        double total = 0;
        for (Pais pais : paises) {
            total += pais.getDimensao();
        }
        return total;
    }

    // População total
    public long populacaoTotal() {
        long total = 0;
        for (Pais pais : paises) {
            total += pais.getPopulacao();
        }
        return total;
    }

    // Densidade populacional
    public double densidadePopulacional() {
        return populacaoTotal() / dimensaoTotal();
    }

    // País com maior população
    public Pais maiorPopulacao() {
        Pais maior = null;
        for (Pais pais : paises) {
            if (maior == null || pais.getPopulacao() > maior.getPopulacao()) {
                maior = pais;
            }
        }
        return maior;
    }

    // País com menor população
    public Pais menorPopulacao() {
        Pais menor = null;
        for (Pais pais : paises) {
            if (menor == null || pais.getPopulacao() < menor.getPopulacao()) {
                menor = pais;
            }
        }
        return menor;
    }

    // País com maior dimensão
    public Pais maiorDimensao() {
        Pais maior = null;
        for (Pais pais : paises) {
            if (maior == null || pais.getDimensao() > maior.getDimensao()) {
                maior = pais;
            }
        }
        return maior;
    }

    // País com menor dimensão
    public Pais menorDimensao() {
        Pais menor = null;
        for (Pais pais : paises) {
            if (menor == null || pais.getDimensao() < menor.getDimensao()) {
                menor = pais;
            }
        }
        return menor;
    }

    // Razão territorial
    public double razaoTerritorial() {
        Pais maior = maiorDimensao();
        Pais menor = menorDimensao();
        if (maior != null && menor != null && menor.getDimensao() > 0) {
            return maior.getDimensao() / menor.getDimensao();
        }
        return 0;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
