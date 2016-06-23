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
        <table class="table">
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Description</th>
                <th>Publish year</th>
                <g:if test="${users.hasAnyRoles(session.user, ["Admin", "Editor"])}">
                    <th style="width: 5%"></th>
                    <th style="width: 5%"></th>
                </g:if>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${books}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.description}</td>
                    <td>${book.publishYear}</td>
                    <g:if test="${users.hasAnyRoles(session.user, ["Admin", "Editor"])}">
                        <td>
                            <a class="btn btn-success" href="/books/edit/${book.id}" title="Edit book"><i class="fa fa-pencil fa-fw"></i></a>
                        </td>
                        <td>
                            <button class="btn btn-danger" title="Delete book" data-toggle="modal" data-target="#deleteBookModal-${book.id}">
                                <i class="fa fa-trash-o fa-fw"></i>
                            </button>
                        </td>
                    </g:if>
                    <div class="modal fade" id="deleteBookModal-${book.id}" tabindex="-1" role="dialog" aria-labelledby="deleteBookModalLabel">
                        <div class="modal-dialog">
                            <div class="modal-content" role="document">
                                <div class="modal-body">
                                    Are you really want to delete the book?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    <g:link class="btn btn-danger" controller="books" action="deleteBook" id="${book.id}">Delete</g:link>
                                </div>
                            </div>
                        </div>
                    </div>
                    <g:if test="${users.hasAnyRoles(session.user, ["Admin", "Editor", "Registered Users"])}">
                        <td>
                            <a class="btn btn-info" href="${book.bookUrl}" target="_blank" title="Download book">Download</a>
                        </td>
                    </g:if>
                    <g:else>
                        <td>
                            <a class="btn btn-info" title="Only for registered users" disabled>Download</a>
                        </td>
                    </g:else>
                </tr>
            </g:each>
            </tbody>
        </table>
        <g:if test="${users.hasAnyRoles(session.user, ["Admin", "Editor"])}">
            <a href="/books/add" type="button" class="btn btn-primary">Add book</a>
        </g:if>
    </section>
</div>

</body>
</html>
