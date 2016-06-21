import booklibrary.User

class UsersController {

    def index() {
        def users = User.findAll()
        render(view: "users", model: [users: users])
    }

    def addUser() {
        if (User.findByUsername(params.username)) {
            flash.message = "User with this login already exists"
            flash.code = "danger"
        }
        else if (User.findByEmail(params.email)) {
            flash.message = "User with this email already exists"
            flash.code = "danger"
        }
        else {
            PasswordHelper.SaltHash saltHash = PasswordHelper.computeHashWithSalt(params.password)
            long now = new Date().getTime()
            def user = new User(username: params.username,
                    password: saltHash.getHash(),
                    salt: saltHash.getSalt(),
                    email: params.email,
                    firstname: params.firstname,
                    lastname: params.lastname,
                    middlename: params.middlename,
                    createdAt: now)
            if (user.save()) {
                flash.message = "User is created"
                flash.code = "success"
            } else {
                flash.message = "An error has occurred. Please try again later or check your entries"
                flash.code = "danger"
            }
        }
        redirect(uri: "/admin/users")
    }

    def edit() {
        def user = User.get(params.id)
        render(view: "edit", model: [user: user])
    }

    def updateUser() {
        def user = User.get(params.id)
        if (user) {
            user.email = params.email
            user.firstname = params.firstname
            user.lastname = params.lastname
            user.middlename = params.middlename
            if (user.save()) {
                flash.message = "User is updated"
                flash.code = "success"
            } else {
                flash.message = "An error has occurred. Please try again later or check your entries"
                flash.code = "danger"
            }
        } else {
            flash.message = "User doesn't exist"
            flash.code = "danger"
        }
        redirect(uri: "/admin/users")
    }

    def deleteUser() {
        def user = User.get(params.id)
        if (user) {
            user.delete()
            def checkUser = User.get(params.id)
            if (!checkUser) {
                if (session.user == user)
                    session.user = null
                flash.message = "User is deleted"
                flash.code = "success"
            } else {
                flash.message = "An error has occurred. Please try again later or check your entries"
                flash.code = "danger"
            }
        } else {
            flash.message = "User doesn't exist"
            flash.code = "danger"
        }
        redirect(uri: "/admin/users")
    }
}
