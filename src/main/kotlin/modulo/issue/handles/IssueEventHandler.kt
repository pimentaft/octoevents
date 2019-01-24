package modulo.issue.handles

import io.javalin.Context
import modulo.issue.classes.IssueEvent
import org.koin.standalone.KoinComponent

object IssueEventHandler : KoinComponent {
    fun payload(ctx: Context) {
        try {
           val issueEvent = ctx.bodyAsClass(IssueEvent::class.java)
            println(issueEvent)
//            when(issueService.save(issueEvent)) {
//                true -> ctx.status(201).json(mapOf("message" to "payload loaded"))
//                else -> throw RuntimeException()
//            }
        } catch (e: Exception) {
            ctx.status(406).json(mapOf("message" to "payload not loaded"))
        }
    }
}