# API Rest Design

## Users endpoints

### Users list
| URI     | Method | Headers             |
|:--------|:-----:|:--------------------|
| `/users` | `GET` | | `TODO: authentication` |

**Response**
```json
{
  "users": [
    {
      "id": "u1234",
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
- 403 - Forbidden
- 500 - Internal server error

### Create user
| URI       | Method | Headers |
|:----------|:------:|:-------|
| `/users`  | `POST` |        |

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
  "id": "u1234",
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

| URI               | Method | Headers                 |
|:------------------|:------:|:------------------------|
| `/users/{userID}` | `PUT`  | `TODO: authentication`  |

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
- 403 - Forbidden
- 404 - Not found
- 500 - Internal server error

### Delete user
| URI               |  Method  | Headers                |
|:------------------|:--------:|:-----------------------|
| `/users/{userID}` | `DELETE` | `TODO: authentication` |

**Errors**
- 200 - Ok
- 403 - Forbidden
- 500 - Internal server error

## Cycle events endpoints

### User events
| URI                       | Method | Headers                |
|:--------------------------|:------:|:-----------------------|
| `/events?userID={userID}` | `GET`  | `TODO: authentication` |

**Response**

```json
{
  "events": [
    {
      "id": "e1234",
      "type": "start",
      "date": "YYYY-DD-MM",
      "authorID": "u5678",
      "userID": "u1234"
    }
  ]
}
```

**Errors**
- 200 - Ok
- 204 - No content
- 400 - Bad request
- 403 - Forbidden
- 404 - Not found
- 500 - Internal server error

### Create user cycle event
| URI                | Method | Headers                |
|:-------------------|:------:|:-----------------------|
| `/events` | `POST` | `TODO: authentication` |

**Body**

```json
{
  "type": "start",
  "date": "YYYY-DD-MM",
  "userID": "u1234"
}
```

**Response**
```json
{
  "id": "e1234",
  "type": "start",
  "date": "YYYY-DD-MM",
  "authorID": "u5678",
  "userID": "u1234"
}
```

**Errors**
- 200 - Ok
- 400 - Bad request
- 403 - Forbidden
- 500 - Internal server error

### Update user cycle event
| URI                 | Method | Headers                |
|:--------------------|:------:|:-----------------------|
| `/events/{eventID}` | `PUT`  | `TODO: authentication` |

**Body**

```json
{
  "type": "start",
  "date": "YYYY-DD-MM",
  "userID": "u1234"
}
```

**Response**
```json
{
  "id": "e1234",
  "type": "start",
  "date": "YYYY-DD-MM",
  "authorID": "u5678",
  "userID": "u1234"
}
```

**Errors**
- 200 - Ok
- 400 - Bad request
- 403 - Forbidden
- 404 - Not found
- 500 - Internal server error

### Delete user cycle event
| URI                 |  Method  | Headers                |
|:--------------------|:--------:|:-----------------------|
| `/events/{eventID}` | `DELETE` | `TODO: authentication` |


**Errors**
- 200 - Ok
- 403 - Forbidden
- 500 - Internal server error

## Stats endpoints

### User's stats
| URI               |  Method  | Body | Headers                 |
|:------------------|:--------:|------|:------------------------|
| `/stats/{userID}` |  `GET`  | -    | `TODO: authentication`  |

**Response**

```json
{
  "stats": [
    {
      "userID": "u1234",
      "periodDuration": 5,
      "timeBetweenPeriods": 28,
      "estimatedNextPeriod": 14 
    }
  ]
}
```

**Errors**
- 200 - Ok
- 204 - No content
- 403 - Forbidden
- 500 - Internal server error

## `/<example>`

### Endpoint title
| URI | Method | Headers |
|:---|:--:|:--------|
| |  |         |

**Body**

**Response**

**Errors**