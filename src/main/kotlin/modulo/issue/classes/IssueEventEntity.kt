package modulo.issue.classes

import org.jetbrains.exposed.dao.*
import java.util.*

class IssueEventEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object :UUIDEntityClass<IssueEventEntity>(IssueEventTable)

    var action by IssueEventTable.action
    var issue by IssueEntity referencedOn IssueEventTable.issueId
}

class IssueEntity(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<IssueEntity>(IssueTable)

    var createdAt by IssueTable.createdAt
    var updatedAt by IssueTable.updatedAt
}