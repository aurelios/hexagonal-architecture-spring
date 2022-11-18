# ☕ Hexagonal Architecture + Spring

Esse projeto foi feito para explicar melhor sobre a arquitetura Hexagonal, podendo ter sido feito com qualquer outra linguagem ou framework.

#Arquitetura Hexagonal
![img.png](img.png)

# Modelagem da arquitetura em uma visão de componentes

![modelo.png](modelo.png)


## 🚀 Para rodar a app na sua máquina

1 - Suba o container do banco PostgreSQL
```shell script
cd docker
```
```shell script
docker-compose up
```
2 - Inicialize a applicação
```shell script
cd..
```
```shell script
./mvnw install
```
```shell script
./mvnw spring-boot:run
```


# REST API
## Create Usuario
### Request
```
POST /usuario
```
```
curl -X POST http://localhost:8080/usuario -H 'content-type: application/json'  -d '{"nome":"Chimarrão","instagram":"@chimarrao","cep":"38400016"}'
```

```
{
	"nome":"Chimarrão",
	"instagram":"@chimarrao",
	"cep":"38400016"
}
```

### Response
```
{
    "id": 2,
    "nome": "Chimarrão",
    "instagram": "@chimarrao",
    "linkedin": null,
    "github": null,
    "dataNascimento": null,
    "endereco": {
        "cep": "38400-016",
        "logradouro": "Rua Segismundo Moraes",
        "uf": "MG",
        "cidade": null,
        "id": 2
    }
}
```