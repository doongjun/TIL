package hello.typeconverter.converter

import hello.typeconverter.type.IpPort
import org.springframework.core.convert.converter.Converter

class StringToIpPortConverter: Converter<String, IpPort> {
    override fun convert(source: String): IpPort? {
        // "127.0.0.1:8080"
        val split = source.split(":")
        val ip = split[0]
        val port = split[1].toInt()
        return IpPort(ip, port)
    }
}