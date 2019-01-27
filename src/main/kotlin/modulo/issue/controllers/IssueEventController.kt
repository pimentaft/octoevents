package modulo.issue.controllers

import io.javalin.Context
import modulo.issue.mensagens.IssueEvent
import modulo.issue.servicos.IssueEventService
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

object IssueEventController : KoinComponent {
    private val issueEventService by inject<IssueEventService>()

    fun payload(ctx: Context) {
        try {
           val issueEvent = ctx.bodyAsClass(IssueEvent::class.java)

            when(issueEventService.save(issueEvent)) {
                true -> ctx.status(201).json(mapOf("message" to "Salvo"))
                else -> throw RuntimeException()
            }
        } catch (e: Exception) {
            ctx.status(406).json(mapOf("message" to "Error"))
            e.printStackTrace()
        }
    }

    fun getEvents(ctx: Context) {
        val issueId = ctx.pathParam("id").toInt()
        val events = issueEventService.getEvents(issueId)
        ctx.json(events)
    }
}