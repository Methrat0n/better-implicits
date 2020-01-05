package io.github.methrat0n.implicits

import scala.reflect.macros.blackbox
import language.experimental.macros

sealed class !:![A, B]

object !:! {
  implicit def apply[A, B]: !:![A, B] = macro applyImpl[A, B]

  def applyImpl[A: c.WeakTypeTag, B: c.WeakTypeTag](c: blackbox.Context): c.Expr[!:![A, B]] = {
    import c.universe._

    val aType = c.weakTypeOf[A].dealias match {
      case SingleType(pre, _) => pre
      case ttype              => ttype
    }
    val bType = c.weakTypeOf[B].dealias match {
      case SingleType(pre, _) => pre
      case ttype              => ttype
    }

    if (aType =:= bType)
      c.abort(c.enclosingPosition, s"${c.weakTypeOf[A].typeSymbol.name.decodedName} is equal to ${c.weakTypeOf[B].typeSymbol.name.decodedName}")
    else
      c.Expr(q"new !:![$aType, $bType]")
  }
}
