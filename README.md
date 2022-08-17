# SimpleOrdersDemo
Demo a simple Springboot REST service for creating orders

Server is set to run on port:8080

The following routes are available:
Get - "/" -returns "Service running"

Get - "/products" -returns product listings

Post - "/order" -returns Order summary
  Sample json body payload:
  {
    "orderBasket": [
        {
            "product": "apples",
            "quantity": 35
        },
        {
            "product": "oranges",
            "quantity": 80
        }
    ]
}

Get - "/order/{id}" -returns a completed Order by Id

Get - "/orders" -returns all completed Orders
