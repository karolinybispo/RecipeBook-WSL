# POP: PROCEDIMENTO OPERACIONAL PADRAO


## PROCESSO A SER SEGUIDO AO INICIAR NOVO PROJETO:
- Defina objetivo e escopo do projeto;
- Defina a plataforma principal (ex: web, desktop, mobile);
- Defina os requisitos técnicos (banco de dados, APIs, frameworks, linguagem de programação);
- Defina o repositório para armazenamento do código (ex: GitHub, GitLab);
- Defina qual IDE será usada;
- Defina a lista de funcionalidades principais do projeto;
- Planeje o desenvolvimento em sprints, com uma funcionalidade específica a ser desenvolvida em cada sprint;
- Estabeleça o prazo para a entrega do projeto;
- Registre cada passo do processo para verificar o progresso do projeto conforme planejado. Realize e documente modificações, quando necessário.

> **Escopo do projeto:** conjunto de objetivos, metas e limites que o projeto deve realizar. Exemplo:  Qual problema o projeto resolverá?  |  Quais funcionalidades ele deve ter para cumprir seu propósito?  |  Quais são as restrições ou limites? (ex: funcionalidades que não serão incluídas ou restrições técnicas)

## Processo a ser seguido para o desenvolvimento de features (funcionalidades) em projetos já desenvolvidos:

 **PASSOS:**
1. **Criar nova branch**
 - Comando para iniciar branch com historico em comum: `git checkout -b nome-da-feature ou da branch`
 - Comando para iniciar branch orfã (sem histórico anterior): `git checkout --orfhan nome-branch ou feature`, na nova branch: `git rm -rf .`  isso apaga o que veio da branch anterior. No momento de fazer o merge faça: `git merge nome-branch --allow-unrelated-historie` isso faz o merge acontecer mesmo nao havendo historico de commits em comum.
4. **Desenvolver a nova feature**
5. **Testar**
6. **Commits**
7. **Fazer merge**



