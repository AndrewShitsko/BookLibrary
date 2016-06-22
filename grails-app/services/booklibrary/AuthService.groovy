import grails.transaction.Transactional

@Transactional
public class AuthService {

    def usersService

    public boolean login(session, String username, String password) {
        def result = false
        def user = usersService.getUserByUsername(username)
        if (user) {
            def isVerify = PasswordHelper.verifyHash(password, user.password, user.salt)
            if (isVerify) {
                session.user = user
                result = true
            }
        }
        return result
    }

    public boolean logout(session) {
        def result = false
        if (session.user != null) {
            session.user = null
            result = true
        }
        return result
    }

    def logout(session, userId) {
        if (session.user.id == userId)
            session.user = null
    }
}
