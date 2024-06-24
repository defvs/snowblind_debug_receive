package events

import java.nio.ByteBuffer

data class ClapEventHeader(
    val size: Int,
    val time: Int,
    val spaceId: Int,
    val type: Int,
    val flags: Int,
)

fun ByteBuffer.readClapEventHeader(): ClapEventHeader {
    return ClapEventHeader(
        size = int,
        time = int,
        spaceId = short.toInt(),
        type = short.toInt(),
        flags = int,
    )
}