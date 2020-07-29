# Grupo
    
Breno Marino\
Felipe Cavalcante\
Sheldon Gomes
 

# Resumo

Foi criado um bot que consegue consultar informações como CEP e Clima e responder algumas mensagens do usuário detectando alguns padrões de mensagem com regex

Exemplo de dialogo:
Oi 
Bom dia 
Boa tarde
tchau 


Exemplo de chamada dos comandos:\
/cep 03333000\
/clima São Paulo

# Estrutura

 - actions
    -  JPUtilityActions : Classe responsável por armazenar os comandos de ações que o bot consegue fazer e chamar as respectivas classes (consultar Api de CEP e Clima);
    -  CepACtion: Classe responsável pela consulta do CEP via API
    -  WeatherAction: Classe responsável pela consulta do Clima via API
 - enums
    - MessagesEnum: Enum responsável por armazenar os regex e suas respectivas interações;
    - WeatherDay: Enum responsável por armazenar os dias da semana em pt-BR;
 - estados
   - BoasVindas: Classe que contém as mensagens relacionadas ao estado de BOASVINDAS;
   - Despedida: Classe que contém as mensagens relacionadas ao estado de DESPEDIDA;
   - Dialogo1: Classe que contém as mensagens relacionadas ao estado DIALOGO1;
   - Dialogo2: Classe que contém as mensagens relacionadas ao estado DIALOGO2;
   - Dialogo3: Classe que contém as mensagens relacionadas ao estado DIALOGO3;
   - MaquinaDeMensagens: Classe responsável por trocar os estados;
 - interfaces
   - Mensagens: Classe responsável por definir os contratos dos métodos e definir qual método deve ser acionado no estado de acordo com a mensagem;
 - models
   - InfoCep: Classe criada com base no retorno da api de CEP e contém o método toString para formatar o dado para retorno ao usuário;
   - InfoWeather: Classe criada com base no retorno da api de Clima e contém o método toString para formatar o dado para retorno ao usuário;
 - utils
   - StringUtils: Classe responsável por remover a acentuação para consulta de api clima;
  - JPUtilityBot: Classe responsável por iniciar, parar, aguardar novas mensagens e responder.
  - MainBot: Classe Main