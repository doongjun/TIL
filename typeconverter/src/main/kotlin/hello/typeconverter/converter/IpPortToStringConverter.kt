package hello.typeconverter.converter

import hello.typeconverter.type.IpPort
import org.springframework.core.convert.converter.Converter

class IpPortToStringConverter: Converter<IpPort, String> {
    override fun convert(source: IpPort): String {
        return "${source.ip}:${source.port}"
    }
}