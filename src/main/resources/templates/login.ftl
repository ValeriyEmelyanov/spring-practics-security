<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-3">
            <div class="header-panel" style="margin-top:45px">
                <h3 class="title">Login with username and password</h3>
            </div>
            <div class="media-body">
                <#if logout >
                    <div class="alert-info" role="alert">You've been logged out successfully.</div>
                </#if>
                <#if error>
                    <div class="alert-danger" role="alert">Invalid Username or Password!</div>
                </#if>
            </div>
            <form method="post">
                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>
                <button type="submit" class="button">Login</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
