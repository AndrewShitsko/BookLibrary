
class AuthController {

    def authService

    def index() {
        render(view: "login")
    }

    def login() {
        if (!session.user) {
            if (authService.login(session, params.username, params.password)) {
                flash.message = "Login succeed"
                flash.code = "success"
            } else {
                flash.message = "Login failed"
                flash.code = "danger"
            }
        }
        redirect(uri: "/")
    }

    def logout() {
        if (authService.logout(session)) {
            flash.message = "Logout succeed"
            flash.code = "success"
        } else {
            flash.message = "You have already logged out"
            flash.code = "danger"
        }
        redirect(uri: "/")
    }
}
