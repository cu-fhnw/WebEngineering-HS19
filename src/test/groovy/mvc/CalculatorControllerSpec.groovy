package mvc


import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

/**
 * See the API for {@link ControllerUnitTest} for usage instructions.
 */
class CalculatorControllerSpec extends Specification implements ControllerUnitTest<CalculatorController> {

    void "simple average of #en and #exam should be #result"() {
        when:
        controller.calc(1.0, 2.0)
        then:
        model.result == 1.5
    }

    // Data driven testing (see http://spockframework.org/spock/docs/1.3-RC1/data_driven_testing.html)
    void "average of #en and #exam should be #result"(en, exam, result) {
        when:
        controller.calc(en, exam)
        then: "average calculation"
        model.result == result
        where:
        en  | exam | result
        0.0 | 0.0  | 0.0
        1.0 | 2.0  | 1.5
        2.0 | 1.0  | 1.5
    }
}
