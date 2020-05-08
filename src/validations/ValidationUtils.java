package validations;

public class ValidationUtils {

    public static String validaExpressao(String expressao) throws Exception {

        if (expressao == null | expressao == "")
            throw new Exception("Valores inválidos!");
        return expressao;

        //fazer outras validações como operadores um ao lado do outro, ex: 10+*2 -> expressao invalida
    }
}
