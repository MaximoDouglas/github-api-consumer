package br.com.argmax.githubconsumer.components.gitrepositorycard.context

import org.junit.Before
import org.junit.Test

class GitRepositoryCardRepositoryNullDescriptionTest : GitRepositoryCardTest() {

    @Before
    fun `setup scenario`() {
        `when repository card has no description`()
    }

    @Test
    fun `test if repository description is gone`() {
        `assert that repository description is gone`()
    }

    @Test
    fun `test if repository description is null or empty`() {
        `assert that repository description is null or empty`()
    }

}