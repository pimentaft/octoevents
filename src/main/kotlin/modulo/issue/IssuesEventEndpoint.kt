package modulo.issue

import io.javalin.apibuilder.ApiBuilder
import io.javalin.apibuilder.EndpointGroup
import modulo.issue.controllers.IssueEventController

class IssuesEventEndpoint : EndpointGroup {

    override fun addEndpoints() {
        ApiBuilder.post("/payload", IssueEventController::payload)

        ApiBuilder.path("/issues") {
            ApiBuilder.get("/:id/events", IssueEventController::getEvents)
        }
    }
}