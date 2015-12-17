// $ANTLR 3.5.1 /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g 2015-09-24 20:21:30

	package ifpi.ads.tcc.padroes;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AtributoRelacionamentoParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADJETIVO", "ADVERBIO", "ARTIGO", 
		"CONJUNCAO_COORDENADA", "CONJUNCAO_SUBORDINADA", "DOIS_PONTOS", "INT", 
		"INTERJEICAO", "LETRASACENTUADAS", "NUMERAL", "PALAVRA", "PONTO", "PREPOSICAO", 
		"PRONOME", "SIMBOLOS", "SUBSTANTIVO", "VERBO", "VERBO_INFINITIVO", "VIRGULA", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ADJETIVO=4;
	public static final int ADVERBIO=5;
	public static final int ARTIGO=6;
	public static final int CONJUNCAO_COORDENADA=7;
	public static final int CONJUNCAO_SUBORDINADA=8;
	public static final int DOIS_PONTOS=9;
	public static final int INT=10;
	public static final int INTERJEICAO=11;
	public static final int LETRASACENTUADAS=12;
	public static final int NUMERAL=13;
	public static final int PALAVRA=14;
	public static final int PONTO=15;
	public static final int PREPOSICAO=16;
	public static final int PRONOME=17;
	public static final int SIMBOLOS=18;
	public static final int SUBSTANTIVO=19;
	public static final int VERBO=20;
	public static final int VERBO_INFINITIVO=21;
	public static final int VIRGULA=22;
	public static final int WS=23;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public AtributoRelacionamentoParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public AtributoRelacionamentoParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return AtributoRelacionamentoParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g"; }

		
		private DiagramaDeClasse diagramaDeClasse;
		private String classe, classe1;
		
		public AtributoRelacionamentoParser(TokenStream input, DiagramaDeClasse diagramaDeClasse) {
			this(input, new RecognizerSharedState());
			this.diagramaDeClasse = diagramaDeClasse;
		}



	// $ANTLR start "estoria"
	// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:65:1: estoria returns [DiagramaDeClasse diagramaDeClasse] : ( atributoRelacionamento )+ ;
	public final DiagramaDeClasse estoria() throws RecognitionException {
		DiagramaDeClasse diagramaDeClasse = null;


		try {
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:65:52: ( ( atributoRelacionamento )+ )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:66:3: ( atributoRelacionamento )+
			{
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:66:3: ( atributoRelacionamento )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ADJETIVO && LA1_0 <= DOIS_PONTOS)||LA1_0==INTERJEICAO||LA1_0==NUMERAL||(LA1_0 >= PONTO && LA1_0 <= PRONOME)||(LA1_0 >= SUBSTANTIVO && LA1_0 <= VIRGULA)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:66:4: atributoRelacionamento
					{
					pushFollow(FOLLOW_atributoRelacionamento_in_estoria378);
					atributoRelacionamento();
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



	// $ANTLR start "atributoRelacionamento"
	// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:70:1: atributoRelacionamento : ( ARTIGO s= SUBSTANTIVO p= PREPOSICAO s1= SUBSTANTIVO p1= PREPOSICAO (n= NUMERAL |s2= SUBSTANTIVO ) | ( CONJUNCAO_COORDENADA | VIRGULA | DOIS_PONTOS ) ( ARTIGO )? s= SUBSTANTIVO ( PREPOSICAO s1= SUBSTANTIVO )? |a= ARTIGO s= SUBSTANTIVO (p= PREPOSICAO s1= SUBSTANTIVO )? ( VERBO | VERBO_INFINITIVO ) (a1= ARTIGO )? s2= SUBSTANTIVO (p1= PREPOSICAO s3= SUBSTANTIVO )? |a= ARTIGO s= SUBSTANTIVO (p= PREPOSICAO s1= SUBSTANTIVO )? VERBO NUMERAL CONJUNCAO_COORDENADA ADVERBIO s2= SUBSTANTIVO (p1= PREPOSICAO s3= SUBSTANTIVO )? | ARTIGO s= SUBSTANTIVO ( PREPOSICAO | VERBO ) NUMERAL s1= SUBSTANTIVO | NUMERAL s= SUBSTANTIVO ( ADJETIVO )? PREPOSICAO s1= SUBSTANTIVO | ( ADJETIVO | ADVERBIO | ARTIGO | SUBSTANTIVO | VERBO | VERBO_INFINITIVO | PRONOME | CONJUNCAO_COORDENADA | CONJUNCAO_SUBORDINADA | INTERJEICAO | PREPOSICAO | NUMERAL | PONTO | VIRGULA | DOIS_PONTOS ) );
	public final void atributoRelacionamento() throws RecognitionException {
		Token s=null;
		Token p=null;
		Token s1=null;
		Token p1=null;
		Token n=null;
		Token s2=null;
		Token a=null;
		Token a1=null;
		Token s3=null;
		Token NUMERAL1=null;

		try {
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:70:23: ( ARTIGO s= SUBSTANTIVO p= PREPOSICAO s1= SUBSTANTIVO p1= PREPOSICAO (n= NUMERAL |s2= SUBSTANTIVO ) | ( CONJUNCAO_COORDENADA | VIRGULA | DOIS_PONTOS ) ( ARTIGO )? s= SUBSTANTIVO ( PREPOSICAO s1= SUBSTANTIVO )? |a= ARTIGO s= SUBSTANTIVO (p= PREPOSICAO s1= SUBSTANTIVO )? ( VERBO | VERBO_INFINITIVO ) (a1= ARTIGO )? s2= SUBSTANTIVO (p1= PREPOSICAO s3= SUBSTANTIVO )? |a= ARTIGO s= SUBSTANTIVO (p= PREPOSICAO s1= SUBSTANTIVO )? VERBO NUMERAL CONJUNCAO_COORDENADA ADVERBIO s2= SUBSTANTIVO (p1= PREPOSICAO s3= SUBSTANTIVO )? | ARTIGO s= SUBSTANTIVO ( PREPOSICAO | VERBO ) NUMERAL s1= SUBSTANTIVO | NUMERAL s= SUBSTANTIVO ( ADJETIVO )? PREPOSICAO s1= SUBSTANTIVO | ( ADJETIVO | ADVERBIO | ARTIGO | SUBSTANTIVO | VERBO | VERBO_INFINITIVO | PRONOME | CONJUNCAO_COORDENADA | CONJUNCAO_SUBORDINADA | INTERJEICAO | PREPOSICAO | NUMERAL | PONTO | VIRGULA | DOIS_PONTOS ) )
			int alt11=7;
			switch ( input.LA(1) ) {
			case ARTIGO:
				{
				int LA11_1 = input.LA(2);
				if ( (LA11_1==SUBSTANTIVO) ) {
					switch ( input.LA(3) ) {
					case PREPOSICAO:
						{
						switch ( input.LA(4) ) {
						case SUBSTANTIVO:
							{
							switch ( input.LA(5) ) {
							case PREPOSICAO:
								{
								switch ( input.LA(6) ) {
								case NUMERAL:
									{
									alt11=1;
									}
									break;
								case SUBSTANTIVO:
									{
									alt11=1;
									}
									break;
								case EOF:
								case ADJETIVO:
								case ADVERBIO:
								case ARTIGO:
								case CONJUNCAO_COORDENADA:
								case CONJUNCAO_SUBORDINADA:
								case DOIS_PONTOS:
								case INTERJEICAO:
								case PONTO:
								case PREPOSICAO:
								case PRONOME:
								case VERBO:
								case VERBO_INFINITIVO:
								case VIRGULA:
									{
									alt11=7;
									}
									break;
								default:
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 11, 21, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}
								}
								break;
							case VERBO:
								{
								switch ( input.LA(6) ) {
								case NUMERAL:
									{
									int LA11_28 = input.LA(7);
									if ( (LA11_28==CONJUNCAO_COORDENADA) ) {
										int LA11_24 = input.LA(8);
										if ( (LA11_24==ADVERBIO) ) {
											int LA11_29 = input.LA(9);
											if ( (LA11_29==SUBSTANTIVO) ) {
												alt11=4;
											}
											else if ( (LA11_29==EOF||(LA11_29 >= ADJETIVO && LA11_29 <= DOIS_PONTOS)||LA11_29==INTERJEICAO||LA11_29==NUMERAL||(LA11_29 >= PONTO && LA11_29 <= PRONOME)||(LA11_29 >= VERBO && LA11_29 <= VIRGULA)) ) {
												alt11=7;
											}

											else {
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 11, 29, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}
										else if ( (LA11_24==EOF||LA11_24==ADJETIVO||(LA11_24 >= ARTIGO && LA11_24 <= DOIS_PONTOS)||LA11_24==INTERJEICAO||LA11_24==NUMERAL||(LA11_24 >= PONTO && LA11_24 <= PRONOME)||(LA11_24 >= SUBSTANTIVO && LA11_24 <= VIRGULA)) ) {
											alt11=7;
										}

										else {
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 11, 24, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}
									else if ( (LA11_28==EOF||(LA11_28 >= ADJETIVO && LA11_28 <= ARTIGO)||(LA11_28 >= CONJUNCAO_SUBORDINADA && LA11_28 <= DOIS_PONTOS)||LA11_28==INTERJEICAO||LA11_28==NUMERAL||(LA11_28 >= PONTO && LA11_28 <= PRONOME)||(LA11_28 >= SUBSTANTIVO && LA11_28 <= VIRGULA)) ) {
										alt11=7;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 11, 28, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

									}
									break;
								case ARTIGO:
									{
									int LA11_18 = input.LA(7);
									if ( (LA11_18==SUBSTANTIVO) ) {
										alt11=3;
									}
									else if ( (LA11_18==EOF||(LA11_18 >= ADJETIVO && LA11_18 <= DOIS_PONTOS)||LA11_18==INTERJEICAO||LA11_18==NUMERAL||(LA11_18 >= PONTO && LA11_18 <= PRONOME)||(LA11_18 >= VERBO && LA11_18 <= VIRGULA)) ) {
										alt11=7;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 11, 18, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

									}
									break;
								case SUBSTANTIVO:
									{
									alt11=3;
									}
									break;
								case EOF:
								case ADJETIVO:
								case ADVERBIO:
								case CONJUNCAO_COORDENADA:
								case CONJUNCAO_SUBORDINADA:
								case DOIS_PONTOS:
								case INTERJEICAO:
								case PONTO:
								case PREPOSICAO:
								case PRONOME:
								case VERBO:
								case VERBO_INFINITIVO:
								case VIRGULA:
									{
									alt11=7;
									}
									break;
								default:
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 11, 22, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}
								}
								break;
							case VERBO_INFINITIVO:
								{
								switch ( input.LA(6) ) {
								case ARTIGO:
									{
									int LA11_18 = input.LA(7);
									if ( (LA11_18==SUBSTANTIVO) ) {
										alt11=3;
									}
									else if ( (LA11_18==EOF||(LA11_18 >= ADJETIVO && LA11_18 <= DOIS_PONTOS)||LA11_18==INTERJEICAO||LA11_18==NUMERAL||(LA11_18 >= PONTO && LA11_18 <= PRONOME)||(LA11_18 >= VERBO && LA11_18 <= VIRGULA)) ) {
										alt11=7;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 11, 18, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

									}
									break;
								case SUBSTANTIVO:
									{
									alt11=3;
									}
									break;
								case EOF:
								case ADJETIVO:
								case ADVERBIO:
								case CONJUNCAO_COORDENADA:
								case CONJUNCAO_SUBORDINADA:
								case DOIS_PONTOS:
								case INTERJEICAO:
								case NUMERAL:
								case PONTO:
								case PREPOSICAO:
								case PRONOME:
								case VERBO:
								case VERBO_INFINITIVO:
								case VIRGULA:
									{
									alt11=7;
									}
									break;
								default:
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 11, 11, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}
								}
								break;
							case EOF:
							case ADJETIVO:
							case ADVERBIO:
							case ARTIGO:
							case CONJUNCAO_COORDENADA:
							case CONJUNCAO_SUBORDINADA:
							case DOIS_PONTOS:
							case INTERJEICAO:
							case NUMERAL:
							case PONTO:
							case PRONOME:
							case SUBSTANTIVO:
							case VIRGULA:
								{
								alt11=7;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 11, 15, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
							}
							break;
						case NUMERAL:
							{
							int LA11_16 = input.LA(5);
							if ( (LA11_16==SUBSTANTIVO) ) {
								alt11=5;
							}
							else if ( (LA11_16==EOF||(LA11_16 >= ADJETIVO && LA11_16 <= DOIS_PONTOS)||LA11_16==INTERJEICAO||LA11_16==NUMERAL||(LA11_16 >= PONTO && LA11_16 <= PRONOME)||(LA11_16 >= VERBO && LA11_16 <= VIRGULA)) ) {
								alt11=7;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 11, 16, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case EOF:
						case ADJETIVO:
						case ADVERBIO:
						case ARTIGO:
						case CONJUNCAO_COORDENADA:
						case CONJUNCAO_SUBORDINADA:
						case DOIS_PONTOS:
						case INTERJEICAO:
						case PONTO:
						case PREPOSICAO:
						case PRONOME:
						case VERBO:
						case VERBO_INFINITIVO:
						case VIRGULA:
							{
							alt11=7;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 11, 9, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case VERBO:
						{
						switch ( input.LA(4) ) {
						case NUMERAL:
							{
							switch ( input.LA(5) ) {
							case SUBSTANTIVO:
								{
								alt11=5;
								}
								break;
							case CONJUNCAO_COORDENADA:
								{
								int LA11_24 = input.LA(6);
								if ( (LA11_24==ADVERBIO) ) {
									int LA11_29 = input.LA(7);
									if ( (LA11_29==SUBSTANTIVO) ) {
										alt11=4;
									}
									else if ( (LA11_29==EOF||(LA11_29 >= ADJETIVO && LA11_29 <= DOIS_PONTOS)||LA11_29==INTERJEICAO||LA11_29==NUMERAL||(LA11_29 >= PONTO && LA11_29 <= PRONOME)||(LA11_29 >= VERBO && LA11_29 <= VIRGULA)) ) {
										alt11=7;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 11, 29, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}
								else if ( (LA11_24==EOF||LA11_24==ADJETIVO||(LA11_24 >= ARTIGO && LA11_24 <= DOIS_PONTOS)||LA11_24==INTERJEICAO||LA11_24==NUMERAL||(LA11_24 >= PONTO && LA11_24 <= PRONOME)||(LA11_24 >= SUBSTANTIVO && LA11_24 <= VIRGULA)) ) {
									alt11=7;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 11, 24, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case EOF:
							case ADJETIVO:
							case ADVERBIO:
							case ARTIGO:
							case CONJUNCAO_SUBORDINADA:
							case DOIS_PONTOS:
							case INTERJEICAO:
							case NUMERAL:
							case PONTO:
							case PREPOSICAO:
							case PRONOME:
							case VERBO:
							case VERBO_INFINITIVO:
							case VIRGULA:
								{
								alt11=7;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 11, 17, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
							}
							break;
						case ARTIGO:
							{
							int LA11_18 = input.LA(5);
							if ( (LA11_18==SUBSTANTIVO) ) {
								alt11=3;
							}
							else if ( (LA11_18==EOF||(LA11_18 >= ADJETIVO && LA11_18 <= DOIS_PONTOS)||LA11_18==INTERJEICAO||LA11_18==NUMERAL||(LA11_18 >= PONTO && LA11_18 <= PRONOME)||(LA11_18 >= VERBO && LA11_18 <= VIRGULA)) ) {
								alt11=7;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 11, 18, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SUBSTANTIVO:
							{
							alt11=3;
							}
							break;
						case EOF:
						case ADJETIVO:
						case ADVERBIO:
						case CONJUNCAO_COORDENADA:
						case CONJUNCAO_SUBORDINADA:
						case DOIS_PONTOS:
						case INTERJEICAO:
						case PONTO:
						case PREPOSICAO:
						case PRONOME:
						case VERBO:
						case VERBO_INFINITIVO:
						case VIRGULA:
							{
							alt11=7;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 11, 10, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case VERBO_INFINITIVO:
						{
						switch ( input.LA(4) ) {
						case ARTIGO:
							{
							int LA11_18 = input.LA(5);
							if ( (LA11_18==SUBSTANTIVO) ) {
								alt11=3;
							}
							else if ( (LA11_18==EOF||(LA11_18 >= ADJETIVO && LA11_18 <= DOIS_PONTOS)||LA11_18==INTERJEICAO||LA11_18==NUMERAL||(LA11_18 >= PONTO && LA11_18 <= PRONOME)||(LA11_18 >= VERBO && LA11_18 <= VIRGULA)) ) {
								alt11=7;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 11, 18, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SUBSTANTIVO:
							{
							alt11=3;
							}
							break;
						case EOF:
						case ADJETIVO:
						case ADVERBIO:
						case CONJUNCAO_COORDENADA:
						case CONJUNCAO_SUBORDINADA:
						case DOIS_PONTOS:
						case INTERJEICAO:
						case NUMERAL:
						case PONTO:
						case PREPOSICAO:
						case PRONOME:
						case VERBO:
						case VERBO_INFINITIVO:
						case VIRGULA:
							{
							alt11=7;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 11, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case EOF:
					case ADJETIVO:
					case ADVERBIO:
					case ARTIGO:
					case CONJUNCAO_COORDENADA:
					case CONJUNCAO_SUBORDINADA:
					case DOIS_PONTOS:
					case INTERJEICAO:
					case NUMERAL:
					case PONTO:
					case PRONOME:
					case SUBSTANTIVO:
					case VIRGULA:
						{
						alt11=7;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 11, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA11_1==EOF||(LA11_1 >= ADJETIVO && LA11_1 <= DOIS_PONTOS)||LA11_1==INTERJEICAO||LA11_1==NUMERAL||(LA11_1 >= PONTO && LA11_1 <= PRONOME)||(LA11_1 >= VERBO && LA11_1 <= VIRGULA)) ) {
					alt11=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CONJUNCAO_COORDENADA:
			case DOIS_PONTOS:
			case VIRGULA:
				{
				switch ( input.LA(2) ) {
				case ARTIGO:
					{
					int LA11_6 = input.LA(3);
					if ( (LA11_6==SUBSTANTIVO) ) {
						alt11=2;
					}
					else if ( (LA11_6==EOF||(LA11_6 >= ADJETIVO && LA11_6 <= DOIS_PONTOS)||LA11_6==INTERJEICAO||LA11_6==NUMERAL||(LA11_6 >= PONTO && LA11_6 <= PRONOME)||(LA11_6 >= VERBO && LA11_6 <= VIRGULA)) ) {
						alt11=7;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 11, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case SUBSTANTIVO:
					{
					alt11=2;
					}
					break;
				case EOF:
				case ADJETIVO:
				case ADVERBIO:
				case CONJUNCAO_COORDENADA:
				case CONJUNCAO_SUBORDINADA:
				case DOIS_PONTOS:
				case INTERJEICAO:
				case NUMERAL:
				case PONTO:
				case PREPOSICAO:
				case PRONOME:
				case VERBO:
				case VERBO_INFINITIVO:
				case VIRGULA:
					{
					alt11=7;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case NUMERAL:
				{
				int LA11_3 = input.LA(2);
				if ( (LA11_3==SUBSTANTIVO) ) {
					switch ( input.LA(3) ) {
					case ADJETIVO:
						{
						int LA11_13 = input.LA(4);
						if ( (LA11_13==PREPOSICAO) ) {
							int LA11_14 = input.LA(5);
							if ( (LA11_14==SUBSTANTIVO) ) {
								alt11=6;
							}
							else if ( (LA11_14==EOF||(LA11_14 >= ADJETIVO && LA11_14 <= DOIS_PONTOS)||LA11_14==INTERJEICAO||LA11_14==NUMERAL||(LA11_14 >= PONTO && LA11_14 <= PRONOME)||(LA11_14 >= VERBO && LA11_14 <= VIRGULA)) ) {
								alt11=7;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 11, 14, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( (LA11_13==EOF||(LA11_13 >= ADJETIVO && LA11_13 <= DOIS_PONTOS)||LA11_13==INTERJEICAO||LA11_13==NUMERAL||LA11_13==PONTO||LA11_13==PRONOME||(LA11_13 >= SUBSTANTIVO && LA11_13 <= VIRGULA)) ) {
							alt11=7;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 11, 13, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case PREPOSICAO:
						{
						int LA11_14 = input.LA(4);
						if ( (LA11_14==SUBSTANTIVO) ) {
							alt11=6;
						}
						else if ( (LA11_14==EOF||(LA11_14 >= ADJETIVO && LA11_14 <= DOIS_PONTOS)||LA11_14==INTERJEICAO||LA11_14==NUMERAL||(LA11_14 >= PONTO && LA11_14 <= PRONOME)||(LA11_14 >= VERBO && LA11_14 <= VIRGULA)) ) {
							alt11=7;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 11, 14, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case EOF:
					case ADVERBIO:
					case ARTIGO:
					case CONJUNCAO_COORDENADA:
					case CONJUNCAO_SUBORDINADA:
					case DOIS_PONTOS:
					case INTERJEICAO:
					case NUMERAL:
					case PONTO:
					case PRONOME:
					case SUBSTANTIVO:
					case VERBO:
					case VERBO_INFINITIVO:
					case VIRGULA:
						{
						alt11=7;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 11, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA11_3==EOF||(LA11_3 >= ADJETIVO && LA11_3 <= DOIS_PONTOS)||LA11_3==INTERJEICAO||LA11_3==NUMERAL||(LA11_3 >= PONTO && LA11_3 <= PRONOME)||(LA11_3 >= VERBO && LA11_3 <= VIRGULA)) ) {
					alt11=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ADJETIVO:
			case ADVERBIO:
			case CONJUNCAO_SUBORDINADA:
			case INTERJEICAO:
			case PONTO:
			case PREPOSICAO:
			case PRONOME:
			case SUBSTANTIVO:
			case VERBO:
			case VERBO_INFINITIVO:
				{
				alt11=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:70:25: ARTIGO s= SUBSTANTIVO p= PREPOSICAO s1= SUBSTANTIVO p1= PREPOSICAO (n= NUMERAL |s2= SUBSTANTIVO )
					{
					match(input,ARTIGO,FOLLOW_ARTIGO_in_atributoRelacionamento394); 
					s=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento398); 
					p=(Token)match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_atributoRelacionamento402); 
					s1=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento406); 
					p1=(Token)match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_atributoRelacionamento410); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:70:88: (n= NUMERAL |s2= SUBSTANTIVO )
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==NUMERAL) ) {
						alt2=1;
					}
					else if ( (LA2_0==SUBSTANTIVO) ) {
						alt2=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);
						throw nvae;
					}

					switch (alt2) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:70:89: n= NUMERAL
							{
							n=(Token)match(input,NUMERAL,FOLLOW_NUMERAL_in_atributoRelacionamento415); 
							}
							break;
						case 2 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:70:99: s2= SUBSTANTIVO
							{
							s2=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento419); 
							}
							break;

					}

					diagramaDeClasse.addAtributo((s1!=null?s1.getText():null), (s!=null?s.getText():null), s2!=null ? (s2!=null?s2.getText():null) : (n!=null?n.getText():null));
					System.out.println("Atributo2: " + (s!=null?s.getText():null) + " - Classe: "+ (s1!=null?s1.getText():null));
					}
					break;
				case 2 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:73:4: ( CONJUNCAO_COORDENADA | VIRGULA | DOIS_PONTOS ) ( ARTIGO )? s= SUBSTANTIVO ( PREPOSICAO s1= SUBSTANTIVO )?
					{
					if ( input.LA(1)==CONJUNCAO_COORDENADA||input.LA(1)==DOIS_PONTOS||input.LA(1)==VIRGULA ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:73:47: ( ARTIGO )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==ARTIGO) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:73:47: ARTIGO
							{
							match(input,ARTIGO,FOLLOW_ARTIGO_in_atributoRelacionamento442); 
							}
							break;

					}

					s=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento447); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:73:69: ( PREPOSICAO s1= SUBSTANTIVO )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==PREPOSICAO) ) {
						int LA4_1 = input.LA(2);
						if ( (LA4_1==SUBSTANTIVO) ) {
							alt4=1;
						}
					}
					switch (alt4) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:73:70: PREPOSICAO s1= SUBSTANTIVO
							{
							match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_atributoRelacionamento450); 
							s1=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento454); 
							}
							break;

					}

					this.classe = s1!=null ? (s1!=null?s1.getText():null) : "proxima";
					diagramaDeClasse.addAtributo(this.classe, (s!=null?s.getText():null), "String");
					System.out.println("Atributo3: " + (s!=null?s.getText():null) + " - Classe: "+ this.classe);
					}
					break;
				case 3 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:77:4: a= ARTIGO s= SUBSTANTIVO (p= PREPOSICAO s1= SUBSTANTIVO )? ( VERBO | VERBO_INFINITIVO ) (a1= ARTIGO )? s2= SUBSTANTIVO (p1= PREPOSICAO s3= SUBSTANTIVO )?
					{
					a=(Token)match(input,ARTIGO,FOLLOW_ARTIGO_in_atributoRelacionamento476); 
					s=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento480); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:77:27: (p= PREPOSICAO s1= SUBSTANTIVO )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==PREPOSICAO) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:77:28: p= PREPOSICAO s1= SUBSTANTIVO
							{
							p=(Token)match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_atributoRelacionamento485); 
							s1=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento489); 
							}
							break;

					}

					if ( (input.LA(1) >= VERBO && input.LA(1) <= VERBO_INFINITIVO) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:77:85: (a1= ARTIGO )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==ARTIGO) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:77:85: a1= ARTIGO
							{
							a1=(Token)match(input,ARTIGO,FOLLOW_ARTIGO_in_atributoRelacionamento501); 
							}
							break;

					}

					s2=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento506); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:77:109: (p1= PREPOSICAO s3= SUBSTANTIVO )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==PREPOSICAO) ) {
						int LA7_1 = input.LA(2);
						if ( (LA7_1==SUBSTANTIVO) ) {
							alt7=1;
						}
					}
					switch (alt7) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:77:110: p1= PREPOSICAO s3= SUBSTANTIVO
							{
							p1=(Token)match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_atributoRelacionamento511); 
							s3=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento515); 
							}
							break;

					}

					this.classe = s1!=null ? (s1!=null?s1.getText():null) : (s!=null?s.getText():null);
							this.classe1 = s3!=null ? (s3!=null?s3.getText():null) : (s2!=null?s2.getText():null);
					diagramaDeClasse.addRelacionamento("1:1", this.classe, this.classe1);
					System.out.println("1Relacionamento11: "+ this.classe + " - " + this.classe1);
					}
					break;
				case 4 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:82:4: a= ARTIGO s= SUBSTANTIVO (p= PREPOSICAO s1= SUBSTANTIVO )? VERBO NUMERAL CONJUNCAO_COORDENADA ADVERBIO s2= SUBSTANTIVO (p1= PREPOSICAO s3= SUBSTANTIVO )?
					{
					a=(Token)match(input,ARTIGO,FOLLOW_ARTIGO_in_atributoRelacionamento537); 
					s=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento541); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:82:27: (p= PREPOSICAO s1= SUBSTANTIVO )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==PREPOSICAO) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:82:28: p= PREPOSICAO s1= SUBSTANTIVO
							{
							p=(Token)match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_atributoRelacionamento546); 
							s1=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento550); 
							}
							break;

					}

					match(input,VERBO,FOLLOW_VERBO_in_atributoRelacionamento554); 
					match(input,NUMERAL,FOLLOW_NUMERAL_in_atributoRelacionamento556); 
					match(input,CONJUNCAO_COORDENADA,FOLLOW_CONJUNCAO_COORDENADA_in_atributoRelacionamento558); 
					match(input,ADVERBIO,FOLLOW_ADVERBIO_in_atributoRelacionamento560); 
					s2=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento564); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:82:117: (p1= PREPOSICAO s3= SUBSTANTIVO )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==PREPOSICAO) ) {
						int LA9_1 = input.LA(2);
						if ( (LA9_1==SUBSTANTIVO) ) {
							alt9=1;
						}
					}
					switch (alt9) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:82:118: p1= PREPOSICAO s3= SUBSTANTIVO
							{
							p1=(Token)match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_atributoRelacionamento569); 
							s3=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento573); 
							}
							break;

					}

					this.classe = s1!=null ? (s1!=null?s1.getText():null) : (s!=null?s.getText():null);
							this.classe1 = s3!=null ? (s3!=null?s3.getText():null) : (s2!=null?s2.getText():null);
					diagramaDeClasse.addRelacionamento("1:n", this.classe, this.classe1);
					System.out.println("2Relacionamento1n: "+ this.classe + " -  " + this.classe1);
					}
					break;
				case 5 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:87:4: ARTIGO s= SUBSTANTIVO ( PREPOSICAO | VERBO ) NUMERAL s1= SUBSTANTIVO
					{
					match(input,ARTIGO,FOLLOW_ARTIGO_in_atributoRelacionamento593); 
					s=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento597); 
					if ( input.LA(1)==PREPOSICAO||input.LA(1)==VERBO ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					NUMERAL1=(Token)match(input,NUMERAL,FOLLOW_NUMERAL_in_atributoRelacionamento605); 
					s1=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento609); 
					diagramaDeClasse.addRelacionamento("1:n", (s!=null?s.getText():null), (s1!=null?s1.getText():null));
					diagramaDeClasse.addAtributo((s1!=null?s1.getText():null), "quantidade", (NUMERAL1!=null?NUMERAL1.getText():null));
					System.out.println("3Relacionamento1n: "+ (s!=null?s.getText():null) + " - " + (s1!=null?s1.getText():null));
					System.out.println("Atributo4: " + "quantidade" + " - Classe: "+ (s1!=null?s1.getText():null));
					}
					break;
				case 6 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:92:4: NUMERAL s= SUBSTANTIVO ( ADJETIVO )? PREPOSICAO s1= SUBSTANTIVO
					{
					match(input,NUMERAL,FOLLOW_NUMERAL_in_atributoRelacionamento631); 
					s=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento635); 
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:92:26: ( ADJETIVO )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==ADJETIVO) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:92:26: ADJETIVO
							{
							match(input,ADJETIVO,FOLLOW_ADJETIVO_in_atributoRelacionamento637); 
							}
							break;

					}

					match(input,PREPOSICAO,FOLLOW_PREPOSICAO_in_atributoRelacionamento640); 
					s1=(Token)match(input,SUBSTANTIVO,FOLLOW_SUBSTANTIVO_in_atributoRelacionamento644); 
					diagramaDeClasse.addRelacionamento("1:n", (s1!=null?s1.getText():null), (s!=null?s.getText():null));
					System.out.println("4Relacionamento1n: "+ (s1!=null?s1.getText():null) + " - " + (s!=null?s.getText():null));
					}
					break;
				case 7 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/AtributoRelacionamento.g:95:4: ( ADJETIVO | ADVERBIO | ARTIGO | SUBSTANTIVO | VERBO | VERBO_INFINITIVO | PRONOME | CONJUNCAO_COORDENADA | CONJUNCAO_SUBORDINADA | INTERJEICAO | PREPOSICAO | NUMERAL | PONTO | VIRGULA | DOIS_PONTOS )
					{
					if ( (input.LA(1) >= ADJETIVO && input.LA(1) <= DOIS_PONTOS)||input.LA(1)==INTERJEICAO||input.LA(1)==NUMERAL||(input.LA(1) >= PONTO && input.LA(1) <= PRONOME)||(input.LA(1) >= SUBSTANTIVO && input.LA(1) <= VIRGULA) ) {
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
	// $ANTLR end "atributoRelacionamento"

	// Delegated rules



	public static final BitSet FOLLOW_atributoRelacionamento_in_estoria378 = new BitSet(new long[]{0x00000000007BABF2L});
	public static final BitSet FOLLOW_ARTIGO_in_atributoRelacionamento394 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento398 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PREPOSICAO_in_atributoRelacionamento402 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento406 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PREPOSICAO_in_atributoRelacionamento410 = new BitSet(new long[]{0x0000000000082000L});
	public static final BitSet FOLLOW_NUMERAL_in_atributoRelacionamento415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_atributoRelacionamento434 = new BitSet(new long[]{0x0000000000080040L});
	public static final BitSet FOLLOW_ARTIGO_in_atributoRelacionamento442 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento447 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_PREPOSICAO_in_atributoRelacionamento450 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARTIGO_in_atributoRelacionamento476 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento480 = new BitSet(new long[]{0x0000000000310000L});
	public static final BitSet FOLLOW_PREPOSICAO_in_atributoRelacionamento485 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento489 = new BitSet(new long[]{0x0000000000300000L});
	public static final BitSet FOLLOW_set_in_atributoRelacionamento493 = new BitSet(new long[]{0x0000000000080040L});
	public static final BitSet FOLLOW_ARTIGO_in_atributoRelacionamento501 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento506 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_PREPOSICAO_in_atributoRelacionamento511 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARTIGO_in_atributoRelacionamento537 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento541 = new BitSet(new long[]{0x0000000000110000L});
	public static final BitSet FOLLOW_PREPOSICAO_in_atributoRelacionamento546 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento550 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_VERBO_in_atributoRelacionamento554 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_NUMERAL_in_atributoRelacionamento556 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CONJUNCAO_COORDENADA_in_atributoRelacionamento558 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ADVERBIO_in_atributoRelacionamento560 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento564 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_PREPOSICAO_in_atributoRelacionamento569 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento573 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARTIGO_in_atributoRelacionamento593 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento597 = new BitSet(new long[]{0x0000000000110000L});
	public static final BitSet FOLLOW_set_in_atributoRelacionamento599 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_NUMERAL_in_atributoRelacionamento605 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMERAL_in_atributoRelacionamento631 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento635 = new BitSet(new long[]{0x0000000000010010L});
	public static final BitSet FOLLOW_ADJETIVO_in_atributoRelacionamento637 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PREPOSICAO_in_atributoRelacionamento640 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SUBSTANTIVO_in_atributoRelacionamento644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_atributoRelacionamento658 = new BitSet(new long[]{0x0000000000000002L});
}
