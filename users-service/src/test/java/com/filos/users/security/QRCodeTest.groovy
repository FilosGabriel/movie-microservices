package com.filos.users.security

import spock.lang.Specification

class QRCodeTest extends Specification {
    def "Of"() {
        given:
            def content = "some random secret"
        when:
            def qr = QRCode.of(content)
        then:
            qr.content == content
            qr.height == 1200
            qr.width == 1200
    }

    def "TestOf"() {
    }
}
