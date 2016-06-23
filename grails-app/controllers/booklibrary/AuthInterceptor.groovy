package booklibrary


class AuthInterceptor {

    public AuthInterceptor() {
        match(controller: "auth").except(action: "logout")
    }

    boolean before() {
        if (session.user) {
            redirect(uri: "/")
            return false
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
