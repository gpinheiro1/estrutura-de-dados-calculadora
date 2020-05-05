package validations;

public class ValidationUtils {

    public static String validaExpressao(String expressao) throws Exception {

        if (expressao == null)
            throw new Exception("O campo não aceita nulo!");
        return expressao;

        //fazer outras validações como operadores um ao lado do outro, ex: 10+*2 -> expressao invalida
    }
}
