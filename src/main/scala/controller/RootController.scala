package controller

import skinny._

class RootController extends ApplicationController {

  def index = {
    set("name", "hoge")
    set("list", List(1, 2, 3))
    render("/root/index")
  }

}
