package booklibrary


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UsersInterceptor)
class UsersInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test users interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"users")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
