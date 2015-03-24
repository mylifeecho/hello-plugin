package hello.elasticsearch

import hello.elasticsearch.rest.HelloRestHandler
import org.elasticsearch.plugins.AbstractPlugin
import org.elasticsearch.rest.RestModule

class HelloPlugin extends AbstractPlugin {
  override def name(): String = "hello-plugin"

  override def description(): String = "Hello plugin"

  def onModule(module: RestModule): Unit = module.addRestAction(classOf[HelloRestHandler])
}