async function calcular() {

    const v1 = document.getElementById("v1").value;
    const v2 = document.getElementById("v2").value;
    const operacao = document.getElementById("operacao").value;

    const url = `http://localhost:8080/calcular/${operacao}?v1=${v1}&v2=${v2}`;

    const response = await fetch(url);
    const resultado = await response.text();
    document.getElementById("resultado").textContent = resultado;
}