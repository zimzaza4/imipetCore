package cn.inrhor.imipetcore.common.script.kether.action

import taboolib.common5.Coerce
import taboolib.library.kether.ArgTypes
import taboolib.module.kether.KetherParser
import taboolib.module.kether.actionNow
import taboolib.module.kether.scriptParser
import taboolib.module.kether.switch

object CommonAction {

    @KetherParser(["indexImi"], shared = true)
    fun parser() = scriptParser {
        it.switch {
            case("select") {
                val a = it.next(ArgTypes.ACTION)
                actionNow {
                    newFrame(a).run<Any>().thenApply { e ->
                        variables().set("@Index", Coerce.toInteger(e))
                    }
                }
            }
        }
    }

}