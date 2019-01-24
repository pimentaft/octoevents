package modulo.issue

import io.javalin.apibuilder.ApiBuilder
import io.javalin.apibuilder.EndpointGroup
import modulo.issue.handles.IssueEventHandler

class IssuesEventEndpoint : EndpointGroup {

    override fun addEndpoints() {
        ApiBuilder.post("/payload", IssueEventHandler::payload)

//        ApiBuilder.path("/issues") {
//            ApiBuilder.get("/:id/events", IssueEventHandler::getEvents)
//            ApiBuilder.get("/statistics", IssueEventHandler::getStatistics)
//        }
    }
}