<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Login to BookLibrary</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <div id="content" role="main">
        <div class="col-md-4 col-md-offset-4">
            <g:form controller="auth" action="login" name="loginForm">
                <div class="form-group">
                    <label for="inputUsername">Username</label>
                    <input type="text" class="form-control" id="inputUsername" name="username" placeholder="Username"/>
                </div>

                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password"/>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </g:form>
        </div>
    </div>

</body>
</html>
