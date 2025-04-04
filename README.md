# Proyecto de API para Consejos de Viajeros

Este proyecto proporciona una API para gestionar consejos de viajeros. Los usuarios pueden crear, modificar, obtener y eliminar consejos.

## Endpoints de la API:

A continuación se muestra el la ruta, el cuerpo, la descripción y posibles respuestas de cada unos de los métodos:


| Método | Ruta                | Cuerpo requerido                                                      | Descripción                                 | Respuestas posibles    |
|--------|---------------------|------------------------------------------------------------------------|---------------------------------------------|------------------------|
| **GET**  | `/api/consejos` 	    | Ninguno          | Obtiene todos los consejos disponibles. 		 | `200 OK` si se encuentran consejos. `404 Not Found` si no hay. |
| **POST**  | `/api/consejos`      | `{ "titulo": "string", "usuario": "string", "mensaje": "string" }` | Crea un nuevo consejo con el título, usuario y mensaje proporcionados.| `201 Created` si el consejo se crea exitosamente. `400 Bad Request` si falta un campo obligatorio o el mensaje es inválido. |
| **PUT**  | `/api/consejos/titulo/{titulo}/usuario/{usuario}` | `{ "mensaje": "string" }`     | Modifica el mensaje de un consejo existente especificado por el título y el usuario.   | `200 OK` si el consejo se actualiza correctamente. `404 Not Found` si no se encuentra el consejo con el título y usuario proporcionados. |
| **DELETE**| `/api/consejos/titulo/{titulo}/usuario/{usuario}` | Ninguno     | Elimina un consejo especificado por el título y usuario.  | `204 No Content` si el consejo se elimina correctamente. `404 Not Found` si no se encuentra el consejo. |

## Descripción de los Endpoints

### 1. Obtener todos los consejos
**Método**: `GET`  
**Ruta**: `/api/consejos`  
**Descripción**: Este endpoint obtiene todos los consejos disponibles. 
**Respuestas**:
- `200 OK`: Si se encuentran consejos, se devuelven como una lista de objetos JSON.
- `404 Not Found`: Si no hay consejos almacenados.

> [!NOTE]
> Como no se ha implementado todavía la seguridad, en los consejos no se muestra el usuario que ha publicado el consejo para evitar que otro usuario modifique un consejo que no es suyo.

### 2. Crear un nuevo consejo

**Método**: `POST`  
**Ruta**: `/api/consejos`  
**Cuerpo**:
json
{
  "titulo": "Título del consejo",
  "usuario": "Nombre del usuario",
  "mensaje": "Mensaje del consejo (entre 20 y 300 palabras)"
}


### 3. Modificar un consejo
**Método**: `PUT`  
**Ruta**: `/api/consejos/titulo/{titulo}/usuario/{usuario}`
**Cuerpo**:

json
{
  "mensaje": "Mensaje actualizado del consejo (entre 20 y 300 palabras)"
}


### 4.Eliminar un consejo
**Método**: `DELETE`
**Ruta**: /api/consejos/titulo/{titulo}/usuario/{usuario}
**Descripción**: Elimina un consejo específico, identificado por su título y el nombre del usuario.
**Respuestas**:
- `204 No Content`: El consejo se ha eliminado correctamente.
- `404 Not Found`: No se encuentra el consejo con el título y usuario proporcionados.