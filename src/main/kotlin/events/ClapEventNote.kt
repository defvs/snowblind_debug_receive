package events

import java.nio.ByteBuffer

data class ClapEventNote(
    val header: ClapEventHeader,
    val noteId: Int,
    val portIndex: Int,
    val channel: Int,
    val key: Int,
    val velocity: Double,
)

fun ByteBuffer.readClapEventNote(): ClapEventNote {
    val header = readClapEventHeader()
    return ClapEventNote(
        header = header,
        noteId = int,
        portIndex = short.toInt(),
        channel = short.toInt(),
        key = short.toInt(),
        velocity = double,
    )
}