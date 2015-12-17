grammar AtributoRelacionamento;

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
	private String classe, classe1;
	
	public AtributoRelacionamentoParser(TokenStream input, DiagramaDeClasse diagramaDeClasse) {
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

SIMBOLOS 
	:	('\'' | ';' | '/' | '[' | ']' | '{' | '}' | '(' | ')' | '+' | '"' | '@' | '#' |
		'_' | '*' | '=' | '-'){skip();}
	;

PONTO 	:	'.';

VIRGULA :	',';

DOIS_PONTOS
	:	':';
	
estoria returns [DiagramaDeClasse diagramaDeClasse]:
		(atributoRelacionamento)+
		{$diagramaDeClasse = this.diagramaDeClasse;}
	;
	
atributoRelacionamento:	ARTIGO s=SUBSTANTIVO p=PREPOSICAO s1=SUBSTANTIVO p1=PREPOSICAO (n=NUMERAL|s2=SUBSTANTIVO) //Atributo
		{diagramaDeClasse.addAtributo($s1.text, $s.text, $s2!=null ? $s2.text : $n.text);}
		{System.out.println("Atributo2: " + $s.text + " - Classe: "+ $s1.text);}
		|(CONJUNCAO_COORDENADA|VIRGULA|DOIS_PONTOS) ARTIGO? s=SUBSTANTIVO (PREPOSICAO s1=SUBSTANTIVO)? // Atributo
		{this.classe = $s1!=null ? $s1.text : "proxima";}
		{diagramaDeClasse.addAtributo(this.classe, $s.text, "String");}
		{System.out.println("Atributo3: " + $s.text + " - Classe: "+ this.classe);}
		|a=ARTIGO s=SUBSTANTIVO (p=PREPOSICAO s1=SUBSTANTIVO)? (VERBO|VERBO_INFINITIVO) a1=ARTIGO? s2=SUBSTANTIVO (p1=PREPOSICAO s3=SUBSTANTIVO)? // Relacionamento 1..1
		{this.classe = $s1!=null ? $s1.text : $s.text;
		this.classe1 = $s3!=null ? $s3.text : $s2.text;}
		{diagramaDeClasse.addRelacionamento("1:1", this.classe, this.classe1);}
		{System.out.println("1Relacionamento11: "+ this.classe + " - " + this.classe1);}
		|a=ARTIGO s=SUBSTANTIVO (p=PREPOSICAO s1=SUBSTANTIVO)? VERBO NUMERAL CONJUNCAO_COORDENADA ADVERBIO s2=SUBSTANTIVO (p1=PREPOSICAO s3=SUBSTANTIVO)? // Relacionamento 1..n
		{this.classe = $s1!=null ? $s1.text : $s.text;
		this.classe1 = $s3!=null ? $s3.text : $s2.text;}
		{diagramaDeClasse.addRelacionamento("1:n", this.classe, this.classe1);}
		{System.out.println("2Relacionamento1n: "+ this.classe + " -  " + this.classe1);}
		|ARTIGO s=SUBSTANTIVO (PREPOSICAO|VERBO) NUMERAL s1=SUBSTANTIVO // Relacionamento 1..n
		{diagramaDeClasse.addRelacionamento("1:n", $s.text, $s1.text);}
		{diagramaDeClasse.addAtributo($s1.text, "quantidade", $NUMERAL.text);}
		{System.out.println("3Relacionamento1n: "+ $s.text + " - " + $s1.text);}
		{System.out.println("Atributo4: " + "quantidade" + " - Classe: "+ $s1.text);}
		|NUMERAL s=SUBSTANTIVO ADJETIVO? PREPOSICAO s1=SUBSTANTIVO // Relacionamento
		{diagramaDeClasse.addRelacionamento("1:n", $s1.text, $s.text);}
		{System.out.println("4Relacionamento1n: "+ $s1.text + " - " + $s.text);}
		|(ADJETIVO|ADVERBIO|ARTIGO|SUBSTANTIVO|VERBO|VERBO_INFINITIVO|PRONOME|CONJUNCAO_COORDENADA|CONJUNCAO_SUBORDINADA|INTERJEICAO|PREPOSICAO|NUMERAL|PONTO|VIRGULA|DOIS_PONTOS)
	;