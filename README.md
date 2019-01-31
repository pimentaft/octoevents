1) Criação do banco de dados Postgres 3.5
- https://www.postgresql.org/download/
- <POSTGRES_HOME>\pgAdmin 4\bin\pgAdmin4.exe
- Os scripts estão no arquivo script.txt do projeto

2) Acesso ao github
git clone https://github.com/pimentaft/octoevents.git

3) Rodar no maven clean install

4) Na classe Application, executar BootRun 

5) Abrir o prompt de comando, ir ate a pasta do ngrok e executar ngrok http 4567, copiar o endereço http gerado. 
Ir no github, entrar em repositories, clicar em octoevents, settings, Webhooks, edit no webhook payload, e substituir o endereço
pelo endereço gerado no nghok + /payload

5) Para execução da gravação do evento, 
- no github, criar issue no repositório octoevents 

6) Para execução da busca de eventos por id 
 - ir na tabela no Postgres ISSUE_EVENT
 - SELECT * FROM ISSUE_EVENT
 - Escolher o registro gravado, copiar o issue_id
 - Abrir o browser, e digitar http://localhost:4567/issues/<ISSUE_ID_DESEJADO>/events e executar
 Obs: Mudar na url <ISSUE_ID_DESEJADO> pelo número do id_issue copiado.

