# REST Assured api test
Test REST Api methods using REST assured and TestNG

## json server
In this demo `json-server` is used to provide a json server

given this json file:

```sh
{
  "users": [
    {
      "id": "846-42-1097",
      "name": "Makayla",
      "Age": "63",
      "city": "Washington",
      "info": {
        "email": "samantha.soto@mail.com",
        "phone": "322-461-1576",
        "address": "81 Aster Court"
      }
    },
    {
      "id": "065-27-5455",
      "name": "London",
      "Age": "90",
      "city": "Washington",
      "info": {
        "email": "landon.parker@gmail.com",
        "phone": "505-268-4367",
        "address": "117 Aster Court APT 68"
      }
    },
    {
      "id": "839-45-1527",
      "name": "Sydney",
      "Age": "62",
      "city": "San Francisco",
      "info": {
        "email": "kaydenpreston@yahoo.com",
        "phone": "681-375-5877",
        "address": "146 Atkins Avenue APT 346"
      }
    },
    {
      "id": "576-30-3006",
      "name": "Piper",
      "Age": "22",
      "city": "Washington",
      "info": {
        "email": "ellamendez@gmail.com",
        "phone": "029-588-035",
        "address": "144 Aster Court APT 300"
      }
    }
  ]
}
```
## How to run:
```sh
mvn test
```
Good luck  :)