package modulo.issue

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import modulo.issue.mensagens.Event
import modulo.issue.mensagens.Issue
import modulo.issue.mensagens.IssueEvent
import modulo.issue.repositorio.IssueEventRepository
import modulo.issue.servicos.IssueEventServiceImpl
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import java.util.*
import kotlin.test.assertEquals

class IssuesTest : Spek( {

    describe("Salvar Issue Event com sucesso") {

        describe("Dado um Issue Event") {
            val issueEvent = IssueEvent(
                "opened", Issue(
                    1234567890,
                    "2018-09-18T00:00:00",
                    "2018-09-18T00:00:00"
                )
            )

            describe("Salvar evento") {
                it("Ok") {
                    val issueEventRepository = mockk<IssueEventRepository>(relaxed = true)

                    every { issueEventRepository.save(issueEvent) } returns true

                    val service = IssueEventServiceImpl(issueEventRepository)

                    service.save(issueEvent)

                    verify { service.save(issueEvent) }
                }
            }
        }

        describe("Dado um id de evento"){
            val id = 1234567890

            describe("Buscar evento") {
                it("Ok"){
                    val issueEventRepository = mockk<IssueEventRepository>(relaxed = true)

                    val evento = Event("opened", "2018-09-18T00:00:00", "2018-09-18T00:00:00")

                    val listaEventos = ArrayList<Event>()

                    listaEventos.add(evento)

                    every { issueEventRepository.getEvents(1234567890) } returns listaEventos

                    val service = IssueEventServiceImpl(issueEventRepository)

                    assertEquals(1, service.getEvents(id).size)
                }
            }
        }
    }
})

