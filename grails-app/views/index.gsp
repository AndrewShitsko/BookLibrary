<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to BookLibrary</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<g:set var="users" bean="usersService" />
<content tag="nav">
    <g:if test="${session.user}">
        <li>
            <a class="btn">Hi, ${session.user.username}</a>
        </li>

        <g:if test="${users.hasRole(session.user, "Admin")}">
            <li>
                <a href="/admin/users">Admin Panel</a>
            </li>
        </g:if>

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
        <h1>Books</h1>
    </section>
</div>

</body>
</html>
