<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Users</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<content tag="nav">
    <li>
        <a href="/admin/users">Users</a>
    </li>
    <li>
        <a href="/admin/roles">Roles</a>
    </li>
</content>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h3>Edit user</h3>
        <g:form controller="users" action="updateUser" id="${user.id}">
            <div class="form-group">
                <label for="inputEmail">Email</label>
                <input type="text" class="form-control" id="inputEmail" name="email" placeholder="Email" value="${user.email}"/>
            </div>
            <div class="form-group">
                <label for="inputFirstname">Firstname</label>
                <input type="text" class="form-control" id="inputFirstname" name="firstname" placeholder="Firstname" value="${user.firstname}"/>
            </div>
            <div class="form-group">
                <label for="inputLastname">Lastname</label>
                <input type="text" class="form-control" id="inputLastname" name="lastname" placeholder="Lastname" value="${user.lastname}"/>
            </div>
            <div class="form-group">
                <label for="inputMiddlename">Middlename</label>
                <input type="text" class="form-control" id="inputMiddlename" name="middlename" placeholder="Middlename" value="${user.middlename}"/>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/admin/users" class="btn btn-default">Cancel</a>
        </g:form>
    </section>
</div>

</body>
</html>