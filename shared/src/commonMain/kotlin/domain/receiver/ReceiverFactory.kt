package domain.receiver

object ReceiverFactory {
    fun getReceivers() = (0..10).map { getReceiver(it.toLong()) }

    fun getReceiver(id: Long) = Receiver(
        id = id,
        name = "LoboLabs",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389",
        address = null
    )
}