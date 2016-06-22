<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Roles</title>

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
        <h1>Roles</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th style="width: 5%"></th>
                    <th style="width: 5%"></th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${roles}" var="role">
                    <tr>
                        <td>${role.id}</td>
                        <td>${role.name}</td>
                        <td>
                            <a class="btn btn-success" href="/admin/roles/edit/${role.id}" title="Edit role"><i class="fa fa-pencil fa-fw"></i></a>
                        </td>
                        <td>
                            <button class="btn btn-danger" title="Delete role" data-toggle="modal" data-target="#deleteRoleModal-${role.id}">
                                <i class="fa fa-trash-o fa-fw"></i>
                            </button>
                        </td>
                        <div class="modal fade" id="deleteRoleModal-${role.id}" tabindex="-1" role="dialog" aria-labelledby="deleteRoleModalLabel">
                            <div class="modal-dialog">
                                <div class="modal-content" role="document">
                                    <div class="modal-body">
                                        Are you really want to delete the role?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                        <g:link class="btn btn-danger" controller="roles" action="deleteRole" id="${role.id}">Delete</g:link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <a href="/admin/roles/add" type="button" class="btn btn-primary">Add role</a>
    </section>
</div>
</body>
</html>
