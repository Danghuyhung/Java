<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.List" %>
<%@ page import="lab05.java_technology.utils.FlashMessage" %>
<c:if test="${not empty username}">
  <c:redirect url="/" />
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Register</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css    ">
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
    p.item {
      padding: 16px;
      text-align: center;
      border-radius: 8px;
      color: white;
      background-color: green;
    }
  </style>
</head>

<body class="bg-secondary">

  <h3 class="text-center my-5 text-light">Account Registration</h3>

  <!-- buộc toàn bộ dòng và cột phải bỏ trong class container -->
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-5">
        <div class="border p-3 rounded bg-light">
          <form method="post" action="">
            <div class="form-group">
              <label for="name">Full Name</label>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-user"></i>
                  </span>
                </div>
                <input id="name" name="name" type="text" class="form-control" placeholder="Your Name" required>
              </div>

            <div class="form-group">
              <label for="email">Email</label>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-user"></i>
                  </span>
                </div>
                <input id="email" name="email" type="text" class="form-control" placeholder="Email" required>
              </div>

            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-lock"></i>
                  </span>
                </div>
                <input id="password" name="password" type="password" class="form-control" placeholder="Password" required>
              </div>
            </div>
            <div class="form-group">
              <label for="password-confirm">Confirm Password</label>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-lock"></i>
                  </span>
                </div>
                <input id="password-confirm" name="password-confirm" type="password" class="form-control" placeholder="Password" required>
              </div>
            </div>
            <div class="form-group">
              <div class="alert alert-danger alert-dismissible fade hide" id="alert">
                <p id="msg"></p>
              </div>
            </div>
            <div class="form-group">
              <button class="btn btn-success px-5" type="submit">Register</button>
            </div>
            <div class="form-group">
              <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login now!</a></p>
            </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <script>
    $(document).ready(function() {
      $('input').on('input', () => {
        $("#alert").removeClass("show").addClass("hide");
      })
      $("form").on("submit", function(event) {
        event.preventDefault();

        const email = $("#email").val();
        const username = $("#username").val();
        const password = $("#password").val();

        if(!/^[\w.%+-]+@[\w.-]+\.[a-zA-Z]{2,}$/.test(email)) {
          $("#alert p").text("Invalid email");
          $("#alert").removeClass("alert-success").addClass("alert-danger").removeClass("hide").addClass("show");
          return;
        }

        if(password.length < 6) {
          $("#alert p").text("Password must be at least 6 characters");
          $("#alert").removeClass("alert-success").addClass("alert-danger").removeClass("hide").addClass("show");
          return;
        }
        if($("#password-confirm").val() !== password) {
          $("#alert p").text("Passwords not match");
          $("#alert").removeClass("alert-success").addClass("alert-danger").removeClass("hide").addClass("show");
          return;
        }

        const formData = $(this).serialize();

        $.ajax({
          url : window.location.pathname,
          method : 'POST',
          data : formData,
          success : function(res) {
            if (!res.success) {
              $("#alert p").text(res.msg);
              $("#alert").removeClass("alert-success").addClass("alert-danger").removeClass("hide").addClass("show");
            }
            else {
              window.location = "${pageContext.request.contextPath}";
            }
          },
          error : (err) => {
            console.log(err);
          }
        })
      })

    });
  </script>

</body>

</html>