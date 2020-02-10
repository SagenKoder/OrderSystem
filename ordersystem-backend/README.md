# API endpoints

### /customer/

- GET /customer/
    - Returns 
        - Http status 200
        - An array of all customers as JSON
- GET /customer/{id}
    - Expects
        - Customers id in URL
    - Returns
        - Http status 200 if found or 404 if not found
        - The Customers data as JSON
- PUT /customer/{id}
    - Expects
        - Customers id in URL
        - The customer object as payload in json/xml
    - Returns
        - Http status 200 if found or 404 if not found
        - The updated customers data as JSON
- POST /customer/
    - Expects
        - The customer object as payload in json/xml
    - Returns
        - The created customers data as JSON
- DELETE /customer/{id}
    - Expects
        - The customers id in URL
    - Returns
        - The deleted customers data as JSON
- GET /customer/search/{filter}
    - Expects
        - A string in the url to filter by
    - Returns
        - An array of all customers with matching number, name or email as JSON
        
### /zip/

- GET /zip/{zip-code}
    - Expects
        - A valid zipcode in URL
    - Returns
        - Status 404 if not found, 200 if found
        - The zip object as JSON
- GET /zip/
    - Returns
        - Status 200 and a JSON array of all zip objects

### /order/

- GET /order/customer/{customerId}
    - Expects
        - A valid customerId in URL
    - Returns
        - 200 and a Json array with all orders for the give customer
- GET /order/
    - Returns
        - 200 and an array of all orders as JSON if OK
- POST /order/
    - Expecs
        - A valid order object as json in body
    - Returns
        - status code 200
        - The newly created order object as json
- GET /order/date/{date}
    - Expects
        - A date formatted as ISO DATE in the url
    - Returns
        - status code 200
        - A json array of all orders for the given date
- GET /order/{id}
    - Expects 
        - A valid order id in url
    - Returns
        - 404 if not found, 200 if found
        - The requested order as json
- PUT /order/{id}
    - Expects
        - A valid id in url
        - An order object as json in body
    - Returns
        - 404 if not found, 200 if found
        - The updated order object as json
- DELETE /order/{id}
    - Expects
        - A valid id in url
    - Returns
        - 404 if not found, 200 if found
        - The deleted object as json

