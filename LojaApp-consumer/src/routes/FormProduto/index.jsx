
import { useEffect, useState } from "react"
import { Link, useParams } from "react-router-dom"
import './index.css'


export default function EditarProduto() {

    let {id} = useParams()

    const [novo, setNovo] = useState({
        codigo:id,
        titulo:"",
        preco:"",
        quantidade:""
    })

    let metodo = "post"

    if(id){
        metodo = "put"
    }

    const handleChange = e=>{
        setNovo({...novo, [e.target.name]:e.target.value})
    }

    const handleSubmit = e =>{
        e.preventDefault()

        fetch(`http://localhost:8080/WebApi/rest/produtos/${id ? id : ""}`, {
            method: metodo,
            headers: {
                "Content-Type":"application/json"
            },
            body: JSON.stringify(novo)
        }).then(()=>{
            window.location = "/produtos"
        })
    }

    useEffect(()=>{
        if(id){
            fetch(`http://localhost:8080/WebApi/rest/produtos/${id}`)
            .then((resposta)=>{
                return(resposta.json())
            }).then(data=>{
                setNovo(data)
            })
        }
    },[id])

    return(
        <main>
            <h1>Produtos</h1>

            <form onSubmit={handleSubmit}>
                <input type="number" name="codigo" value={novo.codigo} placeholder="Código" onChange={handleChange} /> <br />
                <input type="text" name="titulo" value={novo.titulo} placeholder="Título" onChange={handleChange}/> <br />
                <input type="number" name="preco" value={novo.preco} placeholder="Preço" onChange={handleChange} step="0.01"/> <br />
                <input type="number" name="quantidade" value={novo.quantidade} placeholder="Quantidade" onChange={handleChange}/>
                <button className="button1">Enviar</button>
                <Link className="cancel-link" to={"/produtos"}>Cancelar</Link>
            </form>
        </main>
    )
}