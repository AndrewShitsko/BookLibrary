package booklibrary

class BooksInterceptor {

    def usersService

    public BooksInterceptor() {
        match(controller: "books").except(uri: "/", action: "index")
    }

    boolean before() {
        if (!session.user) {
            redirect(uri: "/login")
            return false
        } else if(!usersService.hasAnyRoles(session.user, ["Admin", "Editor"])) {
            flash.error = "Page is only for administrators or editors"
            render(status: 403)
            return false
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
