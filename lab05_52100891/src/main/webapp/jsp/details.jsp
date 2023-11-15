<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/16/2023
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <title>Product Details</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <p class="fs-3">ID: ${product.id}</p>
        </div>
        <div class="row">
            <p class="fs-3">Name: ${product.name}</p>
        </div>
        <div class="row">
            <p class="fs-3">Price: ${product.price}</p>
        </div>
    </div>
</body>
</html>
