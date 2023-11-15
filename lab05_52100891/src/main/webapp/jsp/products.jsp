<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.List" %>
<%@ page import="lab05.java_technology.utils.FlashMessage" %>
<c:if test="${empty username}">
    <c:redirect url="/login" />
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Products Page</title>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #f8f8f8">
    <div class="container-fluid p-5">
        <div class="row mb-5">
            <div class="col-md-6">
                <h3>Product Management</h3>
                <%
                    FlashMessage flashMessage = (FlashMessage) session.getAttribute("flashMessage");
                    if (flashMessage != null) {
                        String message = flashMessage.getMessage();
                        String type = flashMessage.getType();
                        String alert;
                        if (type.equals("success")) {
                            alert = "success";
                        } else {
                            alert = "danger";
                        }
                %>
                <div class="alert alert-<%= alert %>" role="alert">
                    <%= message %>
                </div>
                <%
                        session.removeAttribute("flashMessage");
                    }
                %>
            </div>
            <div class="col-md-6 text-right">
                Welcome, <span class="text-danger">${username}</span> | <a href="${pageContext.request.contextPath}/logout">Logout</a>
            </div>
        </div>
        <div class="row rounded border p-3">
            <div class="col-md-4">
                <h4 class="text-success">Add new product</h4>
                <form class="mt-3" method="post" action="">
                    <div class="form-group">
                        <label for="product-name">Name of product</label>
                        <input class="form-control" type="text" placeholder="input product name" id="product-name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="price">Price of product</label>
                        <input class="form-control" type="number" placeholder="input product price" id="price" name="price" required>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-success mr-2">Add product</button>
                    </div>
                </form>
            </div>
            <div class="col-md-8">
                <h4 class="text-success">Products list</h4>
                <p>Choose a product to see detail</p>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td><c:out value="${product.id}" /></td>
                                <td><a class="text-decoration-none" href="${pageContext.request.contextPath}/details?id=${product.id}"><c:out value="${product.name}" /></a></td>
                                <td>$<c:out value="${product.price}" /></td>
                                <td>
                                    <input type="hidden" name="action" value="delete"/>
                                    <button class="btn btn-outline-danger mr-2 delete" type="submit" name="productId" data-item="${product.id},${product.name}">delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteConfirmationModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">Delete User</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-danger" id="confirm">Delete</button>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script>
        $(document).ready(function() {
            let id, name;
            $('.delete').click(function(event) {
                event.preventDefault()
                const data = $(this).data('item').split(',')
                id = data[0]
                name = data[1]
                $('.modal-body p').html(`Do you want to delete product: <b>\${name}</b>?`)
                $('#deleteModal').modal('show')
            });

            $('#confirm').click(function() {
                $.ajax({
                    method : 'DELETE',
                    url : window.location.pathname + `?id=\${id}`,
                    success : function() {
                        window.location = window.location.pathname;
                    },
                    error : function(error) {
                        console.log(error);
                    }
                })
            });
        });
    </script>
</body>
</html>