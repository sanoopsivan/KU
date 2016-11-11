<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Login</title>

<!-- Bootstrap core CSS -->
<link type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value="/resources/css/customStyles.css" />"
	rel="stylesheet">

<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
			<script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>

<body>
	<div class="container loginContainer">

		<form class="form-signin" action="login" method="post">
			<h2 class="form-signin-heading text-center">Login</h2>
			<c:if test="${not empty param.error}">
				<h6 class="form-signin-heading text-center" style="color: red">${param.error}</h6>
			</c:if>
			<label for="inputEmail" class="sr-only">Username</label>
			<input type="text" id="inputEmail" name="username"
				class="form-control loginFields" placeholder="Username" required
				autofocus>
			<label for="" class="sr-only">Password</label>
			<input type="password" id="inputPassword" name="password"
				class="form-control loginFields" placeholder="Password" required>
			<div class="checkbox text-right">
				<label>
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block loginFields"
				type="submit">Sign in</button>
		</form>
	</div>
</body>

</html>
