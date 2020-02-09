#API endpoints

###/customer/

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
        
##/zip/
