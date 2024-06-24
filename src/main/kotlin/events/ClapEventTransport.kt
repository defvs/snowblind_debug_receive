package events

import java.nio.ByteBuffer

data class ClapEventTransport(
    val header: ClapEventHeader,
    val flags: Int,
    val songPosBeats: Double,
    val songPosSeconds: Double,
    val tempo: Double,
    val tempoInc: Double,
    val loopStartBeats: Double,
    val loopEndBeats: Double,
    val loopStartSeconds: Double,
    val loopEndSeconds: Double,
    val barStart: Double,
    val barNumber: Int,
    val tsigNum: Int,
    val tsigDenom: Int,
)

fun ByteBuffer.readClapEventTransport(): ClapEventTransport {
    val header = readClapEventHeader()
    return ClapEventTransport(
        header = header,
        flags = int,
        songPosBeats = double,
        songPosSeconds = double,
        tempo = double,
        tempoInc = double,
        loopStartBeats = double,
        loopEndBeats = double,
        loopStartSeconds = double,
        loopEndSeconds = double,
        barStart = double,
        barNumber = int,
        tsigNum = short.toInt(),
        tsigDenom = short.toInt(),
    )
}