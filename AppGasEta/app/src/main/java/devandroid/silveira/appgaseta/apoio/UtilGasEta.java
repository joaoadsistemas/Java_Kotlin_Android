package devandroid.silveira.appgaseta.apoio;

public class UtilGasEta {

    public static String mensagemQualquer(String mensagem) {
        return "Olá " + mensagem;
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.70;
        String mensagem;

        if (etanol <= precoIdeal) {
            mensagem = "Abastecer com Etanol";
        } else {
            mensagem = "Abastecer com Gasolina";
        }

        return mensagem;

    };


}
