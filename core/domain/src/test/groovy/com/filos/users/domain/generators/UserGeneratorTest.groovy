package com.filos.users.domain.generators
//
//class UserGeneratorTest extends Specification {
//
//    @Shared
//    UsersGenerator generator = new UsersGenerator();
//
//    @Unroll
//    def "generateUsers should generate #corectSize users when noOfUsers is #noOfUsers"() {
//        when:
//            def result = generator.generateUsers(noOfUsers)
//        then:
//            result.size() == corectSize
//            result != null
//        where:
//            noOfUsers | corectSize
//            1         | 1
//            10        | 10
//
//
//    }
//
//    @Unroll
//    def "generateUsers should throw IllegalArgumentException when noOfUsers = #noOfUsers is invalid"() {
//        when:
//            generator.generateUsers(noOfUsers)
//        then:
//            thrown(IllegalArgumentException.class)
//        where:
//            noOfUsers << [-1, -10]
//    }
//
//    def "createUser should create a valid User"() {
//        when:
//            def user = generator.createUser()
//            user.username = null
//        then: "user shouldn't be null"
//            user != null
//        and: "fields should be populated"
//            !user.username.isBlank()
//            !user.firstName.isBlank()
//            !user.lastName.isBlank()
//            !user.password.isBlank()
//            !user.username.isBlank()
//            user.dateOfBirth < Instant.now()
//    }
//}
//
