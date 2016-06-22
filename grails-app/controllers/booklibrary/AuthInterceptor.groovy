package booklibrary


class AuthInterceptor {

    public AuthInterceptor() {
        match(controller: "auth")
    }

    boolean before() {
        if (!session.user) {
            redirect(uri: "/login")
            return false
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
