package booklibrary


class UsersInterceptor {

    def usersService

    public UsersInterceptor() {
        match(controller: "users")
    }

    boolean before() {
        if (!session.user) {
            redirect(uri: "/login")
            return false
        } else if(!usersService.hasRole(session.user, "Admin")) {
            flash.error = "Page is only for administrators"
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
