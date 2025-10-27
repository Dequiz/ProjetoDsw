const form = document.getElementById('clienteForm');
const list = document.getElementById('list');

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const cliente = {
        nome:document.getElementById('nome').value,
        email:document.getElementById('email').value
    };
    await fetch('/api/clientes', {
        method: 'POST',
        headers: {'COntent-Type': 'application/json'},
        body: JSON.stringify(cliente)
    });
    loadClientes();
    form.reset();
});

async function loadClientes() {
    const response = await fetch('/api/clientes');
    const clientes = await response.json();
    list.innerHTML = '';
    clientes.forEach(cliente => {
        const li = document.createElement('li');
        li.textContent = `${cliente.nome} - ${cliente.email}`;
        list.appendChild(li);
    });
}

loadClientes();