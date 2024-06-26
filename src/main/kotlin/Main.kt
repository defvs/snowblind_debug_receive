import events.*
import org.zeromq.SocketType
import org.zeromq.ZContext
import org.zeromq.ZMQ
import java.nio.ByteBuffer
import java.nio.ByteOrder

fun main() {
    ZContext().use { context ->
        val socket = context.createSocket(SocketType.PULL)
        socket.bind("tcp://127.0.0.1:5555")
        println("Receiver is listening on tcp://127.0.0.1:5555")

        while (!Thread.currentThread().isInterrupted) {
            val message = socket.recv(ZMQ.DONTWAIT)
            if (message != null) {
                val buffer = ByteBuffer.wrap(message).order(ByteOrder.LITTLE_ENDIAN)
                val eventHeader = buffer.readClapEventHeader()

                when (EventType.fromInt(eventHeader.type)) {
                    EventType.NOTE_ON -> {
                        val eventNote = buffer.readClapEventNote()
                        println(eventNote)
                    }
                    EventType.NOTE_OFF -> {
                        val eventNote = buffer.readClapEventNote()
                        println(eventNote)
                    }
                    EventType.TRANSPORT -> {
                        val eventTransport = buffer.readClapEventTransport()
                        println(eventTransport)
                    }
                    EventType.PARAM_VALUE -> {
                        val eventParamValue = buffer.readClapEventParamValue()
                        println(eventParamValue)
                    }
                    else -> println("Unknown event type: ${eventHeader.type}")
                }
            } else {
                // No message received, continue looping
                Thread.sleep(10) // Sleep to avoid busy-waiting
            }
        }
    }
}
