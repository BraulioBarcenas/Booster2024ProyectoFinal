
# Assigment Final Booster 2024



## Descripción del proyecto

El proyecto consiste en el control de inventario de libros, montado con una API en SpringBoot conectada a MongoDB y orquestada en contenedores Docker.


## Despliegue

Para desplegar el proyecto, es necesario crear la imagen de docker del api gateway utilizando en el proyecto, para ello, referirse al siguiente repositorio: https://github.com/BraulioBarcenas/BoosterApiGateway

Una vez creada la imagen, seguir los siguientes pasos:

1. Clonar el repositorio
```bash
  git clone https://github.com/BraulioBarcenas/Booster2024ProyectoFinal
```
2. Empaquetar el proyecto desde la carpeta del proyecto

```bash
  ./mvnw clean package -DskipTests
```
3. Desplegar el proyecto por medio de docker

```bash
  docker-compose up --build
```

El proyecto se creará utilizando docker y se podrá acceder por medio de localhost:8080.



## API Reference

### Inicio de sesión

```bash
  POST /auth/login
```

| Parametro | Tipo     | Descripción                |
| :-------- | :------- | :------------------------- |
| `email` | `string` | **Obligatorio**. Email registrado del usuario a iniciar sesión |
| `password` | `string` | **Obligatorio**. Contraseña de usuario |

El proyecto genera por defecto un usuario con email y contraseña genericos. 
```bash
{
 email = "default"
 password = "default"
}
```

### Control de usuarios

#### Obtener todos los usuarios

```bash
  GET /usuarios
```

#### Nuevo usuario

```bash
  POST /usuarios
```
| Parametro | Tipo     | Descripción                |
| :-------- | :------- | :------------------------- |
| `email` | `string` | **Obligatorio**. Email del usuario |
| `password` | `string` | **Obligatorio**. Contraseña de usuario |

#### Actualizar usuario

```bash
  PUT /usuarios
```
| Parametro | Tipo     | Descripción                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Obligatorio**. Id del usuario a modificar |
| `email` | `string` | Email del usuario |
| `password` | `string` | Contraseña de usuario |

```bash
  DELETE /usuarios
```
| Parametro | Tipo     | Descripción                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Obligatorio**. Id del usuario a eliminar |

### Control de libros

#### Obtener todos los libros

```bash
  GET /libros
```

#### Nuevo libro

```bash
  POST /libros
```
| Parametro | Tipo     | Descripción                |
| :-------- | :------- | :------------------------- |
| `nombre` | `string` | **Obligatorio**. Nombre del libro |
| `autor` | `string` | **Obligatorio**. Autor del libro |

#### Actualizar libro

```bash
  PUT /libros
```
| Parametro | Tipo     | Descripción                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Obligatorio**. Id del libro a modificar |
| `nombre` | `string` | Nombre del libro |
| `autor` | `string` | Autor del libro |

```bash
  DELETE /libros
```
| Parametro | Tipo     | Descripción                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Obligatorio**. Id del libro a eliminar |






# Conclusiones

Decidí mantener simple la lógica de negocio del proyecto para en su lugar hacer énfasis en la integración de todos los temas vistos en el booster en un solo proyecto, denotando el avance y conocimientos adquiridos.

Personalmente, mis mayores complicaciones tuvieron que ver con la implementación de gRPC y la dockerización del api gateway, sin embargo, leer e investigar sobre los temas me permitió comprender las soluciones propuestas en internet a los bloqueos que tenia durante el desarrollo.

El proyecto puede ser claramente mejorado, sin embargo, estas mejoras ya no eran posibles debido a la falta de tiempo para avanzar en el desarrollo del proyecto, por lo que considerando este factor, estoy satisfecho con el resultado.
