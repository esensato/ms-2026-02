const OpenAPIClientAxios = require("openapi-client-axios").default;

const api = new OpenAPIClientAxios({
    definition: "http://localhost:8081/v3/api-docs",
});
api.init()
    .then((client) =>
        client.cadastro({}, { nome: "Teste Node", curso: "CDN", turma: "XPTO" })
    )
    .then((res) => console.log("Resultado:", res.data));