package events

import java.nio.ByteBuffer

data class ClapEventParamValue(
    val header: ClapEventHeader,
    val paramId: Int,
    val cookie: Long,
    val noteId: Int,
    val portIndex: Int,
    val channel: Int,
    val key: Int,
    val value: Double,
)

fun ByteBuffer.readClapEventParamValue(): ClapEventParamValue {
    val header = readClapEventHeader()
    return ClapEventParamValue(
        header = header,
        paramId = int,
        cookie = long,
        noteId = int,
        portIndex = short.toInt(),
        channel = short.toInt(),
        key = short.toInt(),
        value = double,
    )
}
