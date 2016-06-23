<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Edit role</title>

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
        <g:form controller="roles" action="updateRole" id="${role.id}" name="roleForm">
            <div class="form-group">
                <label for="inputName">Name</label>
                <input type="text" class="form-control" id="inputName" name="name" placeholder="Name" value="${role.name}"/>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/admin/roles" class="btn btn-default">Cancel</a>
        </g:form>
    </section>
</div>

</body>
</html>