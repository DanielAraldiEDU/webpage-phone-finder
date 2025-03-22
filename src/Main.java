
import api.CapturaRecursosWeb;
import java.util.ArrayList;

public class Main {
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
		crw.getListaRecursos().add("https://selbetti.com.br/contato/");
		crw.getListaRecursos().add("https://www.escalize.com.br/");
		crw.getListaRecursos().add("https://www.bc.sc.gov.br/contato.cfm");
		ArrayList<String> listaCodigos = crw.carregarRecursos();

		char[] alphabet = {
				'0', '1', '2', '3',
				'4', '5', '6', '7',
				'8', '9', ' ', '-',
				'(', ')',
		};
		String estado_inicial = "q0";
		String[] codigosHTML = {
				listaCodigos.get(0),
				listaCodigos.get(1),
				listaCodigos.get(2),
		};
		String[] states = {
				"q0", "q1", "q2", "q3", "q4",
				"q5", "q6", "q7", "q8", "q9",
				"q10", "q11", "q12", "q13", "q14",
				"q15", "q16", "q17", "q18", "q19",
				"q20", "q21", "q22", "q23", "q24",
				"q25", "q26", "q27", "q28", "q29",
				"q30", "q31", "q32", "q33", "q34",
				"q35"
		};
		String[] estados_finais = {
				"q35"
		};

		int[][] matriz = new int[36][14];

		// q0
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '(')] = get_string_ref(states, "q6");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q5");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q1");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q2");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q5");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q3");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q5");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q4");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q5");
		matriz[get_string_ref(states, "q0")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q5");

		// q1
		matriz[get_string_ref(states, "q1")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q12");
		matriz[get_string_ref(states, "q1")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q12");
		matriz[get_string_ref(states, "q1")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q12");
		matriz[get_string_ref(states, "q1")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q12");
		matriz[get_string_ref(states, "q1")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q12");

		// q2
		matriz[get_string_ref(states, "q2")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q13");
		matriz[get_string_ref(states, "q2")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q13");
		matriz[get_string_ref(states, "q2")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q13");
		matriz[get_string_ref(states, "q2")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q13");
		matriz[get_string_ref(states, "q2")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q13");
		matriz[get_string_ref(states, "q2")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q13");
		matriz[get_string_ref(states, "q2")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q13");

		// q3
		matriz[get_string_ref(states, "q3")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q14");
		matriz[get_string_ref(states, "q3")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q14");
		matriz[get_string_ref(states, "q3")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q14");
		matriz[get_string_ref(states, "q3")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q14");

		// q4
		matriz[get_string_ref(states, "q4")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q15");
		matriz[get_string_ref(states, "q4")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q15");
		matriz[get_string_ref(states, "q4")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q15");
		matriz[get_string_ref(states, "q4")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q15");
		matriz[get_string_ref(states, "q4")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q15");
		matriz[get_string_ref(states, "q4")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q15");

		// q5
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q16");
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q16");
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q16");
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q16");
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q16");
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q16");
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q16");
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q16");
		matriz[get_string_ref(states, "q5")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q16");

		// q6
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q11");
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q7");
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q8");
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q11");
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q9");
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q11");
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q10");
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q11");
		matriz[get_string_ref(states, "q6")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q11");

		// q7
		matriz[get_string_ref(states, "q7")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q17");
		matriz[get_string_ref(states, "q7")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q17");
		matriz[get_string_ref(states, "q7")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q17");
		matriz[get_string_ref(states, "q7")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q17");
		matriz[get_string_ref(states, "q7")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q17");

		// q8
		matriz[get_string_ref(states, "q8")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q18");
		matriz[get_string_ref(states, "q8")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q18");
		matriz[get_string_ref(states, "q8")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q18");
		matriz[get_string_ref(states, "q8")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q18");
		matriz[get_string_ref(states, "q8")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q18");
		matriz[get_string_ref(states, "q8")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q18");
		matriz[get_string_ref(states, "q8")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q18");

		// q9
		matriz[get_string_ref(states, "q9")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q19");
		matriz[get_string_ref(states, "q9")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q19");
		matriz[get_string_ref(states, "q9")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q19");
		matriz[get_string_ref(states, "q9")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q19");

		// q10
		matriz[get_string_ref(states, "q10")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q20");
		matriz[get_string_ref(states, "q10")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q20");
		matriz[get_string_ref(states, "q10")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q20");
		matriz[get_string_ref(states, "q10")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q20");
		matriz[get_string_ref(states, "q10")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q20");
		matriz[get_string_ref(states, "q10")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q20");

		// q11
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q21");
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q21");
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q21");
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q21");
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q21");
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q21");
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q21");
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q21");
		matriz[get_string_ref(states, "q11")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q21");

		// q12
		matriz[get_string_ref(states, "q12")][get_char_ref(alphabet, ' ')] = get_string_ref(states, "q23");
		matriz[get_string_ref(states, "q12")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q24");

		// q13
		matriz[get_string_ref(states, "q13")][get_char_ref(alphabet, ' ')] = get_string_ref(states, "q23");
		matriz[get_string_ref(states, "q13")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q24");

		// q14
		matriz[get_string_ref(states, "q14")][get_char_ref(alphabet, ' ')] = get_string_ref(states, "q23");
		matriz[get_string_ref(states, "q14")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q24");

		// q15
		matriz[get_string_ref(states, "q15")][get_char_ref(alphabet, ' ')] = get_string_ref(states, "q23");
		matriz[get_string_ref(states, "q15")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q24");

		// q16
		matriz[get_string_ref(states, "q16")][get_char_ref(alphabet, ' ')] = get_string_ref(states, "q23");
		matriz[get_string_ref(states, "q16")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q24");

		// q17
		matriz[get_string_ref(states, "q17")][get_char_ref(alphabet, ')')] = get_string_ref(states, "q22");

		// q18
		matriz[get_string_ref(states, "q18")][get_char_ref(alphabet, ')')] = get_string_ref(states, "q22");

		// q19
		matriz[get_string_ref(states, "q19")][get_char_ref(alphabet, ')')] = get_string_ref(states, "q22");

		// q20
		matriz[get_string_ref(states, "q20")][get_char_ref(alphabet, ')')] = get_string_ref(states, "q22");

		// q21
		matriz[get_string_ref(states, "q21")][get_char_ref(alphabet, ')')] = get_string_ref(states, "q22");

		// q22
		matriz[get_string_ref(states, "q22")][get_char_ref(alphabet, ' ')] = get_string_ref(states, "q23");
		matriz[get_string_ref(states, "q22")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q24");

		// q23
		matriz[get_string_ref(states, "q23")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q24");

		// q24
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, ' ')] = get_string_ref(states, "q25");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q24")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q26");

		// q25
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q26");
		matriz[get_string_ref(states, "q25")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q26");

		// q26
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q27");
		matriz[get_string_ref(states, "q26")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q27");

		// q27
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q28");
		matriz[get_string_ref(states, "q27")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q28");

		// q28
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q29");
		matriz[get_string_ref(states, "q28")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q29");

		// q29
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, ' ')] = get_string_ref(states, "q30");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '-')] = get_string_ref(states, "q31");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q29")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q32");

		// q30
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q30")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q32");

		// q31
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q32");
		matriz[get_string_ref(states, "q31")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q32");

		// q32
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q33");
		matriz[get_string_ref(states, "q32")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q33");

		// q33
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q34");
		matriz[get_string_ref(states, "q33")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q34");

		// q34
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '0')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '1')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '2')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '3')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '4')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '5')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '6')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '7')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '8')] = get_string_ref(states, "q35");
		matriz[get_string_ref(states, "q34")][get_char_ref(alphabet, '9')] = get_string_ref(states, "q35");

		// q35
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, ' ')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '-')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '(')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, ')')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '0')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '1')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '2')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '3')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '4')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '5')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '6')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '7')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '8')] = -1;
		matriz[get_string_ref(states, "q35")][get_char_ref(alphabet, '9')] = -1;

		int estado = get_string_ref(states, estado_inicial);
		int estado_anterior = -1;
		String palavra = "";
		ArrayList<String> palavras_reconhecidas = new ArrayList<String>();

		for (String html : codigosHTML) {
			palavras_reconhecidas.clear();
			palavra = "";
			// varre o código-fonte de um código
			for (int i = 0; i < html.length(); i++) {
				estado_anterior = estado;
				estado = proximo_estado(alphabet, matriz, estado, html.charAt(i));
				// se o não há transição
				if (estado == -1) {
					// pega estado inicial
					estado = get_string_ref(states, estado_inicial);
					// se o estado anterior foi um estado final
					if (get_string_ref(estados_finais, states[estado_anterior]) != -1) {
						// se a palavra não é vazia adiciona palavra reconhecida
						if (!palavra.equals("")) {
							palavras_reconhecidas.add(palavra.trim());
						}
						// se ao analisar este caracter não houve transição
						// teste-o novamente, considerando que o estado seja inicial
						i--;
					}
					// zera palavra
					palavra = "";
				} else {
					// se houver transição válida, adiciona caracter a palavra
					palavra += html.charAt(i);
				}
			}

			// foreach no Java para exibir todas as palavras reconhecidas
			for (String p : palavras_reconhecidas) {
				System.out.println(p);
			}
		}
	}
}
