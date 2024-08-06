// Atualize o JavaScript para adicionar um ouvinte de eventos
document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('form').addEventListener('submit', async function(event) {
        event.preventDefault(); 
        await cadastrarUsuario();
    });
});

async function cadastrarUsuario(){
    const nome = document.getElementById('username').value;
    console.log(nome);
    const senha= document.getElementById('password').value;
    console.log(senha);
    const email = document.getElementById('email').value;
    console.log(email);

    const response = await fetch('http://localhost:8080/user', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nome, email, senha})
    });

    if (response.ok) {
        alert('Usuário cadastrado com sucesso!');
    }
    else {
        alert('Erro ao cadastrar usuário!');
    }
}

cadastrarUsuario();