package booklibrary


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RolesInterceptor)
class RolesInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test roles interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"roles")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
