
import { useState, useEffect } from "react"
import { Link } from "react-router-dom"
import './index.css'


export default function ListaProdutos() {

    const [produtos, setProdutos] = useState([])

    useEffect( () => {
        fetch("http://localhost:8080/WebApi/rest/produtos").then((resposta) =>{
            return resposta.json();
        //tentar dar a resposta   
        }).then((resposta) =>{
            setProdutos(resposta)
        //mostrar erro no console    
        }).catch((error)=>{
            console.log(error);
        },[])
    })

    const handleDelete = (id)=> {
        fetch(`http://localhost:8080/WebApi/rest/produtos/${id}`, {
            method: "delete"
        }).then(() =>{
            window.location = "/produtos"
        }).catch((error) =>{
            console.log(error);
        })
    }

    return(
        <main>

            <h1>Lista de Produtos</h1>

            <Link className="button1" to={"/inserir"}>Inserir Produto</Link>

            <table border={2}>
                <thead>
                    <tr>
                        <th>Título</th> <th>Código</th> <th>Preço</th> <th>Quantidade</th>
                    </tr>
                </thead>
                <tbody>
                    {produtos.map((produto) => (
                        <tr key={produto.codigo}>
                            <td>{produto.titulo}</td>
                            <td>{produto.codigo}</td>
                            <td>R${produto.preco}</td>
                            <td>{produto.quantidade}</td>
                            <Link className="button1" to={`editar/${produto.codigo}`}>Editar</Link>
                            <button className="edit-button" onClick={handleDelete.bind(this, produto.codigo)}>Deletar</button>
                        </tr>
                    ))}
                </tbody>
                <tfoot>
                    <tr>
                        <td colSpan={4}>
                            Produtos do Servidor
                        </td>
                    </tr> 
                </tfoot>
            </table>
        </main>
    )
}