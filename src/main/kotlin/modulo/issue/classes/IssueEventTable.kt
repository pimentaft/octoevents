package modulo.issue.classes

import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.dao.UUIDTable

object IssueEventTable : UUIDTable("github.issue_event"){
    val action = varchar("action", 50)
    val issueId = reference("issue_id", IssueTable)
}

object IssueTable : IdTable<Int>("github.issue"){
    override val id = integer("id").primaryKey().entityId()
    val createdAt = datetime("create_at")
    val updatedAt = datetime("update_at")
}