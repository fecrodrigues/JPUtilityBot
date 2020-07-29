# Grupo
    
Breno\
Felipe Cavalcante\
Sheldon
 

# Resumo

Foi criado um bot que consegue consultar informações como CEP e Clima e responder algumas mensagens do usuário detectando alguns padões de mensagem com regex

Exemplo de dialogo:


Exemplo de chamada dos comandos:\
/cep 03333000\
/clima São Paulo

# Estrutura

 - actions
    -  JPUtilityActions : Classe responsável por armazenar as ações que o bot consegue fazer (consultar Api de CEP e Clima);
 - enums
    - MessagesEnum: Enum responsável por armazenar os regex e suas respectivas interações;
    - WeatherDay: Enum responsável por armazenar os dias da semana em pt-BR;
 - estados
   - BoasVindas: Classe que contém as mensagens relacionadas ao estado de BOASVINDAS;
   - Despedida: Classe que contém as mensagens relacionadas ao estado de DESPEDIDA;
   - Dialogo1: Classe que contém as mensagens relacionadas ao estado DIALOGO1;
   - Dialogo2: Classe que contém as mensagens relacionadas ao estado DIALOGO2;
   - Dialogo3: Classe que contém as mensagens relacionadas ao estado DIALOGO3;
   - MaquinaDeMensagens: Classe responsável por conhecer e manuzear os estados;
 - interfaces
   - Mensagens: 
 - models
   - InfoCep: Classe criada com base no retorno da api de CEP e contém o método toString para formatar o dado para retorno ao usuário;
   - InfoWeather: Classe criada com base no retorno da api de Clima e contém o método toString para formatar o dado para retorno ao usuário;
 - utils
   - Emoji:
   - StringUtils:
  - JPUtilityBot: Classe responsavel por iniciar, parar, aguardar novas mensagens e responder.
  - MainBot: Classe Main