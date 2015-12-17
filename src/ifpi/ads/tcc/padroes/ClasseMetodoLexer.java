// $ANTLR 3.5.1 /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g 2015-09-22 10:01:01

	package ifpi.ads.tcc.padroes;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ClasseMetodoLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ClasseMetodoLexer() {} 
	public ClasseMetodoLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ClasseMetodoLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g"; }

	// $ANTLR start "LETRASACENTUADAS"
	public final void mLETRASACENTUADAS() throws RecognitionException {
		try {
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:37:18: ( 'á' | 'Á' | 'é' | 'É' | 'í' | 'Í' | 'õ' | 'Õ' | 'ü' | 'Ü' | 'ç' | 'Ç' | 'ã' | 'Ã' | 'ê' | 'Ê' | 'ô' | 'Ô' | 'à' | 'À' | 'ó' | 'Ó' | 'ú' | 'Ú' | '-' )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:
			{
			if ( input.LA(1)=='-'||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00C1')||input.LA(1)=='\u00C3'||input.LA(1)=='\u00C7'||(input.LA(1) >= '\u00C9' && input.LA(1) <= '\u00CA')||input.LA(1)=='\u00CD'||(input.LA(1) >= '\u00D3' && input.LA(1) <= '\u00D5')||input.LA(1)=='\u00DA'||input.LA(1)=='\u00DC'||(input.LA(1) >= '\u00E0' && input.LA(1) <= '\u00E1')||input.LA(1)=='\u00E3'||input.LA(1)=='\u00E7'||(input.LA(1) >= '\u00E9' && input.LA(1) <= '\u00EA')||input.LA(1)=='\u00ED'||(input.LA(1) >= '\u00F3' && input.LA(1) <= '\u00F5')||input.LA(1)=='\u00FA'||input.LA(1)=='\u00FC' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETRASACENTUADAS"

	// $ANTLR start "PALAVRA"
	public final void mPALAVRA() throws RecognitionException {
		try {
			int _type = PALAVRA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:40:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | LETRASACENTUADAS )+ )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:40:11: ( 'a' .. 'z' | 'A' .. 'Z' | LETRASACENTUADAS )+
			{
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:40:11: ( 'a' .. 'z' | 'A' .. 'Z' | LETRASACENTUADAS )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='-'||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')||(LA1_0 >= '\u00C0' && LA1_0 <= '\u00C1')||LA1_0=='\u00C3'||LA1_0=='\u00C7'||(LA1_0 >= '\u00C9' && LA1_0 <= '\u00CA')||LA1_0=='\u00CD'||(LA1_0 >= '\u00D3' && LA1_0 <= '\u00D5')||LA1_0=='\u00DA'||LA1_0=='\u00DC'||(LA1_0 >= '\u00E0' && LA1_0 <= '\u00E1')||LA1_0=='\u00E3'||LA1_0=='\u00E7'||(LA1_0 >= '\u00E9' && LA1_0 <= '\u00EA')||LA1_0=='\u00ED'||(LA1_0 >= '\u00F3' && LA1_0 <= '\u00F5')||LA1_0=='\u00FA'||LA1_0=='\u00FC') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:
					{
					if ( input.LA(1)=='-'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00C1')||input.LA(1)=='\u00C3'||input.LA(1)=='\u00C7'||(input.LA(1) >= '\u00C9' && input.LA(1) <= '\u00CA')||input.LA(1)=='\u00CD'||(input.LA(1) >= '\u00D3' && input.LA(1) <= '\u00D5')||input.LA(1)=='\u00DA'||input.LA(1)=='\u00DC'||(input.LA(1) >= '\u00E0' && input.LA(1) <= '\u00E1')||input.LA(1)=='\u00E3'||input.LA(1)=='\u00E7'||(input.LA(1) >= '\u00E9' && input.LA(1) <= '\u00EA')||input.LA(1)=='\u00ED'||(input.LA(1) >= '\u00F3' && input.LA(1) <= '\u00F5')||input.LA(1)=='\u00FA'||input.LA(1)=='\u00FC' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PALAVRA"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:42:5: ( ( '0' .. '9' )+ ( ( '.' ( '0' .. '9' )? )+ )? )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:42:7: ( '0' .. '9' )+ ( ( '.' ( '0' .. '9' )? )+ )?
			{
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:42:7: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:42:17: ( ( '.' ( '0' .. '9' )? )+ )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='.') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:42:18: ( '.' ( '0' .. '9' )? )+
					{
					// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:42:18: ( '.' ( '0' .. '9' )? )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0=='.') ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:42:19: '.' ( '0' .. '9' )?
							{
							match('.'); 
							// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:42:23: ( '0' .. '9' )?
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
								alt3=1;
							}
							switch (alt3) {
								case 1 :
									// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:
									{
									if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
										input.consume();
									}
									else {
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

							}

							}
							break;

						default :
							if ( cnt4 >= 1 ) break loop4;
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:45:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:45:9: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "PONTO"
	public final void mPONTO() throws RecognitionException {
		try {
			int _type = PONTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:53:8: ( '.' )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:53:10: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PONTO"

	// $ANTLR start "VIRGULA"
	public final void mVIRGULA() throws RecognitionException {
		try {
			int _type = VIRGULA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:55:9: ( ',' )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:55:11: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VIRGULA"

	// $ANTLR start "SIMBOLOS"
	public final void mSIMBOLOS() throws RecognitionException {
		try {
			int _type = SIMBOLOS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:58:2: ( ( '\\'' | ':' | ';' | '/' | '[' | ']' | '{' | '}' | '(' | ')' | '+' | '\"' | '@' | '#' | '_' | '*' | '=' | '-' ) )
			// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:58:4: ( '\\'' | ':' | ';' | '/' | '[' | ']' | '{' | '}' | '(' | ')' | '+' | '\"' | '@' | '#' | '_' | '*' | '=' | '-' )
			{
			if ( (input.LA(1) >= '\"' && input.LA(1) <= '#')||(input.LA(1) >= '\'' && input.LA(1) <= '+')||input.LA(1)=='-'||input.LA(1)=='/'||(input.LA(1) >= ':' && input.LA(1) <= ';')||input.LA(1)=='='||input.LA(1)=='@'||input.LA(1)=='['||input.LA(1)==']'||input.LA(1)=='_'||input.LA(1)=='{'||input.LA(1)=='}' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIMBOLOS"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:1:8: ( PALAVRA | INT | WS | PONTO | VIRGULA | SIMBOLOS )
		int alt6=6;
		switch ( input.LA(1) ) {
		case '-':
			{
			alt6=1;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt6=2;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt6=3;
			}
			break;
		case '.':
			{
			alt6=4;
			}
			break;
		case ',':
			{
			alt6=5;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
		case '\u00C0':
		case '\u00C1':
		case '\u00C3':
		case '\u00C7':
		case '\u00C9':
		case '\u00CA':
		case '\u00CD':
		case '\u00D3':
		case '\u00D4':
		case '\u00D5':
		case '\u00DA':
		case '\u00DC':
		case '\u00E0':
		case '\u00E1':
		case '\u00E3':
		case '\u00E7':
		case '\u00E9':
		case '\u00EA':
		case '\u00ED':
		case '\u00F3':
		case '\u00F4':
		case '\u00F5':
		case '\u00FA':
		case '\u00FC':
			{
			alt6=1;
			}
			break;
		case '\"':
		case '#':
		case '\'':
		case '(':
		case ')':
		case '*':
		case '+':
		case '/':
		case ':':
		case ';':
		case '=':
		case '@':
		case '[':
		case ']':
		case '_':
		case '{':
		case '}':
			{
			alt6=6;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:1:10: PALAVRA
				{
				mPALAVRA(); 

				}
				break;
			case 2 :
				// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:1:18: INT
				{
				mINT(); 

				}
				break;
			case 3 :
				// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:1:22: WS
				{
				mWS(); 

				}
				break;
			case 4 :
				// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:1:25: PONTO
				{
				mPONTO(); 

				}
				break;
			case 5 :
				// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:1:31: VIRGULA
				{
				mVIRGULA(); 

				}
				break;
			case 6 :
				// /home/clesio/tcc/tcc/src/ifpi/ads/tcc/padroes/ClasseMetodo.g:1:39: SIMBOLOS
				{
				mSIMBOLOS(); 

				}
				break;

		}
	}



}
