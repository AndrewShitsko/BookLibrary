import booklibrary.User

class AuthController {

    def index() {
        render(view: "login")
    }

    def login() {
        if (session.user == null) {
            flash.message = "Login failed"
            flash.code = "danger"
            def user = User.findByUsername(params.username)
            if (user) {
                def isVerify = PasswordHelper.verifyHash(params.password, user.password, user.salt)
                if (isVerify) {
                    flash.message = "Login succeed"
                    flash.code = "success"
                    session.user = user
                }
            }
        }
        redirect(uri: "/")
    }

    def logout() {
        if (session.user != null) {
            session.user = null
            redirect(uri: "/")
        }
    }
}
