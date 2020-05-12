package validations;

public class ValidationUtils {

    public static String validaExpressao(String expressao) throws Exception {

        if (expressao == null | expressao == "")
            throw new Exception("Valores inválidos!");

        if(expressao.matches("[a-zA-Z]+"))
            throw new Exception("Letras não são permitidas na expressão");

        return expressao;
    }
}
