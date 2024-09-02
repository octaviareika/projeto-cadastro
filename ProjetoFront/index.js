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

    /*A verificação if (window.location.pathname.endsWith('listar.html')) 
    
    dentro do evento de submissão do formulário de administração não será
    executada após o redirecionamento, pois o script é executado antes do redirecionamento. */

    if (window.location.pathname.endsWith('listar.html')) {
        listarUsuarios();
    }

    const formAdm = document.getElementById('form-adm');
    if (formAdm){
        const usernameAdm = document.getElementById('usernameAdm');
        const passwordAdm = document.getElementById('passwordAdm');
        formAdm.addEventListener('submit', async (event) => {
            if (usernameAdm.value === 'admin' && passwordAdm.value === 'admin'){
                event.preventDefault();
                window.location.href = '/ProjetoFront/listar.html'; // Caminho absoluto
                
            }
            else {
                alert('Usuário ou senha inválidos');
            }
        });
    }


    
});

async function cadastrarUsuario(){
    const nome = document.getElementById('username').value;
    //console.log(nome);
    const senha= document.getElementById('password').value;
   // console.log(senha);
    const email = document.getElementById('email').value;
   // console.log(email);

    const response = await fetch('http://localhost:8080/user', { // fetch é uma função assíncrona
        // espera a resposta do servidor
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
        return await response.json(); // retorna o json da resposta
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
            return `<div class="usuario-total">
                        <h3 class="titulo-usuario">${usuario.nome} </h3> 
                        <li class="usuario">${usuario.email}</li>
                    </div>`; // return aqui
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

async function deletarUsuario(){

    var id = document.getElementById('id').value;

    const response = await fetch(`http://localhost:8080/user/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    });

    if (response.ok) {
        alert('Usuário deletado com sucesso!');
    }
    else {
        alert('Erro ao deletar usuário!');
    }

}
//cadastrarUsuario();
