import io.javalin.Javalin
import modulo.issue.IssueEventModule
import modulo.issue.IssuesEventEndpoint
import modulo.issue.classes.IssueEventTable
import modulo.issue.classes.IssueTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

class Application : KoinComponent{

    private val issueEventEndpoint by inject<IssuesEventEndpoint>()

    fun start() = Javalin.create().apply{
        StandAloneContext.startKoin(listOf(IssueEventModule))

        Database.connect("jdbc:postgresql://localhost/github",
            driver = "org.postgresql.Driver",
            user="postgres",
            password="123")

        port(4567)
        routes {
            issueEventEndpoint.addEndpoints()
        }
        start()
    }
}

object BootRun {

    @JvmStatic
    fun main(args : Array<String>) {
        Application().start()
    }
}



