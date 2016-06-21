<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to BookLibrary</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<content tag="nav">
    <g:if test="${session.user}">
        <li>
            <a class="btn">Hi, ${session.user.username}</a>
        </li>
        <li>
            <a href="/admin/users">Admin Panel</a>
        </li>
        <li>
            <g:link controller="auth" action="logout">Logout</g:link>
        </li>
    </g:if>
    <g:else>
        <li>
            <a href="/login">Login</a>
        </li>
    </g:else>
</content>

<div id="content" role="main">
    <section class="row colset-2-its">
        <g:if test="${flash.message}">
            <div class="alert alert-${flash.code}" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i class="fa fa-close"></i>
                </button>
                ${flash.message}
            </div>
        </g:if>
        <h1>Books</h1>
    </section>
</div>

</body>
</html>
