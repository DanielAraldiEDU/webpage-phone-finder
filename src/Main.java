
import api.CapturaRecursosWeb;
import java.util.ArrayList;

public class Main {
    private static char[] generate_alphabet() {
        char[] alphabet = new char[10];
        for (int i = 0; i < 10; i++) {
            String index = Integer.toString(i);
            alphabet[i] = index.charAt(0);
        }
        return alphabet;
    }

    private static String[] generate_states() {
        String[] states = new String[3];
        for (int i = 0; i < 3; i++) {
            states[i] = "q" + i;
        }
        return states;
    }

    public static int get_char_ref(char[] vet, char ref) {
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == ref) {
                return i;
            }
        }
        return -1;
    }

    public static int get_string_ref(String[] vet, String ref) {
        for (int i = 0; i < vet.length; i++) {
            if (vet[i].equals(ref)) {
                return i;
            }
        }
        return -1;
    }

    public static int proximo_estado(char[] alfabeto, int[][] matriz, int estado_atual, char simbolo) {
        int simbol_indice = get_char_ref(alfabeto, simbolo);
        if (simbol_indice != -1) {
            return matriz[estado_atual][simbol_indice];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        CapturaRecursosWeb crw = new CapturaRecursosWeb();
        crw.getListaRecursos().add("https://www.univali.br/");
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        String codigoHTML = listaCodigos.get(0);

        char[] alphabet = generate_alphabet();

        String[] states = generate_states();

        String estado_inicial = "q0";

        String[] estados_finais = new String[1];
        estados_finais[0] = "q2";

        int[][] matriz = new int[3][10];

        for (int i = 0; i < 10; i++) {
            String index = Integer.toString(i);
            char ref = index.charAt(0);
            matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, ref)] = get_string_ref(states, "q1");
        }

        for (int i = 0; i < 10; i++) {
            String index = Integer.toString(i);
            char ref = index.charAt(0);
            matriz[get_string_ref(states, "q1")][get_char_ref(alphabet, ref)] = get_string_ref(states, "q2");
        }

        for (int i = 0; i < 10; i++) {
            String index = Integer.toString(i);
            char ref = index.charAt(0);
            matriz[get_string_ref(states, "q2")][get_char_ref(alphabet, ref)] = -1;
        }

        int estado = get_string_ref(states, estado_inicial);
        int estado_anterior = -1;
        ArrayList<String> palavras_reconhecidas = new ArrayList<String>();

        String palavra = "";

        // varre o código-fonte de um código
        for (int i = 0; i < codigoHTML.length(); i++) {
            estado_anterior = estado;
            estado = proximo_estado(alphabet, matriz, estado, codigoHTML.charAt(i));
            // se o não há transição
            if (estado == -1) {
                // pega estado inicial
                estado = get_string_ref(states, estado_inicial);
                // se o estado anterior foi um estado final
                if (get_string_ref(estados_finais, states[estado_anterior]) != -1) {
                    // se a palavra não é vazia adiciona palavra reconhecida
                    if (!palavra.equals("")) {
                        palavras_reconhecidas.add(palavra);
                    }
                    // se ao analisar este caracter não houve transição
                    // teste-o novamente, considerando que o estado seja inicial
                    i--;
                }
                // zera palavra
                palavra = "";
            } else {
                // se houver transição válida, adiciona caracter a palavra
                palavra += codigoHTML.charAt(i);
            }
        }

        // foreach no Java para exibir todas as palavras reconhecidas
        for (String p : palavras_reconhecidas) {
            System.out.println(p);
        }
    }
}
