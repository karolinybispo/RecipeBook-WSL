const app = Vue.createApp({
    data(){
        return {
            nome: '',
            ingredientes: [],
            message: ''
        };
    },
    methods: {
    async salvarReceita(){
        const receita = { // receita eh o obj json que contem os dados que serao enviados. Esse treco define um obj js que o axios converte para json ao enviar a requisicao, esse json sera enviado como corpo da requisicao para a API no spring.
                nome: this.nome,
                ingredientes: this.ingredientes.split(",") // Por exemplo, separando os ingredientes em um array
        };
        try{
            const response = await axios.post("http://localhost:8080/receitas/salvar", receita);
            this.message = 'Receita salva com sucesso: ' + response.data;
            console.log('receita salva com sucesso: ', response.data);
        }catch(error){
            this.message = 'Erro ao salvar receita: ' + (error.response ? error.response.data : error.message);
            console.error('erro ao salvar receita: ', error.response ? error.response.data : error.message);
        }
    }
}
});
app.mount('#app');