// $ANTLR 3.5.1 /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g 2015-09-22 10:01:01

	package ifpi.ads.tcc.padroes;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ClasseMetodoParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADJETIVO", "ADVERBIO", "ARTIGO", 
		"CONJUNCAO_COORDENADA", "CONJUNCAO_SUBORDINADA", "INT", "INTERJEICAO", 
		"LETRASACENTUADAS", "NUMERAL", "PALAVRA", "PONTO", "PREPOSICAO", "PRONOME", 
		"SIMBOLOS", "SUBSTANTIVO", "VERBO", "VERBO_INFINITIVO", "VIRGULA", "WS"
	};
	public static final int EOF=-1;
	public static final int ADJETIVO=4;
	public static final int ADVERBIO=5;
	public static final int ARTIGO=6;
	public static final int CONJUNCAO_COORDENADA=7;
	public static final int CONJUNCAO_SUBORDINADA=8;
	public static final int INT=9;
	public static final int INTERJEICAO=10;
	public static final int LETRASACENTUADAS=11;
	public static final int NUMERAL=12;
	public static final int PALAVRA=13;
	public static final int PONTO=14;
	public static final int PREPOSICAO=15;
	public static final int PRONOME=16;
	public static final int SIMBOLOS=17;
	public static final int SUBSTANTIVO=18;
	public static final int VERBO=19;
	public static final int VERBO_INFINITIVO=20;
	public static final int VIRGULA=21;
	public static final int WS=22;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ClasseMetodoParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ClasseMetodoParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ClasseMetodoParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g"; }

		
		private DiagramaDeClasse diagramaDeClasse;
		
		public ClasseMetodoParser(TokenStream input, DiagramaDeClasse diagramaDeClasse) {
			this(input, new RecognizerSharedState());
			this.diagramaDeClasse = diagramaDeClasse;
		}



	// $ANTLR start "estoria"
	// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:62:1: estoria returns [DiagramaDeClasse diagramaDeClasse] : ( classeMetodo )+ ;
	public final DiagramaDeClasse estoria() throws RecognitionException {
		DiagramaDeClasse diagramaDeClasse = null;


		try {
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:62:52: ( ( classeMetodo )+ )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:63:3: ( classeMetodo )+
			{
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:63:3: ( classeMetodo )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ADJETIVO && LA1_0 <= CONJUNCAO_SUBORDINADA)||LA1_0==INTERJEICAO||LA1_0==NUMERAL||(LA1_0 >= PONTO && LA1_0 <= PRONOME)||(LA1_0 >= SUBSTANTIVO && LA1_0 <= VIRGULA)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:63:4: classeMetodo
					{
					pushFollow(FOLLOW_classeMetodo_in_estoria374);
					classeMetodo();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			diagramaDeClasse = this.diagramaDeClasse;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return diagramaDeClasse;
	}
	// $ANTLR end "estoria"



	// $ANTLR start "classeMetodo"
	// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:67:1: classeMetodo : (s= SUBSTANTIVO PREPOSICAO s1= SUBSTANTIVO | ( ARTIGO | NUMERAL ) SUBSTANTIVO ( VERBO )? ADJETIVO |v= VERBO_INFINITIVO ( ARTIGO | NUMERAL )? s= SUBSTANTIVO |v= VERBO_INFINITIVO ( VIRGULA | CONJUNCAO_COORDENADA ) | ( ADJETIVO | ADVERBIO | ARTIGO | SUBSTANTIVO | VERBO | VERBO_INFINITIVO | PRONOME | CONJUNCAO_COORDENADA | CONJUNCAO_SUBORDINADA | INTERJEICAO | PREPOSICAO | NUMERAL | PONTO | VIRGULA ) );
	public final void classeMetodo() throws RecognitionException {
		Token s=null;
		Token s1=null;
		Token v=null;
		Token SUBSTANTIVO1=null;

		try {
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:67:14: (s= SUBSTANTIVO PREPOSICAO s1= SUBSTANTIVO | ( ARTIGO | NUMERAL ) SUBSTANTIVO ( VERBO )? ADJETIVO |v= VERBO_INFINITIVO ( ARTIGO | NUMERAL )? s= SUBSTANTIVO |v= VERBO_INFINITIVO ( VIRGULA | CONJUNCAO_COORDENADA ) | ( ADJETIVO | ADVERBIO | ARTIGO | SUBSTANTIVO | VERBO | VERBO_INFINITIVO | PRONOME | CONJUNCAO_COORDENADA | CONJUNCAO_SUBORDINADA | INTERJEICAO | PREPOSICAO | NUMERAL | PONTO | VIRGULA ) )
			int alt4=5;
			switch ( input.LA(1) ) {
			case SUBSTANTIVO:
				{
				int LA4_1 = input.LA(2);
				if ( (LA4_1==PREPOSICAO) ) {
					int LA4_5 = input.LA(3);
					if ( (LA4_5==SUBSTANTIVO) ) {
						alt4=1;
					}
					else if ( (LA4_5==EOF||(LA4_5 >= ADJETIVO && LA4_5 <= CONJUNCAO_SUBORDINADA)||LA4_5==INTERJEICAO||LA4_5==NUMERAL||(LA4_5 >= PONTO && LA4_5 <= PRONOME)||(LA4_5 >= VERBO && LA4_5 <= VIRGULA)) ) {
						alt4=5;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA4_1==EOF||(LA4_1 >= ADJETIVO && LA4_1 <= CONJUNCAO_SUBORDINADA)||LA4_1==INTERJEICAO||LA4_1==NUMERAL||LA4_1==PONTO||LA4_1==PRONOME||(LA4_1 >= SUBSTANTIVO && LA4_1 <= VIRGULA)) ) {
					alt4=5;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ARTIGO:
			case NUMERAL:
				{
				int LA4_2 = input.LA(2);
				if ( (LA4_2==SUBSTANTIVO) ) {
					switch ( input.LA(3) ) {
					case EOF:
					case ADVERBIO:
					case ARTIGO:
					case CONJUNCAO_COORDENADA:
					case CONJUNCAO_SUBORDINADA:
					case INTERJEICAO:
					case NUMERAL:
					case PONTO:
					case PREPOSICAO:
					case PRONOME:
					case SUBSTANTIVO:
					case VERBO_INFINITIVO:
					case VIRGULA:
						{
						alt4=5;
						}
						break;
					case VERBO:
						{
						int LA4_11 = input.LA(4);
						if ( (LA4_11==ADJETIVO) ) {
							alt4=2;
						}
						else if ( (LA4_11==EOF||(LA4_11 >= ADVERBIO && LA4_11 <= CONJUNCAO_SUBORDINADA)||LA4_11==INTERJEICAO||LA4_11==NUMERAL||(LA4_11 >= PONTO && LA4_11 <= PRONOME)||(LA4_11 >= SUBSTANTIVO && LA4_11 <= VIRGULA)) ) {
							alt4=5;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ADJETIVO:
						{
						alt4=2;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA4_2==EOF||(LA4_2 >= ADJETIVO && LA4_2 <= CONJUNCAO_SUBORDINADA)||LA4_2==INTERJEICAO||LA4_2==NUMERAL||(LA4_2 >= PONTO && LA4_2 <= PRONOME)||(LA4_2 >= VERBO && LA4_2 <= VIRGULA)) ) {
					alt4=5;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case VERBO_INFINITIVO:
				{
				switch ( input.LA(2) ) {
				case CONJUNCAO_COORDENADA:
				case VIRGULA:
					{
					alt4=4;
					}
					break;
				case ARTIGO:
				case NUMERAL:
					{
					int LA4_8 = input.LA(3);
					if ( (LA4_8==SUBSTANTIVO) ) {
						alt4=3;
					}
					else if ( (LA4_8==EOF||(LA4_8 >= ADJETIVO && LA4_8 <= CONJUNCAO_SUBORDINADA)||LA4_8==INTERJEICAO||LA4_8==NUMERAL||(LA4_8 >= PONTO && LA4_8 <= PRONOME)||(LA4_8 >= VERBO && LA4_8 <= VIRGULA)) ) {
						alt4=5;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case SUBSTANTIVO:
					{
					alt4=3;
					}
					break;
				case EOF:
				case ADJETIVO:
				case ADVERBIO:
				case CONJUNCAO_SUBORDINADA:
				case INTERJEICAO:
				case PONTO:
				case PREPOSICAO:
				case PRONOME:
				case VERBO:
				case VERBO_INFINITIVO:
					{
					alt4=5;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case ADJETIVO:
			case ADVERBIO:
			case CONJUNCAO_COORDENADA:
			case CONJUNCAO_SUBORDINADA:
			case INTERJEICAO:
			case PONTO:
			case PREPOSICAO:
			case PRONOME:
			case VERBO:
			case VIRGULA:
				{
				alt4=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:67:16: s= SUBSTANTIVO PREPOSICAO s1= SUBSTANTIVO
					{
					s=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_classeMetodo392); 
					match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_classeMetodo394); 
					s1=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_classeMetodo398); 
					diagramaDeClasse.addClasse((s1!=null?s1.getText():null));
					System.out.println("Classe1: "+ (s1!=null?s1.getText():null));
					}
					break;
				case 2 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:70:4: ( ARTIGO | NUMERAL ) SUBSTANTIVO ( VERBO )? ADJETIVO
					{
					if ( input.LA(1)==ARTIGO||input.LA(1)==NUMERAL ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					SUBSTANTIVO1=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_classeMetodo418); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:70:33: ( VERBO )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==VERBO) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:70:33: VERBO
							{
							match(input,VERBO,FOLLOW_VERBO_in_classeMetodo420); 
							}
							break;

					}

					match(input,ADJETIVO,FOLLOW_ADJETIVO_in_classeMetodo423); 
					diagramaDeClasse.addClasse((SUBSTANTIVO1!=null?SUBSTANTIVO1.getText():null));
					diagramaDeClasse.addAtributo((SUBSTANTIVO1!=null?SUBSTANTIVO1.getText():null), "descricao", "String");
					System.out.println("Classe2: "+ (SUBSTANTIVO1!=null?SUBSTANTIVO1.getText():null));
					System.out.println("Atributo1: " + "descricao" + " - Classe: "+ (SUBSTANTIVO1!=null?SUBSTANTIVO1.getText():null));
					}
					break;
				case 3 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:75:4: v= VERBO_INFINITIVO ( ARTIGO | NUMERAL )? s= SUBSTANTIVO
					{
					v=(Token)match(input,VERBO_INFINITIVO,FOLLOW_VERBO_INFINITIVO_in_classeMetodo447); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:75:23: ( ARTIGO | NUMERAL )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==ARTIGO||LA3_0==NUMERAL) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:
							{
							if ( input.LA(1)==ARTIGO||input.LA(1)==NUMERAL ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					s=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_classeMetodo458); 
					diagramaDeClasse.addClasse((s!=null?s.getText():null));
					diagramaDeClasse.addMetodo((s!=null?s.getText():null), (v!=null?v.getText():null), (s!=null?s.getText():null));
					diagramaDeClasse.addRelacionamento("1:n", "ator", (s!=null?s.getText():null));
					System.out.println("Classe3: "+ (s!=null?s.getText():null));
					System.out.println("Metodo1: "+ (v!=null?v.getText():null) + "(" + (s!=null?s.getText():null) + ")");
					System.out.println("Relacionamento1n: "+ "ator" + " - " + (s!=null?s.getText():null));
					}
					break;
				case 4 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:82:4: v= VERBO_INFINITIVO ( VIRGULA | CONJUNCAO_COORDENADA )
					{
					v=(Token)match(input,VERBO_INFINITIVO,FOLLOW_VERBO_INFINITIVO_in_classeMetodo490); 
					if ( input.LA(1)==CONJUNCAO_COORDENADA||input.LA(1)==VIRGULA ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					diagramaDeClasse.addMetodo("proxima", (v!=null?v.getText():null), "proxima");
					System.out.println("Metodo2: "+ (v!=null?v.getText():null) + "(proxima)");
					}
					break;
				case 5 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:85:4: ( ADJETIVO | ADVERBIO | ARTIGO | SUBSTANTIVO | VERBO | VERBO_INFINITIVO | PRONOME | CONJUNCAO_COORDENADA | CONJUNCAO_SUBORDINADA | INTERJEICAO | PREPOSICAO | NUMERAL | PONTO | VIRGULA )
					{
					if ( (input.LA(1) >= ADJETIVO && input.LA(1) <= CONJUNCAO_SUBORDINADA)||input.LA(1)==INTERJEICAO||input.LA(1)==NUMERAL||(input.LA(1) >= PONTO && input.LA(1) <= PRONOME)||(input.LA(1) >= SUBSTANTIVO && input.LA(1) <= VIRGULA) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "classeMetodo"

	// Delegated rules



	public static final BitSet FOLLOW_classeMetodo_in_estoria374 = new BitSet(new long[]{0x00000000003DD5F2L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_classeMetodo392 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PREPOSICAO_in_classeMetodo394 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_classeMetodo398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_classeMetodo412 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_classeMetodo418 = new BitSet(new long[]{0x0000000000080010L});
	public static final BitSet FOLLOW_VERBO_in_classeMetodo420 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ADJETIVO_in_classeMetodo423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VERBO_INFINITIVO_in_classeMetodo447 = new BitSet(new long[]{0x0000000000041040L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_classeMetodo458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VERBO_INFINITIVO_in_classeMetodo490 = new BitSet(new long[]{0x0000000000200080L});
	public static final BitSet FOLLOW_set_in_classeMetodo492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_classeMetodo509 = new BitSet(new long[]{0x0000000000000002L});
}
