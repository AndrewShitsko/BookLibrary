<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Roles management</title>

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
    <section class="row">
        <h3>Granted roles</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Role</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${userRoles}" var="userRole">
                    <tr>
                        <td>${userRole.name}</td>
                        <td>
                            <g:link controller="users" action="revokeRole" class="btn btn-danger pull-right" title="Revoke role" params="${[userId: user.id, roleId: userRole.id]}">Revoke</g:link>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </section>
    <section class="row">
        <h3>Add role</h3>
        <g:form controller="users" id="${user.id}">
            <div class="input-group">
                <g:select class="form-control" name="roleId" from="${roles}" optionKey="id" optionValue="name" />
                <div class="input-group-btn">
                    <g:actionSubmit class="btn btn-success" title="Grant role" action="grantRole" value="Grant" />
                </div>
            </div>
        </g:form>
    </section>
    <br />
    <div class="row">
        <a href="/admin/users" class="btn btn-default pull-right">Back</a>
    </div>
</div>
</body>
</html>
