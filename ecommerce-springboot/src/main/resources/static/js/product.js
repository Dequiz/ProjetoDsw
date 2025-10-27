const form = document.getElementById('productForm');
const list = document.getElementById('list');

form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const produto = {
        nome: document.getElementById('nome').value,
        preco: parseFloat(document.getElementById('preco').value)
    };

    await fetch('/api/produtos', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(produto)
    });

    loadProdutos();
    form.reset();
});

async function loadProdutos() {
    const response = await fetch('/api/produtos');
    const produtos = await response.json();

    list.innerHTML = '';
    produtos.forEach(produto => {
        const li = document.createElement('li');
        li.textContent = `${produto.nome} - R$ ${produto.preco.toFixed(2)}`;
        list.appendChild(li);
    });
}

loadProdutos();
