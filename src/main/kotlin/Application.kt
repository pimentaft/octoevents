import io.javalin.Javalin
import modulo.issue.IssueEventModule
import modulo.issue.IssuesEventEndpoint
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

class Application : KoinComponent{

    private val issueEventEndpoint by inject<IssuesEventEndpoint>()

    fun start() = Javalin.create().apply{
        StandAloneContext.startKoin(listOf(IssueEventModule));
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



