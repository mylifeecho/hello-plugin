package hello.elasticsearch.rest

import org.elasticsearch.client.Client
import org.elasticsearch.common.inject.Inject
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.rest._

class HelloRestHandler @Inject() (settings: Settings, controller: RestController, client:Client)
    extends BaseRestHandler(settings, controller, client) {
  controller.registerHandler(RestRequest.Method.GET, "/_hello", this)


  def handleRequest(request: RestRequest, channel: RestChannel, client: Client): Unit =
    channel.sendResponse(new BytesRestResponse(RestStatus.OK, answer(request.param("name"))))

  private def answer(who: String) = Option(who) match {
    case Some("Robert") => "Your Grace!"
    case None | Some("") => "I don't talk to strangers."
    case _ => "Hello, " + who + "!"
  }
}
