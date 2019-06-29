package playground.string;

/**
 * Searching
 */
public class Searching {

    /**
     * Busca una porcion de texto dentro de una cadena en forma lineal.
     *
     * @param text Cadena de texto
     * @param pattern Porción de texto a buscar.
     * @return posición la primer coincidencia. Retorna -1 si no encuentra.
     */
    public static int linealSearch(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        for (int pos = 0; pos <= textLen - patternLen; pos++) {
            int cur = 0;
            while(cur < patternLen && text.charAt(pos + cur) == pattern.charAt(cur)) {
                cur += 1;
            }
            if (cur == patternLen) {
                return pos;
            }
        }
        return -1;
    }

}
