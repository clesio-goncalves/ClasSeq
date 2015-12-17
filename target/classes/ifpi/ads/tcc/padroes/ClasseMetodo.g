grammar ClasseMetodo;

tokens {
	ADJETIVO;
	ADVERBIO;
	ARTIGO;
	SUBSTANTIVO;
	VERBO;
	VERBO_INFINITIVO;
	PRONOME;
	CONJUNCAO_COORDENADA;
	CONJUNCAO_SUBORDINADA;
	INTERJEICAO;
	PREPOSICAO;
	NUMERAL;
}

@lexer::header {
	package ifpi.ads.tcc.padroes;
}

@header {
	package ifpi.ads.tcc.padroes;
}

@members{	
	private DiagramaDeClasse diagramaDeClasse;
	
	public ClasseMetodoParser(TokenStream input, DiagramaDeClasse diagramaDeClasse) {
		this(input, new RecognizerSharedState());
		this.diagramaDeClasse = diagramaDeClasse;
	}
}

fragment
LETRASACENTUADAS :	'á'|'Á'|'é'|'É'|'í'|'Í'|'õ'|'Õ'|'ü'|'Ü'|'ç'|'Ç'|
			'ã'|'Ã'|'ê'|'Ê'|'ô'|'Ô'|'à'|'À'|'ó'|'Ó'|'ú'|'Ú'|'-'
 ;

PALAVRA :	('a'..'z'|'A'..'Z'|LETRASACENTUADAS)+ ;

INT :	'0'..'9'+ (('.' ('0'..'9')?)+)?
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;


PONTO 	:	'.';

VIRGULA	:	',';

SIMBOLOS 
	:	('\'' | ':' | ';' | '/' | '[' | ']' | '{' | '}' | '(' | ')' | '+' | '"' | '@' | '#' |
		'_' | '*' | '=' | '-'){skip();}
	;
	
estoria returns [DiagramaDeClasse diagramaDeClasse]:
		(classeMetodo)+
		{$diagramaDeClasse = this.diagramaDeClasse;}
	;

classeMetodo :	s=SUBSTANTIVO PREPOSICAO s1=SUBSTANTIVO //Classe
		{diagramaDeClasse.addClasse($s1.text);}
		{System.out.println("Classe1: "+ $s1.text);}
		|(ARTIGO|NUMERAL) SUBSTANTIVO VERBO? ADJETIVO //Classe/Atributo
		{diagramaDeClasse.addClasse($SUBSTANTIVO.text);}
		{diagramaDeClasse.addAtributo($SUBSTANTIVO.text, "descricao", "String");}
		{System.out.println("Classe2: "+ $SUBSTANTIVO.text);}
		{System.out.println("Atributo1: " + "descricao" + " - Classe: "+ $SUBSTANTIVO.text);}
		|v=VERBO_INFINITIVO (ARTIGO|NUMERAL)? s=SUBSTANTIVO //Classe/Metodo/Relacionamento
		{diagramaDeClasse.addClasse($s.text);}
		{diagramaDeClasse.addMetodo($s.text, $v.text, $s.text);}
		{diagramaDeClasse.addRelacionamento("1:n", "ator", $s.text);}
		{System.out.println("Classe3: "+ $s.text);}
		{System.out.println("Metodo1: "+ $v.text + "(" + $s.text + ")");}
		{System.out.println("Relacionamento1n: "+ "ator" + " - " + $s.text);}
		|v=VERBO_INFINITIVO (VIRGULA|CONJUNCAO_COORDENADA)//Método/Relacionamento
		{diagramaDeClasse.addMetodo("proxima", $v.text, "proxima");}
		{System.out.println("Metodo2: "+ $v.text + "(proxima)");}
		|(ADJETIVO|ADVERBIO|ARTIGO|SUBSTANTIVO|VERBO|VERBO_INFINITIVO|PRONOME|CONJUNCAO_COORDENADA|CONJUNCAO_SUBORDINADA|INTERJEICAO|PREPOSICAO|NUMERAL|PONTO|VIRGULA)
	;