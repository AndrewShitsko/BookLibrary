<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Add book</title>

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
        <h3>Add a new book</h3>
        <g:form controller="books" action="addBook" id="${session.user.id}" name="bookForm">
            <div class="form-group">
                <label for="inputTitle">Title</label>
                <input type="text" class="form-control" id="inputTitle" name="title" placeholder="Title"/>
            </div>
            <div class="form-group">
                <label for="inputAuthor">Author</label>
                <input type="text" class="form-control" id="inputAuthor" name="author" placeholder="Author"/>
            </div>
            <div class="form-group">
                <label for="inputDescription">Description</label>
                <textarea type="text" class="form-control" id="inputDescription" name="description" placeholder="Description"></textarea>
            </div>
            <div class="form-group">
                <label for="inputPublishYear">Publish year</label>
                <input type="text" class="form-control" id="inputPublishYear" name="publishYear" placeholder="Publish year" />
            </div>
            <div class="form-group">
                <label for="inputBookUrl">Book url</label>
                <input type="text" class="form-control" id="inputBookUrl" name="bookUrl" placeholder="Book url" />
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/" class="btn btn-default">Cancel</a>
        </g:form>
    </section>
</div>

</body>
</html>