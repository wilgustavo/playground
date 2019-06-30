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

    /**
     * Búsqueda por el método Boyer-Moore.
     *
     * @param text Cadena de texto
     * @param pattern Porción de texto a buscar.
     * @return posición la primer coincidencia. Retorna -1 si no encuentra.
     */
    public static int boyerMooreSearch(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        int pos = 0;
        int cur = pos + patternLen - 1;
        boolean igual = false;
        while(cur >= pos) {
            igual = pattern.charAt(cur - pos) == text.charAt(cur);
            if(igual) {
                cur -= 1;
            } else {
                char c = text.charAt(cur);
                while(cur >= pos && pattern.charAt(cur - pos) != c) {
                    cur -= 1;
                }
                if (cur < pos) {
                    pos += patternLen;
                } else {
                    pos += pos + patternLen - cur -1;
                }
                if (pos <= textLen - patternLen) {
                    cur = pos + patternLen - 1;
                }
            }
        }
        if (igual) {
            return pos;
        }
        return -1;
    }

}
