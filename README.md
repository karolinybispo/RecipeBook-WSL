# RecipeBook (WSL)

Aplicação simples de Livro de Receitas com duas frentes:

- **Web**: formulário em `Vue 3` (via CDN) que envia receitas para uma API.
- **Mobile (Android)**: app em `Java` (Android) que envia receitas para a mesma API.

O repositório foi organizado para indicar tudo que existe para o desenvolvimento da aplicação, simulando um WSL. É adotado práticas ágeis (Scrum) ao longo do ciclo.

## Estrutura do projeto

```
.
├── Backlog.md          # Product Backlog e cronograma de sprints
├── POP.md              # Procedimento Operacional Padrão (fluxo de trabalho)
├── README.md           # Este arquivo
├── SetupDev.md         # Guia de setup de desenvolvimento (IDE, ferramentas, etc.)
├── MOBILE/             # App Android (Java)
│   └── app/src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/mobile/ActivityPrincipal.java
│       └── res/ (layouts, drawables, etc.)
└── WEB/                # Frontend web estático (Vue via CDN)
    ├── index.html
    ├── script.js
    └── style.css
```

## Funcionalidades

- Inserção de receitas com nome e lista de ingredientes.
- Envio dos dados para uma API REST (não inclusa neste repositório).
- Na visão web, uso de `axios` para POST; na visão mobile, uso de `HttpURLConnection`.

## Tecnologias

- **Web**: HTML, CSS, JavaScript, Vue 3 (CDN), Axios (CDN)
- **Mobile**: Android (Java)
- **Ferramentas**: VS Code, Android Studio (detalhado em `SetupDev.md`)

Consulte `SetupDev.md` para lista de IDEs, extensões e pré‑requisitos de ambiente.

## Backend esperado (fora deste repo)

O frontend e o app mobile esperam uma API rodando localmente. Endpoints sugeridos:

- `POST /receitas/salvar` — recebe um JSON com:
  ```json
  {
    "nome": "Bolo de cenoura",
    "ingredientes": ["cenoura", "açúcar", "farinha"]
  }
  ```

URLs padrão usadas no projeto:

- Web (`WEB/script.js`): `http://localhost:8080/receitas/salvar`
- Mobile (`MOBILE/.../ActivityPrincipal.java`): substitua `https://sua-api.com/receitas` pela URL real do seu backend (ex: `http://10.0.2.2:8080/receitas/salvar` para emulador Android)

## Como executar — Web

1. Abra a pasta `WEB/` no VS Code.
2. Opcional: use a extensão "Live Server" para servir `index.html`.
3. Garanta que o backend esteja em execução na porta/rota configurada.
4. Acesse a página, preencha os campos e clique em "Salvar Receita".

Observações:

- O arquivo `script.js` usa `axios.post("http://localhost:8080/receitas/salvar", ...)`. Ajuste a URL se necessário.
- Os ingredientes são enviados como array (a partir de uma string separada por vírgulas).

## Como executar — Mobile (Android)

1. Abra `MOBILE/` no Android Studio.
2. No arquivo `ActivityPrincipal.java`, ajuste a constante de URL da API:
   - Para emulador Android: `http://10.0.2.2:8080/receitas/salvar`
   - Para dispositivo físico: use o IP da sua máquina na rede (ex: `http://192.168.x.x:8080/receitas/salvar`)
3. Construa e execute o app em um emulador ou dispositivo.
4. Preencha os campos e envie. Um `Toast` indicará sucesso/erro.

## Desenvolvimento e processo

- Planejamento e sprints: consulte `Backlog.md`.
- Procedimentos e fluxo de trabalho (branching, merge, etc.): consulte `POP.md`.
- Setup de ferramentas e ambiente: `SetupDev.md`.

### Roadmap inicial (Backlog)

- Tela de inserção de dados (web/mobile)
- API para persistir no banco de dados
- API para pesquisa por ingrediente
- Revisões e melhorias
- Entrega

## Dúvidas comuns

- "Por que a web não salva?" — Verifique se a API está rodando em `localhost:8080` e se a rota `POST /receitas/salvar` existe.
- "O app Android não conecta no localhost" — No emulador, use `10.0.2.2` no lugar de `localhost`.

## Licença

Este projeto é acadêmico/didático.
