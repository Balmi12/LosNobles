function sumar() {
    let n1 = parseFloat(document.getElementById("n1").value);
    let n2 = parseFloat(document.getElementById("n2").value);
    document.getElementById("resultado").innerText = n1 + n2;
}

function restar() {
    let n1 = parseFloat(document.getElementById("n1").value);
    let n2 = parseFloat(document.getElementById("n2").value);
    document.getElementById("resultado").innerText = n1 - n2;
}

function multiplicar() {
    let n1 = parseFloat(document.getElementById("n1").value);
    let n2 = parseFloat(document.getElementById("n2").value);
    document.getElementById("resultado").innerText = n1 * n2;
}

function dividir() {
    let n1 = parseFloat(document.getElementById("n1").value);
    let n2 = parseFloat(document.getElementById("n2").value);
    if (n2 !== 0) {
        document.getElementById("resultado").innerText = n1 / n2;
    } else {
        document.getElementById("resultado").innerText = "No se puede dividir por cero";
    }
}

function exponente() {
    let n1 = parseFloat(document.getElementById("n1").value);
    let n2 = parseFloat(document.getElementById("n2").value);
    document.getElementById("resultado").innerText = Math.pow(n1, n2);
}

function raizCuadrada() {
    let n1 = parseFloat(document.getElementById("n1").value);
    if (n1 >= 0) {
        document.getElementById("resultado").innerText = Math.sqrt(n1);
    } else {
        document.getElementById("resultado").innerText = "No se puede obtener la raíz cuadrada de un número negativo";
    }
}