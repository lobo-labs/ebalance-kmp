package receiver

import receiver.domain.Receiver
import receiver.domain.ReceiverReference

object ReceiverFactory {
    fun getReceivers() = (0..10).map { getReceiver(it.toLong()) }

    fun getReceiver(id: Long) = Receiver(
        id = id,
        name = "LoboLabs",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389",
        address = null
    )

    fun getReference(id: Long) = ReceiverReference(
        id = id,
        name = "LoboLabs",
        cnpj = "32.901.153/00001-04",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389"
    )
}