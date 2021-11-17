![LOGO](./ue-iade-h75.png)    

# RELATÓRIO (2ªEntrega)

## Nome Do Projeto: MyIADE

### Cadeiras participantes:

- Bases de Dados;
- Competências Comunicacionais;
- Matemática Discreta;
- Programação de Dispositivos Móveis;
- Programação Orientada por Objetos;
- Projeto de Desenvolvimento Móvel.

* * *

### Membros do grupo:

- Rúben Martins (NºEstudante:20200453)
- Rúben Passarinho (NºEstudante:20200095)

* * *

### Público alvo do projeto:

A aplicação MyIADE possui como público alvo os diversos estudantes e docentes da universidade IADE.

* * *

### Resumo:

Iremos desenvolver uma app móvel da faculdade, com o nome de "MyIADE", de modo a facilitar o acesso à informação pelos estudantes e docentes.

* * *

### Palavras-Chave:

Faculdade  | Informação | Alunos | Horários | Acessibilidade

* * *

### Enquadramento:

Hoje em dia a forma mais comum de procurar informação são os dispositivos móveis, sendo uma forma bastante simples e rápida de consultar informação a qualquer hora e lugar.
Esse aspeto é mais vincado na população mais jovem, nomeadamente entre os estudantes universitários. 
A nossa faculdade, o IADE, possui uma aplicação móvel, a qual se encontra bastante desatualizada não estando enquadrada nos requisitos bases de um design apelativo ao utilizador. Como tal, decidimos criar uma nova aplicação adicionando novas funcionalidades inovadoras e úteis, que facilitam a vida dos estudantes e docentes.

* * *

### Objetivo:

O objetivo deste projeto é desenvolver uma app móvel da faculdade, que corresponda às verdadeiras necessidades do estudante.

* * *

### Funcionalidades:

A nossa app será direcionada aos diversos alunos e docentes da faculdade, possuindo diversas funcionalidades:
- Consulta de notas, horários, propinas e noticias;
- Chat estudantil através do número de estudante;
- Encaminhamento para o e-mail do aluno;
- Sistema de presenças através de QR Code disponibilizado pelo docente, sendo necessário estar ligado à rede da faculdade para confirmar a localização;
- Sistema de notificações que indique a próxima aula, a respetiva sala, e se possível o trajeto.
- Marcação de deslocações à secretaria ou algum órgão da faculdade.

* * *

### Outras ferramentas já existentes:

Como já referimos anteriormente o IADE já possui uma app móvel. A mesma não está atualizada e possui um design não adequado à atualidade.
Procurámos outras aplicações semelhantes a esta em outros estabelecimentos de ensino, sendo eles:
- Universidade Lusófona
- Faculdade de Ciências 

Com base na nossa pesquisa conferimos que, em geral, as aplicações são sempre bastante semelhantes, possuindo as mesmas opções básicas, como por exemplo conferir notas e horários.
Com a nossa aplicação iremos inovador este estigma por entre estas aplicações, inovando nas opções fornecidas.

* * *

### Guiões de teste:

###### (Leitura do QR Code para marcação da presença)
1º - No menu principal irá existir uma opção com o nome "Presenças", que irá abrir um menu onde irá possuir 2 opções (marcar presença e presenças). Irá entrar na opção "Marcar presença", será pedido o acesso à câmara do telemóvel, depois de permitir o acesso irá ler o QR Code. Será automaticamente marcada a presença na respetiva aula. 

###### (Mostrar o mapa da sala)
2º - 5 minutos antes da aula marcada começar, irá receber uma notificação com o nome da respetiva aula e o número da sala de aula. Irá ter de clicar na notificação recebida de forma a ser mostrada a informação completa acerca da aula (Nome da cadeira, respetiva sala, nome do docente, hora de inicio e de fim). De seguida terá de clicar no botão "localizar sala de aula", sendo mostrado um mapa do andar com a respetiva sala marcada e trajeto.

###### (Conferir notas do aluno)
3º - No menu principal da aplicação irá possuir um simbolo com 3 barras no canto superior esquerdo. Ao entrar nesse menu irão ser mostradas 4 opções, o meu curso, área financeira, campus e chat. Ao entrar na aba o meu curso, irão ser mostradas 4 opções, aulas, calendário, percurso e presenças. Irá entrar na aba percurso e escolher o respetivo semestre que deseja consultar as notas. Serão mostradas as notas das cadeiras por ordem alfabética.

* * *

### Personas:

###### (Persona 1)

O André Santos é um jovem de 21 anos, atualmente é estudante do 3ºano do curso de design na universidade do IADE. O André possui nacionalidade portuguesa e atualmente reside em Lisboa. Nos seus tempos livres gosta de desenhar e praticar exercício físico, mais precisamente caminhar e jogar futebol. O André possui uma familia bastante vasta, tendo 3 irmãos e vários tios, tendo um irmão também no IADE. O André irá utilizar a aplicação para consultar informação acerca do seu percurso na universidade, ajudando-o enquanto estudante do IADE.

###### (Persona 2)

A Bruna Sousa é uma jovem de 19 anos, é estudante do IADE, 1ºano, frequentando o curso de fotografia. A Bruna possui nacionalidade portuguesa, é natural do Porto, mas atualmente vive em Lisboa para estar mais próxima da universidade. A Bruna gosta de tirar fotografias nos seus tempos livres e jogar jogos de tabuleiro. A Bruna possui uma familia pequena, tendo perdido o pai enquanto era bastante pequena. A Bruna sempre quis uma maneira rápida e fácil de consultar as informações acerca do seu curso, com esta aplicação irá conseguir fazê-lo.         

###### (Persona 3)

O Fábio Santos é um jovem de 20 anos, é estudante do IADE tendo outro irmão também na universidade, chamado André Santos. O Fábio é estudante do curso de desenvolvimento de aplicaçoes e jogos, estando no 2ºano. Tal como o seu irmão, possui nacionalidade portuguesa e reside em Lisboa. Nos seus tempos livres gosta de jogar videojogos e jogar futebol com o seu irmão. O Fábio é um aluno tranferido de outra universidade, onde sempre se queixou de a mesma não possuir uma aplicação para facilitar o percurso dos estudantes. Com a aplicação do MyIADE, será possivel fornecer uma forma mais prática para consultar o percurso dos estudantes.

* * *

### Documentação REST:

#### Apresentação da informação de todos os estudantes
###### (Devolve a informação referente a todos os estudantes)
##### Url: myiade.herokuapp.com/api/students (get)
Resultado:
[
{
   "id":1,"name":"André Santos","phone":925478589,"email":"andres@iade.pt","address":"lisboa","password":"11445226","gender":"M","bdate":"2000-05-21","civilNumber":32541255
}
{
   "id":2,"name":"Bruna Sousa","phone":965544324,"email":"brunas@iade.pt","address":"lisboa","password":"23232335","gender":"F","bdate":"2002-01-02","civilNumber":77553844}
}
…]

#### Apresentação da informação de um estudante através do id
###### (Devolve a informação referente a cada estudante pelo seu id)
##### Url: Url: myiade.herokuapp.com/api/students/{id} (get)
##### Parâmetros: id - inteiro positivo que corresponde ao id do estudante 

Resultado:
{
   "id":1,"name":"André Santos","phone":925478589,"email":"andres@iade.pt","address":"lisboa","password":"11445226","gender":"M","bdate":"2000-05-21","civilNumber":32541255}     
}
 
Erros:
404 (HttpStatus.NOT_FOUN D): O estudante não foi encontrado
{
    "timestamp": "2021-11-10T22:12:27.282+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Student with id 9 not found",
    "path": "/api/students/0"
}

#### Obter as notas do estudante através do id associado a um curso e uma uc
###### (Irá devolver uma nota de um estudante tendo por base o id associado a um curso e uc)
##### Url: myiade.herokuapp.com/api/students/{id}/grade (get)
##### Parâmetros: id - inteiro positivo que corresponde ao id associado a um curso e uc

Resultado:
