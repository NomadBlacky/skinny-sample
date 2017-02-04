package controller

import skinny._
import skinny.validator._
import _root_.controller._
import model.User

class UsersController extends SkinnyResource with ApplicationController {
  protectFromForgery()

  override def model = User
  override def resourcesName = "users"
  override def resourceName = "user"

  override def resourcesBasePath = s"/${toSnakeCase(resourcesName)}"
  override def useSnakeCasedParamKeys = true

  override def viewsDirectoryPath = s"/${resourcesName}"

  override def createParams = Params(params)
  override def createForm = validation(
    createParams,
    paramKey("name") is required & maxLength(512),
    paramKey("age") is required & numeric & intValue,
    paramKey("description") is maxLength(140)
  )
  override def createFormStrongParameters = Seq(
    "name" -> ParamType.String,
    "age" -> ParamType.Int,
    "description" -> ParamType.String
  )

  override def updateParams = Params(params)
  override def updateForm = validation(
    updateParams,
    paramKey("name") is required & maxLength(512),
    paramKey("age") is required & numeric & intValue,
    paramKey("description") is maxLength(140)
  )
  override def updateFormStrongParameters = Seq(
    "name" -> ParamType.String,
    "age" -> ParamType.Int,
    "description" -> ParamType.String
  )

}
