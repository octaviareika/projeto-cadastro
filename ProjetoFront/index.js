document.addEventListener('DOMContentLoaded', function() {
    if (window.location.pathname.endsWith('index.html')) {
        const form = document.querySelector('form');
        if (form) {
            form.addEventListener('submit', async (event) => {
                event.preventDefault();
                await cadastrarUsuario();
            });
        } else {
            console.error('Formulário não encontrado');
        }
    }

    const botaoLista = document.querySelector('.botao-lista');
    if (botaoLista) {
        botaoLista.addEventListener('click', async () => {
            window.location.href = 'listar.html';
        });
    }
    
    if (window.location.pathname.endsWith('listar.html')) {
        listarUsuarios();
    }
});

async function cadastrarUsuario(){
    const nome = document.getElementById('username').value;
    //console.log(nome);
    const senha= document.getElementById('password').value;
   // console.log(senha);
    const email = document.getElementById('email').value;
   // console.log(email);

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

// listar usuarios
async function acessarRota(){

    try {
        const response = await fetch('http://localhost:8080/user/listar');
        if (!response.ok) throw new Error('Falha ao obter resposta do servidor');
        return await response.json();
    } catch(error){
        console.error('Erro ao acessar rota: ', error);
        throw error; // 
    }
}

var secao = {
    secaoUsuario: document.getElementById('users')
}

function criarListaDeUsuarios(dado, elemento){
    
    const ulExistente = elemento.querySelector('ul');

    if(ulExistente){
        elemento.removeChild(ulExistente);
    }

    else {
        const ulNova = document.createElement('ul');
        ulNova.classList.add('lista-usuario');

        const listaHTML = dado.map(usuario => {
            return `<li class="usuario">${usuario.nome} - ${usuario.email}</li>`; // return aqui
        }).join('');

        ulNova.innerHTML = listaHTML; // dentro da ul vai ter a lista de usuarios
        elemento.appendChild(ulNova); // adiciona a ul na section
    }
}

async function listarUsuarios(){

    try {
        const dado = await acessarRota();
        criarListaDeUsuarios(dado, secao.secaoUsuario);
    }
    catch(error){
        console.error('Erro ao listar usuários: ', error);
        alert("Erro");
    }
}

//cadastrarUsuario();
