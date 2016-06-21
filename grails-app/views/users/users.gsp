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
        <g:if test="${flash.message}">
            <div class="alert alert-${flash.code}" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i class="fa fa-close"></i>
                </button>
                ${flash.message}
            </div>
        </g:if>
        <h1>Users</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Username</th>
                    <th>Full name</th>
                    <th>Email</th>
                    <th>Date registration</th>
                    <th style="width: 5%"></th>
                    <th style="width: 5%"></th>
                    <th style="width: 5%"></th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.firstname} ${user.lastname} ${user.middlename}</td>
                        <td>${user.email}</td>
                        <td>${user.createdAt}</td>
                        <td>
                            <a class="btn btn-info" href="/admin/users/roles/${user.id}" title="Roles management"><i class="fa fa-user-plus"></i></a>
                        </td>
                        <td>
                            <a class="btn btn-success" href="/admin/users/edit/${user.id}" title="Edit user"><i class="fa fa-pencil fa-fw"></i></a>
                        </td>
                        <td>
                            <button class="btn btn-danger" title="Delete user" data-toggle="modal" data-target="#deleteUserModal-${user.id}">
                                <i class="fa fa-trash-o fa-fw"></i>
                            </button>
                        </td>
                        <div class="modal fade" id="deleteUserModal-${user.id}" tabindex="-1" role="dialog" aria-labelledby="deleteUserModalLabel">
                            <div class="modal-dialog">
                                <div class="modal-content" role="document">
                                    <div class="modal-body">
                                        Are you really want to delete the user?
                                    </div>
                                    <div class="modal-footer">
                                        <button id=${user.id} type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                        <g:link class="btn btn-danger" controller="users" action="deleteUser" id="${user.id}">Delete</g:link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <a href="/admin/users/add" type="button" class="btn btn-primary">Add user</a>
    </section>
</div>
</body>
</html>
