package io.github.joxebus.challenge.repository

import io.github.joxebus.challenge.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository extends JpaRepository<Person, Integer> {

}
