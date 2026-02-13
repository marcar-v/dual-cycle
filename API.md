# API Rest Design

## `/users`

### Users list
| URI     | Method | Body | Headers |
|:--------|:------:|:-----|:--------|
| `/users` | `GET`  | -    | -       |

**Response**
```json
{
  "users": [
    {
      "id": "12145436",
      "name": "User1",
      "email": "user1@email.com",
      "year": 1995,
      "genre": "female"
    }
  ]
}
```

**Errors**
- 200 - Ok
- 204 - No content
- 500 - Internal server error

### Create user
| URI | Method | Headers |
|:----|:------:|:--------|
| `/users`    | `POST`  | -       |

**Body**
```json
{
  "name": "User1",
  "email": "user1@email.com",
  "password": "hash(password)"
}
```

**Response**
```json
{
  "id": "12145436",
  "name": "User1",
  "email": "user1@email.com"
}
```

**Errors**
- 201 - Created
- 400 - Bad request
- 409 - Conflict
- 500 - Internal server error

### Update user
Only the mutable attributes of the users can be modified.

| URI               | Method | Headers |
|:------------------|:------:|:--------|
| `/users/{userID}` | `PUT`  | -       |

**Body**
```json
{
  "name": "User11",
  "year": 1995,
  "genre": "female"
}
```

**Errors**
- 200 - Ok
- 400 - Bad request
- 404 - Not found
- 500 - Internal server error

### Delete user
| URI               |  Method  | Headers |
|:------------------|:--------:|:--------|
| `/users/{userID}` | `DELETE` | -       |


**Errors**
- 200 - Ok
- 500 - Internal server error

## `/<stats>`

### User's stats
| URI              |  Method  | Body | Headers |
|:-----------------|:--------:|------|:--------|
| `/stats`         |  `GET`  | -    | -    |

**Response**

```json
{
  "stats": [
    {
    "id": "12145436",
    "periodAvg": 5,
    "timeAvg": 28
    }
  ]
}
```

**Errors**
- 200 - Ok
- 204 - No content
- 500 - Internal server error

## `/<example>`

### Endpoint title
| URI | Method | Headers |
|:---|:--:|:--------|
| |  |         |

**Body**

**Response**

**Errors**