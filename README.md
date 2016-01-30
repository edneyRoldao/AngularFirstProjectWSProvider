# AngulasJSFirstProjectJavaBackend

Disponibilizei este projeto para a galera que está acompanhando o tutorial do Rodrigo Branas sobre angular JS,<br/> 
assim podemos nos concentrar apenas no tutorial. Abaixo segue um pequeno guia para rodar o backend sem complicacoes<br/>
<br/>
O projeto foi escrito em JAVA fazendo-se uso das seguintes tecnologias:
  - para compilar: JDK 1.8
  - servidor web: Tomcat 8
  - API hibernate para implementacao da JPA (trata as operacoes com o Banco de Dados)
  - API Jersey para criação do webservice em Restful
  - API Jackson para fazer os tratamentos nos arquivos JSON
  - Banco de Dados MySQL
  
PASSO-A-PASSO - configuracoes importantes para o servico rodar:<br/>
  1 -> configurar o classpath do projeto para java jdk (1.7 ou 1.8)<br/>
  2 -> adicionar o servidor do tomcat(7 ou 8)<br/>
  3 -> apontar o tomcat correto no projeto (se o projeto não estiver com erros, pule este passo):<br/>
     &#160;&#160;&#160;&#160;   a) clique com o botao direito do mouse no projeto<br/>
     &#160;&#160;&#160;&#160;   b) vá para preferences<br/>
     &#160;&#160;&#160;&#160;   c) procure por target Run Time<br/>
     &#160;&#160;&#160;&#160;   d) marque o tomcat correto, ou seja, equele que você acabou de adicionar<br/>
  4 -> Alterar o arquivo src/META-INF/persistence.xml<br/>
      &#160;&#160;&#160;&#160;  a) na linha 12 troque o nome "root" pelo seu nome de usuario do seu banco de dados MySQL<br/>
      &#160;&#160;&#160;&#160;  b) na linha 13 adicione a senha do seu banco de dados case ela exista<br/>
      &#160;&#160;&#160;&#160;  c) na linha 14 verifique qual é a porta que seu bando de dados está utilizando e altere se for preciso.<br/>
            geralmente, no windows é a porta 3306 e no mac 3307.<br/>
  5 -> Abra o MySQL e crie um banco de dados com o nome "angularjs_listatelefonica", ou você pode modificar esse nome na linha 14<br/>
  6 -> Execute a classe StartDatabase.java que possui o metodo main, ela vai gerar a nossa lista de opradoras<br/>
  7 -> Agora é só iniciar o tomcat com o projeto e continuar seu tutorial de Angular JS.<br/>
  <br/>
  Lista das URL`s (obs: talvez o porta do tomcat seja diferente, não esqueça de verificar):<br/>
   PARA OBTER A LISTA DE TELEFONES CADASTRADOS (get) ou adicionar novo contato (post), a URL é a mesma:<br/>
      http://localhost:8080/AngularJSTutorialBackend/lista/telefones<br/>
  <br/>
  PARA RECUPERAR A LISTA DE OPERADORAS (obs: não esqueça o passo 6 para popular o banco de dados com as operadoras):<br/>
    http://localhost:8080/AngularJSTutorialBackend/lista/operadoras<br/>
    <br/>
  Extra: Eu criei um metodo a mais para excluir os contatos, este metodo utiliza o verbo http PUT e pode receber um ou mais contatos<br/>
    ou seja, podemos passar para o backend tanto um JSONObject quanto um JSONArray que ele resolve o resto:<br/>
     http://localhost:8080/AngularJSTutorialBackend/lista/telefones<br/>
    
  INFORMACAO IMPORTANTE PRA FINALIZAR:<br/>
    Utilize sempre o firefox para o tutorial pois a política de mesma origem (same policy origin) é mais rigorosa no chrome,
    e justamente por isso mesmo eu adicionando CORS no meu backend, ele nao vai deixar você fazer um POST ou PUT.<br/>
    USE O FIREFOX.
     
     
     
     
     
            
