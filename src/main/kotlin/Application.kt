import io.javalin.Javalin
import modulo.issue.IssueEventModule
import modulo.issue.IssuesEventEndpoint
import org.jetbrains.exposed.sql.Database
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

class Application : KoinComponent{

    private val issueEventEndpoint by inject<IssuesEventEndpoint>()

    private val url = "jdbc:postgresql://localhost/postgres"
    private val driver = "org.postgresql.Driver"
    private val user = "postgres"
    private val password = "123"

    fun start() = Javalin.create().apply{
        StandAloneContext.startKoin(listOf(IssueEventModule))

        Database.connect(url,
            driver = driver,
            user=user,
            password=password)

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



