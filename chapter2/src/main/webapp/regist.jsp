<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>你好,请注册</h1>

<form action="regist.do" class="navbar-form navbar-left" method="post">
	<div class="input-group">
		<span class="input-group-addon" id="basic-addon1">用户名：</span> <input
			type="text" class="form-control" placeholder="" name='username'
			aria-describedby="basic-addon1">
	</div>
	<div class="input-group">
		<span class="input-group-addon" id="basic-addon1">密码：</span> <input
			type="password" class="form-control" placeholder="" name='password'
			aria-describedby="basic-addon1">
	</div>
	<div class="input-group">
		<span class="input-group-addon" id="basic-addon1">确认密码：</span> <input
			type="password" class="form-control" placeholder="" name='confirmedpassword'
			aria-describedby="basic-addon1">
	</div>
	<div class="input-group">
		<span class="input-group-addon" id="basic-addon1">邮箱：</span> <input
			type="text" class="form-control" placeholder="" name='email'
			aria-describedby="basic-addon1"><br />
	</div>
	  <button type="submit" class="btn btn-default">提交</button>
	  </form>
</body>
</html>
