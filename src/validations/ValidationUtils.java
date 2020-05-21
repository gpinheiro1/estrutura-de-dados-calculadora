package validations;

public class ValidationUtils {

    public static String validaExpressao(String expressao) throws Exception {

        if (expressao == null | expressao == "")
            throw new Exception("Valores inválidos!");

        if(expressao.matches("[a-zA-Z]+"))
            throw new Exception("Letras não são permitidas na expressão");

        if(!validaParenteses(expressao))
            throw new Exception("Parênteses inválidos");

        return expressao;
    }

    public static boolean validaParenteses(String expressao) {
        int qtdAbreParenteses = 0;
        int qtdFechaParenteses = 0;

        for(int i = 0; i < expressao.length(); i++) {
            if(expressao.charAt(i) == '(')
                qtdAbreParenteses++;
            else if(expressao.charAt(i) == ')')
                qtdFechaParenteses++;
        }
        return qtdAbreParenteses == qtdFechaParenteses;
    }
}
