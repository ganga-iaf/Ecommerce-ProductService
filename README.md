## Product Service
* Product service is to get the list of available products for user query.

### API Endpoints
1.`[GET]` api/product/{query}

Path variable(s)
* query*

Sample response body:
```json
[
  {
    "id": 1,
    "name": "Iphone 16",
    "description": "Apple mobile with latest features.",
    "price": 130000.0,
    "images": [
      {
        "imageUrl": "https://www.bing.com/th/id/OIP.Whg0dwZ9BF4Izc4EXtJOsQHaE7?w=273&h=211&c=8&rs=1&qlt=70&o=7&cb=iavawebp1&dpr=1.3&pid=3.1&rm=3",
        "altText": "Alt Text"
      }
    ],
    "categories": [
      "Electronics",
      "Mobiles"
    ]
	},
	{
      "id": 2,
      "name": "Iphone 15",
      "description": "Apple mobile",
      "price": 100000.0,
      "images": [{
              "imageUrl": "https://www.bing.com/th/id/OIP.Whg0dwZ9BF4Izc4EXtJOsQHaE7?w=273&h=211&c=8&rs=1&qlt=70&o=7&cb=iavawebp1&dpr=1.3&pid=3.1&rm=3",
              "altText": "Alt Text"
			}],
      "categories": [
        "Electronics",
        "Mobiles"
		]
	}
]
```

### Database table(s)
* product
  * id
  * name
  * description
  * price
  * category_id
  * created_at
  * updated_at  
  

* category
  * id
  * name
  * created_at
  * updated_at


* product_image
  * id
  * name
  * url
  * product_id

### Technologies
* Java17
* Spring Boot
* My SQL DB

### Maven dependencies
* lombok
* mysql-connector-j
* spring-boot-starter-data-jpa 

