======================== MANUAL DA FERRAMENTA DESENVOLVIDA ========================

Este documento destina-se a apresentar a ferramenta desenvolvida no processo de geração dos 
diagramas de classe, de sequência e do cdóigo java.


======================== PRÉ-REQUISITOS ========================

1 - Java SE Development Kit 8

2 - Apache Tomcat 8.0

3 - Banco de dados MySQL:
	usuário: root
	senha: root

4 - Criar o banco de dados "tcc" e importar o script "tcc.sql" disponível na pasta "banco de dados".


======================== CONFIGURAR O ETIQUETADOR DE TEXTO ========================

1 - Realize o download do arquivo "tree-tagger-pt.zip"

2 - Caso utilize o linux, descompacte o arquivo "tree-tagger-pt.zip" no diretório pessoal.

3 - No linux, abra o terminal, acesse seu diretório pessoal e dê permissão para o etiquetador executando o seguinte comando: 
sudo chmod 777 tree-tagger-pt/bin/tree-tagger


======================== ACESSAR A FERRAMENTA DESENVOLVIDA ========================

1 - Realize o download do arquivo "ferramenta.war"

2 - Inicie o servidor de aplicação Tomcat.

3 - Vá para o diretório do .../apache-tomcat/webapps e cole o arquivo "ferramenta.war" dentro do diretório "webapps".

4 - Acesse a ferramenta desenvolvida através da URL: http://localhost:8080/ferramenta/estoriaUsuario


======================== PROCESSAR AS ESTÓRIAS DE USUÁRIO ========================

1 - Após acessar a aplicação, escreva sua estória ou faça Upload dela nos seguintes formatos: Documento de texto (.txt), Estoria JBehave (.story), Documento Word (.doc) ou Portable Document Format (.pdf). Há algumas estórias de usuário disponíveis na pasta "estórias de usuário" 
para fins de teste.

2 - Clique no botão "Enviar".

3 - Clique no botão "Editar", caso queira realizar alguma alteração na estória de usuário.


======================== DOWNLOAD DOS DIAGRAMAS DE CLASSE, DE SEQUÊNCIA E DO CÓDIGO JAVA ========================

1 - Faça download do arquivo XMI v2.1 (contendo os diagramas de classes e de sequência) e importe-o no 
Modelio (Download: https://www.modelio.org/). Ou, ainda, faça download do XMI v1.2 (contendo o diagrama de classes) 
e importe-o no ArgoUML (Download: http://argouml.tigris.org/).

2 - Faça download do código java e edite-o em qualquer editor de texto simples.


======================== CONTATOS ========================

Dúvidas, sugestões ou comentários.

Clésio Gonçalves - clesio.pi@hotmail.com | clesio.goncalves@ifpi.edu.br
Rafael Anchiêta - rta@ifpi.edu.br
Rogério Figueredo - rogerio.sousa@ifpi.edu.br
