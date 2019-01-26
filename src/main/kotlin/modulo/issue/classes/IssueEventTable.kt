package modulo.issue.classes

import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.dao.UUIDTable

object IssueEventTable : UUIDTable("ISSUE_EVENT"){
    val action = varchar("action", 50)
    val issueId = reference("issue_id", IssueTable)
}

object IssueTable : IdTable<Int>("ISSUE"){
    override val id = integer("id").primaryKey().entityId()
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}