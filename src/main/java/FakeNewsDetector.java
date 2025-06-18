
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import utils.PalavrasChave;
import analisadores.*;

public class FakeNewsDetector {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        AnalisarDominio analiseDominio = new AnalisarDominio();

        System.out.println("=== Detector de Fake News ===");

        System.out.println("Digite a URL do seu site para analisarmos: ");
        /*String url = input.nextLine();

        try {
            Document documento = Jsoup.connect(url).get();
            System.out.println(analisarDominio(documento.location()));
            System.out.println(analisarTitulo(documento.title()));
            System.out.println(analisarConteudo(documento.text()));

            long inicio = System.currentTimeMillis();
            long fim = System.currentTimeMillis();
            long tempoCarregamento = (fim - inicio) / 1000;

            System.out.println(analisarTecnica(documento, tempoCarregamento));

            int pontosFinais = analisarDominio(documento.location()) + analisarTecnica(documento, tempoCarregamento) + analisarTitulo(documento.title());
            System.out.println(pontosFinais);
            if (pontosFinais > 60) {
                System.out.println("Site Confiavel");
                
            }

        } catch (Exception e) {
            System.out.println("Erro ao acessar o conteúdo da URL: " + e.getMessage());
        }

        input.close();

    }

    public static int analisarDominio(String url) {

        int pontos = 0;

        for (String confiavel : PalavrasChave.DOMINIOS_CONFIAVEIS) {
            if (url.contains(confiavel)) {
                System.out.println("Domínio Confiavel +30 pontos");
                pontos += 30;

            }
        }

        for (String suspeito : PalavrasChave.DOMINIOS_SUSPEITOS) {
            if (url.contains(suspeito)) {
                pontos -= 30;

            }
        }

        if (url.startsWith("https://")) {
            pontos += 10;
            System.out.println("Https presente + 10 pontos");

        } else {
            pontos -= 5;
            System.out.println("Sem HTTPS: -5 pontos");
        }

        String dominio = "";
        try {
            // Remove http:// ou https://
            String urlLimpa = url.replace("https://", "").replace("http://", "");
            // Pega só a parte antes da primeira /
            dominio = urlLimpa.split("/")[0];
            System.out.println(dominio);

            // Verificar tamanho do domínio
            if (dominio.length() > 30) {
                pontos -= 10;
                System.out.println("Domínio muito longo (" + dominio.length() + " chars): -10 pontos");
            } else {
                System.out.println("Tamanho do domínio OK (" + dominio.length() + " chars) +0 pontos");

            }

        } catch (Exception e) {
            System.out.println("Erro ao analisar domínio");
        }

        return pontos;
    }

    public static int analisarTitulo(String titulo) {

        int pontosTitulo = 0;
        int totalLetras = 0;
        int letrasMaiusculas = 0;

        for (char c : titulo.toCharArray()) {
            if (Character.isLetter(c)) {
                totalLetras++;

                if (Character.isUpperCase(c)) {
                    letrasMaiusculas++;

                }
            }

        }

        double percentual = (double) letrasMaiusculas / totalLetras * 100;

        if (titulo.length() > 200) {
            System.out.println("Título muito longo (" + titulo.length() + " caracteres): -5 pontos");
            pontosTitulo -= 5;

        }

        if (percentual > 30) {
            System.out.println("Mais de 30% em maiúsculas: -" + 10 + " pontos");
            pontosTitulo -= 10;
        }

        for (String sensac : PalavrasChave.SENSACIONALISTAS) {
            if (titulo.contains(sensac)) {
                System.out.println("Título Sensacionalista");
                pontosTitulo -= 30;

            }
        }

        if (pontosTitulo == 0) {
            System.out.println("Título sem exageros: +15 pontos");
            pontosTitulo += 15;
        }

        return pontosTitulo;
    }

    public static int analisarConteudo(String texto) {

        int pontosConteudo = 0;
        if (texto.length() < 200) {
            System.out.println("Texto muito curto: -15 pontos");
            pontosConteudo -= 15;

        }

        for (String palavra : PalavrasChave.SUSPEITAS) {
            if (texto.toLowerCase().contains(palavra)) {
                System.out.println("Palavra suspeita '" + palavra + "': -5 pontos");
                pontosConteudo -= 5;

            }
        }

        if (pontosConteudo == 0) {
            System.out.println("Sem palavras suspeitas: +0 pontos");

        }

        return pontosConteudo;

    }

    public static int analisarTecnica(Document doc, long tempoCarregamentoSegundos) {
        int pontosTecnica = 0;

        if (tempoCarregamentoSegundos < 3) {
            System.out.println("Site carrega rapido = +10 pontos");
            pontosTecnica += 10;

        }

        boolean temDescription = !doc.select("meta[name=description]").isEmpty();
        boolean temKeywords = !doc.select("meta[name=keywords]").isEmpty();

        if (temDescription && temKeywords) {
            System.out.println("Metadados presentes: +5 pontos");
            pontosTecnica += 5;
        }

        int adsCount = doc.select("[class*=ad], [id*=ad]").size();
        if (adsCount > 200) {
            System.out.println("Excesso de anúncios: -10 pontos");
            pontosTecnica -= 10;
        }

        return pontosTecnica;*/

        System.out.println(analiseDominio.getInfoWhois("google.com"));
        input.close();
    }

}
