package modulo.issue.classes

import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.dao.UUIDTable

object IssueEventTable : UUIDTable("github.ISSUE_EVENT"){
    val action = varchar("action", 50)
    val issueId = reference("issue_id", IssueTable)
}

object IssueTable : IdTable<Int>("github.ISSUE"){
    override val id = IssueEventTable.integer("id").primaryKey().entityId()
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}