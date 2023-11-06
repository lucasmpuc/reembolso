function mostrarTela(tela) {
        var telas = ['selecaoUsuario', 'telaFuncionario', 'telaGerente'];
        telas.forEach(function(id) {
            document.getElementById(id).style.display = 'none';
        });

        switch(tela) {
            case 'funcionario':
                document.getElementById('telaFuncionario').style.display = 'block';
                break;
            case 'gerente':
                document.getElementById('telaGerente').style.display = 'block';
                break;
            default:
                document.getElementById('selecaoUsuario').style.display = 'block';
        }
    }

function enviarReembolso() {
    const descricao = document.getElementById('descricao').value;
    const data = document.getElementById('data').value;
    const valor = document.getElementById('valor').value;

    // Create a JavaScript object with the form data
    const formData = {
        descricao: descricao,
        data: data,
        valor: valor
};

    // Make an HTTP POST request to your server to save the data as JSON
fetch('/reembolso', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(formData)
})
.then(response => {
    if (response.status === 200) {
        alert('Reembolso saved successfully!');
    } else {
        alert('Error saving reembolso.');
    }
})
.catch(error => {
    console.error('Error:', error);
});
}
